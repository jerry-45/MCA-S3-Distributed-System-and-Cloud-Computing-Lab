// RPC Server

import java.net.*;      // network programming
import java.io.*;
import java.util.*;

public class RPCAddServer {
    // UDP for client-server connection
    DatagramSocket ds;          //For connection
    DatagramPacket dp;          //For sending message
    
    String str, methodName, result;
    //Message stored in str. From str we have to tokenize methodName and Values. 
    //After calculation result will be sent as string

    int val1, val2;             //from str by applying parseInt

    RPCAddServer(){
        try{
            ds = new DatagramSocket(2222);
            byte[] b = new byte[4096];      //to store message from client

            while(true){
                dp = new DatagramPacket(b, b.length);       //dp will receive the message from client as a packet
                ds.receive(dp);                             // socket is receiving the packet

                str = new String(dp.getData(), 0, dp.getLength());

                if(str.equalsIgnoreCase("exit")){
                    System.exit(1);
                }
                else{
                    StringTokenizer st = new StringTokenizer(str, " ");

                    while(st.hasMoreTokens()){              //travel the string for last token
                        String token = st.nextToken();      //to get tokens
                        methodName = token;
                        val1 = Integer.parseInt(st.nextToken());
                        val2 = Integer.parseInt(st.nextToken());
                    } //end of while
                } //end of else

                System.out.println("\n First Value: " + val1);
                System.out.println("\n Second Value: " + val2);

                InetAddress ia = InetAddress.getLocalHost();        //get the address of localhost
                
                result = "" + add(val1, val2);                      //calling method add(int x, int y)

                byte b1[] = result.getBytes();                      //send b1 in packet

                DatagramPacket dp1 = new DatagramPacket(b1, b1.length, ia, 1300);
                System.out.println("Result: " + result);
                ds.send(dp1);
            } //end of while
        } //end of try
        catch(IOException e){
            e.printStackTrace();
        } //end of catch
    } //end of constructor

    public int add(int x, int y){
        return x + y;
    }

    public static void main(String[] args){
        new RPCAddServer();
    }
}
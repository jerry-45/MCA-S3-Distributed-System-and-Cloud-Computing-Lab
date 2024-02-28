// Write a socket program for client and server, such that the server will serve multiple clients at a time

import java.net.*;
import java.io.*;
import java.util.*;

public class MultiClientServer
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            ServerSocket ss = new ServerSocket(2222);
            int count = 0;

            while(true)     //for ultiple client
            {
                count++;
                Socket s = ss.accept();
                System.out.println(">>Client no " + count + "joined");
                ClientThread ct = new ClientThread(s, count);       //we creare thread and we are assigning thread
                ct.start();
            }
        }
        catch(Exception e)
        {

        }
        
    }
}

class ClientThread extends Thread
{
    Socket serverClient;
    int clientNo;

    ClientThread(Socket inSocket, int counter)
    {
        serverClient = inSocket;
        clientNo = counter;
    }
    public void run()
    {
        try
        {
            DataInputStream dis = new DataInputStream(serverClient.getInputStream());
            DataOutputStream dos = new DataOutputStream(serverClient.getOutputStream());
            String serverMsg = "";
            String clientMsg = "";

            while(!clientMsg.equals("exit"))
            {
                clientMsg = dis.readUTF();
                System.out.println("From client: " + clientMsg);
                int square = Integer.parseInt(clientMsg)*Integer.parseInt(clientMsg);
                serverMsg = "From Server: " + clientNo + " square of " + clientMsg + " is " + square;
                dos.writeUTF(serverMsg);
            }   //while close
            dis.close();
            dos.close();
            serverClient.close();
        }
        catch(Exception e)
        {
            
        }
    }       //run() close
}           //class close
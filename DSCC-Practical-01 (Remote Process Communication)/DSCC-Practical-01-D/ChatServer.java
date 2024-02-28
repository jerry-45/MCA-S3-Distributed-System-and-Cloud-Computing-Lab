// Develop a program for client server chat using java socket

import java.net.*;      //for Socket and ServerSocket class
import java.io.*;
import java.util.*;

public class ChatServer{
    public static void main(String[] args) throws Exception{

        String str;

        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());     //reading data from socket
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Scanner input = new Scanner(System.in);

        while(true){
            str = dis.readUTF();        //client message
            
            if(str.equals("exit")){
                dos.writeUTF("exit");
                break;
            }

            System.out.println("Client: " + str);
            System.out.println("Server: ");
            str = input.nextLine();
            dos.writeUTF(str);
        }

        ss.close();
        s.close();
    }
}
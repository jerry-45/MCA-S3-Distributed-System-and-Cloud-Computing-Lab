import java.net.*;
import java.io.*;
import java.util.*;

public class ChatClient {
    public static void main(String[] args) throws Exception{
        String clientMsg, serverMsg;

        Socket s = new Socket("localhost", 3333);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Client: ");
            clientMsg = input.nextLine();
            dos.writeUTF(clientMsg);

            serverMsg = dis.readUTF();
            System.out.println("Server: " + serverMsg);

            if(serverMsg.equals("exit"))
                break;
        }
        s.close();
    }
}
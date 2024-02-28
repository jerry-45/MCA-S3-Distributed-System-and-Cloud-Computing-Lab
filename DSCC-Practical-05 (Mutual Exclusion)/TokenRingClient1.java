// If the process or node has token, it will make the token value = true
// It it wants to enter Critical Section (CS), token = true until it completes its task
// After completion of the task token = false
// If the process doesn't want to enter Critical Section
// It will pass the token to next node

import java.net.*;
import java.io.*;

public class TokenRingClient1 {
    public static DatagramSocket ds;
    public static DatagramPacket dp;
    public static BufferedReader br;

    public static void main(String[] args) throws Exception{
        boolean hasToken = true;
        ds = new DatagramSocket(2001);
        while(true){
            if(hasToken == true)            // the current node has token
            {
                System.out.println("Do you want to enter CS? (yes/no)");
                br = new BufferedReader(new InputStreamReader(System.in));      // for reading yes or no
                String choice = br.readLine();
                // If the choice is yes the client will write data on server
                if(choice.equalsIgnoreCase("yes")){
                    System.out.println("Enter the message: "); // hi
                    br = new BufferedReader(new InputStreamReader(System.in));
                    // prepare one msg which will send to server
                    String msg = "Client1-->"+br.readLine();
                    dp = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), 2000);
                    ds.send(dp);
                    System.out.println("message sent");
                } // end of if
                else if(choice.equalsIgnoreCase("no")){
                    System.out.println("I am not ready for CS.");
                    String msg1 = "Token";
                    dp = new DatagramPacket(msg1.getBytes(), msg1.length(), InetAddress.getLocalHost(), 2002);
                    ds.send(dp);
                    hasToken = false;
                } // end of else if
            } // end of if
            else{
                    System.out.println("waiting for token");

                    // create a space to receive token from previous client
                    byte[] buffer = new byte[2048];
                    dp = new DatagramPacket(buffer, buffer.length);
                    ds.receive(dp);     // token receiving from previous client
                    String preClientMsg = new String(dp.getData(), 0, dp.getLength());
                    System.out.println("previous client message " + preClientMsg);
                    if(preClientMsg.equals("Token")){
                        hasToken = true;
                        System.out.println("I have token now");
                    }
                } // end of else
        } // end of while()
    } // end of main()
} // end of class

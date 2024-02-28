// A server which receive the messages or tasks from all clients
// Implement this using UDP

import java.net.*;      // for DatagramSocket and DatagramPacket

public class TokenRingServer {
    public static DatagramSocket ds;
    public static DatagramPacket dp;
    public static void main(String[] args) throws Exception{
        ds = new DatagramSocket(2000);

        while (true) {
            // preallocated space for receiving message from other node or client
            byte[] buffer = new byte[1024];
            dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Message from " + str);
        } // end of while()
    } // end of main()
} // end of class

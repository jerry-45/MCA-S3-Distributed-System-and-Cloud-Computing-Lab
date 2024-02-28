import java.io.IOException;
import java.net.*;
import java.util.*;

public class OddEvenClient {
    public static void main(String args[]) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
        DatagramPacket DpReceive = null;
        byte[] receive = new byte[65535];
        System.out.print("Enter the Number for Test: ");
        String inp = sc.nextLine();
        buf = inp.getBytes();
        DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
        ds.send(DpSend);
        DpReceive = new DatagramPacket(receive, receive.length);
        ds.receive(DpReceive);
        System.out.println("Server says the Number " + data(receive));
    }

    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0){ 
            ret.append((char) a[i]);
            i++; 
        }
        return ret;
    }
}

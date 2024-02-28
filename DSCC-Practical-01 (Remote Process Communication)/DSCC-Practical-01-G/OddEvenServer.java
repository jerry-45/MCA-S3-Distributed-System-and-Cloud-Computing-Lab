import java.io.IOException;
import java.net.*;

public class OddEvenServer {
    public static void main(String[] args) throws IOException
    {
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;
        byte buf[] = null;
        DpReceive = new DatagramPacket(receive, receive.length);
        ds.receive(DpReceive);
        String str=new String(DpReceive.getData(),0,DpReceive.getLength());
        System.out.println("Number Entered by Client is " + str);
        String parts[] = str.split(" ", 2);
        int i=Integer.parseInt(parts[0]);
        String s=Integer.toString(i);
        String inp2 ;
        if ( i % 2 == 0 ){
            inp2 =s+" is an Even Number!";
            System.out.println(inp2);
        }
        else{
            inp2 =s+" is an Odd Number!";
            System.out.println(inp2);
        }
            
        String inp = inp2;
        InetAddress ip = DpReceive.getAddress();
        int cp = DpReceive.getPort();
        DatagramPacket DpSend = new DatagramPacket(inp.getBytes(),inp.length(),ip,cp);
        ds.send(DpSend);
        System.out.println("Server Out...");
    }
}

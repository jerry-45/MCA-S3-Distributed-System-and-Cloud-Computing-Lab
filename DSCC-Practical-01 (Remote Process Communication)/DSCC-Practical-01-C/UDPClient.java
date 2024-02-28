import java.net.*;

public class UDPClient {
    public static void main(String[] args)throws Exception{
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        String msg = "This is Atul Vishwakarma, from Client";
        DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(),msg.length(),ip,1234);
        ds.send(sendPacket);
        byte[] buffer = new byte[256];
        DatagramPacket inPacket = new DatagramPacket(buffer,buffer.length);
        ds.receive(inPacket);
        String response = new String(inPacket.getData(),0,inPacket.getLength());
        System.out.println("The Server says: "+response);
    }
}
import java.io.*;
import java.net.*;

public class DateTimeClient {
    DateTimeClient(){
        try{
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket(1300);
            
            while(true){
                byte[] b = new byte[1024];
                DatagramPacket dp = new DatagramPacket(b,b.length,ia,2222);
                ds.send(dp);
                dp = new DatagramPacket(b,b.length);
                ds.receive(dp);
                String dt = new String(dp.getData(),0,dp.getLength());
                System.out.println("\nDate Time: \n"+dt+"\n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new DateTimeClient();
    }
}

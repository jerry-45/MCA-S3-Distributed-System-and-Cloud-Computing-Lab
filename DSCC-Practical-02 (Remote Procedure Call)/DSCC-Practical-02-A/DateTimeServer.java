import java.net.*;
import java.util.*;
import java.text.*;

public class DateTimeServer {
    DatagramSocket ds;
    DatagramPacket dp;
    String result;

    DateTimeServer(){
        try{
            ds = new DatagramSocket(2222);
            byte b[] = new byte[4096];
            dp = new DatagramPacket(b,b.length);
            ds.receive(dp);
            result= "Today's Date: "+fetchDate()+"\n"+"Current Time: "+fetchTime();
            InetAddress ia = InetAddress.getLocalHost();
            int port = dp.getPort();
            String dt = result;
            DatagramPacket op = new DatagramPacket(dt.getBytes(), dt.length(), ia, port);
            ds.send(op);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String fetchDate(){
        return new SimpleDateFormat("dd/mm/yyyy").format(new Date()).toString();
    }

    public String fetchTime(){
        return new SimpleDateFormat("hh:mm:ss").format(new Date()).toString();
    }
    public static void main(String[] args){
        new DateTimeServer();
    }
}

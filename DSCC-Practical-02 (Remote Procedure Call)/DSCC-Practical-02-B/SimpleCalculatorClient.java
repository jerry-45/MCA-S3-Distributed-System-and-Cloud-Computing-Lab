import java.io.*;
import java.net.*;

class SimpleCalculatorClient{
    SimpleCalculatorClient(){
        try{
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket(1300);
            System.out.println("Enter Method Name with Parameter(e.g. [Addition 2 3]: "); 
            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String msg = br.readLine();
                DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.length(),ia,2222);
                ds.send(dp);
                byte[] b = new byte[1024];
                dp = new DatagramPacket(b,b.length);
                ds.receive(dp);
                String s = new String(dp.getData(),0,dp.getLength());
                System.out.println("\nResult = " + s);
                System.out.println("\nEnter Method Name with Parameter(e.g. [Addition 2 3]: ");
            } 
        }
        catch (Exception e){
            e.printStackTrace();
        } 
    }

    public static void main(String[] args){
        new SimpleCalculatorClient();
    }
}
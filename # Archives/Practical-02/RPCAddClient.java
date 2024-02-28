//RPC client
import java.net.*; //for socket programming 
import java.io.*;

class RPCAddClient
{
    RPCAddClient()
    {
        try{
            InetAddress ia = InetAddress.getLocalHost();
            DatagramSocket ds = new DatagramSocket(1300);
            System.out.println("Enter method name with parameter like add 3 4");
            
            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String msg=br.readLine();
                DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), ia, 2222);
                ds.send(dp);

                //For receiving msg from server
                byte[] b = new byte[1024];

                //Create a space to receiving msg from server
                //Size should be in the format of 2 to the power of n
                dp = new DatagramPacket(b, b.length);
                ds.receive(dp);     //socket always receive the msg in the format of DatagramPacket msg

                //Create string to open a msg
                String s = new String(dp.getData(),0,dp.getLength());
                System.out.println("Result = "+s);
                System.out.println("Enter method name with parameter like add 2 3:");
            }//End of while
        }//End of true
        catch(Exception e){
            e.printStackTrace();
        }//End of catch 
    }//End of constructor 
    public static void main(String[] args){
        new RPCAddClient();
    }//End of main
}//end of class
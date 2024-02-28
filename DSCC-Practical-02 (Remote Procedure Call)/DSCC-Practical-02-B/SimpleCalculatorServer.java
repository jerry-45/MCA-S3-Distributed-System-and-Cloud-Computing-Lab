import java.net.*;
import java.util.*;

class SimpleCalculatorServer{
    DatagramSocket ds;
    DatagramPacket dp;
    String str, methodName, result;
    int val1, val2;

    SimpleCalculatorServer(){
        try{
            ds = new DatagramSocket(2222);
            byte b[] = new byte[4096];
            while(true){
                dp = new DatagramPacket(b,b.length);
                ds.receive(dp);
                str = new String(dp.getData(),0,dp.getLength());
                if(str.equalsIgnoreCase("quit"))
                    System.exit(1);
                else{
                    StringTokenizer st = new StringTokenizer(str," ");
                    while(st.hasMoreTokens()){
                        String token = st.nextToken();
                        methodName = token;
                        val1 = Integer.parseInt(st.nextToken());
                        val2 = Integer.parseInt(st.nextToken());
                    }
                }
                System.out.println("\nClient Selected "+str+" Method : ");
                System.out.println("\nFirst Value : "+val1);
                System.out.println("Second Value : "+val2);
                if(methodName.equals("Addition")){
                    result= "" + add(val1,val2);
                }
                if(methodName.equals("Subtraction")){
                    result= "" + sub(val1,val2);
                }
                if(methodName.equals("Multiplication")){
                    result= "" + mul(val1,val2);
                }
                if(methodName.equals("Division")){
                    result= "" + div(val1,val2);
                }
                byte b1[] = result.getBytes();
                DatagramPacket dp1 = new DatagramPacket(b1,b1.length,InetAddress.getLocalHost(), 1300);
                ds.send(dp1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int add(int val1, int val2){
        return val1 + val2;
    }

    public int sub(int val1, int val2){
        return val1 - val2;
    }

    public int mul(int val1, int val2){
        return val1 * val2;
    }

    public int div(int val1, int val2){
        return val1 / val2;
    }

    public static void main(String[] args){
        new SimpleCalculatorServer();
    }
}
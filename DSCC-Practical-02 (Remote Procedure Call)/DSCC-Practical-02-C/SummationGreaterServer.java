import java.net.*;
import java.io.*;

public class SummationGreaterServer{
    private static final int PORT = 2222;
    public static void main(String[] args)throws Exception{
        ServerSocket srvsoc = new ServerSocket(PORT);
        System.out.println("Server Started");
        Socket soc = srvsoc.accept();
        while(true){
            DataInputStream dis=new DataInputStream(soc.getInputStream());
            DataOutputStream dos=new DataOutputStream(soc.getOutputStream());
            int num1 = dis.read();
            int num2 = dis.read();
            int add = num1 + num2;
            System.out.println("\nClient enterd num1 :"+num1+" num2 :"+num2+"\n Result : "+add);
            dos.write(add);
        }
    }
}
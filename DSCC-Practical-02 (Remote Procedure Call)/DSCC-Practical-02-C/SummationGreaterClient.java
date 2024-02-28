import java.net.*;
import java.io.*;
import java.util.*;

public class SummationGreaterClient{
    private static InetAddress host;
    private static final int PORT=2222;
    public static void main(String[] args)throws Exception{
        try{
            host=InetAddress.getLocalHost();
        }
        catch(UnknownHostException e){
            System.out.println("Host Not Found");
            System.exit(1);
        }
        int num1,num2;
        Socket soc = new Socket(host,PORT);
        DataInputStream dis = new DataInputStream(soc.getInputStream());
        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Input First Value: ");
            num1=input.nextInt();
            System.out.println("Input Second Value: ");
            num2=input.nextInt();
            dos.write(num1);
            dos.write(num2);
            int add=dis.read();
            if(add>100) {
                System.out.println("\n"+add+" is greater than 100\n");}
            else{
                System.out.println("\n"+add+" is less than 100\n");
            } 
        } 
    }
}
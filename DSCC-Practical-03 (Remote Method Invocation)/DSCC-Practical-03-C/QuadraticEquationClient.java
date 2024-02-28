import java.rmi.*;
import java.util.*;

public class QuadraticEquationClient{
    public static void main(String[] args)throws Exception{
        int a, b, c;
        double ans;
        Scanner input = new Scanner(System.in);
        QuadraticEquationInterface obj = (QuadraticEquationInterface)Naming.lookup("QuadraticEquationImpl");
        System.out.println("Enter value for A: ");
        a=input.nextInt();
        System.out.println("Enter value for B: ");
        b=input.nextInt();
        System.out.println("Enter value for C: ");
        c=input.nextInt();
        System.out.println("\nResult Factor: "+obj.quad(a,b,c));
    }
}
import java.rmi.*;
import java.util.*;

public class EquationClient{
    public static void main(String[] args)throws Exception{
        int a, b;
        double ans;
        Scanner input = new Scanner(System.in);
        EquationInterface obj = (EquationInterface)Naming.lookup("EquationImpl");
        System.out.println("Enter value for A: ");
        a=input.nextInt();
        System.out.println("Enter value for B: ");
        b=input.nextInt();
        System.out.println("Square is "+obj.square(a,b));
        System.out.println("Cube is "+obj.cube(a,b));
    }
}
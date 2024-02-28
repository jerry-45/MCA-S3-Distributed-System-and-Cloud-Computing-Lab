import java.rmi.*;
import java.rmi.registry.*;

public class BasicCalculatorServer{
    public static void main(String[] agrs){
        try{
            BasicCalculatorImpl obj = new BasicCalculatorImpl();
            Registry reg = LocateRegistry.getRegistry();
            Naming.rebind("BasicCalculatorImpl",obj);
        }
        catch(Exception e){}
    }
}
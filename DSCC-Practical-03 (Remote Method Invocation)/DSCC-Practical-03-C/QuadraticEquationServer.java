import java.rmi.*;
import java.rmi.registry.*;

public class QuadraticEquationServer{
    public static void main(String[] args){
        try {
            Registry reg = LocateRegistry.getRegistry();
            QuadraticEquationImpl obj = new QuadraticEquationImpl();
            Naming.rebind("QuadraticEquationImpl",obj);
        }
        catch(Exception e){ 

        }
    }
}
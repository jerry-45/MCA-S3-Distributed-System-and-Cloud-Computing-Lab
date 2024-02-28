import java.rmi.*;
import java.rmi.registry.*;

public class EquationServer{ 
    public static void main(String[] args){
        try {
            Registry reg = LocateRegistry.getRegistry();
            EquationImpl obj = new EquationImpl();
            Naming.rebind("EquationImpl",obj);
        }
        catch(Exception e){ 

        }
    }
}
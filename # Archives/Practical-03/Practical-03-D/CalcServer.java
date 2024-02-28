import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class CalcServer
{
    public static void main(String[] args){
        //object registation steps
        try{
            CalcImpl obj = new CalcImpl();
            //LocateRegistry and CreateRegistry used to get a space or port
            //inside rmirgistry
            Registry reg=LocateRegistry.getRegistry();
            //register the object inside rmiregistry with a name
            //Naming class is to do this
            Naming.rebind("Calculator ",obj);
        }
        catch(Exception e){
            
        }
    }    
}
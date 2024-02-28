import java.rmi.*;
import java.rmi.registry.*;

public class RMISquareServer{
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(3333);      // create a port in rmiregistry
            RMISquareImpl obj = new RMISquareImpl();
            Naming.rebind("squareOfSum", obj);
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }    
}

import java.rmi.*;
import java.rmi.registry.*;

public class GreatestServer{
    public static void main(String[] args){
        try{
            Registry reg=LocateRegistry.createRegistry(3333);
            GreatestImpl obj=new GreatestImpl();
            Naming.rebind("GreatestImpl",obj);
        }
        catch(Exception e){
        }
    }
}
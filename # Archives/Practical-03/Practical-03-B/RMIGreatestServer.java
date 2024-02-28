// RMIGreatestServer.java
// This will register implementation program in rmiregistry

import java.rmi.*;
import java.rmi.registry.*;

public class RMIGreatestServer{
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(3333);      // create a port in rmiregistry
            RMIGreatestImpl obj = new RMIGreatestImpl();
            Naming.rebind("greatest", obj);
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }    
}

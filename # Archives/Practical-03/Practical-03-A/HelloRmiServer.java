// Step 03: Register the object inside RMI Registry
// create server program

import java.rmi.*;
import java.rmi.registry.*;     // to get the registry services

public class HelloRmiServer{
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(2099);     // we are invoking registry class
            // Registry reg = LocateRegistry.getRegistry();
            HelloRmiImpl obj = new HelloRmiImpl();

            // give a name to obj and store that object inside rmiregistry
            // to give name we have to use bind() or rebind() of Naming class

            Naming.rebind("rmi://localhost:2099/hello", obj);
            // Naming.rebind("hellormi", obj);
        }
        catch(Exception e){
            
        }
    }
}
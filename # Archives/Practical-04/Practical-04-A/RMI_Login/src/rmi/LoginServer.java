package rmi;
import java.rmi.*;
import java.rmi.registry.*;
public class LoginServer {
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(2099);     // we are invoking registry class
            // Registry reg = LocateRegistry.getRegistry();
            LoginImplementation obj = new LoginImplementation();

            // give a name to obj and store that object inside rmiregistry
            // to give name we have to use bind() or rebind() of Naming class

            Naming.rebind("rmi://localhost:2099/db", obj);
            // Naming.rebind("hellormi", obj);
        }
        catch(Exception e){
            
        }
    }
}

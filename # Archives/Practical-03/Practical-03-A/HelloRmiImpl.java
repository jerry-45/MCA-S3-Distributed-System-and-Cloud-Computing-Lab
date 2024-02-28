// Step 02: Implement the Interface methods
// create a class

import java.rmi.*;
import java.rmi.server.*;       // for RMI server application

public class HelloRmiImpl extends UnicastRemoteObject implements HelloRmiInterface{
    public HelloRmiImpl() throws RemoteException{
        super();
    }

    public String display() throws RemoteException{
        return ("Welcome to RMI Application");
    }
}
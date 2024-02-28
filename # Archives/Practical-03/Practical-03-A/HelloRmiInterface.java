// retrieve simple method which is locating inside an object from server

// Step 01: Define an interface which contains a method

import java.rmi.*;      // form RMI implementation

public interface HelloRmiInterface extends Remote{
    public String display() throws RemoteException;
}
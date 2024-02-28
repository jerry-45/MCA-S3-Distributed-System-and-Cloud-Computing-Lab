
package rmi;
import java.rmi.*;
import java.util.*;
public interface LoginInterface extends Remote {
   public String[] getData() throws RemoteException; 
}

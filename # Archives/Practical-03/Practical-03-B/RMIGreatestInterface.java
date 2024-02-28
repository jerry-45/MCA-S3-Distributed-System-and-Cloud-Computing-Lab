// GreatestInterface.java

import java.rmi.*;

public interface RMIGreatestInterface extends Remote {
    public int greatest(int a, int b) throws RemoteException;
}

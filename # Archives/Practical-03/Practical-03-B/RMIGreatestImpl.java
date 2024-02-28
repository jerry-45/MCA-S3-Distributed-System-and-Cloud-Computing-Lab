// RMIGreatestImpl.java

import java.rmi.*;
import java.rmi.server.*;

public class RMIGreatestImpl extends UnicastRemoteObject implements RMIGreatestInterface{
    public RMIGreatestImpl() throws RemoteException{
        super();
    }

    public int greatest(int a, int b) throws RemoteException{
        if(a > b)
            return a;
        else
            return b;
    }
}

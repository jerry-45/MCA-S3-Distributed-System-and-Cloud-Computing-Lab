import java.rmi.*;
import java.rmi.server.*;

public class GreatestImpl extends UnicastRemoteObject implements GreatestInterface{
    GreatestImpl()throws RemoteException{
        super();
    }

    public boolean grt(int num1, int num2)throws RemoteException{
        boolean ans;
        if(num1>num2)
            return true;
        else
            return false;
    }
}
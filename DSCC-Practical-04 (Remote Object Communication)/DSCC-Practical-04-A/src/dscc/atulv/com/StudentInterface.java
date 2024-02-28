package dscc.atulv.com;

import java.rmi.*;
public interface StudentInterface extends Remote
{
    public double findScore(String name)throws RemoteException;
}
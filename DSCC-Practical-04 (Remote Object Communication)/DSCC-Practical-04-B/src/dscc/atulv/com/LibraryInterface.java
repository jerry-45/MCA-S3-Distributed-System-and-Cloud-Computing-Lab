package dscc.atulv.com;

import java.rmi.*;
public interface LibraryInterface extends Remote
{
    public String[] findInfo(String id)throws RemoteException;
}
package dscc.atulv.com;

import java.rmi.*;
public interface ElectricBillInterface extends Remote
{
    public String[] findBill(String name)throws RemoteException;
}
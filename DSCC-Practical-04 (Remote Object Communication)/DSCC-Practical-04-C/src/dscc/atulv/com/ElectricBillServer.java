package dscc.atulv.com;

import java.rmi.*;
import java.rmi.registry.*;
public class ElectricBillServer
{
    public static void main(String[] agrs)
    {
        try
        {
            ElectricBillImpl obj = new ElectricBillImpl();
            Registry reg = LocateRegistry.getRegistry();
            Naming.rebind("ElectricBillImpl",obj);
        }
        catch(Exception e)
        {}
    }
}
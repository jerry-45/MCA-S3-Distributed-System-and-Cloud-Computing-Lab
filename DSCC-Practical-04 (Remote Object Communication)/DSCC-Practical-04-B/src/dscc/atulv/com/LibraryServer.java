package dscc.atulv.com;

import java.rmi.*;
import java.rmi.registry.*;
public class LibraryServer
{
    public static void main(String[] agrs)
    {
        try
        {
            LibraryImpl obj = new LibraryImpl();
            Registry reg = LocateRegistry.getRegistry();
            Naming.rebind("LibraryImpl",obj);
        }
        catch(Exception e)
        {}
    }
}
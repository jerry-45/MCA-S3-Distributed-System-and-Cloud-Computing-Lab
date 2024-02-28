package dscc.atulv.com;

import java.rmi.*;
import java.rmi.registry.*;
public class StudentServer
{
    public static void main(String[] agrs)
    {
        try
        {
            StudentImpl obj = new StudentImpl();
            Registry reg = LocateRegistry.getRegistry();
            Naming.rebind("StudentImpl",obj);
        }
        catch(Exception e)
        { 
        }
    }
}
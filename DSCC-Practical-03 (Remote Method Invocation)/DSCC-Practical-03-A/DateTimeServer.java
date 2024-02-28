import java.rmi.*;
import java.rmi.registry.*;

public class DateTimeServer{
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.getRegistry();
            DateTimeImpl obj = new DateTimeImpl();
            Naming.rebind("DateTimeImpl",obj);
        }
        catch(Exception e)
        { }
    }    
}
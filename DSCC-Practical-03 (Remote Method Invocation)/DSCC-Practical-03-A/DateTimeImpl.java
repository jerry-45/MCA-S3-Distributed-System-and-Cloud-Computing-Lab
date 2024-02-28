import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.text.*;

public class DateTimeImpl extends UnicastRemoteObject implements DateTimeInterface{
    DateTimeImpl() throws RemoteException{
        super();
    }

    public String getDate()throws RemoteException{
        return new SimpleDateFormat("dd/mm/yyyy").format(new Date()).toString();
    }

    public String getTime()throws RemoteException{
        return new SimpleDateFormat("hh:mm:ss").format(new Date()).toString();
    }
}
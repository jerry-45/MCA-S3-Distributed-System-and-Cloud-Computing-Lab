import java.rmi.*;

public interface DateTimeInterface extends Remote{
    public String getDate()throws RemoteException;
    public String getTime() throws RemoteException;
}
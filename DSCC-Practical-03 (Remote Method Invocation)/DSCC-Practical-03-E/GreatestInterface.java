import java.rmi.*;

public interface GreatestInterface extends Remote{
    public boolean grt(int num1, int num2)throws RemoteException;
}
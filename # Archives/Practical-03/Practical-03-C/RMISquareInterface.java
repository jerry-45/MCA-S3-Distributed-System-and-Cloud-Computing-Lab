import java.rmi.*;

public interface RMISquareInterface extends Remote {
    public int squareOfSum(int a, int b) throws RemoteException;
}
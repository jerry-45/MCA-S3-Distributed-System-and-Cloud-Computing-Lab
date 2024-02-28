import java.rmi.*;
import java.rmi.server.*;

public class RMISquareImpl extends UnicastRemoteObject implements RMISquareInterface{
    public RMISquareImpl() throws RemoteException{
        super();
    }

    public int squareOfSum(int a, int b) throws RemoteException{
        int sum = a + b;
        int square = sum * sum;

        return square;
    }
}

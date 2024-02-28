import java.rmi.*;

public interface QuadraticEquationInterface extends Remote{
    public double quad(int a, int b, int c) throws RemoteException;
}
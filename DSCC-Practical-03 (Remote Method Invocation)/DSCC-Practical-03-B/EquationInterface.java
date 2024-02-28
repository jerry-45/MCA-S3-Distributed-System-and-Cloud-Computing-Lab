import java.rmi.*;

public interface EquationInterface extends Remote{
    public double square(int a, int b) throws RemoteException;
    public double cube(int a, int b) throws RemoteException;
}
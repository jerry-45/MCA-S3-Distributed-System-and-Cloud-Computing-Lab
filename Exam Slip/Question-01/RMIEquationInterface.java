import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIEquationInterface extends Remote {
    double[] solveQuadratic(double a, double b, double c) throws RemoteException;
}
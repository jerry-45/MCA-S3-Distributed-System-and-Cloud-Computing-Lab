import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIEquationImpl extends UnicastRemoteObject implements RMIEquationInterface {
    public RMIEquationImpl() throws RemoteException {
        super();
    }

    @Override
    public double[] solveQuadratic(double a, double b, double c) throws RemoteException {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            // Complex roots, you can handle this case accordingly
            return new double[0];
        }
    }
}
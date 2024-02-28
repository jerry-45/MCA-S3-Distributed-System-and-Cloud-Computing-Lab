import java.rmi.*;
import java.rmi.server.*;

public class QuadraticEquationImpl extends UnicastRemoteObject implements QuadraticEquationInterface{
    public QuadraticEquationImpl()throws RemoteException{
        super();
    }

    public double quad(int a, int b, int c)throws RemoteException{
        double x = (b*b)-(4*a*c);
        double ans = (float)(-b-Math.sqrt(x))/(2*a);
        return ans;
    }
}
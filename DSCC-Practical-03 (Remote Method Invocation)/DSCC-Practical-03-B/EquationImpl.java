import java.rmi.*;
import java.rmi.server.*;

public class EquationImpl extends UnicastRemoteObject implements EquationInterface{
    public EquationImpl()throws RemoteException{
        super();
    }

    public double square(int a, int b)throws RemoteException{
        double ans = (a*a)+(b*b)+2*a*b;
        return ans;
    }

    public double cube(int a, int b)throws RemoteException{
        double ans = (a*a*a)+3*a*a*b+3*a*(b*b)+(b*b*b);
        return ans;
    }
}
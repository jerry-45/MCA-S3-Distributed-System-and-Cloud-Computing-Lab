import java.rmi.*;
import java.rmi.server.*;

public class CalcImpl extends UnicastRemoteObject{
    public CalcImpl() throws RemoteException{
        super();
    }

    public double add(double num1,double num2)throws RemoteException{
        return (num1 + num2);
    }
    public double sub(double num1,double num2)throws RemoteException{
        return (num1 - num2);
    }
    public double mul(double num1,double num2)throws RemoteException{
        return (num1 * num2);
    }
    public double div(double num1,double num2)throws RemoteException{
        return (num1 / num2);
    }
}

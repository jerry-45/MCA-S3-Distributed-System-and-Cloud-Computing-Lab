import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class BasicCalculatorImpl extends UnicastRemoteObject implements BasicCalculatorInterface{
    public BasicCalculatorImpl() throws RemoteException{
        super();
    }

    public double add(double a, double b)throws RemoteException{
        return a+b;
    }

    public double sub(double a, double b)throws RemoteException{
        return a-b;
    }

    public double mul(double a, double b)throws RemoteException{
        return a*b;
    }

    public double div(double a, double b)throws RemoteException{
        return a/b;
    }
}
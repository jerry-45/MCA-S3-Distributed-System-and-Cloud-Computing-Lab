import java.rmi.*;
public interface CalcInterface extends Remote
{
    public double add(double num1,double num2) throws RemoteException;
    public double sub(double num1,double num2) throws RemoteException;
    public double mul(double num1,double num2) throws RemoteException;
    public double div(double num1,double num2) throws RemoteException;
    public double clear(double num1,double num2) throws RemoteException;
}
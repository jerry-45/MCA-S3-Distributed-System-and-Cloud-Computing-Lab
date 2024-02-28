import java.rmi.*;

public interface StudentScoreInterface extends Remote{
    public double findScore(String name)throws RemoteException;
}
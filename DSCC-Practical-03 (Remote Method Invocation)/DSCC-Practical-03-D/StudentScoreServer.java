import java.rmi.*;
import java.rmi.registry.*;

public class StudentScoreServer{
    public static void main(String[] agrs){
        try{
            StudentScoreImpl obj = new StudentScoreImpl();
            Registry reg = LocateRegistry.getRegistry();
            Naming.rebind("StudentScoreImpl",obj);
        }
        catch(Exception e){

        }
    }
}
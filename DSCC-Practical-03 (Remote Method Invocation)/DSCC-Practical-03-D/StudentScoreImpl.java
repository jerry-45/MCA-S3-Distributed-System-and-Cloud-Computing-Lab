import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class StudentScoreImpl extends UnicastRemoteObject implements StudentScoreInterface{
    private HashMap<String,Double> scores = new HashMap<String,Double>();
    public StudentScoreImpl()throws RemoteException{
        super();
        initializeStudent();
    }

    public void initializeStudent(){
        scores.put("Rachel",new Double(75.00));
        scores.put("Monica",new Double(95.00));
        scores.put("Ross",new Double(85.00));
        scores.put("Chandler",new Double(80.00));
    }

    public double findScore(String name)throws RemoteException{
        Double d = (Double)scores.get(name);
        if(d==null){
            System.out.println("Student"+name+"is not found");
            return -1;
        }
        else{
            System.out.println("Student "+name+" score is "+d.doubleValue());
            return d;
        }
    }
}
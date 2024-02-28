import java.rmi.*;

public class DateTimeClient{
    public static void main(String[] args){
        try{
            DateTimeInterface obj=(DateTimeInterface)Naming.lookup("DateTimeImpl");
            System.out.println("Date is: "+obj.getDate());
            System.out.println("Time is: "+obj.getTime());
        }
        catch(Exception e)
        { }
    }
}

package rmi;
import java.rmi.*;
            for(int i=0;i<size;i++
public class LoginClient {
    public static void main(String[] args) throws RemoteException{
        try{
            LoginInterface obj = (LoginInterface) Naming.lookup("rmi://localhost:2099/db");
            String[] str=obj.getData();
            int size=str.length;){
                if(str[i]!=null)
                    System.out.println(str[i]);
            }
        }
        catch(Exception e){

        }
    }
}

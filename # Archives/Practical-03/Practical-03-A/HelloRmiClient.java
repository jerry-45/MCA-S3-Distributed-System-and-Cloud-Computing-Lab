// client application for searhing services from rmiregistry

import java.rmi.*;

public class HelloRmiClient{
    public static void main(String[] args){
        try{
            HelloRmiInterface remoteObject = (HelloRmiInterface) Naming.lookup("rmi://localhost:2099/hello");
            System.out.println(remoteObject.display());
        }
        catch(Exception e){

        }
    }
}
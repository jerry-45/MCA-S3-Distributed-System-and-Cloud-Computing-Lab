/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_employee;

/**
 *
 * @author Admin
 */
import java.rmi.*;
import java.rmi.registry.*;

public class EmployeeServer {
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.createRegistry(3099);     // we are invoking registry class
            
            // Registry reg = LocateRegistry.getRegistry();
            EmployeeImpl obj = new EmployeeImpl();

            // give a name to obj and store that object inside rmiregistry
            // to give name we have to use bind() or rebind() of Naming class

            Naming.rebind("rmi://localhost:3099/employee", obj);
        }
        catch(Exception e){
            
        }
    }
}

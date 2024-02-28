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

public interface EmployeeInterface extends Remote {
    public String[] getEmployeeDetails(String name) throws RemoteException;
}

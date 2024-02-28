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
import java.util.Scanner;

public class EmployeeClient {
    public static void main(String[] args) throws Exception{
        try{
            EmployeeInterface obj = (EmployeeInterface) Naming.lookup("rmi://localhost:3099/employee");
            System.out.println("Enter Employee Name: ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            String[] str = obj.getEmployeeDetails(name);
            System.out.println(str);
            int size = str.length;
            for(int i = 0; i < size; i++){
                System.out.println(str[i]);
            }
        }
        catch(Exception e)
        {
        }
    }
}

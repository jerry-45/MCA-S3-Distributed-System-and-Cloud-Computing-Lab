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
import java.rmi.server.*;
import java.sql.*;

public class EmployeeImpl extends UnicastRemoteObject implements EmployeeInterface {
    int count = 0, k = 0;
    String[] str;
    
    public EmployeeImpl() throws RemoteException{
        super();
    }
    
    public String[] getEmployeeDetails(String name) throws RemoteException{
        // Database Connection
        try{
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish Conection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi?zeroDateTimeBehavior=convertToNull", "root", "");
            
            Statement st = con.createStatement();
            
            // Set a data returned from a database
            ResultSet rs = st.executeQuery("SELECT emp_name from employee;");
            
            //Count the number of rows in employee table
            while(rs.next()){
                count++;
            }
            
            str = new String[count];
            ResultSet rs1 = st.executeQuery("SELECT * from employee where emp_name = ?;");
            
            ResultSetMetaData rsmd = rs1.getMetaData();
            
            int col = rsmd.getColumnCount();
            
            while(rs1.next()){
                str[k] = "";
                for(int i = 1; i <= col; i++){
                    str[k] = str[k] + rs1.getString(i) + "";
                }
                k++;
            }
        }
        catch(Exception e)
        {
        }
        
        return str;
    }
}

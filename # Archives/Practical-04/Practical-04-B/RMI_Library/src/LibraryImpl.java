/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

public class LibraryImpl extends UnicastRemoteObject implements LibraryInterface {
    
    int count = 0, k = 0;
    String[] str;
    
    public LibraryImpl() throws RemoteException{
        super();
    }
    
    public String[] getBookInfo() throws RemoteException{
        // Database Connection
        try{
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish Conection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi?zeroDateTimeBehavior=convertToNull", "root", "");
            
            Statement st = con.createStatement();
            
            // Set a data returned from a database
            ResultSet rs = st.executeQuery("SELECT * from library;");
            
            //Count the number of rows in library table
            while(rs.next()){
                count++;
            }
            
            //System.out.println("Total Number of Rows is " + count);
            
            str = new String[count];
            ResultSet rs1 = st.executeQuery("SELECT BookName from library;");
            
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

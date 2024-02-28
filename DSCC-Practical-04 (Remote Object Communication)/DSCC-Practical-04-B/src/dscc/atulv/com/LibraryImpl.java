package dscc.atulv.com;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

public class LibraryImpl extends UnicastRemoteObject implements LibraryInterface
{
    int find = 0;
    String info[];
    public LibraryImpl()throws RemoteException
    {
        super();
    }

    public String[] findInfo(String id)throws RemoteException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Registered");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            System.out.println("Database connected");
            Statement stmt = conn.createStatement();
            String str = "select * from Book where Book_id='"+id+"'";
            ResultSet rs = stmt.executeQuery(str);
            while(rs.next())
            {
                find++;
            }
            info = new String[find];
            ResultSet rst = stmt.executeQuery(str);
            for(int i = 0; i < find; i++)
            {
                rst.next();
                info[i] = "Result:\n \n ID: "+rst.getString(1)+"\n \n Book Name: "+rst.getString(2)+"\n \n Author: "+rst.getString(3);
                System.out.println(info[i]);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return info;
    }
}
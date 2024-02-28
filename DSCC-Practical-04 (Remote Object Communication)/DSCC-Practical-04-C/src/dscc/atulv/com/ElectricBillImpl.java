package dscc.atulv.com;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

public class ElectricBillImpl extends UnicastRemoteObject implements ElectricBillInterface
{
    int find = 0;
    String info[];
    public ElectricBillImpl()throws RemoteException
    {
        super();
    }
    public String[] findBill(String name)throws RemoteException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Registered");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/elecrtic_bill","root","");
            System.out.println("Database connected");
            Statement stmt = conn.createStatement();
            String str = "select * from Bill where consumer_name='"+name+"'";
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
                info[i] = "Bill:\n \n Customer: "+rst.getString(1)+"\n \n Due Date: "+rst.getString(2)+"\n \n Amount: Rs."+rst.getString(3);
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
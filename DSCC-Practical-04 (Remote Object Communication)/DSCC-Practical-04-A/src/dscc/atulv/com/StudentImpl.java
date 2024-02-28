package dscc.atulv.com;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
public class StudentImpl extends UnicastRemoteObject implements StudentInterface
{
    private PreparedStatement pstmt;
    public StudentImpl()throws RemoteException
    {
        super();
        initilizeDB();
    }

    protected void initilizeDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver registered");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/symca?zeroDateTimeBehavior=convertToNull","root","");
            System.out.println("Database connected");
            pstmt = conn.prepareStatement("select * from student where Name =?");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    public double findScore(String name)throws RemoteException
    {
        double score = -1;
        try
        {
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                score = rs.getDouble(2); 
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        System.out.println(score);
        return score;
    }
}
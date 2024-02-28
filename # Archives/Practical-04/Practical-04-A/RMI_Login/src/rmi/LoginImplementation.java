package rmi;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
public class LoginImplementation extends UnicastRemoteObject implements LoginInterface {
    int count=0;
    String[] str;
    int k=0;
    public LoginImplementation() throws RemoteException{
        super();
    }
    public String[] getData()throws RemoteException
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rmi?zeroDateTimeBehavior=convertToNull","root","");
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery("select username from login");
            while(rs1.next())
            {
                count++;
            }
            str=new String[count];
            ResultSet rs=st.executeQuery("select username from login");
            ResultSetMetaData rsmd=rs.getMetaData();
            int col = rsmd.getColumnCount();
            while(rs.next()){
                str[k]="";
                for(int i=1;i<=col;i++)
                {
                    str[k]=str[k]+rs.getString(i)+"";
                    
                }
                k++;
            }
        }
        catch(Exception e){
            
        }
        return str;
    }
}

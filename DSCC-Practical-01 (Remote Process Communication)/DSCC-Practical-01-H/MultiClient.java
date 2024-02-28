import java.net.*;
import java.util.*;
import java.io.*;

public class MultiClient
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost", 2222);
        Scanner in = new Scanner(System.in);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        //write msg in socket as a thread object
        Thread sendMsg = new Thread(new Runnable()
        {
                public void run()
                {
                    while(true)
                    {
                        String msg = in.nextLine();
                        try
                        {
                            dos.writeUTF(msg);      //write in output stream
                        }       //close try
                        catch(Exception e)
                        {

                        }       //close catch
                    }           //close while
                }               //close run
        });                     //close runnable

        //read msg from socket as thread
        Thread readMsg = new Thread(new Runnable()
        {
            public void run()
            {
                while(true)
                {
                    try
                    {
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    }           //close try
                    catch(Exception e)
                    {

                    }           //close catch
                }               //close while
            }                   //close run
        });                     //close runnable
        sendMsg.start();
        readMsg.start();
    }
}

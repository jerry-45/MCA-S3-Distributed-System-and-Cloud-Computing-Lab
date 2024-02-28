// Write a program to find the IP address and host information

import java.net.*;
import java.net.InetAddress;
import java.util.*;

public class LocalIPAddress
{
    public static void main(String[] args)
    {
        String hostName = null;

        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter Hostname: ");

        hostName = input.nextLine();

        try
        {
            InetAddress address = InetAddress.getLocalHost();   // return an object
            System.out.println(address);

            String name = address.getHostName();
            System.out.println("Hostname: " + name);

            String host = address.getHostAddress();
            System.out.println("Host Address: " + host);

            InetAddress add = InetAddress.getByName(hostName);
            System.out.println(add.toString());
        }
        catch(Exception e)
        {
            System.out.println("Could not find local address");
        }
    }
}
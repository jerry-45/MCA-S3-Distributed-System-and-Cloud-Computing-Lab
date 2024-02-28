// Write a server program to add 2 numbers which is passed by client program using datagram

import java.net.*;
import java.io.*;

public class AdditionServer
{
    public static void main(String[] args)
    {
        DatagramSocket socket = null;

        try
        {
            socket = new DatagramSocket(9876); // Create a socket bound to port 9876

            byte[] receiveData = new byte[1024];

            while (true)
            {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket); // Wait for incoming datagram packet

                // Extract data from the received packet
                String clientData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + clientData);

                // Split the received data into two numbers
                String[] numbers = clientData.split(",");
                if (numbers.length != 2)
                {
                    System.err.println("Invalid data format from client");
                    continue;
                }

                // Parse the numbers and perform addition
                int num1 = Integer.parseInt(numbers[0]);
                int num2 = Integer.parseInt(numbers[1]);
                int result = num1 + num2;

                // Send the result back to the client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String response = "Result: " + result;
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        finally
        {
            if (socket != null && !socket.isClosed())
            {
                socket.close();
            }
        }
    }
}

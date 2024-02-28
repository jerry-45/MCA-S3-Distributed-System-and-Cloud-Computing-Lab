import java.net.*;
import java.io.*;

public class AdditionClient
{
    public static void main(String[] args)
    {
        DatagramSocket socket = null;

        try
        {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost"); // Replace with the server's IP address if necessary
            int serverPort = 9876; // Server port

            // Input numbers from the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first number: ");
            int num1 = Integer.parseInt(reader.readLine());
            System.out.print("Enter the second number: ");
            int num2 = Integer.parseInt(reader.readLine());

            // Send the numbers to the server
            String data = num1 + "," + num2;
            byte[] sendData = data.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);

            // Receive the result from the server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + result);
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

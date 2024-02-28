import java.net.*;
import java.util.*;
import java.io.*;

public class TCPClient
{
	public static void main(String[] args) throws Exception
	{
		//Step 1: Create a Socket Object
		Socket sock = new Socket("localhost", 1234);

		//Step 2: Set up input and output stream.	
		Scanner input = new Scanner(sock.getInputStream());
		PrintWriter output = new PrintWriter(sock.getOutputStream(), true);
		
		//Step 3: Perform communication
		output.println("This is Atul Vishwakarma");

		//Step 4: Close connection
		sock.close();

	}
}
// Develop a program for oneway client and server communication 
// using Java Socket, where client sends message to the server
// and server reads the message and display on cmd

import java.net.*;		// for network programming
import java.util.*;
import java.io.*;

public class TCPServer
{
	public static void main(String[] args) throws Exception
	{
		//Step 1: Create ServerSocket object
		ServerSocket servSocket = new ServerSocket(1234);
		
		//Step 2: Put the server in a waiting stage. 
		//To accept the client request we have to call accept() method of ServerSocket Class
		Socket link = servSocket.accept();

		//Step 3: Set up input and output stream.
		Scanner  input = new Scanner(link.getInputStream());
		
		PrintWriter output = new PrintWriter(link.getOutputStream());

		//Step 4: Perform Communication
		String msg = input.nextLine();
		//System.out.println("Client address " + servSocket.gethostname());
		System.out.println("Message from client: " + msg);
	}
}
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost", 8080);
        System.out.println("Connected to server");

        Scanner scanner = new Scanner(System.in);

        // Get input from user for two times
        System.out.println("Enter first time (hours and minutes): ");
        String firstTime = scanner.nextLine();

        System.out.println("Enter second time (hours and minutes): ");
        String secondTime = scanner.nextLine();

        // Send input to server
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
        writer.println(firstTime);
        writer.println(secondTime);
        writer.flush();

        // Read results from server
        Scanner serverReader = new Scanner(clientSocket.getInputStream());

        System.out.println("Total time in hours: " + serverReader.nextLine());
        System.out.println("Total time in minutes: " + serverReader.nextLine());

        clientSocket.close();
    }
}

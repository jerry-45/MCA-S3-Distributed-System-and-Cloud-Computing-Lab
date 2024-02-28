import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Read the two values from the client
            String firstTimeString = new Scanner(clientSocket.getInputStream()).nextLine();
            String secondTimeString = new Scanner(clientSocket.getInputStream()).nextLine();

            // Extract hours and minutes from each string
            int firstHours = Integer.parseInt(firstTimeString.split(" ")[0]);
            int firstMinutes = Integer.parseInt(firstTimeString.split(" ")[2]);

            int secondHours = Integer.parseInt(secondTimeString.split(" ")[0]);
            int secondMinutes = Integer.parseInt(secondTimeString.split(" ")[2]);

            // Add hours and minutes separately
            long totalHours = firstHours + secondHours;
            long totalMinutes = firstMinutes + secondMinutes;

            // Calculate total time as Duration
            Duration totalDuration = Duration.ofHours(totalHours).plusMinutes(totalMinutes);

            // Send the results to the client
            String hoursOnly = String.format("%d Hours", totalHours);
            String minutesOnly = String.format("%d Minutes", totalMinutes.toMinutes());

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
            writer.println(hoursOnly);
            writer.println(minutesOnly);
            writer.flush();

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

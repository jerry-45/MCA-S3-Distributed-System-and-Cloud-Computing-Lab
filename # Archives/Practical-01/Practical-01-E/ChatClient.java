import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient extends Application {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private PrintWriter out;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat Client");

        TextField messageInput = new TextField();
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);

        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage(messageInput, chatArea));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(chatArea, messageInput, sendButton);

        primaryStage.setScene(new Scene(vbox, 400, 300));
        primaryStage.show();

        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread receiverThread = new Thread(() -> {
                String message;
                try {
                    while ((message = in.readLine()) != null) {
                        final String msg = message;
                        Platform.runLater(() -> chatArea.appendText(msg + "\n"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(TextField messageInput, TextArea chatArea) {
        String message = messageInput.getText();
        if (!message.isEmpty()) {
            out.println(message);
            messageInput.clear();
        }
    }
}

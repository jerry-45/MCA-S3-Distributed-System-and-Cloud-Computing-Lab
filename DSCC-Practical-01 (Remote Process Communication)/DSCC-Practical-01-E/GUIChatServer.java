import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GUIChatServer extends JFrame implements ActionListener, Runnable {
    JButton b;
    JButton c;
    JTextField tf;
    JTextArea ta;
    ServerSocket ss;
    Socket s;
    PrintWriter pw;
    BufferedReader br;
    Thread th;

    public GUIChatServer(){
        b = new JButton("Send");
        b.addActionListener(this);
        c = new JButton("Close");
        tf = new JTextField(30);
        ta = new JTextArea(20, 40);
        add(tf);
        add(b);
        add(c);
        add(ta);
        try {
            ss = new ServerSocket(1245);
            s = ss.accept();
            ta.append("Server Started:" + new Date() + "\n");
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
        }
        catch(Exception e){

        }
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pw.println("Client Left");
                ta.append("You are disconnected now.\n");
                dispose();
            }
        });

        th = new Thread(this);
        th.start();
    }

    public void actionPerformed(ActionEvent ae) {
        pw.println(tf.getText());
        ta.append("Server Says:" + tf.getText() + "\n");
        tf.setText(" ");
    }

    public void run() {
        while (true) {
            try {
                ta.append("Client says:" + br.readLine() + "\n");
            } 
            catch (Exception e) {
            } 
        }
    }

    public static void main(String[] args) {
        GUIChatServer sc = new GUIChatServer();
        sc.setLayout(new FlowLayout());
        sc.setSize(600, 500);
        sc.setTitle("Server");
        sc.setVisible(true);
    }
}

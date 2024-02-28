import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class GUIChatClient extends JFrame implements ActionListener, Runnable {
    JButton b;
    JButton c;
    JTextField tf;
    JTextArea ta;
    Socket s;
    PrintWriter pw;
    BufferedReader br;
    Thread th;

    public GUIChatClient() {
        b = new JButton("Send");
        c = new JButton("Close");
        b.addActionListener(this);
        tf = new JTextField(30);
        ta = new JTextArea(20, 40);
        add(tf);
        add(b);
        add(c);
        add(ta);
        try {
            s = new Socket("localhost", 1245);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream(), true);
        } 
        catch (Exception e) {
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
        ta.append("Client says:" + tf.getText() + "\n");
        tf.setText("");
    }

    public void run() {
        while (true) {
            try {
                ta.append("Server says:" + br.readLine() + "\n");
            } 
            catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        GUIChatClient c = new GUIChatClient();
        c.setLayout(new FlowLayout());
        c.setSize(600, 500);
        c.setTitle("Client");
        c.setVisible(true);
    }
}

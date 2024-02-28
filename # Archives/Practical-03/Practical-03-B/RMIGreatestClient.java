// RMI GreatestClient.java

import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class RMIGreatestClient extends JFrame implements ActionListener{
    JTextField tf1, tf2;
    JLabel lb1, lb2, lb3;
    JButton btn;
    
    RMIGreatestClient(){
        tf1 = new JTextField();
        tf2 = new JTextField();

        lb1 = new JLabel("Enter First Number: ");
        lb2 = new JLabel("Enter Second Number: ");
        lb3 = new JLabel("");

        btn = new JButton("Find Greatest");

        add(lb1);
        add(tf1);

        add(lb2);
        add(tf2);

        add(lb3);

        add(btn);

        btn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            RMIGreatestInterface obj = (RMIGreatestInterface) Naming.lookup("greatest");
                
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt(tf2.getText());
            int c = obj.greatest(a, b);

            // lb3.setText("Greatest is ");
            lb3.setText(c + " is the greatest number");
        }
        catch(Exception e){
            // lb3.setText("ERROR");
        }
    }

    public static void main(String[] args){
        RMIGreatestClient gc = new RMIGreatestClient();
        gc.setLayout(new GridLayout(6, 1));
        gc.setVisible(true);
        gc.setSize(400, 400);
    }
}

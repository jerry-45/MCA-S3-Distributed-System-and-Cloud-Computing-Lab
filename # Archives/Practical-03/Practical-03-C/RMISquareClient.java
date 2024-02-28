import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RMISquareClient extends JFrame implements ActionListener{
    JTextField tf1, tf2;
    JLabel lb1, lb2, lb3;
    JButton btn;
    
    RMISquareClient(){
        tf1 = new JTextField();
        tf2 = new JTextField();

        lb1 = new JLabel("Enter First Number: ");
        lb2 = new JLabel("Enter Second Number: ");
        lb3 = new JLabel("");

        btn = new JButton("FIND");

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
            RMISquareInterface obj = (RMISquareInterface) Naming.lookup("squareOfSum");
                
            int a = Integer.parseInt(tf1.getText());
            int b = Integer.parseInt(tf2.getText());
            int c = obj.squareOfSum(a, b);

            lb3.setText("Square of sum of two numbers is " + c);
        }
        catch(Exception e){
            lb3.setText("ERROR");
        }
    }

    public static void main(String[] args){
        RMISquareClient gc = new RMISquareClient();
        gc.setLayout(new GridLayout(6, 1));
        gc.setVisible(true);
        gc.setSize(400, 400);
    }
}

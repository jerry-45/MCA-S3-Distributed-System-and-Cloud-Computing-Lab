import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GreatestClient extends JFrame implements ActionListener{
    JTextField tf1,tf2;
    JLabel lb1,lb2,lb3,lb4,lb5;
    JButton btn;
    GreatestClient(){
        JFrame frame = new JFrame("Even Odd Tester");
        tf1=new JTextField(10);
        tf2=new JTextField(10);
        lb1=new JLabel("<html>Enter First Number:&emsp;</html>", SwingConstants.CENTER);
        lb5=new JLabel("<html>Enter Second Number:&emsp;</html>", SwingConstants.CENTER);
        lb2=new JLabel("<html><br/><br/><br/><br/><br/></html>", SwingConstants.CENTER);
        lb3=new JLabel("", SwingConstants.CENTER);
        lb4=new JLabel("<html><br/><br/><br/><br/></html>", SwingConstants.CENTER);
        btn=new JButton("Find Largest");
        Panel p=new Panel();
        p.add(lb1);
        p.add(tf1);
        p.add(lb5);
        p.add(tf2);
        p.add(lb2);
        p.add(lb3);
        p.add(lb4);
        p.add(btn);
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            GreatestInterface obj=(GreatestInterface)Naming.lookup("GreatestImpl");
            int num1=Integer.parseInt(tf1.getText());
            int num2=Integer.parseInt(tf2.getText());
            if(obj.grt(num1,num2)){
                lb3.setText(" Result: "+num1+" is the Larger Number ");
            }
            else{
                lb3.setText(" Result: "+num2+" is the Larger Number ");
            }
        }
        catch(Exception e){
            lb3.setText("Error");
        }
    }
    public static void main(String[] args){
        GreatestClient gc=new GreatestClient();
        gc.setLayout(new GridLayout(6,1));
        gc.setVisible(true);
        gc.setSize(400,300);
    }
}
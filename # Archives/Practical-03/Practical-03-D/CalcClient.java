import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalcClient extends JApplet implements ActionListener{

    private CalcInterface calc;
    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();

    private JLabel lb1 = new JLabel("Enter 1st number.");
    private JLabel lb2 = new JLabel("Enter 2nd number.");
    private JLabel lb3 = new JLabel("");

    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton div = new JButton("/");
    
    public void init()
    {
        try{
            calc=(CalcInterface)Naming.lookup("Calculator");
        }
        catch(Exception e){
        }
        JPanel panel=new JPanel();
        panel.setLayout(null);
        lb1.setBounds(15,15,75,33);
        panel.add(lb1);
        tf1.setBounds(85,15,130,33);
        panel.add(lb1);
        lb2.setBounds(15,65,75,33);
        panel.add(lb2);
        tf2.setBounds(85,65,130,33);
        panel.add(lb1);
        add.setBounds(15,75,70,33);
        panel.add(add,BorderLayout.CENTER);
        sub.setBounds(85,120,70,33);
        panel.add(sub,BorderLayout.CENTER);
        mul.setBounds(15,75,70,33);
        panel.add(mul,BorderLayout.CENTER);
        div.setBounds(85,125,70,33);
        panel.add(div,BorderLayout.CENTER);
        lb3.setBounds(15,130,75,33);
        panel.add(lb3);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                add();
            }
        });
        
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                sub();
            }
        });
        ;
        mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                mul();
            }
        });
        
        div.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                div();
            }
        });
        
    }
    public void add()
    {
        try{
            double result=calc.add(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            lb3.setText("Result : "+result);
        }
        catch(Exception e){

        }
    }
    public void sub()
    {
        try{
            double result=calc.sub(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            lb3.setText("Result : "+result);
        }
        catch(Exception e){

        }
    }
    public void mul()
    {
        try{
            double result=calc.mul(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            lb3.setText("Result : "+result);
        }
        catch(Exception e){

        }
    }
    public void div()
    {
        try{
            double result=calc.div(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            lb3.setText("Result : "+result);
        }
        catch(Exception e){

        }
    }
    public static void main(String[] args){
        CalcClient applet=new CalcClient();
        JFrame frame=new JFrame();
        frame.setTitle("Calculator");
        frame.add(applet,BorderLayout.CENTER);
        frame.setSize(700, 350);
        applet.init();
        frame.setVisible(true);
    }
}

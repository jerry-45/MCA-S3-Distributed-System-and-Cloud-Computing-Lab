import java.rmi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicCalculatorClient extends JApplet{
    private BasicCalculatorInterface student;
    private JButton add = new JButton("+");
    private JButton sub = new JButton("-");
    private JButton mul = new JButton("*");
    private JButton div = new JButton("/");
    private JTextField tf1 = new JTextField();
    private JTextField tf2 = new JTextField();
    private JLabel lname = new JLabel("Number 1");
    private JLabel lscore = new JLabel("Number 2");
    private JLabel result = new JLabel("");

    public void init(){
        try{
            student = (BasicCalculatorInterface)Naming.lookup("BasicCalculatorImpl");
        }
        catch(Exception e){}

        JPanel panel = new JPanel();
        panel.setLayout(null);
        lname.setBounds(15, 15, 75, 33);
        panel.add(lname);
        tf1.setBounds(95, 15, 150, 33);
        panel.add(tf1);
        lscore.setBounds(15, 65, 75, 33);
        panel.add(lscore);
        tf2.setBounds(95, 65, 150, 33);
        panel.add(tf2);
        add.setBounds(95, 130, 100, 33);
        panel.add(add, BorderLayout.CENTER);
        sub.setBounds(205, 130, 100, 33);
        panel.add(sub, BorderLayout.CENTER);
        mul.setBounds(315, 130, 100, 33);
        panel.add(mul, BorderLayout.CENTER);
        div.setBounds(425, 130, 100, 33);
        panel.add(div, BorderLayout.CENTER);
        result.setBounds(100, 170, 175, 75);
        panel.add(result);
        add(panel,BorderLayout.CENTER);

        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                add();
            }
        });

        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                sub();
            }
        });

        mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                mul();
            }
        });

        div.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                div();
            }
        });
    }

    public void add(){
        try{
            double score = student.add(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            result.setText("Result: "+score);
            System.out.println("Result: "+score);
        }
        catch(Exception ex){
        }
    }

    public void sub(){
        try{
            double score = student.sub(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            result.setText("Result: "+score);
            System.out.println("Result: "+score);
        }
        catch(Exception ex){
        }
    }
    
    public void mul(){
        try{
            double score = student.mul(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            result.setText("Result: "+score);
            System.out.println("Result: "+score);
        }
        catch(Exception ex){
        }
    }

    public void div(){
        try{
            double score = student.div(Double.parseDouble(tf1.getText()),Double.parseDouble(tf2.getText()));
            result.setText("Result: "+score);
            System.out.println("Result: "+score);
        }
        catch(Exception ex){
        }
    }

    public static void main(String[] args){
        BasicCalculatorClient applet = new BasicCalculatorClient();
        JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        frame.add(applet,BorderLayout.CENTER);
        frame.setSize(700,350);
        applet.init();
        frame.setVisible(true);
    }
}
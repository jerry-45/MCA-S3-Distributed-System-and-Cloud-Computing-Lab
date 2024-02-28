import java.rmi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentScoreClient extends JApplet{
    private StudentScoreInterface student;
    private JButton getScore = new JButton("Get Score");
    private JTextField name = new JTextField();
    private JTextField tfscore = new JTextField();
    private JLabel lname = new JLabel("Student");
    private JLabel lscore = new JLabel("Score");
    public void init(){
        try{
            student = (StudentScoreInterface)Naming.lookup("StudentScoreImpl");
        }
        catch(Exception e){

        }
        JPanel panel = new JPanel();
        panel.setLayout(null);
        lname.setBounds(15, 15, 75, 33);
        panel.add(lname);
        name.setBounds(95, 15, 150, 33);
        panel.add(name);
        lscore.setBounds(15, 65, 75, 33);
        panel.add(lscore);
        tfscore.setBounds(95, 65, 150, 33);
        panel.add(tfscore);
        getScore.setBounds(95, 130, 150, 33);
        panel.add(getScore, BorderLayout.CENTER);
        add(panel,BorderLayout.CENTER);
        
        getScore.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                getScore();
            } 
        });
    }
    public void getScore(){
        try {
            double score = student.findScore(name.getText());
            if(score<0)
                tfscore.setText("Not Found");
            else
                tfscore.setText(""+score);
        }
        catch(Exception ex){ 

        }
    }
    public static void main(String[] args){
        StudentScoreClient applet = new StudentScoreClient();
        JFrame frame = new JFrame();
        frame.setTitle("Result Board");
        frame.add(applet,BorderLayout.CENTER);
        frame.setSize(300,250);
        applet.init();
        frame.setVisible(true);
    }
}
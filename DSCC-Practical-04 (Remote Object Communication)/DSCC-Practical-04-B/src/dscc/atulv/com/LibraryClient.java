package dscc.atulv.com;

import java.rmi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryClient extends JApplet
{
    private LibraryInterface library;
    private JButton getDetail = new JButton("Get Detail");
    private JTextField name = new JTextField();
    private JLabel lname = new JLabel("Book");
    private JLabel result = new JLabel("Result");
    public void init()
    {
        try
        {
            library = (LibraryInterface)Naming.lookup("LibraryImpl");
        }
        catch(Exception e)
        {
        }
        JPanel panel = new JPanel();
        panel.setLayout(null);
        lname.setBounds(15, 15, 75, 33);
        panel.add(lname);
        name.setBounds(95, 15, 150, 33);
        panel.add(name);
        result.setBounds(15, 65, 750, 45);
        panel.add(result);
        getDetail.setBounds(115, 130, 150, 33);
        panel.add(getDetail, BorderLayout.CENTER);
        add(panel,BorderLayout.CENTER);
        getDetail.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                getDetail();
            }
        });
    }

    public void getDetail()
    {
        try
        {
            String[] str = library.findInfo(name.getText());
            String r = "";
            for(int i = 0; i<str.length; i++)
            {
                r += " \n"+str[i];
                System.out.println(str[i]);
            }
            result.setText(r);
        }
        catch(Exception ex)
        {
        }
    }

    public static void main(String[] args)
    {
        LibraryClient applet = new LibraryClient();
        JFrame frame = new JFrame();
        frame.setTitle("Book Details");
        frame.add(applet,BorderLayout.CENTER);
        frame.setSize(450,250);
        applet.init();
        frame.setVisible(true);
    } 
}
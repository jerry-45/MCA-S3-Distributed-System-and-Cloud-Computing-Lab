package dscc.atulv.com;

import java.rmi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ElectricBillClient extends JApplet
{
    private ElectricBillInterface electric;
    private JButton getBill = new JButton("Get Bill");
    private JTextField name = new JTextField();
    private JLabel lname = new JLabel("Customer");
    private JLabel result = new JLabel("Bill");

    public void init()
    {
        try
        {
            electric = (ElectricBillInterface)Naming.lookup("ElectricBillImpl");
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
        getBill.setBounds(115, 130, 150, 33);
        panel.add(getBill, BorderLayout.CENTER);
        add(panel,BorderLayout.CENTER);
        getBill.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                getBill();
            }
        });
    }

    public void getBill()
    {
        try
        {
            String[] str = electric.findBill(name.getText());
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
        ElectricBillClient applet = new ElectricBillClient();
        JFrame frame = new JFrame();
        frame.setTitle("Bill Details");
        frame.add(applet,BorderLayout.CENTER);
        frame.setSize(450,250);
        applet.init();
        frame.setVisible(true);
    }
}

package universitymanagementsystem;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener
{
    Choice cempId,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TeacherLeave()
    {
        setSize(510,550);
        getContentPane().setBackground(Color.darkGray);
        setLocation(600,150);
        
        setLayout(null);
        // for heading
        JLabel heading=new JLabel("Apply Leave(Teacher)");
        heading.setBounds(130,50,300,30);       
        heading.setFont(new Font("serif",Font.BOLD,25));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        // for heading
        JLabel lbempId=new JLabel("Search by Employee Id : ");
        lbempId.setBounds(70,130,180,25);             
        lbempId.setFont(new Font("serif",Font.BOLD,20 ));
        lbempId.setForeground(Color.WHITE);
        add(lbempId);
        
        // choice
        cempId=new Choice();
        cempId.setBounds(260,133,150,25);
        add(cempId);    
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from Teacher"); 
            while(rs.next())
            {
                cempId.add(rs.getString("empId"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel lbdate=new JLabel("Date");
        lbdate.setBounds(70,180,180,25);             
        lbdate.setFont(new Font("serif",Font.BOLD,20 ));
        lbdate.setForeground(Color.WHITE);
        add(lbdate);
        
        dcdate=new JDateChooser();
        dcdate.setBounds(73,220,200,25);
        add(dcdate);
        
        // time
        JLabel lbtime=new JLabel("Time Duration");
        lbtime.setBounds(70,270,180,22);             
        lbtime.setFont(new Font("serif",Font.BOLD,20 ));
        lbtime.setForeground(Color.WHITE);
        add(lbtime);
        
        // choice
        ctime=new Choice();
        ctime.setBounds(73,310,150,25);
        ctime.add("Select time");
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        // submit button
        submit=new JButton("Submit");
        submit.setBounds(110,370,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        //add action listener for button
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(280,370,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        // add action listener for button
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String empId=cempId.getSelectedItem();
            String date= ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String query="insert into TeacherLeave values('" +empId+"','" +date+"','" +duration+"')";
            
            try
            {
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirm.");
                setVisible(false);
           }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else
        {
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new TeacherLeave();
    }
}

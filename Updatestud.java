package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
// for submit cancel button we need actionListener
import java.awt.event.*;
import java.sql.*;
public class Updatestud extends JFrame implements ActionListener
{
    JTextField tfcourse, tfaddr,tfphone,tfemail,tfbranch;
    // roll no is not editable it it random number
    JLabel lbrollno;
    // for buttons
    JButton submit,cancel;
    Choice crollno;
    
    Updatestud()
    {
        setSize(1000,680);
        setLocation(350,70);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
        JLabel lbrollno=new JLabel("Select Roll Number");
        lbrollno.setBounds(90,90,200,25);
        lbrollno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbrollno);
        
        // choice
        crollno=new Choice();
        crollno.setBounds(340,92,200,25);
        add(crollno);
               
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from Student"); 
            while(rs.next())
            {
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        // label
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(90,140,100,30);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);
        
        // for accepting name of student
        JLabel labelname=new JLabel();
        labelname.setBounds(260,143,180,30);
        add(labelname);
        
        // for fathers name
        JLabel lbfname=new JLabel("Father's Name");
        lbfname.setBounds(520,140,200,30);
        lbfname.setFont(new Font("serif",Font.BOLD,20));
        add(lbfname);
        
        JLabel labelfname=new JLabel();
        labelfname.setBounds(680,143,180,30);
        add(labelfname);
        
        // for roll number
        JLabel lbroll=new JLabel("Roll Number");
        lbroll.setBounds(90,200,200,28);
        lbroll.setFont(new Font("serif",Font.BOLD,20));
        add(lbroll); 
        
        lbrollno=new JLabel();
        lbrollno.setBounds(260,201,200,28);
        lbrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lbrollno);
        
        // for date of birth
        JLabel lbdob=new JLabel("Date Of Birth");
        lbdob.setBounds(522,201,200,28);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);
        
        // for dob
        JLabel dob=new JLabel();
        dob.setBounds(680,200,200,30);
        add(dob);
        
        // for address
        JLabel lbaddr=new JLabel("Address");
        lbaddr.setBounds(90,270,200,28);
        lbaddr.setFont(new Font("serif",Font.BOLD,20));
        add(lbaddr); 
        
        tfaddr=new JTextField();
        tfaddr.setBounds(260,273,200,28);
        add(tfaddr);
        
        // for phone
        JLabel lbphone=new JLabel("Phone");
        lbphone.setBounds(522,270,200,28);
        lbphone.setFont(new Font("serif",Font.BOLD,20));
        add(lbphone); 
        
        tfphone=new JTextField();
        tfphone.setBounds(680,273,200,28);
        add(tfphone);
        
        //for email
        JLabel lbemail=new JLabel("Email Id");
        lbemail.setBounds(90,330,200,28);
        lbemail.setFont(new Font("serif",Font.BOLD,20));
        add(lbemail); 
        
        tfemail=new JTextField();
        tfemail.setBounds(260,332,200,28);
        add(tfemail);
        
        // class in X
        JLabel lbclassX=new JLabel("Class X(%)");
        lbclassX.setBounds(522,330,200,28);
        lbclassX.setFont(new Font("serif",Font.BOLD,20));
        add(lbclassX); 
        
        JLabel lx=new JLabel();
        lx.setBounds(680,333,200,28);
        add(lx);
        
        //for class 12th
        JLabel lbxii=new JLabel("Class XII(%)");
        lbxii.setBounds(90,410,200,28);
        lbxii.setFont(new Font("serif",Font.BOLD,20));
        add(lbxii); 
        
        JLabel labelxii=new JLabel();
        labelxii.setBounds(260,410,200,28);
        add(labelxii);
        
        // class in X
        JLabel lbaddhar=new JLabel("Aadhar Number");
        lbaddhar.setBounds(522,410,200,28);
        lbaddhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbaddhar); 
        
        JLabel labelAAdhar=new JLabel();
        labelAAdhar.setBounds(680,413,200,28);
        add(labelAAdhar);
        
        //for course
        JLabel lbcourse=new JLabel("Course");
        lbcourse.setBounds(90,470,200,28);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse); 
        
        
        tfcourse=new JTextField();
        tfcourse.setBounds(260,473,200,28);
        add(tfcourse);
        
        // for branch
        JLabel lbbranch=new JLabel("Branch");
        lbbranch.setBounds(522,470,200,28);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch); 
        
        tfbranch=new JTextField();
        tfbranch.setBounds(680,470,200,28);
        add(tfbranch);
        
        try
        {
            Conn c=new Conn();
            String query="select * from Student where rollno'"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        // submit button
        submit=new JButton("Update");
        submit.setBounds(290,560,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        // add action listener for button
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(580,560,100,30);
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
           String name=tfname1.getText();
           String fname=tffname.getText();
           String rollno=lbrollno.getText();
           String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
           String address = tfaddr.getText();
           String phone=tfphone.getText();
           String email=tfemail.getText();
           String X=tfclassX.getText();
           String xii=txii.getText();
           String aadhar=tfaddhar.getText();
           String course=(String)cbcourse.getSelectedItem(); // we do the typecast because it contains object
           String branch=(String)cbbranch.getSelectedItem();
           
           try
           {
               String query="insert into Student values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+X+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
               Conn c=new Conn();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Student details inserted succesfully.");
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
    
    public static void main(String [] args)
    {
        new Updatestud();
    }
}


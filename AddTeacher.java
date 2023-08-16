package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
// for submit cancel button we need actionListener
import java.awt.event.*;

public class AddTeacher extends JFrame implements ActionListener
{
     JTextField tfname1,tffname,tfaddr,tfphone,tfemail,tfclassX,txii,tfaddhar;
    // roll no is not editable it it random number
    JLabel lbempId;
    // for random roll 
    Random ran=new Random();
    //number is enter by user so it is long
    long first4=Math.abs((ran.nextLong()%9000)+1000L);
    
    // for calendar
    JDateChooser dcdob;
    // for course and branch
    JComboBox cbcourse,cbbranch;
    
    // for buttons
    JButton submit,cancel;
    
    AddTeacher()
    {
        setSize(1000,700);
        setLocation(350,70);
        setLayout(null);
        
        JLabel heading=new JLabel("New Teacher Details");
        heading.setBounds(360,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,35));
        add(heading);
        
        // label
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(90,140,100,30);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);
        
        // for accepting name of student
        tfname1=new JTextField();
        tfname1.setBounds(260,143,180,30);
        add(tfname1);
        
        // for fathers name
        JLabel lbfname=new JLabel("Father's Name");
        lbfname.setBounds(520,140,200,30);
        lbfname.setFont(new Font("serif",Font.BOLD,20));
        add(lbfname);
        
        tffname=new JTextField();
        tffname.setBounds(680,143,180,30);
        add(tffname);
        
        // for roll number
        JLabel lbemp=new JLabel("Employee Id");
        lbemp.setBounds(90,200,200,28);
        lbemp.setFont(new Font("serif",Font.BOLD,20));
        add(lbemp); 
        
        lbempId=new JLabel("101"+first4);
        lbempId.setBounds(260,201,200,28);
        lbempId.setFont(new Font("serif",Font.BOLD,20));
        add(lbempId);
        
        // for date of birth
        JLabel lbdob=new JLabel("Date Of Birth");
        lbdob.setBounds(522,201,200,28);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);
        
        // for dob
        dcdob=new JDateChooser();
        dcdob.setBounds(680,200,200,30);
        add(dcdob);
        
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
        
        tfclassX=new JTextField();
        tfclassX.setBounds(680,333,200,28);
        add(tfclassX);
        
        //for class 12th
        JLabel lbxii=new JLabel("Class XII(%)");
        lbxii.setBounds(90,410,200,28);
        lbxii.setFont(new Font("serif",Font.BOLD,20));
        add(lbxii); 
        
        txii=new JTextField();
        txii.setBounds(260,410,200,28);
        add(txii);
        
        // class in X
        JLabel lbaddhar=new JLabel("Aadhar Number");
        lbaddhar.setBounds(522,410,200,28);
        lbaddhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbaddhar); 
        
        tfaddhar=new JTextField();
        tfaddhar.setBounds(680,413,200,28);
        add(tfaddhar);
        
        //for course
        JLabel lbcourse=new JLabel("Qualification");
        lbcourse.setBounds(90,470,200,28);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse); 
        
        // for add the values in couse we have to create of array of it
        String course[]={"Select Course","BBA","BCA","B.E","Bsc","B.Tech","MCA","MSC","M.E","MBA"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(260,473,200,28);
        add(cbcourse);
        
        // for branch
        JLabel lbbranch=new JLabel("Department");
        lbbranch.setBounds(522,470,200,28);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch); 
        
        // for add the values in couse we have to create of array of it
        String branch[]={"Select branch","Artificial Intelligence","Automation and Robotics","Civil Engineering","Chemical Engineering","Computer Engineering","Electronics & Telecomunication","Mechanical Engineering","Electrical Engineering","Instrumentation Engineering"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(680,470,200,28);
        add(cbbranch);
        
        // submit button
        submit=new JButton("Submit");
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
           String empId=lbempId.getText();
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
               String query="insert into Teacher values('"+name+"','"+fname+"','"+empId+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+X+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
               Conn c=new Conn();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Teacher details inserted succesfully.");
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
        new AddTeacher();
    }
}

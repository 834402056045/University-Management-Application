package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateTeacher extends JFrame implements ActionListener
{
    JTextField tfcourse,tfaddr,tfphone,tfemail,tfbranch;
    // roll no is not editable it it random number
   // JLabel lbrollno;
    // for buttons
    JButton submit,cancel;
    Choice cempId;
    JLabel LabelEmpId;
    private Object labelbrollno;
    UpdateTeacher()
    {
        setSize(1000,680);
        setLocation(350,70);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Teacher Details");
        heading.setBounds(50,30,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
       // for searching roll number
       JLabel lbrollno=new JLabel("Select Employee Id");
        lbrollno.setBounds(90,100,200,25);
        lbrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lbrollno);
        
        // choice
        cempId=new Choice();
        cempId.setBounds(290,100,200,25);
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
       
        // label
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(90,140,100,30);
        lbname.setFont(new Font("serif",Font.BOLD,20));
        add(lbname);
        
        // for accepting name of student
        JLabel lbname1=new JLabel();
        lbname1.setBounds(260,143,180,30);
        lbname1.setFont(new Font("serif",Font.PLAIN,20));
        add(lbname1);
        
        // for fathers name
        JLabel lbfname=new JLabel("Father's Name");
        lbfname.setBounds(520,140,200,30);
        lbfname.setFont(new Font("serif",Font.BOLD,20));
        add(lbfname);
        
        JLabel fname=new JLabel();
        fname.setBounds(680,143,180,30);
        fname.setFont(new Font("serif",Font.PLAIN,20));
        add(fname);
        
        // for roll number
        JLabel lbroll=new JLabel("Employee Id");
        lbroll.setBounds(90,200,200,28);
        lbroll.setFont(new Font("serif",Font.BOLD,20));
        add(lbroll); 
        
        LabelEmpId=new JLabel();
        LabelEmpId.setBounds(260,201,200,28);
        LabelEmpId.setFont(new Font("serif",Font.BOLD,20));
        add(LabelEmpId);
        
        // for date of birth
        JLabel lbdob=new JLabel("Date Of Birth");
        lbdob.setBounds(522,201,200,28);
        lbdob.setFont(new Font("serif",Font.BOLD,20));
        add(lbdob);
        
        // for dob
        JLabel dob=new JLabel();
        dob.setBounds(680,200,200,30);
        dob.setFont(new Font("serif",Font.PLAIN,20));
        add(dob);
        
        // for address
        JLabel lbaddr=new JLabel("Address");
        lbaddr.setBounds(90,270,200,28);
        lbaddr.setFont(new Font("serif",Font.BOLD,20));
        add(lbaddr); 
        
        tfaddr=new JTextField();
        tfaddr.setBounds(260,273,200,28);
        tfaddr.setFont(new Font("serif",Font.PLAIN,20));
        add(tfaddr);
        
        // for phone
        JLabel lbphone=new JLabel("Phone");
        lbphone.setBounds(522,270,200,28);
        lbphone.setFont(new Font("serif",Font.BOLD,20));
        add(lbphone); 
        
        tfphone=new JTextField();
        tfphone.setBounds(680,273,200,28);
        tfphone.setFont(new Font("serif",Font.PLAIN,20));
        add(tfphone);
        
        //for email
        JLabel lbemail=new JLabel("Email Id");
        lbemail.setBounds(90,330,200,28);
        lbemail.setFont(new Font("serif",Font.BOLD,20));
        add(lbemail); 
        
        tfemail=new JTextField();
        tfemail.setBounds(260,332,200,28);
        tfemail.setFont(new Font("serif",Font.PLAIN,16));
        add(tfemail);
        
        // class in X
        JLabel lbclassX=new JLabel("Class X(%)");
        lbclassX.setBounds(522,330,200,28);
        lbclassX.setFont(new Font("serif",Font.BOLD,20));
        add(lbclassX); 
        
        JLabel lbx=new JLabel();
        lbx.setBounds(680,333,200,28);
        lbx.setFont(new Font("serif",Font.PLAIN,20));
        add(lbx);
        
        //for class 12th
        JLabel lbxii=new JLabel("Class XII(%)");
        lbxii.setBounds(90,410,200,28);
        lbxii.setFont(new Font("serif",Font.BOLD,20));
        add(lbxii); 
        
        JLabel labelbxii=new JLabel();
        labelbxii.setBounds(260,410,200,28);
        labelbxii.setFont(new Font("serif",Font.PLAIN,20));
        add(labelbxii);
        
        // class in X
        JLabel lbaddhar=new JLabel("Aadhar Number");
        lbaddhar.setBounds(522,410,200,28);
        lbaddhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbaddhar); 
        
       JLabel faddhar=new JLabel();
        faddhar.setBounds(680,413,200,28);
        faddhar.setFont(new Font("serif",Font.PLAIN,20));
        add(faddhar);
        
        //for course
        JLabel lbcourse=new JLabel("Education");
        lbcourse.setBounds(90,470,200,28);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse); 
        
        
        tfcourse=new JTextField();
        tfcourse.setBounds(260,473,200,28);
        tfcourse.setFont(new Font("serif",Font.PLAIN,20));
        add(tfcourse);
        
        // for branch
        JLabel lbbranch=new JLabel("Department");
        lbbranch.setBounds(522,470,200,28);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch); 
        
        tfbranch=new JTextField();
        tfbranch.setBounds(680,470,200,28);
        tfbranch.setFont(new Font("serif",Font.PLAIN,16));
        add(tfbranch);
        
        try
        {
           Conn c=new Conn();
           String query="select * from Teacher where empId='"+cempId.getSelectedItem()+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next())
           {
               lbname1.setText(rs.getString("name"));
               fname.setText(rs.getString("fname"));
               dob.setText(rs.getString("dob"));
               tfaddr.setText(rs.getString("address"));
               tfphone.setText(rs.getString("phone"));
               tfemail.setText(rs.getString("email"));
               lbx.setText(rs.getString("class_x"));
               labelbxii.setText(rs.getString("class_xii"));
               faddhar.setText(rs.getString("aadhar"));   
               LabelEmpId.setText(rs.getString("empId"));
               tfcourse.setText(rs.getString("education"));
               tfbranch.setText(rs.getString("department"));
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        cempId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie)
            {
                try
                {
                   Conn c=new Conn();
                        String query="select * from Teacher where empId='"+cempId.getSelectedItem()+"'";
                        ResultSet rs=c.s.executeQuery(query);
                        while(rs.next())
                        {
                            lbname1.setText(rs.getString("name"));
                            fname.setText(rs.getString("fname"));
                            dob.setText(rs.getString("dob"));
                            tfaddr.setText(rs.getString("address"));
                            tfphone.setText(rs.getString("phone"));
                            tfemail.setText(rs.getString("email"));
                            lbx.setText(rs.getString("class_x"));
                            labelbxii.setText(rs.getString("class_xii"));
                            faddhar.setText(rs.getString("aadhar"));   
                            LabelEmpId.setText(rs.getString("empId"));
                            tfcourse.setText(rs.getString("qulaification"));
                            tfbranch.setText(rs.getString("department"));
                        }
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                    }
        });
        
       
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
          
          String empId=cempId.getSelectedItem();
           String address = tfaddr.getText();
           String phone=tfphone.getText();
           String email=tfemail.getText();
           String course=tfcourse.getText();
           String branch=tfbranch.getText();
           try
           {
               String query="update Teacher set address='"+address+"',phone='"+phone+"',email='"+email+"',qulaification='"+course+"',department='"+branch+"'where empId='"+empId+"'";
               Conn c=new Conn();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Student details updated succesfully.");
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
        new UpdateTeacher();
    }
}


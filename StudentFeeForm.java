
package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class StudentFeeForm extends JFrame implements ActionListener{
    Choice crollno;
    JLabel labeltotal;
    JComboBox cbcourse,cbbranch,cbsemester;
    JButton update,pay,back;
    StudentFeeForm()
    {
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3); 
        label.setBounds(400, 60, 450, 306);
        add(label);
        
        JLabel lbrollno=new JLabel("Select Roll No");
        lbrollno.setBounds(40,60,150,25);
        lbrollno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbrollno);
        
        // choice
        crollno=new Choice();
        crollno.setBounds(200,60,150,25);
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
        
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(40,120,150,30);
        lbname.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lbname);
        
        // for accepting name of student
        JLabel lbname1=new JLabel();
        lbname1.setBounds(200,120,150,30);
        lbname1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbname1);
        
        // for fathers name
        JLabel lbfname=new JLabel("Father's Name");
        lbfname.setBounds(40,160,150,30);
        lbfname.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lbfname);
        
        JLabel fname=new JLabel();
        fname.setBounds(200,160,150,30);
        fname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(fname);
        
        try
        {
           Conn c=new Conn();
           String query="select * from Student where rollno='"+crollno.getSelectedItem()+"'";
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next())
           {
               lbname1.setText(rs.getString("name"));
               fname.setText(rs.getString("fname"));;
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie)
            {
                try
                {
                   Conn c=new Conn();
                   String query="select * from Student where rollno='"+crollno.getSelectedItem()+"'";
                   ResultSet rs=c.s.executeQuery(query);
                   while(rs.next())
                   {
                       lbname1.setText(rs.getString("name"));
                       fname.setText(rs.getString("fname"));
                   }
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                }
        });
        
        JLabel lbcourse=new JLabel("Course");
        lbcourse.setBounds(40,215,150,20);
        lbcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lbcourse); 
        
        // for add the values in couse we have to create of array of it
        String course[]={"BTech","MSC","B.E","Bcom","BCA","B.Sc","MCA","MTech"};
        cbcourse=new JComboBox(course);
        cbcourse.setBounds(200,215,150,20);
        add(cbcourse);
        
        // for branch
        JLabel lbbranch=new JLabel("Branch");
        lbbranch.setBounds(40,260,150,20);
        lbbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lbbranch); 
        
        // for add the values in couse we have to create of array of it
        String branch[]={"Select branch","AI","A&R","Civil","Chemical","CS","E&TC","Mechanical","Electrical","Instrumentation"};
        cbbranch=new JComboBox(branch);
        cbbranch.setBounds(200,260,150,20);
        add(cbbranch);
        
        JLabel lblsemester=new JLabel("Semester");
        lblsemester.setBounds(40,310,150,20); 
        lblsemester.setFont(new Font("serif",Font.BOLD,20));
        add(lblsemester);
        
        String semester[]={"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(200,310,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel total=new JLabel("Total Payable");
        total.setBounds(40,350,150,20);
        total.setFont(new Font("serif",Font.PLAIN,20));
        add(total);
        
        labeltotal=new JLabel();
        labeltotal.setBounds(200,350,150,20);
        labeltotal.setFont(new Font("serif",Font.PLAIN,20));
        add(labeltotal);
        
        update=new JButton("Update");
        update.setBounds(20,400,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        // add action listener for button
        update.addActionListener(this);
        update.setFont(new Font("tahoma",Font.BOLD,16));
        add(update);
        
        pay=new JButton("Pay Fee");
        pay.setBounds(200,400,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        // add action listener for button
        pay.addActionListener(this);
        pay.setFont(new Font("tahoma",Font.BOLD,16));
        add(pay);
        
        back=new JButton("Back");
        back.setBounds(360,400,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        // add action listener for button
        back.addActionListener(this);
        back.setFont(new Font("tahoma",Font.BOLD,16));
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String course=(String)cbcourse.getSelectedItem();
            String sem=(String)cbsemester.getSelectedItem();
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from FeesStructure where course='"+course+"'");
                while(rs.next())
                {
                    labeltotal.setText(rs.getString(sem));
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(ae.getSource()==pay)
        {
            String rollno=crollno.getSelectedItem();
            String course=(String)cbcourse.getSelectedItem();
            String sem=(String)cbsemester.getSelectedItem();
            String branch=(String)cbbranch.getSelectedItem();
            String total=labeltotal.getText();
            try{
                Conn c=new Conn();
                String query="insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+sem+"','"+total+"')";
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "College Fees submitted succesfully..");
                setVisible(false);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            setVisible(false);
        }
    }
    public static void main(String [] args)
    {
        new StudentFeeForm();
    }
}

package universitymanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.util.*;
// for resultset 
import java.sql.*;
// for that library rs2xml-tz
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class TeacherLeaveDetails extends JFrame implements ActionListener
{
    // for up down scroll
    Choice cempId;
    // table
    JTable table;
    // for buttons
    JButton search,print,cancel;
    TeacherLeaveDetails()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        // for heading
        JLabel heading=new JLabel("Search by Employee Id");
        heading.setBounds(30,30,160,25);
        add(heading);
        
        // choice
        cempId=new Choice();
        cempId.setBounds(180,33,150,25);
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
        
        table=new JTable();
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,1200,600);
        add(jsp);
        
        // buttons
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(230,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        try 
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from TeacherLeave"); 
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        setSize(1200,700);
        setLocation(150,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            String query="select * from TeacherLeave where rollno='"+cempId.getSelectedItem()+"'";
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print)
        {
            try{
                table.print();
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
        new TeacherLeaveDetails();
    }
}



package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class EnterMarks extends JFrame implements ActionListener{
    Choice crollno;
    JComboBox cbsemester;
    JButton submit,cancel;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmark1,tfmark2,tfmark3,tfmark4,tfmark5;
    EnterMarks()
    {
        setSize(900,450);
        setLocation(300,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 640,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3); 
        label.setBounds(450,50,400,300);
        add(label);
        
        JLabel heading=new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lbrollno=new JLabel("Select Roll Number");
        lbrollno.setBounds(50,70,150,25); 
        add(lbrollno);
        
        // choice
        crollno=new Choice();
        crollno.setBounds(200,72,150,25);
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
        
        JLabel lblsemester=new JLabel("Select Semester");
        lblsemester.setBounds(50,110,150,25); 
        add(lblsemester);
        
        String semester[]={"I","II","III","IV","V","VI","VII"};
        cbsemester=new JComboBox(semester);
        cbsemester.setBounds(200,110,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
         JLabel lblsubject=new JLabel("Enter Subject");
        lblsubject.setBounds(70,150,200,40); 
        add(lblsubject);
        
         JLabel lblentermarks=new JLabel("Enter Marks");
        lblentermarks.setBounds(280,150,200,40); 
        add(lblentermarks);
        
        tfsub1=new JTextField();
        tfsub1.setBounds(55,200,130,20);
        add(tfsub1);
        
        tfsub2=new JTextField();
        tfsub2.setBounds(55,230,130,20);
        add(tfsub2);
        
        tfsub3=new JTextField();
        tfsub3.setBounds(55,260,130,20);
        add(tfsub3);
        
        tfsub4=new JTextField();
        tfsub4.setBounds(55,290,130,20);
        add(tfsub4);
        
        tfsub5=new JTextField();
        tfsub5.setBounds(55,320,130,20);
        add(tfsub5);
        
        tfmark1=new JTextField();
        tfmark1.setBounds(250,200,130,20);
        add(tfmark1);
        
        tfmark2=new JTextField();
        tfmark2.setBounds(250,230,130,20);
        add(tfmark2);
        
        tfmark3=new JTextField();
        tfmark3.setBounds(250,260,130,20);
        add(tfmark3);
        
        tfmark4=new JTextField();
        tfmark4.setBounds(250,290,130,20);
        add(tfmark4);
        
        tfmark5=new JTextField();
        tfmark5.setBounds(250,320,130,20);
        add(tfmark5);
        
        // submit button
        submit=new JButton("Submit");
        submit.setBounds(60,360,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        // add action listener for button
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(255,360,120,30);
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
           try{
              
              Conn c=new Conn();
              String query1="insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
              String query2="insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmark1.getText()+"','"+tfmark2.getText()+"','"+tfmark3.getText()+"','"+tfmark4.getText()+"','"+tfmark5.getText()+"')";
              c.s.executeUpdate(query1);
              c.s.executeUpdate(query2);
              
              JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
          setVisible(false);
           }catch(Exception e)
           {
               e.printStackTrace();
           }
       }
       else{
           setVisible(false);
       }
    }
    public static void main(String[] args)
    {
        new EnterMarks();
    }
}

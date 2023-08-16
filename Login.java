 
package universitymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener  {
    JButton login,cancel;
    JTextField tfusername, tfpassword;
    Login()
    {
        // for coloring frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username=new JLabel("Username");
        // to set that content in perfect place
        username.setBounds(40,20,100,20);
        add(username);
        
        // to take input 
        tfusername=new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        // same we do for password
        JLabel password=new JLabel("Password");
        // to set that content in perfect place
        password.setBounds(40,70,100,20);
        add(password);
        
        // to take input 
        tfpassword=new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        // button
        login=new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        // add action listener for button
        login.addActionListener(this);
        login.setFont(new Font("tahoma",Font.BOLD,16));
        add(login);
        
        // for cancel
        cancel=new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
        
        // add image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(350, 0,200,200); // we need set bound because we add setLayout==null
        add(label);
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    // for override the method action event 
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==login)
       {
           // to accept username and password
           String username=tfusername.getText();
           String password=tfpassword.getText();
           
           // we have to create table that stores the value for username and password.
          String query="select * from login where username='"+username+"' and password='"+password+"'";
          
          try{
              //create conncetion
              Conn c=new Conn();
              // we store the values in resultSet from table
              ResultSet rs=c.s.executeQuery(query);
              // if rs is not empty then it execute a query otherwise query is not executed
              if(rs.next())
              {
                  setVisible(false);
                  new Project(); // when rs contains values it will go to the project page 
              }
              else{   // if it contains no values it will give a message
                  JOptionPane.showMessageDialog(null,"Invalid username or password"); // second is string that is message.
                  setVisible(false);
              }
          } catch (Exception e){
              e.printStackTrace();
          }
       }   
      
       else if(ae.getSource()==cancel)
       {
           setVisible(false);
       }
    }
    
    
    public static void main(String[] args)
    {
        new Login();
    }

  
}

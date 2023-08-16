
package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class examdetails extends JFrame implements ActionListener{
    JTextField search;
    JButton submit,cancel;
    JTable table;
    examdetails()
    {
        setSize(1000,480);
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        search =new JTextField();
        search.setBounds(80,70,200,30);
        search.setFont(new Font("Tahome",Font.PLAIN,18));
        add(search);
        
        submit=new JButton("Result");
        submit.setBounds(340,70,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        // add action listener for button
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD,16));
        add(submit);
        
        cancel=new JButton("Back");
        cancel.setBounds(530,70,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        // add action listener for button
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD,16));
        add(cancel);
        
        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        
        // scrollbar
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 320);
        add(jsp);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from Student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            setVisible(false);
            new Marks(search.getText());
            
        }
        else
        {
            setVisible(false);
        }
    }
    
   public static void main(String [] args)
   {
       new examdetails();
   }
}

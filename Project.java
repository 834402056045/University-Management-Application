
package universitymanagementsystem;

import java.awt.*;
import javax.swing.*;
// for exit button
import java.awt.event.*;
public class Project extends JFrame implements ActionListener
{
    Project()
    {
        setSize(1540,850);
        setVisible(true);
        
         // add image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 750,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3); 
        add(label);
        
        // for creating class we used JMenubar class
        JMenuBar mb=new JMenuBar();
        Font f=new Font("Times New Roman",Font.BOLD,15);
        
        // for information
        // to add the content on menu bar 
        JMenu newInformation=new JMenu("New Information");
        newInformation.setForeground(Color.BLACK);
        newInformation.setFont(f);
        mb.add(newInformation);
        
        // add items in newInformation
        JMenuItem facultyinfo=new JMenuItem("New Faculty Information");
        facultyinfo.setBackground(Color.WHITE);
        facultyinfo.addActionListener(this);
        newInformation.add(facultyinfo);
        
        JMenuItem studentinfo=new JMenuItem("New Student Information");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        newInformation.add(studentinfo);
        
        
        
        // for details
        JMenu newdetails=new JMenu("View Details");
        newdetails.setForeground(Color.BLACK);
        newdetails.setFont(f);
        mb.add(newdetails);
        // add items in newInformation
        JMenuItem facultyDetail=new JMenuItem("View Faculty Details");
        facultyDetail.setBackground(Color.WHITE);
        facultyDetail.addActionListener(this);
        newdetails.add(facultyDetail);
        
        JMenuItem studentDetail=new JMenuItem("View Student Details");
        studentDetail.setBackground(Color.WHITE);
        studentDetail.addActionListener(this);
        newdetails.add(studentDetail);
        
        // for leave
        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        leave.setFont(f);
        mb.add(leave);
        // add items in newInformation
        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave=new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        
        // for leave details
        JMenu leaveDetails=new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        leaveDetails.setFont(f);
        mb.add(leaveDetails);
        // add items in newInformation
        JMenuItem facultyleaveDetails=new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.setBackground(Color.WHITE);
        facultyleaveDetails.addActionListener(this);
        leaveDetails.add(facultyleaveDetails);
        
        JMenuItem studentleaveDetails=new JMenuItem("Student Leave Details");
        studentleaveDetails.setBackground(Color.WHITE);
        studentleaveDetails.addActionListener(this);
        leaveDetails.add(studentleaveDetails);
        
        // for Examination
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        exam.setFont(f);
        mb.add(exam);        
        // add items in newInformation
        JMenuItem examinationDetails=new JMenuItem("Examination Result");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);
        
        JMenuItem enterMarks=new JMenuItem("Enter Marks");
        enterMarks.addActionListener(this);
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        
        // for Updates
        JMenu update=new JMenu("Update Details");
        update.setForeground(Color.BLACK);
        update.setFont(f);
        mb.add(update);        
        // add items in newInformation
        JMenuItem updateFacultyInfo=new JMenuItem("Update Faculty Details");
        updateFacultyInfo.setBackground(Color.WHITE);
        updateFacultyInfo.addActionListener(this);
        update.add(updateFacultyInfo);
        
        JMenuItem updateStudentInfo=new JMenuItem("Update Students Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        update.add(updateStudentInfo);
        
        // for Fees
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        fee.setFont(f);
        mb.add(fee);        
        // add items in newInformation
        JMenuItem feeStructure=new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);
        
        JMenuItem feeform=new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
        
        // for utility
        JMenu utility=new JMenu("Utility Details");
        utility.setForeground(Color.BLACK);
        utility.setFont(f);
        mb.add(utility);        
        // add items in newInformation
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
        // for exit
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        exit.setFont(f);
        mb.add(exit);        
        // add items in newInformation
        JMenuItem ex=new JMenuItem("Exit");
        ex.addActionListener(this);
        ex.setBackground(Color.WHITE);
        exit.add(ex);
        
        setJMenuBar(mb); // using these we can add menu bar on frame  
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        // we can also do with getsource but we use string method
        String msg=ae.getActionCommand();
        if(msg.equals("Exit"))
        {
            setVisible(false);
        }
        else if(msg.equals("Calculator"))
        {
            try
            {
                Runtime.getRuntime().exec("calc.exe"); // calulator is open outside the project
            }
            catch(Exception e)
            {
            
            }
        }
        else if(msg.equals("Notepad"))
        {
            try
            {
                Runtime.getRuntime().exec("notepad.exe"); // calulator is open outside the project
            }
            catch(Exception e)
            {
            
            }
        }
        else if(msg.equals("New Faculty Information"))
        {
            new AddTeacher();
        }
        
        else if(msg.equals("New Student Information"))
        {
            new AddStudent();
        }
        
        else if(msg.equals("View Faculty Details"))
        {
            new TeacherDetails();
        }
        else if(msg.equals("View Student Details"))
        {
            new StudentDetails();
        }
        else if(msg.equals("Faculty Leave"))
        {
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave"))
        {
            new StudentLeave();
        }
        
        else if(msg.equals("Faculty Leave Details"))
        {
            new TeacherLeaveDetails();
        }
        
        else if(msg.equals("Student Leave Details"))
        {
            new StudentLeaveDetails();
        }
         else if(msg.equals("Update Faculty Details"))
        {
            new UpdateTeacher();
        }
        
        else if(msg.equals("Update Students Details"))
        {
            new UpdateStudent();
        }
        else if(msg.equals("Enter Marks"))
        {
            new EnterMarks();
        }
        else if(msg.equals("Examination Result"))
        {
            new examdetails();
        }
        else if(msg.equals("Fee Structure"))
        {
            new FeeStructure();
        }
        else if(msg.equals("Student Fee Form"))
        {
            new StudentFeeForm();
        }
    }
    public static void main(String [] args)
    {
        new Project();
    }

    
}

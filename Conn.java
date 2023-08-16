
package universitymanagementsystem;
// connection to jdbc it include 5 steps:
// 1) Register driver classes
// 2) Creating connection String
// 3) Creating Statement
// 4) Execuiting SQL queries
// 5) Closed the connection

// for coonection to sql
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create conncetion string
            c=DriverManager.getConnection("jdbc:mysql:///universitymanagement","root","jkp@20");
            // create statement
            s=c.createStatement();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String [] args)
    {
        
    }
}

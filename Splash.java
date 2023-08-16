package universitymanagementsystem;
import java.awt.Image;
import javax.swing.*;
// we create frame using swing. JFrame is class under swing which contains methods.
public class Splash extends JFrame implements Runnable
{
        
    Thread t;
    public Splash()
        {
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
            Image i2=i1.getImage().getScaledInstance(1300, 780,Image.SCALE_DEFAULT);
            ImageIcon i3= new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            add(label);
            
            
            t=new Thread(this);
            t.start();
            setVisible(true); //by default spash visibility is hidden so we used set visibility function
            // we want size of frame increaing and decreasing mode
            int x=1;
            for(int i=2;i<=600;i+=4,x+=1)
            {
                setLocation(400-((i+1)/2),300-(i/2));
                setSize(i+5*x,i+5*x);  // we can set size of frame
                //by default spash visibility is hidden so we used set visibility function
           
            try{
                Thread.sleep(10);
            }
            catch(InterruptedException e){}
            }
}
    // for close the frame automatically
        public void run(){
            try{
                Thread.sleep(4000);
                setVisible(true);
                
                // next frame that is login we create object of login class
                new Login();
            }catch(Exception e){}
        }
    public static void main(String[] args)
    {
        new Splash();
    }
}

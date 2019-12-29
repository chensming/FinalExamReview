import java.awt.Graphics;
import javax.swing.JApplet;

public class JHello extends JApplet{
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        
        g.drawString("**********************************************",20,40);
        g.drawString("**    Pratice makes perfect!",20,60);
        g.drawString("**********************************************",20,80);
    }
}
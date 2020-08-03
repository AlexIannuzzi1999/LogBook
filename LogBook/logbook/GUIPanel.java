package logbook;

import javax.swing.*;
import java.awt.*;

/**
 * Window that the client will use and input data on.  
 * @author Alexander Iannuzzi
 * @version 1->6/21/19
 * @copyright Alexander Iannuzzi 5/28/19
 * @param <T> Generic Argument
 */
@SuppressWarnings("serial")
public class GUIPanel extends JPanel {
    private String window;
    private LinkedList<Color> colors;
    
    public GUIPanel()
    {
        super();
        window = "";
    }
    
    public void drawing(String str, LinkedList<Color> colors)
    {
        window = str;
        this.colors = colors;
        repaint();
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (window.equals("stats"))
        {
            g.setColor(Color.BLACK);
            g.drawLine(0, 160, 1000, 160);
            g.drawLine(250, 160, 250, 420);
            g.drawLine(0, 420, 1000, 420);
            g.drawLine(250, 420, 350, 420);
            g.drawLine(500, 420, 500, 700);
            g.drawLine(400, 0, 400, 160);
            
            //Grid lines for the most recent flights
            g.drawLine(250, 220, 1000, 220);
            g.drawLine(250, 260, 1000, 260);
            g.drawLine(250, 300, 1000, 300);
            g.drawLine(250, 340, 1000, 340);
            g.drawLine(250, 380, 1000, 380);
            //labels for the most recent flights
            g.drawLine(375, 200, 375, 420);
            g.drawLine(475, 200, 475, 420);
            g.drawLine(600, 200, 600, 420);
            g.drawLine(725, 200, 725, 420);
            g.drawLine(850, 200, 850, 420);
        }
        else if (window.equals("info"))
        {
            
        }
        else if (window.equals("log"))
        {
            for (int i = 120; i < 660; i+=30)
            {
                g.drawLine(0, i, 1000, i);
                
            }
            
            g.drawLine(70, 90, 70, 700);
            g.drawLine(140, 90, 140, 700);
            g.drawLine(210, 90, 210, 700);
            g.drawLine(270, 90, 270, 700);
            g.drawLine(330, 90, 330, 700);
            
            //aircraft category
            //design color key for single, multi, other, and rotor
            g.drawLine(390, 90, 390, 700);
            g.drawLine(450, 90, 450, 700);
            
            //condifitons of flight
            g.drawLine(510, 90, 510, 700);
            
            //number of landings/approaches
            //color key for day/night
            g.drawLine(560, 90, 560, 700);
            g.drawLine(610, 90, 610, 700);
            
            //stops, total duration,  and remarks
            g.drawLine(680, 90, 680, 700);
            g.drawLine(740, 90, 740, 700);
            
            g.drawLine(930, 90, 930, 700);
            
            
            //color key for category and class
            int startY = 120;
            for (int i = 0; i < colors.getSize(); i+=3)
            {
                g.setColor(colors.get(i));
                g.fillRect(375, startY, 15, 30);
                g.setColor(colors.get(i + 1));
                g.fillRect(435, startY, 15, 30);
                g.setColor(colors.get(i + 2));
                g.fillRect(495, startY, 15, 30);
                startY += 30;
            }
            
        }
        else if (window.equals("add"))
        {
            
        }
        else if (window.equals("endor"))
        {
            
        }
    }
}

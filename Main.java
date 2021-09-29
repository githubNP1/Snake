package Trial;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class Main extends JPanel implements KeyListener{
    Full full;
    
    public Main(){
        JFrame frame = new JFrame();
        frame.add(this);
        frame.setSize(1020, 750); 
        frame.addKeyListener(this); 
        
        full = new Full();
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            move();
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.gray);
        for(Segment s : full.segments){
            for(int[] pixel : s.pixels){
                g.drawRect(pixel[0], pixel[1], 1, 1);
            }
        }
    }
    
    public void move(){
        for(Segment s : full.segments){
            switch(s.direction){
                case "up":
                    s.adjust(0, -10);
                    break;
                case "down":
                    s.adjust(0, 10);
                    break;
                case "right":
                    s.adjust(10, 0);
                    break;
                default:
                    s.adjust(-10, 0);
                    break;
            }
        }
    }
    
    public static void main(String[] args){
        new Main();
    }

    public void keyPressed(KeyEvent e) { //needs to add anchor to segments
        int[] anchor = {full.segments.get(0).pixels.get(0)[0], full.segments.get(0).pixels.get(0)[1], 0};  //perhaps create method to get this info
        if(e.getKeyCode() == KeyEvent.VK_UP){
            full.segments.get(0).direction = "up"; 
            anchor[2] = 1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            full.segments.get(0).direction = "down";
            anchor[2] = 2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            full.segments.get(0).direction = "right";
            anchor[2] = 3;
        }
        else{
            full.segments.get(0).direction = "left";
            anchor[2] = 4;
        }
        for(Segment s : full.segments){
            if(full.segments.indexOf(s) != 0){s.anchors.add(anchor);}
        }
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import framework.Canvas;
import framework.State;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;

/**
 *
 * @author Kade
 */
public class BridgeCanvas extends Canvas{
    public BridgeCanvas(State state){
        super.setState(state);
        BridgeState other = (BridgeState) state;
        this.curState = other;
        
//        person1 = new Ellipse2D.Double(0, 0, 50, 50);
//        person2 = new Ellipse2D.Double(0, 55, 50, 50);
//        flashlight = new Ellipse2D.Double(0, 110, 50, 50); 
//        person5 = new Ellipse2D.Double(0, 165, 50, 50);
//        person10 = new Ellipse2D.Double(0, 220, 50, 50); 
        
    }
    
    
    public void paintComponent(Graphics g){
    curState = (BridgeState) getState();    
    super.paintComponent(g);
    g2 = (Graphics2D) g; 
    g2.setStroke(new BasicStroke(3));
//Land    
    g2.setColor(Color.green);
    g2.draw(land);
    g2.fill(land);
// Water    
    g2.setColor(Color.BLUE);
    g2.draw(water);
    g2.fill(water);
    
//bridge
    g2.setColor(new Color(165, 42, 19));
    g2.draw(bridge);
    g2.fill(bridge);
    
    g2.setColor(Color.BLACK);
    
//Person1
    if(curState.getP1Position() == Position.EAST){
        person1 = new Ellipse2D.Double(300, 0, 50, 50);
        g2.draw(person1);
        g2.setColor(Color.yellow);
        g2.fill(person1);
        g2.setColor(Color.black);
        g2.drawString("P1", 320, 25);
    }
    else{
        person1 = new Ellipse2D.Double(10, 0, 50, 50);
        g2.draw(person1);
        g2.setColor(Color.yellow);
        g2.fill(person1);
        g2.setColor(Color.black);
        g2.drawString("P1", 30, 25);
    }
// Person2 
    if(curState.getP2Position() == Position.EAST){
        person2 = new Ellipse2D.Double(300, 55, 50, 50);
        g2.draw(person2);
        g2.setColor(Color.yellow);
        g2.fill(person2);
        g2.setColor(Color.black);
        g2.drawString("P2", 320, 80);
    }
    else{
        person2 = new Ellipse2D.Double(10, 55, 50, 50);
        g2.draw(person2);
        g2.setColor(Color.yellow);
        g2.fill(person2);
        g2.setColor(Color.black);
        g2.drawString("P2", 30, 80);
    }
//Flashlight
    if(curState.getFlashlightPosition() == Position.EAST){
       flashlight = new Ellipse2D.Double(300, 110, 50, 50); 
       g2.draw(flashlight);
       g2.setColor(Color.RED);
       g2.fill(flashlight);
       g2.setColor(Color.black);
       g2.drawString("F", 320, 135);
       
    }
    else{
        flashlight = new Ellipse2D.Double(10, 110, 50, 50); 
        g2.draw(flashlight);
        g2.draw(flashlight);
        g2.setColor(Color.RED);
        g2.fill(flashlight);
        g2.setColor(Color.black);
        g2.drawString("F", 35, 135);
    }
//Person5
    if(curState.getP5Position() == Position.EAST){
        person5 = new Ellipse2D.Double(300, 165, 50, 50);
        g2.draw(person5);
        g2.setColor(Color.yellow);
        g2.fill(person5);
        g2.setColor(Color.black);
        g2.drawString("P5", 320, 190);
    }
    else{
        person5 = new Ellipse2D.Double(10, 165, 50, 50);
        g2.draw(person5);
        g2.setColor(Color.yellow);
        g2.fill(person5);
        g2.setColor(Color.black);
        g2.drawString("P5", 30, 190);
    }
//Person10 
    if(curState.getP10Position() == Position.EAST){
        person10 = new Ellipse2D.Double(300, 220, 50, 50);
        g2.draw(person10);
        g2.setColor(Color.yellow);
        g2.fill(person10);
        g2.setColor(Color.black);
        g2.drawString("P10", 315, 250);
    }
    else{
        person10 = new Ellipse2D.Double(10, 220, 50, 50);
        g2.draw(person10);
        g2.setColor(Color.yellow);
        g2.fill(person10);
        g2.setColor(Color.black);
        g2.drawString("P10", 25, 250);
    }
// The time
    g2.setStroke(new BasicStroke(5));
    g2.drawString("Time: " + curState.getTimeSoFar(), 190, 240);

}
//    public void animate(int start, int end){
//        timer = new Timer(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                
//            }
//            
//        });
//        
//    }
    
    public void clear(){
    g2.draw(person1);
    g2.draw(person2);
    g2.draw(flashlight);
    g2.draw(person5);
    g2.draw(person10);
    }
    private Graphics2D g2;
    private BridgeState curState;
    private Shape person1;
    private Shape person2;
    private Shape person5;
    private Shape person10;
    private Shape flashlight;
    private Shape bridge = new Rectangle2D.Double(140, 110, 120, 75);
    private Shape water = new Rectangle2D.Double(150, 0, 100, 320); 
    private Shape land = new Rectangle2D.Double(0, 0, 420, 320);
    private Timer timer;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waterjug;

import framework.Canvas;
import framework.State;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Kade
 */
public class WaterJugCanvas extends Canvas{
    public WaterJugCanvas(State state){
        //this.time = new Timer();
         super.setState(state);
         curState = (WaterJugState) state;
         JugX = new Rectangle2D.Double(50, 58, 378/3, 172);
         JugY = new Rectangle2D.Double(200, 0, 378/3, 230);
         repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        curState = (WaterJugState) getState();    
        Graphics2D g2 = (Graphics2D) g;
        int waterLevelX = curState.getJugX();
        int waterLevelY = curState.getJugY();
//JugX        
        if(waterLevelX == 0){
            fillerX =  new Rectangle2D.Double(50, 58, 378/3, 172);
            g2.draw(fillerX);
        }
        else if(waterLevelX == 1){
            fillerX =  new Rectangle2D.Double(50, 58, 378/3, 116);
            g2.draw(fillerX);
        }
        else if(waterLevelX == 2){
            fillerX =  new Rectangle2D.Double(50, 58, 378/3, 58);
            g2.draw(fillerX);
        }
        else if(waterLevelX == 3){
            
            fillerX = new Rectangle2D.Double(50, 58, 378/3, 0);
            g2.draw(fillerX);
        }
//JugY        
        if(waterLevelY == 0){
            fillerY =  new Rectangle2D.Double(200, 0, 378/3, 230);
            g2.draw(fillerY); 
        }
        else if(waterLevelY == 1){
            fillerY =  new Rectangle2D.Double(200, 0, 378/3, 174);
            g2.draw(fillerY);
        }
        else if(waterLevelY == 2){
            fillerY =  new Rectangle2D.Double(200, 0, 378/3, 116);
            g2.draw(fillerY);
        }
        else if(waterLevelY == 3){
            fillerY =  new Rectangle2D.Double(200, 0, 378/3, 58);
            g2.draw(fillerY);
        }
        else if(waterLevelY == 4){
            fillerY = new Rectangle2D.Double(50, 58, 378/3, 0);
            g2.draw(fillerY);
        }
        
        g2.setStroke(new BasicStroke(10));
        g2.setColor(Color.white);
        g2.draw(background);
        g2.setColor(Color.white);
        g2.fill(background);
        g2.setColor(Color.BLACK);
        g2.draw(JugX);
        g2.draw(JugY);
        g2.setColor(Color.CYAN);
        g2.fill(JugX);
        g2.fill(JugY);
        g2.setColor(Color.white);
        g2.fill(fillerX);
        g2.fill(fillerY);
        g2.setColor(Color.black);
        g2.drawString("JugX ("+ waterLevelX + ")", 25 + (378/6), 58 + 172+ 20);
        g2.drawString("JugY (" + waterLevelY + ")",180 + (378/6) ,58 + 172 + 20);
    }
    
    private WaterJugState curState;
    public Shape JugX;
    public Shape JugY;
    private Shape fillerX;
    private Shape fillerY;
    private Shape background = new Rectangle2D.Double(0, 0, 420, 321);
    
}

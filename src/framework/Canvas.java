
package framework;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * This class is used to create the graphical representation of the problem 
 * @author Kade Helseth
 */
public abstract class Canvas extends JComponent{
//    Canvas(State state){
//        this.curState = state;
//    }
    
    /**
     * Draws the current state 
     * @param g the current graphic to be drawn.
     */
    @Override
    protected void printComponent(Graphics g){
        
    }
    
    /**
     * accesor for the State variable  
     * @return the current State being displayed 
     */
    public State getState(){
     return curState; 
    }
    
    /**
     * setter for the State variable to 
     * @param other the State to be set 
     */
    public void setState(State other){
        curState = other;
    }
    
    /**
     * accesor for the previous State variable  
     * @return the previous State being displayed 
     */
    public State getPreviousState(){
     return prevState; 
    }
    
    /**
     * setter for the State variable to 
     * @param other the State to be set to the previous State
     */
    public void setPreviousState(State other){
        prevState = other;
    }
    
    /**
     * The variable the first state displayed by the canvas
     */
    public State curState;
    private State prevState;
}

package waterjug;

import framework.State;

/**
 * This class represents states of the Water Jug problem.
 * It creates new water jug states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 */
public class WaterJugState implements State {
    /**
     * constructor
     * 
     * the constructor for the water jug state 
     * sets the heights of jug x and jug y 
     * @param sizeX the height of jug x 
     * @param sizeY the height of jug y
     */
    public WaterJugState(int sizeX, int sizeY){
        this.jugSizeX=sizeX;
        this.jugSizeY=sizeY;
    }
    /**
     * accessor for the water jug x
     * @return the integer representation of jug x 
     */
    public int getJugX(){
        return this.jugSizeX;
    }
    
    /**
     * accessor for the water jug y
     * @return the integer representation of jug y
     */
    public int getJugY(){
        return this.jugSizeY;
    }

    /**
       Tests for equality between this state and the argument state.
       Two states are equal if the X jugs have the same amount of water
       and the Y jugs have the same amount of water.
       @param other the state to test against this state
       @return whether the states are equal
    */
    @Override
    public boolean equals(Object other) {
        WaterJugState otherState= (WaterJugState) other;
	boolean result= false ; 
        
        if(this.getJugX()==otherState.getJugX()&& this.getJugY()== otherState.getJugY()){
            result= true;
        }
        return result; 
    }

    /**
       Creates a primitive, non-GUI representation of this WaterJugState object.
       @return the string representation of this water jug state
     */
    @Override
    public String toString() {
        String retString="";
        //level 4
	if(this.getJugY()<4){
            retString="       |   |\n";
        }
        else if(this.getJugY()==4){
            retString="       |***|\n";
        }
        
        else if(this.getJugY()==3 && this.getJugX()>=3){
            retString+= "|***|  |***|\n";
        }
        //level 3
        if(this.getJugX()>=3 && this.getJugY()>=3){
            retString+= "|***|  |***|\n";
        }
        else if(this.getJugX()<3 && this.getJugY()>=3){
            retString+="|   |  |***|\n";
        }
        else if(this.getJugX()>=3 && this.getJugY()<3){
            retString+= "|***|  |   |\n";
        }
        else if(this.getJugX()<3 && this.getJugY()<3){
            retString+= "|   |  |   |\n";
        }
        //level 2
        if(this.getJugX()>=2 && this.getJugY()>=2){
            retString+= "|***|  |***|\n";
        }
        else if(this.getJugX()<2 && this.getJugY()>=2){
            retString+="|   |  |***|\n";
        }
        else if(this.getJugX()>=2 && this.getJugY()<2){
            retString+= "|***|  |   |\n";
        }
        else if(this.getJugX()<2 && this.getJugY()<2){
            retString+= "|   |  |   |\n";
        }
        //level 1
        if(this.getJugX()>=1 && this.getJugY()>=1){
            retString+= "|***|  |***|\n";
        }
        else if(this.getJugX()<1 && this.getJugY()>=1){
            retString+="|   |  |***|\n";
        }
        else if(this.getJugX()>=1 && this.getJugY()<1){
            retString+= "|***|  |   |\n";
        }
        else if(this.getJugX()<1 && this.getJugY()<1){
            retString+= "|   |  |   |\n";
        }
        // level 0
        retString+="+---+  +---+\n";
        retString+="  X      Y  \n";
        
        return retString;
    }
    private int jugSizeX;
    private int jugSizeY;
    
}

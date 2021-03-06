package bridge;

import framework.State;

/**
 * This class represents states of the Bridge Crossing problem.
 * It creates new bridge states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 * Except for the import and the class header, this class can be
 * the same as in the previous assignment.
 * @author your name here
 */
public class BridgeState implements State {
    
    /**
     * Creates a new bridge state.  
     * Besides storing the positions of the persons and flashlight, a
     * bridge state should also store the time taken to get to this state in
     * integer minutes.
     * @param p1Position position of the person who can cross in 1 minute
     * @param p2Position position of the person who can cross in 2 minutes
     * @param flashlightPosition position of the flashlight
     * @param p5Position position of the person who can cross in 5 minutes
     * @param p10Position  position of the person who can cross in 10 minutes
     * @param timeSoFar time taken so far
     */
    public BridgeState(Position p1Position, 
                       Position p2Position, 
                       Position flashlightPosition, 
                       Position p5Position, 
                       Position p10Position,
                       int timeSoFar) {
        this.p1Position= p1Position;
        this.p2Position= p2Position;
        this.flashlightPosition= flashlightPosition;
        this.p5Position= p5Position;
        this.p10Position=p10Position;
        this.timeSoFar=timeSoFar;
        
    }
    
    /**
     * Compares this bridge state with another for equality.
     * Note that this method overrides the <b>equals</b> method defined
     * in <b>java.lang.Object</b>.
     * Thus the argument of type <b>Object</b> must be cast to type
     * <b>BridgeState</b> before processing.
     * Two bridge states are equal if the positions of the persons and 
     * flashlight in one state are matched by their positions in the other.
     * Note that the time taken to cross so far is not taken into account
     * when considering equality.
     * @param other the other bridge state to be compared with this one.
     * @return whether this state is equal to the other state
     */
    @Override
    public boolean equals(Object other) {
        BridgeState state = (BridgeState) other;
        return this.getP1Position()==state.getP1Position()&&
                this.getP2Position()==state.getP2Position()&&
                this.getP5Position()==state.getP5Position()&&
                this.getP10Position()==state.getP10Position()&&
                this.getFlashlightPosition()== state.getFlashlightPosition(); 
    }
    
    /**
     * Creates a string representation of this state for display to the user
     * trying to solve the problem.
     * Note that the time so far to cross is part of the string representation.
     * @return the string representation of this state
     */
    @Override
    public String toString() {
        String ret;
        if(this.getP1Position()==Position.WEST){
            ret=" P1 |   |\n";
        }
        else{
            ret="    |   | P1\n";
        }
        if(this.getP2Position()==Position.WEST){
            ret+=" P2 |   |\n";
        }       
        else{
            ret+= "    |   | P2\n";
        }
        if(this.getFlashlightPosition()==Position.WEST){
            ret+="  f |===|\n";
        }
        else{
            ret+="    |===| f\n";
        }  
        if(this.getP5Position()==Position.WEST){
            ret+= " P5 |   |\n";
        }
        else{
            ret+="    |   | P5\n";
        }
        if(this.getP10Position()==Position.WEST){
            ret+="P10 |   |\n";
        }
        else{
            ret+="    |   |P10\n";
        }
            ret+=  "Time elapsed so far: "+this.getTimeSoFar() +" minutes.\n";
        
	return ret;  
    }
    

    /**
     * Getter (accessor) for the position of the flashlight in this state.
     * @return the position of the flashlight
     */
    public Position getFlashlightPosition() {
        return this.flashlightPosition; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P1 in this state.
     * @return the position of person P1
     */
    public Position getP1Position() {
        return this.p1Position; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P2 in this state.
     * @return the position of person P2
     */
    public Position getP2Position() {
        return this.p2Position; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P5 in this state.
     * @return the position of person P5
     */
    public Position getP5Position() {
        return this.p5Position; // You must provide
    }

    /**
     * Getter (accessor) for the position of person P10 in this state.
     * @return the position of person P10
     */
    public Position getP10Position() {
        return this.p10Position; // You must provide
    }

    /**
     * Getter (accessor) for the time taken to get to this state.
     * @return the time taken to get to this state
     */
    public int getTimeSoFar() {
        return this.timeSoFar;
    }
   
    private final Position p1Position;
    private final Position p2Position;
    private final Position flashlightPosition;
    private final Position p5Position;
    private final Position p10Position;
    private final int timeSoFar;
}

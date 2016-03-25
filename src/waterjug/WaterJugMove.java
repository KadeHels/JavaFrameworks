package waterjug;

import framework.Move;
import framework.State;

/**
 * This class represents moves in the Water Jug problem.
 * A move object stores its move name and knows how to apply itself
 * to a water jug state to create a new state representing the result
 * of the move.
 * Note that this class extends the abstract class <b>Move</b> and
 * therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent
 * and thus it should not have an instance field for the move name.
 * @author Kade Helseth
*/
public class WaterJugMove extends Move {

    /**
     * Constructs a new water jug move object.
     * Note that the move name is passed to the parent constructor
     * using <b>super</b>.
     * @param moveName the name of this move.
     * It is an error if the name is not one of the following:
     * <ul>
     * <li> "Fill Jug X" </li>
     * <li> "Fill Jug Y" </li>
     * <li> "Empty Jug X" </li>
     * <li> "Empty Jug Y" </li>
     * <li> "Transfer Jug X to Jug Y" </li>
     * <li> "Transfer Jug Y to Jug X" </li>
     * </ul>
     */
    WaterJugMove(String moveName) {
	super(moveName);
        this.moveName=moveName;
    }

    /**
     * Attempts to perform this move on a given water jug state.
     * Note that this method implements the abstract <b>doMove</b> method declared
     * in the parent.
     * Thus the argument of type <b>State</b> must be cast to type
     * <b>WaterJugState</b> before processing.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new water jug state object is returned that
     * reflects this move.
     * A move cannot be performed if trying to fill or transfer to an already
     * full jug, or if trying to empty or transfer from an empty jug.
     * If the move cannot be performed <b>null</b> is returned.
     * @param otherState the water jug state on which this move is to be performed
     * @return a new water jug state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    @Override
    public State doMove(State otherState) {
	WaterJugState state = (WaterJugState) otherState;
        
        if(this.getMoveName().equals("Fill Jug X")){
        //if water jug X has room to add to            
            if(state.getJugX() < 3){
                nextState = new WaterJugState(3, state.getJugY());
            } //else water jug x is full =3
            else {
                nextState = null;
            }
        }
        else if(this.getMoveName().equals("Fill Jug Y")){
            if(state.getJugY()<4){
                nextState = new WaterJugState(state.getJugX(),4);
            }
            else{
                nextState=null;
            }
        }
        else if(this.getMoveName().equals("Empty Jug X")){
            if(state.getJugX()>0){
                nextState = new WaterJugState(0,state.getJugY());
            }
            else{
                nextState=null;
            }
        }
        else if(this.getMoveName().equals("Empty Jug Y")){
            if(state.getJugY()>0){
                nextState = new WaterJugState(state.getJugX(),0); 
            }
            else{
                nextState= null;
            }
        }
        else if(this.getMoveName().equals("Transfer Jug X to Jug Y")){
            if(state.getJugX()>0 && state.getJugY()<4){
                int Ycount=state.getJugY();
                int Xcount=state.getJugX();
                int total=Ycount+Xcount;
                if(total<=4){
                nextState = new WaterJugState(0,state.getJugX()+state.getJugY());  
                }
                else if(total>4){
                nextState= new WaterJugState((state.getJugX()+state.getJugY()-4),(state.getJugX()+state.getJugY())-(state.getJugX()+state.getJugY()-4));    
                }
            }
            else{
                nextState= null;
            }
        }
        else if(this.getMoveName().equals("Transfer Jug Y to Jug X")){
        if(state.getJugY()>0 && state.getJugX()<3){
                int Ycount=state.getJugY();
                int Xcount=state.getJugX();
                int total=Ycount+Xcount;
                if(total<=3){
                nextState = new WaterJugState(state.getJugX()+state.getJugY(),0);  
                }
                else if(total>3){
                nextState= new WaterJugState((state.getJugX()+state.getJugY())-(state.getJugX()+state.getJugY()-3),(state.getJugX()+state.getJugY()-3));    
                }
            }
            else{
                nextState= null;
            }    
        }
        
        return nextState; 
    }
    
   private WaterJugState nextState;
    
}

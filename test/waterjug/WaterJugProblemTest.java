package waterjug;

import java.util.List;
import framework.Problem;
import framework.State;
import framework.Move;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugProblem class.
 * You should use the BridgeProblemTest class as a model.
 * @author Kade Helseth
 */
public class WaterJugProblemTest {
    
   private Problem problem= new WaterJugProblem();
   private final List<Move> moves= problem.getMoves();
   
   private WaterJugMove m1; 
   private WaterJugMove m2;
   private WaterJugMove m3;
   private WaterJugMove m4;
   private WaterJugMove m5;
   private WaterJugMove m6;
   
   /**
     * Tests to be sure the problem represents all the moves.
     */
    @Test
    public void testMoves() {
     initializeMoves();   
     assertTrue(m1!=null);
     assertTrue(m2!=null);
     assertTrue(m3!=null);
     assertTrue(m4!=null);
     assertTrue(m5!=null);
     assertTrue(m6!=null);
    }
    /**
     * Tries to perform a move on the current state of the problem.
     * The problem's current state is updated to the next state, which 
     * could be null.
     * @param move the move to try
     */
    private void tryMove(Move move) {
        State state = problem.getCurrentState();
        State next = move.doMove(state);
        problem.setCurrentState(next);
    }
    /**
     * Searches the problem's move list for a move with the given name
     * @param moveName the name of the desired move
     * @return the move with the given name or null if not found
     */
    private Move findMove(String moveName) {
        for (Move move : moves) {
            if (move.getMoveName().equals(moveName)) {
                return move;
            }
        }
        return null;
    }
    /**
     * initializes the 6 moves that can be done by WaterJug
     */
    private void initializeMoves() {
        m1 = (WaterJugMove) findMove("Fill Jug X");
        m2 = (WaterJugMove) findMove("Fill Jug Y");
        m3 = (WaterJugMove) findMove("Empty Jug X");
        m4 = (WaterJugMove) findMove("Empty Jug Y");
        m5 = (WaterJugMove) findMove("Transfer Jug X to Jug Y");
        m6 = (WaterJugMove) findMove("Transfer Jug Y to Jug X");
        
    }
    /**
     * Tests the 4-move solution to the water jug problem
     */
    @Test
    public void testSolution1() {
        initializeMoves();
        assertFalse(problem.success());
        tryMove(m1);
        
        assertFalse(problem.success());
        tryMove(m5);
        
        assertFalse(problem.success());
        tryMove(m1);
        
        assertFalse(problem.success());
        tryMove(m5);
        assertTrue(problem.success());
    }

    /**
     * Tests the 6-move solution to the water jug problem
     */
    @Test
    public void testSolution2() {
       this.initializeMoves();
       assertFalse(problem.success());
       tryMove(m2);
       
       assertFalse(problem.success());
       tryMove(m6);
       
       assertFalse(problem.success());
       tryMove(m3);
       
       assertFalse(problem.success());
       tryMove(m6);
       
       assertFalse(problem.success());
       tryMove(m2);
       
       assertFalse(problem.success());
       tryMove(m6);
       
       assertTrue(problem.success());
    }
    
    /**
     * Tests the problem's introduction string.
     */
    @Test
    public void testIntro() {
        assertTrue(problem.getIntroduction().equals("Welcome to the Water Jug Problem.\n" +
"\n" +
"You are given two empty jugs: jug X holds 3 gallons, jug Y holds 4.\n" +
"Neither has any measuring markers on it. You have a ready supply\n" +
"of water. You can fill either jug, empty either jug on the ground,\n" +
"or pour all or some of either jug into the other.  The goal is to\n" +
"get exactly 2 gallons of water into either jug."));
    }
}

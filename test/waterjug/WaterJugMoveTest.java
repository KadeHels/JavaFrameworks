package waterjug;

import framework.Move;
import framework.State;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugMove class.
 * @author Kade Helseth
 */
public class WaterJugMoveTest {
    
    private State start= new WaterJugState(0, 0);
    private State state1= new WaterJugState(3,0);
    private State state2= new WaterJugState(0,4);
    private State state3= new WaterJugState(3,4);
    private State state4= new WaterJugState(0,3);
    private State state5= new WaterJugState(3,1);
    private State state6= new WaterJugState(3,2);
    private State state7= new WaterJugState(1,4);

    private WaterJugMove fillXJug= new WaterJugMove("Fill Jug X");
    private WaterJugMove fillYJug= new WaterJugMove("Fill Jug Y");
    private WaterJugMove emptyXJug= new WaterJugMove("Empty Jug X");
    private WaterJugMove emptyYJug= new WaterJugMove("Empty Jug Y");
    private WaterJugMove transXJug= new WaterJugMove("Transfer Jug X to Jug Y");
    private WaterJugMove transYJug= new WaterJugMove("Transfer Jug Y to Jug X");
    
    /**
     * Tests filling jug X
     */
    @Test
    public void testFillX() {
    WaterJugState next= (WaterJugState) fillXJug.doMove(start);     
    assertTrue(next != null);
    assertTrue(next.equals(state1));
    
    }

    /**
     * Tests filling jug Y
     */
    @Test
    public void testFillY() {
    WaterJugState next= (WaterJugState) fillYJug.doMove(start);     
    assertTrue(next != null);
    assertTrue(next.equals(state2));
    
    }
    
    /**
     * Tests emptying jug X
     */
    @Test
    public void testEmptyX() {
    WaterJugState next= (WaterJugState) emptyXJug.doMove(state1);     
    assertTrue(next != null);
    assertTrue(next.equals(start));
    
    }
    
    /**
     * Tests emptying jug Y
     */
    @Test
    public void testEmptyY() {
    WaterJugState next= (WaterJugState) emptyYJug.doMove(state2);     
    assertTrue(next != null);
    assertTrue(next.equals(start));
    }
    
    /**
     * Tests transferring jug X to jug Y
     */
    @Test
    public void testXToY() {
    WaterJugState next= (WaterJugState) transXJug.doMove(state1);     
    assertTrue(next != null);
    assertTrue(next.equals(state4));
    WaterJugState next1= (WaterJugState) transXJug.doMove(state6); 
    assertTrue(next1.equals(state7));
    }
    
    /**
     * Tests transferring jug Y to jug X
     */
    @Test
    public void testYToX() {
    WaterJugState next= (WaterJugState) transYJug.doMove(state2);     
    assertTrue(next != null);
    assertTrue(next.equals(state5));    
    }
}

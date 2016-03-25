package waterjug;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugState class
 * @author Kade Helseth
 */
public class WaterJugStateTest {
    
    private final String state1String = "       |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
                                 
    
    private final String state2String = "       |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    
    private final String state3String = "       |***|\n" +
                                  "|   |  |***|\n" +
                                  "|   |  |***|\n" +
                                  "|   |  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    private final String state4String = "       |   |\n" +
                                  "|***|  |   |\n" +
                                  "|***|  |   |\n" +
                                  "|***|  |   |\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    WaterJugState state1= new WaterJugState(0,0);
    WaterJugState state2= new WaterJugState(3,4);
    WaterJugState state3= new WaterJugState(0,4);
    WaterJugState state4= new WaterJugState(3,0);
    
    
    /**
     * This method tests the accessors (getters) for <b>WaterJugState</b> objects.
     */
    @Test
    public void testAccessors() {
        //test to make sure the jugs are constructed correctly
        assertTrue(state1.getJugX()==0);
        assertTrue(state1.getJugY()==0);
        
        assertTrue(state2.getJugX()==3);
        assertTrue(state2.getJugY()==4);
    }

    /**
     * This method tests the <b>equals</b> method for <b>WaterJugState</b> objects.
     */
    @Test
    public void testEquals() {
        assertFalse(state1.equals(state2));
        assertTrue(state1.equals(state1));
    }

    /**
     * This method tests the <b>toString</b> method for <b>WaterJugState</b> objects.
     * Look at the definitions of <b>state1String</b> and <b>state2String</b> to see
     * how <b>toString</b> should format a state's string representation.
     */
    @Test
    public void testToString() {
        
        assertTrue(state1.toString().equals(state1String));
        assertTrue(state2.toString().equals(state2String));
        assertTrue(state3.toString().equals(state3String));
        assertTrue(state4.toString().equals(state4String));
        assertFalse(state2.toString().equals(state1String));
    }
}

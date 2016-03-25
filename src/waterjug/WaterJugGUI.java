package waterjug;

import framework.GUI;
import javax.swing.JFrame;

/**
 * A class to test your GUI class on the water jug problem.
 * @author tcolburn
 */
public class WaterJugGUI extends JFrame {
    
    public WaterJugGUI() {
    WaterJugProblem problem = new WaterJugProblem();
        WaterJugCanvas canvas = new WaterJugCanvas(problem.getCurrentState());
        add(new GUI(problem, canvas));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * This method launches the GUI.
     * @param args ignored
     */
    public static void main(String[] args) {
        new WaterJugGUI();
    }
    
}

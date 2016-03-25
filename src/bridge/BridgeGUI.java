package bridge;

import framework.GUI;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 * A class to test your GUI class on the bridge crossing problem.
 * @author tcolburn
 */
public class BridgeGUI extends JFrame {
    
    public BridgeGUI() {
        BridgeProblem problem = new BridgeProblem();
        BridgeCanvas canvas = new BridgeCanvas(problem.getCurrentState());
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
        new BridgeGUI();
    }
    
}

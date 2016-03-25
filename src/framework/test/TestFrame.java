package framework.test;

import bridge.BridgeCanvas;
import bridge.BridgeProblem;
import framework.GUI;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import waterjug.WaterJugCanvas;
import waterjug.WaterJugProblem;

/**
 * A class to display the bridge crossing and water jug problems in a tabbed pane
 * within an application frame.
 * @author tcolburn
 */
public class TestFrame {
    
    public TestFrame() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Bridge", new GUI(new BridgeProblem(), new BridgeCanvas(new BridgeProblem().getCurrentState())));
        tabbedPane.add("Water Jug", new GUI(new WaterJugProblem(), new WaterJugCanvas(new WaterJugProblem().getCurrentState())));
        JFrame frame = new JFrame("Testing Bridge and Water Jug Problems");
        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new TestFrame();
    }
    
}

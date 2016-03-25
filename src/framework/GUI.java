package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

/**
 * A class that creates GUI components for solving search problems.
 * @author Kade Helseth
 */
public class GUI extends JComponent {
    
    public GUI(Problem problem, Canvas canvas) {
       this.currentCanvas = canvas;
       this.intro = problem.getIntroduction();
       this.moveList = problem.getMoves();
       this.curState = problem.getCurrentState();  
       this.originalState = problem.getCurrentState();
       this.problem = problem;
       this.prevState = problem.getCurrentState();
       this.setPreferredSize(new Dimension(MAX_WIDTH + 100, MAX_HEIGHT + 50));
       mainPanel = new JPanel();
       mainPanel.setPreferredSize(new Dimension(MAX_WIDTH/2, MAX_HEIGHT));
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
            
       JPanel topPanel = new JPanel();
       topPanel.add(introPanel());
       
       JPanel botPanel = new JPanel();
       botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.X_AXIS));
       botPanel.add(statePanel());
       botPanel.add(optionPanel());
       
       mainPanel.add(topPanel);
       mainPanel.add(botPanel);
       JScrollPane pane = new JScrollPane(mainPanel);
       
       add(pane);
    }
    
    public JPanel introPanel(){
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Introduction"));
        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension((int) (MAX_WIDTH-(MAX_WIDTH*.05)), MAX_HEIGHT/2));
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setToolTipText("Introduction");
        textArea.setLineWrap(true);
        textArea.setFont(new Font("MONOSPACED", 0, 13));
        textArea.setPreferredSize(new Dimension((int) (MAX_WIDTH-(MAX_WIDTH*.1)), (int) (MAX_HEIGHT/2.2)));
        textArea.setText(intro);
        
        panel.add(textArea);
        return panel;
    }
    
    public JPanel optionPanel(){
        final int panelWidth = (int) (MAX_WIDTH - (MAX_WIDTH * .7) );
        final int panelHeight = (int) (MAX_HEIGHT - (MAX_HEIGHT * .6) ) ;
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(panelWidth, panelHeight) );
        panel.setBorder(new TitledBorder("Options"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        /* this is an optional iterator for the moveList
        
//        ListIterator<Move> iterator = moveList.listIterator();
//        while(iterator.hasNext()) {
//        panel.add(createButton((Move) moveList.get(iterator.nextIndex())));
        */

        int i = 0;
        while(i < moveList.size()){
        buttonList.add(createButton((Move) moveList.get(i)));
        panel.add((Component) buttonList.get(i));
        i++;
        }
        setColors();
        final JButton button = new JButton("Reset");
        button.addActionListener(new 
        ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
             curState = originalState;
             problem.setCurrentState(originalState);
             setColors();
             timer.stop();
             score = 0;
             
             currentCanvas.setState(curState);
             currentCanvas.repaint();
             updateState();
            }
        });
        panel.add(button);
        return panel;
    }
    
    
    public JPanel statePanel(){
        //int panelWidth = (int) (MAX_WIDTH - (MAX_WIDTH*.3) );
        //int panelHeight = (int) (MAX_HEIGHT - (MAX_HEIGHT*.6) ) ;
        
        final JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("State"));
        panel.setPreferredSize(new Dimension(panelWidth , panelHeight));
        timer = new Timer(0200, new ActionListener(){
            
        @Override
        public void actionPerformed(ActionEvent ae) {
        ++score;
        panel.setBorder(new TitledBorder(Integer.toString(score)));
        }
        
    });  
        
        currentCanvas.setPreferredSize(new Dimension((int) (panelWidth - (panelWidth*.1)), (int) (panelHeight * .9)));
        currentCanvas.setVisible(true);
        currentCanvas.setOpaque(true);
        panel.add(currentCanvas);
        panel.setOpaque(true);
        
        return panel;
    }
    
    private JButton createButton(final Move move){
        final JButton button = new JButton(move.getMoveName());
        int buttonWidth = (int) (MAX_WIDTH - (MAX_WIDTH * .9));
        int buttonHeight = (int) (MAX_HEIGHT - (MAX_HEIGHT * .9));
        button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button.addActionListener(new
 ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                curState = move.doMove(curState);
            if (curState != null){    
            setColors();
            timer.start();
            prevState = curState;
            problem.setCurrentState(curState);
            updateState();
            if(problem.success()){
                timer.stop();
                updateState();
                JOptionPane.showMessageDialog(mainPanel,
                 "Winner!");
            }
            }
            else {
                curState = prevState;
                JOptionPane.showMessageDialog(mainPanel,
                move.getMoveName().toUpperCase() + " is an illegal move",
                "ERROR",
                JOptionPane.ERROR_MESSAGE);
                
            }
            
            updateState();
        }
            
 });
        
        return button;
    }
    
    private void updateState(){
//      CurState cannot be equal to null        
        if(curState != null) {
            //textField.setText(curState.toString());
            currentCanvas.setState(curState);
            currentCanvas.repaint();
        } 
    }
    private void setColors(){
        int j = 0;
        if(curState != null){   
        while(j < buttonList.size()){
           Move move = (Move) moveList.get(j);
           JButton button = (JButton) buttonList.get(j);
        
            if(move.doMove(curState) != null){
            button.setBackground(new Color(0, 250, 0));   
            }
            else{
            button.setBackground(new Color(250, 0, 0));
            }
            ++j;
            }
        }
    }
    
    private final JPanel mainPanel;
    private final Problem problem;
    private final List moveList;
    private final String intro;
    private JTextPane textField;
    private State prevState;
    private State curState;
    private State originalState;
    private List buttonList= new LinkedList();
    private Timer timer;
    private int score = 0;
    private Canvas currentCanvas;

    /**
     * @var MAX_HEIGHT: the max height of the panel
     * @var MAX_WIDTH: the max width of the panel
     */
    private final int MAX_HEIGHT = 800;
    private final int MAX_WIDTH = 600;
    
    private final int panelWidth = (int) (MAX_WIDTH - (MAX_WIDTH*.3) );
    private final int panelHeight = (int) (MAX_HEIGHT - (MAX_HEIGHT*.6) ) ;;
    
}
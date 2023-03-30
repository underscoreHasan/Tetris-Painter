package ui;

import model.BlockHeap;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private static final String SCORE_TXT = "Score: ";
    private static final int LBL_WIDTH = 70;
    private static final int LBL_HEIGHT = 30;
    private BlockHeap fixedBlocks;
    private JLabel scoreLbl;

    // Constructs a score panel
    // effects: sets the background colour and draws the initial labels;
    //          updates this with the game whose score is to be displayed
    public ScorePanel(BlockHeap fixedBlocks) {
        this.fixedBlocks = fixedBlocks;
        setBackground(new Color(180, 180, 180));
        scoreLbl = new JLabel(SCORE_TXT + fixedBlocks.getScore());
        scoreLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(scoreLbl);
        add(Box.createHorizontalStrut(10));
    }

    // Updates the score panel
    // modifies: this
    // effects:  updates number of invaders shot and number of missiles
    //           remaining to reflect current state of game
    public void update() {
        scoreLbl.setText(SCORE_TXT + fixedBlocks.getScore());
        repaint();
    }
}

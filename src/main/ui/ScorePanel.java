package ui;

import model.BlockHeap;

import javax.swing.*;
import java.awt.*;

// Represents the panel in which the score is rendered.
public class ScorePanel extends JPanel {
    private static final String SCORE_TXT = "Score: ";
    private static final int LBL_WIDTH = 70;
    private static final int LBL_HEIGHT = 30;
    private BlockHeap fixedBlocks;
    private JLabel scoreLbl;

    // EFFECTS: Sets the background colour and draws the initial label;
    //          updates this with the score.
    public ScorePanel(BlockHeap fixedBlocks) {
        this.fixedBlocks = fixedBlocks;
        setBackground(new Color(180, 180, 180));
        scoreLbl = new JLabel(SCORE_TXT + fixedBlocks.getScore());
        scoreLbl.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(scoreLbl);
        add(Box.createHorizontalStrut(10));
    }

    // MODIFIES: this
    // EFFECTS: Updates the score
    public void update() {
        scoreLbl.setText(SCORE_TXT + fixedBlocks.getScore());
        repaint();
    }
}

package ui;

import model.Block;
import model.BlockHeap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * The panel in which the game is rendered.
 */
public class GamePanel extends JPanel {

    private static final String OVER = "Game Over!";
    private static final String REPLAY = "R to replay";
    private Block controlBlock;
    private BlockHeap fixedBlocks;

    // Constructs a game panel
    // effects:  sets size and background colour of panel,
    //           updates this with the game to be displayed
    public GamePanel(Block b, BlockHeap loB) {
        setPreferredSize(new Dimension(TetrisPainter.BOARD_WIDTH, TetrisPainter.BOARD_HEIGHT));
        this.controlBlock = b;
        this.fixedBlocks = loB;
    }

}

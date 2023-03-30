package ui;

import model.Block;
import model.BlockHeap;

import java.awt.*;

import javax.swing.JPanel;

/*
 * The panel in which the game is rendered.
 */
public class GamePanel extends JPanel {

    private Block controlBlock;
    private BlockHeap fixedBlocks;

    // Constructs a game panel
    // effects:  sets size and background colour of panel,
    //           updates this with the game elements to be displayed
    public GamePanel(Block b, BlockHeap loB) {
        setPreferredSize(new Dimension(TetrisPainter.SCREEN_WIDTH, TetrisPainter.SCREEN_HEIGHT));
        this.controlBlock = b;
        this.fixedBlocks = loB;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawGame(g);
    }

    // Draws the game
    // modifies: g
    // effects:  draws the game onto g
    private void drawGame(Graphics g) {
        drawBlocks(g);
        drawBlock(g, controlBlock);
    }

    // Draw the invaders
    // modifies: g
    // effects:  draws the invaders onto g
    private void drawBlocks(Graphics g) {
        for (Block next : fixedBlocks.getBlockList()) {
            drawBlock(g, next);
        }
    }

    // Draw an invader
    // modifies: g
    // effects:  draws the invader i onto g
    private void drawBlock(Graphics g, Block b) {
        Color savedCol = g.getColor();
        g.setColor(b.getColor());
        for (Point p : b.getOrientation()) {
            int newX = b.getAnchorPoint().x + p.x;
            int newY = b.getAnchorPoint().y - p.y;

            g.fillRect(newX * Block.BLOCK_SIDE, newY * Block.BLOCK_SIDE, Block.BLOCK_SIDE, Block.BLOCK_SIDE);
        }
        g.setColor(savedCol);
    }

    public void setControlBlock(Block b) {
        this.controlBlock = b;
    }

    public Block getControlBlock() {
        return controlBlock;
    }
}

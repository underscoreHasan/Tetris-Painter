package ui;

import model.Block;
import model.BlockHeap;

import java.awt.*;

import javax.swing.JPanel;

// Represents the panel in which the game is rendered.
public class GamePanel extends JPanel {

    private Block controlBlock;
    private BlockHeap fixedBlocks;

    // EFFECTS: Sets size of panel and updates this with the app elements to be displayed.
    public GamePanel(Block b, BlockHeap loB) {
        setPreferredSize(new Dimension(TetrisPainter.SCREEN_WIDTH, TetrisPainter.SCREEN_HEIGHT));
        this.controlBlock = b;
        this.fixedBlocks = loB;
    }

    // EFFECTS: Overrides the paintComponent method in JComponent to draw the painter
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawPainter(g);
    }

    // MODIFIES: g
    // EFFECTS: draws the controlBlock and fixedBlocks onto g
    private void drawPainter(Graphics g) {
        drawBlocks(g);
        drawBlock(g, controlBlock);
    }

    // MODIFIES: g
    // EFFECTS: Draws the fixedBlocks onto g
    private void drawBlocks(Graphics g) {
        for (Block next : fixedBlocks.getBlockList()) {
            drawBlock(g, next);
        }
    }

    // MODIFIES: g
    // EFFECTS: Draws the Block b onto g
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

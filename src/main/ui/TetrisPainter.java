package ui;

import model.Block;
import model.BlockHeap;
import model.shapedblocks.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class TetrisPainter extends JFrame {

    //private static final int INTERVAL = 10;
    private Block controlBlock;
    private BlockHeap fixedBlocks;
    private GamePanel gp;

    private static final String[] POSSIBLE_BLOCKS = {"I", "J", "L", "O", "S", "T", "Z"};
    protected static final int BOARD_HEIGHT = 600;
    protected static final int BOARD_WIDTH = 300;

    // Constructs main window
    // effects: sets up window in which Space Invaders game will be played
    public TetrisPainter() {
        super("Tetris Painter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        newBlock();
        fixedBlocks = new BlockHeap();
        gp = new GamePanel(controlBlock, fixedBlocks);
        add(gp);
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        //addTimer();
    }

//    // Set up timer
//    // modifies: none
//    // effects:  initializes a timer that updates game each
//    //           INTERVAL milliseconds
//    private void addTimer() {
//        Timer t = new Timer(INTERVAL, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                game.update();
//                gp.repaint();
//            }
//        });
//
//        t.start();
//    }

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    /*
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_DOWN) {
                controlBlock.downOneLine();
            } else if (keyCode == KeyEvent.VK_LEFT) {
                controlBlock.moveLeft();
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                controlBlock.moveRight();
            } else if (keyCode == KeyEvent.VK_C) {
                controlBlock.rotateLeft();
            } else if (keyCode == KeyEvent.VK_V) {
                controlBlock.rotateRight();
            } else if (keyCode == KeyEvent.VK_SPACE) {
                fixedBlocks.fixBlock(controlBlock);
                newBlock();
                System.out.println("\nNew block generated!");
            }

            gp.repaint();
            printControlBlockInfo();

//        } else if (move.equals("view")) {
//            printFixedBlocks();
//        } else if (move.equals("save")) {
//            saveFixedBlocks();
//        } else if (move.equals("load")) {
//            loadControlBlock();
//            loadFixedBlocks();
//        } else {
//            System.out.println("\nChosen move is not in the list of moves. Try again.");
//        }
        }
    }

    // REQUIRES: fixedBlocks.fixBlock(controlBlock) must have already executed
    // MODIFIES: this, controlBlock
    // EFFECTS: sets controlBlock to be one of 7 random Blocks, places this curBlock at
    //          the starting position x = BOARD_WIDTH / 2, y = 2
    @SuppressWarnings("methodlength")
    public void newBlock() {
        Random rand = new Random();
        String blockType = POSSIBLE_BLOCKS[rand.nextInt(POSSIBLE_BLOCKS.length)];

        switch (blockType) {
            case "I":
                controlBlock = new BlockI();
                break;
            case "J":
                controlBlock = new BlockJ();
                break;
            case "L":
                controlBlock = new BlockL();
                break;
            case "O":
                controlBlock = new BlockO();
                break;
            case "S":
                controlBlock = new BlockS();
                break;
            case "T":
                controlBlock = new BlockT();
                break;
            case "Z":
                controlBlock = new BlockZ();
                break;
        }

        controlBlock.setAnchorPoint(BOARD_WIDTH / 2, 2);
    }

    // EFFECTS: displays the type and coordinates of the controlBlock
    private void printControlBlockInfo() {

        System.out.print(controlBlock.getBlockType() + "-Shaped: ");

        for (Point p : controlBlock.getOrientation()) {
            int newX = controlBlock.getAnchorPoint().x + p.x;
            int newY = controlBlock.getAnchorPoint().y - p.y;

            System.out.print("[" + newX + "," + newY + "] ");
        }

        System.out.println();
    }

    /*
     * Play the game
     */
    public static void main(String[] args) {
        new TetrisPainter();
    }

}


package ui;

import model.Block;
import model.BlockHeap;
import model.shapedblocks.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class TetrisPainter extends JFrame {

    private Block controlBlock;
    private BlockHeap fixedBlocks;
    private GamePanel gp;
    private ScorePanel sp;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/gameState.json";
    private static final String[] POSSIBLE_BLOCKS = {"I", "J", "L", "O", "S", "T", "Z"};
    protected static final int BOARD_WIDTH = 10;
    protected static final int SCREEN_HEIGHT = 600;
    protected static final int SCREEN_WIDTH = 800;

    // Constructs main window
    // effects: sets up window in which Space Invaders game will be played
    @SuppressWarnings("methodlength")
    public TetrisPainter() {
        super("Tetris Painter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        newBlock();
        fixedBlocks = new BlockHeap();
        gp = new GamePanel(controlBlock, fixedBlocks);
        sp = new ScorePanel(fixedBlocks);
        add(gp);
        add(sp, BorderLayout.NORTH);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFixedBlocks();
            }
        });
        saveButton.setFocusable(false);

        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadControlBlock();
                loadFixedBlocks();
                remove(gp);
                remove(sp);
                gp = new GamePanel(controlBlock, fixedBlocks);
                sp = new ScorePanel(fixedBlocks);
                add(gp);
                add(sp, BorderLayout.NORTH);
                pack();
                gp.repaint();
                printControlBlockInfo();
            }
        });
        loadButton.setFocusable(false);

        add(loadButton, BorderLayout.EAST);
        add(saveButton, BorderLayout.WEST);
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
    }

    // Centres frame on desktop
    // modifies: this
    // effects:  location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getWidth()) / 2, (screen.height - getHeight()) / 2);
    }

    /*
     * A key handler to respond to key events
     */
    @SuppressWarnings("methodlength")
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_UP) {
                controlBlock.upOneLine();
            } else if (keyCode == KeyEvent.VK_DOWN) {
                controlBlock.downOneLine();
            } else if (keyCode == KeyEvent.VK_LEFT) {
                controlBlock.moveLeft();
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                controlBlock.moveRight();
            } else if (keyCode == KeyEvent.VK_C) {
                controlBlock.rotateLeft();
            } else if (keyCode == KeyEvent.VK_V) {
                controlBlock.rotateRight();
            } else if (keyCode == KeyEvent.VK_R) {
                fixedBlocks.removeLatestBlock();
                sp.update();
            } else if (keyCode == KeyEvent.VK_SPACE) {
                fixedBlocks.fixBlock(controlBlock);
                newBlock();
                gp.setControlBlock(controlBlock);
                sp.update();
                System.out.println("\nNew block generated!");
            } else {
                System.out.println("\nChosen move is not in the list of moves. Try again.");
            }
            gp.repaint();
            printControlBlockInfo();

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

    // EFFECTS: saves the fixedBlocks to file
    private void saveFixedBlocks() {
        try {
            jsonWriter.open();
            jsonWriter.write(fixedBlocks, controlBlock);
            jsonWriter.close();
            System.out.println("Saved all placed blocks to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads fixedBlocks from file
    private void loadControlBlock() {
        try {
            controlBlock = jsonReader.readBlock();
            System.out.println("Loaded control block from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads fixedBlocks from file
    private void loadFixedBlocks() {
        try {
            fixedBlocks = jsonReader.readBlockHeap();
            System.out.println("Loaded placed blocks from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    /*
     * Play the game
     */
    public static void main(String[] args) {
        new TetrisPainter();
    }

}


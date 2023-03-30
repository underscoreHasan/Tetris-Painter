package ui;

import model.Block;
import model.BlockHeap;
import model.shapedblocks.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

// Tetris Application
public class TetrisApp {
    private Block controlBlock;
    private BlockHeap fixedBlocks;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/gameState.json";
    private static final String[] POSSIBLE_BLOCKS = {"I", "J", "L", "O", "S", "T", "Z"};
    private static final int BOARD_WIDTH = 10;

    // EFFECTS: runs the Tetris Game.
    public TetrisApp() {
        playTetris();
    }

    // MODIFIES: this
    // EFFECTS: takes user input and processes it
    private void playTetris() {
        boolean continuePlaying = true;
        String move;

        init();
        printCurBlockType();
        printControlBlockCoords();
        printScore();

        while (continuePlaying) {
            displayMoves();
            move = input.next();

            move = move.toLowerCase();

            if (move.equals("quit")) {
                continuePlaying = false;
            } else {
                doMove(move);
                printCurBlockType();
                printControlBlockCoords();
                printScore();
            }
        }

        System.out.println("\n Game Over. Your score was: " + fixedBlocks.getScore() + ".");
    }


    // MODIFIES: this
    // EFFECTS: initializes a Board object, controlBlock, fixedBlocks and generates a new random Block
    private void init() {
        newBlock();
        fixedBlocks = new BlockHeap();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: displays menu of possible moves to user
    private void displayMoves() {
        System.out.println("\nChoose a move by typing it out:");
        System.out.println("Down - moves the current block down 1 row.");
        System.out.println("Left - moves the current block leftward 1 column.");
        System.out.println("Right - moves the current block rightward 1 column.");
        System.out.println("Rotate Right - rotates the current block clockwise 90°.");
        System.out.println("Rotate Left - rotates the current block anti-clockwise 90°.");
        System.out.println("Place - fixes the current block in place, and creates a new ");
        System.out.println("random block for you to control.");
        System.out.println();
        System.out.println("View - View all the placed blocks and their coordinates.");
        System.out.println("Save - saves all the placed blocks to file");
        System.out.println("Load - loads the blocks saved on file");
        System.out.println("Quit - End the game - saves your score and all blocks.");
    }

    // MODIFIES: this
    // EFFECTS: processes user selected move
    @SuppressWarnings("methodlength")
    private void doMove(String move) {
        if (move.equals("down")) {
            controlBlock.downOneLine();
        } else if (move.equals("left")) {
            controlBlock.moveLeft();
        } else if (move.equals("right")) {
            controlBlock.moveRight();
        } else if (move.equals("rotate left")) {
            controlBlock.rotateLeft();
        } else if (move.equals("rotate right")) {
            controlBlock.rotateRight();
        } else if (move.equals("place")) {
            fixedBlocks.fixBlock(controlBlock);
            newBlock();
            System.out.println("\nNew block generated!");
        } else if (move.equals("view")) {
            printFixedBlocks();
        } else if (move.equals("save")) {
            saveFixedBlocks();
        } else if (move.equals("load")) {
            loadControlBlock();
            loadFixedBlocks();
        } else {
            System.out.println("\nChosen move is not in the list of moves. Try again.");
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

    // EFFECTS: displays all fixedBlocks along with their coordinates
    private void printFixedBlocks() {
        System.out.println();
        System.out.println("The placed blocks are:");

        for (Block b : fixedBlocks.getBlockList()) {
            System.out.print(b.getBlockType() + "-Shaped: ");

            for (Point p : b.getOrientation()) {
                int newX = b.getAnchorPoint().x + p.x;
                int newY = b.getAnchorPoint().y - p.y;

                System.out.print("[" + newX + "," + newY + "] ");
            }
            System.out.print("\n");
        }

        System.out.println();
    }

    // EFFECTS: displays the shape of the controlBlock
    private void printCurBlockType() {
        System.out.println("\nThe current block is " + controlBlock.getBlockType() + "-Shaped. ");
    }

    // EFFECTS: displays the current score
    private void printScore() {
        System.out.println();
        System.out.println("\nCurrent Score: " + fixedBlocks.getScore());
    }

    // EFFECTS: displays the coordinates of the controlBlock
    private void printControlBlockCoords() {

        for (Point p : controlBlock.getOrientation()) {
            int newX = controlBlock.getAnchorPoint().x + p.x;
            int newY = controlBlock.getAnchorPoint().y - p.y;

            System.out.print("[" + newX + "," + newY + "] ");
        }
    }
}


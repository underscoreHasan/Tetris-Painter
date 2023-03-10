package ui;

import model.Block;
import model.BlockHeap;
import model.Board;
import model.shapedblocks.*;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

// Tetris Application
public class TetrisApp {
    private Block controlBlock;
    private BlockHeap fixedBlocks;
    private Scanner input;
    private String curBlockType;

    private static final String[] POSSIBLE_BLOCKS = {"I", "J", "L", "O", "S", "T", "Z"};
    private static final int BOARD_HEIGHT = 20;
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
        printBlockType();
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
                printBlockType();
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
    }

    // EFFECTS: displays menu of possible moves to user
    private void displayMoves() {
        System.out.println("\nChoose a move by typing it out:");
        System.out.println("Select from:");
        System.out.println("Down - moves the current block down 1 row.");
        System.out.println("Left - moves the current block leftward 1 column.");
        System.out.println("Right - moves the current block rightward 1 column.");
        System.out.println("Rotate Right - rotates the current block clockwise 90°.");
        System.out.println("Rotate Left - rotates the current block anti-clockwise 90°.");
        System.out.println("Place - fixes the current block in place, and creates a new ");
        System.out.println("random block for you to control.");
        System.out.println("Quit - End the game and save your score.");
    }

    // MODIFIES: this
    // EFFECTS: processes user selected move
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
        } else {
            System.out.println("\nChosen move is not in the list of moves. Try again.");
        }
    }

    // REQUIRES: fixedBlocks.fixBlock(controlBlock) must have already executed XOR board.getCurBlock() returns null
    // MODIFIES: this, board.curBlock, board.curBlockType
    // EFFECTS: sets curBlock to be one of 7 random Blocks, places this curBlock at
    //          the starting position x = Board.getBoardWidth() / 2, y = 2
    @SuppressWarnings("methodlength")
    public void newBlock() {
        Random rand = new Random();
        // String blockType = POSSIBLE_BLOCKS.get(rand.nextInt(POSSIBLE_BLOCKS.size()));
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

        curBlockType = blockType;
    }

    private void printBlockType() {
        System.out.println("\nThe block is " + curBlockType + "-shaped.\n");
    }

    private void printScore() {
        System.out.println("\nCurrent Score: " + fixedBlocks.getScore());
    }

    private void printControlBlockCoords() {

        for (Point p : controlBlock.getOrientation()) {
            int newX = controlBlock.getAnchorPoint().x + p.x;
            int newY = controlBlock.getAnchorPoint().y - p.y;

            System.out.println(newX + "," + newY);
        }
    }
}


package ui;

import model.Block;
import model.BlockCollection;
import model.Board;
import model.shapedblocks.*;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Tetris Application
public class TetrisApp {
    private Board board;
    private Block controlBlock;
    private BlockCollection fixedBlocks;
    private Scanner input;

    //private static final List<String> POSSIBLE_BLOCKS = List.of("I", "J", "L", "O", "S", "T", "Z");
    private static final String[] POSSIBLE_BLOCKS = {"I", "J", "L", "O", "S", "T", "Z"};

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
                printBlockType();
                printControlBlockCoords();
                doMove(move);
                printScore();
            }
        }

        System.out.println("\n Game Over. Your score was: " + board.getFixedBlocks().getScore() + ".");
    }


    // MODIFIES: this
    // EFFECTS: initializes a Board object, controlBlock, fixedBlocks and generates a new random Block
    private void init() {
        board = new Board();
        newBlock();
        controlBlock = board.getCurBlock();
        fixedBlocks = board.getFixedBlocks();
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
            controlBlock = board.getCurBlock();
            System.out.println("\nNew block generated!");
            printBlockType();
            printControlBlockCoords();
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

        controlBlock.setAnchorPoint(Board.getBoardWidth() / 2, 2);

        board.setCurBlock(controlBlock);
        board.setCurBlockType(blockType);
    }

    private void printBlockType() {
        System.out.println("\nThe block is " + board.getCurBlockType() + "-shaped.\n");
    }

    private void printScore() {
        System.out.println("\nCurrent Score: " + board.getFixedBlocks().getScore());
    }

    private void printControlBlockCoords() {

        for (Point p : controlBlock.getOrientation()) {
            int newX = controlBlock.getAnchorPoint().x + p.x;
            int newY = controlBlock.getAnchorPoint().y - p.y;

            System.out.println(newX + "," + newY);
        }
    }
}


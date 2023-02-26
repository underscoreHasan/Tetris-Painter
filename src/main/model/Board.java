package model;

import model.shapedblocks.*;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Board {

    private Block curBlock;
    private int[][] positions;
    private BlockCollection fixedBlocks;

    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;
    private static final List<String> POSSIBLE_BLOCKS = List.of("I", "J", "L", "O", "S", "T", "Z");

    private void board() {
        positions = new int[BOARD_HEIGHT][BOARD_WIDTH];
        fixedBlocks = new BlockCollection();
    }

    //generate the next coordinates the block will be at
    private boolean genNextCoordinates() {
        //copy the curblock into a new object
        //apply move
        //get new coordinates
        //pass each pair to check collision
        //if false do not allow move
        //if true curblock = new object
        return false; //stub
    }

    //check if curBlock will hit the given x,y Coords (use pointsList from BlockCollection) once the proposed
    // move is completed
    private boolean checkCollision(Point p) {
        return fixedBlocks.getPointList().contains(p);
    }

    // REQUIRES: curBlock == BlockVoid
    // MODIFIES: this
    // EFFECTS: sets curBlock to be one of 7 random Blocks, and places this curBlock at
    //          the starting position x = BOARD_WIDTH / 2, y = 2
    @SuppressWarnings("methodlength")
    private void newBlock() {
        Random rand = new Random();
        String blockType = POSSIBLE_BLOCKS.get(rand.nextInt(POSSIBLE_BLOCKS.size()));

        switch (blockType) {
            case "I":
                curBlock = new BlockI();
                break;
            case "J":
                curBlock = new BlockJ();
                break;
            case "L":
                curBlock = new BlockL();
                break;
            case "O":
                curBlock = new BlockO();
                break;
            case "S":
                curBlock = new BlockS();
                break;
            case "T":
                curBlock = new BlockT();
                break;
            case "Z":
                curBlock = new BlockZ();
                break;
        }

        curBlock.setAnchorPoint(BOARD_WIDTH / 2, 2);
    }
}

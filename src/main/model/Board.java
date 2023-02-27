package model;

import model.shapedblocks.*;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class Board {

    private Block curBlock;
    private int[][] positions;
    private BlockCollection fixedBlocks;
    private boolean canFall = false;

    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;
    private static final List<String> POSSIBLE_BLOCKS = List.of("I", "J", "L", "O", "S", "T", "Z");

    private void board() {
        positions = new int[BOARD_HEIGHT][BOARD_WIDTH];
        fixedBlocks = new BlockCollection();
    }

    //used by ui, pass block.movex() to it
    //test next coordinates the block will be at. True if valid, false if invalid
    public boolean tryNextCoordinates(Point newAnchorPoint) {
        Point[] curOrientation = curBlock.getOrientation();

        for (Point p : curOrientation) {
            int newX = newAnchorPoint.x + p.x;
            int newY = newAnchorPoint.y - p.y;

            if (checkCollision(new Point(newX, newY))) {
                return false;
            }
        }
        curBlock.setAnchorPoint(newAnchorPoint.x, newAnchorPoint.y);
        return true;
    }

    public boolean tryNextCoordinates(Point[] newCoords, String dir) {
        for (Point p : newCoords) {
            if (checkCollision(p)) {
                return false;
            }
        }

        if (dir.equals('l')) {
            curBlock.decRotationState();
        } else if (dir.equals('r')) {
            curBlock.incRotationState();
        }
        return true;
    }

    //apply .move()
    //get the new coordinates of the anchorpoint
    //calculate coordinates of all the segments
    //pass each pair to check collision
    //if false for all the new coords set new anchorpoint to be curBlocks anchorpoint
    //if true for any of the new coords retain old anchorpoint
    //stub

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
    public void newBlock() {
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

    public Block getCurBlock() {
        return curBlock;
    }

    public BlockCollection getFixedBlocks() {
        return fixedBlocks;
    }
}
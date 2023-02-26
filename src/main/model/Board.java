package model;

import model.shapedblocks.*;

import java.awt.*;
import java.util.ArrayList;
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

    @SuppressWarnings("methodlength")
    private void newPiece() {
        Random rand = new Random();
        String blockType = POSSIBLE_BLOCKS.get(new Random().nextInt(POSSIBLE_BLOCKS.size()));

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

        curBlock.setAnchorPoint(new Point(5, 2));
    }

    private boolean checkCollision(int x, int y) {
        return false;
    }
    //array, 1 element representing each position in array
    //0 if unoccupied
    //1 if occupied


}

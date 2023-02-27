package model;

import model.shapedblocks.*;

import java.awt.*;
import java.util.List;
import java.util.Random;

// A game board that contains fixed pieces (BlockCollection fixedBlocks) and a current,
// controllable piece (Block curBlock). The Board class provides getter and setter methods
// that allow a TetrisApp to control the curBlock and add it to fixedBlocks if needed.
public class Board {

    private Block curBlock;
    private BlockCollection fixedBlocks;
    private String curBlockType;

    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public Board() {
        fixedBlocks = new BlockCollection();
    }

    public Block getCurBlock() {
        return curBlock;
    }

    public void setCurBlock(Block curBlock) {
        this.curBlock = curBlock;
    }

    public BlockCollection getFixedBlocks() {
        return fixedBlocks;
    }

    public String getCurBlockType() {
        return curBlockType;
    }

    public void setCurBlockType(String curBlockType) {
        this.curBlockType = curBlockType;
    }

    public static int getBoardWidth() {
        return BOARD_WIDTH;
    }

    public static int getBoardHeight() {
        return BOARD_HEIGHT;
    }
}
package model;

// A game board that contains fixed pieces (BlockCollection fixedBlocks) and a current,
// controllable piece (Block curBlock). The Board class provides getter and setter methods
// that allow a TetrisApp to control the curBlock and add it to fixedBlocks if needed.
public class Board {

    private Block curBlock;
    private BlockHeap fixedBlocks;
    private String curBlockType;

    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public Board() {
        fixedBlocks = new BlockHeap();
    }

    public Block getCurBlock() {
        return curBlock;
    }

    public void setCurBlock(Block curBlock) {
        this.curBlock = curBlock;
    }

    public BlockHeap getFixedBlocks() {
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
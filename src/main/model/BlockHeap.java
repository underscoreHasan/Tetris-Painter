package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// A BlockCollection is the representation of the Tetris Blocks that have been fixed in place. It holds
// a List<Block> that contains all the blocks fixed so far, and a List<Point> that contains all the coordinates
// in that the List<Block> occupies in a game board.
public class BlockHeap {
    private List<Block> blockList;
    private List<Point> pointList;
    private int score;
    // private List<Point> removedSegments;

    // MODIFIES: this
    // EFFECTS: Constructs an empty collection of blocks with an empty blockList,
    //          pointList and no removedSegments
    public BlockHeap() {
        blockList = new ArrayList<>();
        pointList = new ArrayList<>();
        score = 0;
        // removedSegments = new ArrayList<>();
    }

    // REQUIRES: block.anchorPoint.x > 0 && block.anchorPoint.y > 0
    // MODIFIES: this
    // EFFECTS: Adds the curPiece to the fixedBlocks
    public void fixBlock(Block block) {
        blockList.add(block);
        Point[] curOrientation = block.getOrientation();

        for (Point s : curOrientation) {
            int finalX = block.getAnchorPoint().x + s.x;
            int finalY = block.getAnchorPoint().y - s.y;
            pointList.add(new Point(finalX, finalY));
        }

        score += 10;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public int getScore() {
        return score;
    }

}

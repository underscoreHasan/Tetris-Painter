package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockCollection {
    private List<Block> blockList;
    private List<Point> pointList;
    private int score;
    // private List<Point> removedSegments;

    // EFFECTS: Constructs an empty collection of blocks with an empty blockList,
    //          pointList and no removedSegments
    public void blockCollection() {
        blockList = new ArrayList<>();
        pointList = new ArrayList<>();
        // removedSegments = new ArrayList<>();
    }

    // REQUIRES: tryMove() == true && collisionCheck == true
    // MODIFIES: this
    // EFFECTS: Adds the curPiece to the fixedBlocks
    private void fixBlock(Block block) {
        blockList.add(block);
        Collections.addAll(pointList, block.getOrientation());
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

/*
    // MODIFIES: this
    // EFFECTS: Removes the block segments and points that correspond to fully occupied
    //          horizontal lines from blockList and pointList
    private void removeLines() {
        List<Point> fullLines;

        fullLines = findFullLines();

        for (Point p : fullLines) {
            pointList.remove(p);
            removedSegments.add(p);
        }
    }

    // EFFECTS: Returns a List<Point> that contains the coordinates for every block that
    //          must be removed due to it being part of a full line.
    private List<Point> findFullLines() {
        List<Point> fullLines = new ArrayList<>();

        for (Point p : pointList) {
            //!!!
        }

        return fullLines;
    }
*/
}

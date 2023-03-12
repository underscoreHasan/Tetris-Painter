package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// A BlockCollection is the representation of the Tetris Blocks that have been fixed in place. It holds
// a List<Block> that contains all the blocks fixed so far, and a List<Point> that contains all the coordinates
// in that the List<Block> occupies in a game board.
public class BlockHeap implements Writable {
    private List<Block> blockList;
    private int score;

    // MODIFIES: this
    // EFFECTS: Constructs an empty collection of blocks with an empty blockList,
    //          pointList and no removedSegments
    public BlockHeap() {
        blockList = new ArrayList<>();
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
        }

        score += 10;
    }

    // EFFECTS: returns this.blockList as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("score", score);
        json.put("blockList", blocksToJson());
        return json;
    }

    // EFFECTS: returns blocks in this.blockList as a JSON array
    private JSONArray blocksToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Block b : blockList) {
            jsonArray.put(b.toJson());
        }

        return jsonArray;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// A BlockCollection is the representation of the Tetris Blocks that have been fixed in place. It holds
// a List<Block> that contains all the blocks fixed so far, and the score so far.
public class BlockHeap implements Writable {
    private List<Block> blockList;
    private int score;

    // EFFECTS: Constructs an empty collection of blocks with an empty blockList and a score of 0.
    public BlockHeap() {
        blockList = new ArrayList<>();
        score = 0;
    }

    // MODIFIES: this
    // EFFECTS: Adds the curPiece to the fixedBlocks
    public void fixBlock(Block block) {
        blockList.add(block);
        Point[] curOrientation = block.getOrientation();

        for (Point s : curOrientation) {
            int finalX = block.getAnchorPoint().x + s.x;
            int finalY = block.getAnchorPoint().y - s.y;
        }

        EventLog.getInstance().logEvent(
                new Event("Added " + block.getBlockType()
                        + "-shaped block at AnchorPoint: "
                        + "[" + block.getAnchorPoint().x + "," + block.getAnchorPoint().y + "]")
        );

        score += 10;
    }

    // MODIFIES: this
    // EFFECTS: Removes the latest placed block from the fixedBlocks
    public void removeLatestBlock() {
        if (!blockList.isEmpty()) {
            Block block = blockList.get(blockList.size() - 1);

            EventLog.getInstance().logEvent(
                    new Event("Removed latest placed block from fixedBlocks: " + block.getBlockType()
                            + "-shaped block at AnchorPoint: "
                            + "[" + block.getAnchorPoint().x + "," + block.getAnchorPoint().y + "]")
            );

            blockList.remove(blockList.size() - 1);
            score -= 10;
        } else {
            EventLog.getInstance().logEvent(
                    new Event("No blocks placed, nothing can be removed!")
            );
        }
    }

    // EFFECTS: returns this.blockList as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
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
}

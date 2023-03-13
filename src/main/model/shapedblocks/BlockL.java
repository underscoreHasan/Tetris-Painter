package model.shapedblocks;

import model.Block;

import java.awt.*;

// Class that represents specific behavior and properties of an L-Shaped block.
public class BlockL extends Block {

    // EFFECTS: constructs an L-Shaped Block
    public BlockL() {
        setCoordStates(new Point[][]{
                {new Point(1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)},
                {new Point(-1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0)},
                {new Point(-1, 1), new Point(0, 1), new Point(0, 0), new Point(0, -1)},
                {new Point(1, 1), new Point(0, 0), new Point(1, 0), new Point(-1, 0)}
        });
        setColor(new Color(255, 127, 0));
        setOrientation(0);
        setRotationState(0);
        setBlockType("L");
    }
}

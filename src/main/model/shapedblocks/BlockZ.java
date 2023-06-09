package model.shapedblocks;

import model.Block;

import java.awt.*;

// Class that represents specific behavior and properties of a Z-Shaped block.
public class BlockZ extends Block {

    // EFFECTS: constructs a Z-Shaped Block
    public BlockZ() {
        setCoordStates(new Point[][] {
                {new Point(0,-1), new Point(0,0), new Point(1,0), new Point(1,1)},
                {new Point(1,-1), new Point(0,-1), new Point(0,0), new Point(-1,0)},
                {new Point(0,-1), new Point(0,0), new Point(-1,0), new Point(-1,1)},
                {new Point(-1,1), new Point(0,1), new Point(0,0), new Point(1,0)}
        });
        setColor(new Color(255, 0, 0));
        setOrientation(0);
        setRotationState(0);
        setBlockType("Z");
    }
}

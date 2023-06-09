package model.shapedblocks;

import model.Block;

import java.awt.*;

// Class that represents specific behavior and properties of an O-Shaped block.
public class BlockO extends Block {

    // EFFECTS: constructs an O-Shaped Block
    public BlockO() {
        setCoordStates(new Point[][] {
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)}
        });
        setColor(new Color(255, 255, 0));
        setOrientation(0);
        setRotationState(0);
        setBlockType("O");
    }
}

package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockI extends Block {

    public BlockI() {
        setCoordStates(new Point[][] {
                {new Point(0,-1), new Point(0,0), new Point(0,1), new Point(0,2)},
                {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(2,0)},
                {new Point(0,-2), new Point(0,-1), new Point(0,0), new Point(0,1)},
                {new Point(-2,0), new Point(-1,0), new Point(0,0), new Point(1,0)}
        });
        setColor(new Color(0, 255, 255));
        setOrientation(0);
        setRotationState(0);
        setBlockType("I");
    }
}

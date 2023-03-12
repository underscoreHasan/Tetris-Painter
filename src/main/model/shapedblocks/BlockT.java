package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockT extends Block {

    public BlockT() {
        setCoordStates(new Point[][] {
                {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(0,1)},
                {new Point(0,1), new Point(0,0), new Point(0,-1), new Point(1,0)},
                {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(0,-1)},
                {new Point(0,1), new Point(0,0), new Point(0,-1), new Point(-1,0)}
        });
        setColor(new Color(80, 0, 80));
        setOrientation(0);
        setRotationState(0);
        setBlockType("T");
    }
}

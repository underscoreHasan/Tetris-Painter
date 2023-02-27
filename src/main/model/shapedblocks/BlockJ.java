package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockJ extends Block {

    public BlockJ() {
        setCoordStates(new Point [][] {
                {new Point(-1,-1), new Point(0,-1), new Point(0,0), new Point(0,1)},
                {new Point(-1,1), new Point(-1,0), new Point(0,0), new Point(1,0)},
                {new Point(1,1), new Point(0,1), new Point(0,0), new Point(0,-1)},
                {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(1,-1)}
        });
        setColor(new Color(0, 0, 255));
        setOrientation(0);
        setRotationState(0);
    }
}
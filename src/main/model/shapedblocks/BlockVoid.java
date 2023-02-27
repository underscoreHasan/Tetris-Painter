package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockVoid extends Block {

    public BlockVoid() {
        setCoordStates(new Point[][] {
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)},
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)},
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)},
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)}
        });
        setColor(new Color(0, 0, 0));
        setOrientation(0);
        setRotationState(0);
        setRotationState(0);
    }
}

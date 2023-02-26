package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockVoid extends Block {

    public void blockVoid() {
        setCoordStates(new Point[][] {
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)},
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)},
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)},
                {new Point(0,0), new Point(0,0), new Point(0,0), new Point(0,0)}
        });
        setColor(new Color(0, 0, 0));
        setOrientation(1);
    }
}

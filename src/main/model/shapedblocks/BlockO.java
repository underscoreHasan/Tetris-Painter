package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockO extends Block {

    public void blockO() {
        setCoordStates(new Point[][] {
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
                {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)}
        });
        setColor(new Color(255, 255, 0));
        setOrientation(0);
    }
}

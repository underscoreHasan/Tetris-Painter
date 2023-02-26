package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockZ extends Block {

    public void blockT() {
        setCoordStates(new Point[][] {
                {new Point(0,-1), new Point(0,0), new Point(1,0), new Point(1,1)},
                {new Point(1,-1), new Point(0,-1), new Point(0,0), new Point(-1,0)},
                {new Point(0,-1), new Point(0,0), new Point(-1,0), new Point(-1,-1)},
                {new Point(-1,1), new Point(0,1), new Point(0,0), new Point(1,0)}
        });
        setColor(new Color(255, 0, 0));
        setOrientation(0);
    }
}

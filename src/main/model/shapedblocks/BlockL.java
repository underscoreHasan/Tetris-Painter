package model.shapedblocks;

import model.Block;

import java.awt.*;

public class BlockL extends Block {

    public void blockL() {
        setCoordStates(new Point[][]{
                {new Point(1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)},
                {new Point(-1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0)},
                {new Point(-1, 1), new Point(0, 1), new Point(0, 0), new Point(0, -1)},
                {new Point(1, 1), new Point(0, 0), new Point(1, 0), new Point(-1, 0)}
        });
        setColor(new Color(255, 127, 0));
        setOrientation(1);
    }
}

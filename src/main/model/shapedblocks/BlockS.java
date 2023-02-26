package model.shapedblocks;

import model.Block;
import java.awt.*;

public class BlockS extends Block {

    public void blockS() {
        setCoordStates(new Point[][] {
                {new Point(0,-1), new Point(0,0), new Point(-1,0), new Point(-1,1)},
                {new Point(-1,0), new Point(0,0), new Point(0,1), new Point(1,1)},
                {new Point(1,-1), new Point(1,0), new Point(0,0), new Point(0,1)},
                {new Point(-1,-1), new Point(0,-1), new Point(0,0), new Point(1,0)}
        });
        setColor(new Color(0, 255, 0));
        setOrientation(1);
    }
}

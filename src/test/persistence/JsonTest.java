package persistence;

import model.Block;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Class encapsulating helper methods for the JsonReaderTest and JsonWriterTest classes.
public class JsonTest {
    protected void checkBlock(String blockType, int rotationState, int anchorPointX, int anchorPointY, Block readBlock) {
        assertEquals(blockType, readBlock.getBlockType());
        assertEquals(rotationState, readBlock.getRotationState());
        assertEquals(anchorPointX, readBlock.getAnchorPoint().x);
        assertEquals(anchorPointY, readBlock.getAnchorPoint().y);
    }
}

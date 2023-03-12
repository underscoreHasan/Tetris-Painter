package persistence;

import model.Block;
import model.BlockHeap;
import model.shapedblocks.BlockZ;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {
    @Test
    void testWriterInvalidFile() {
        try {
            Block controlBlock = new BlockZ();
            BlockHeap fixedBlocks = new BlockHeap();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:gameState.json");
            writer.open();
            fail("IOException was expected");
        } catch (FileNotFoundException e) {
            // pass since exception was thrown
        }
    }

}
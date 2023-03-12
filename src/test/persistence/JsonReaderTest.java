package persistence;

import model.*;
import model.shapedblocks.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Block controlBlock = reader.readBlock();
            BlockHeap fixedBlocks = reader.readBlockHeap();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderGeneralGameStateNoFixedBlocks() {
        try {
            JsonReader reader = new JsonReader("./data/testGeneralGameStateNoFixedBlocks.json");
            Block readControlBlock = reader.readBlock();
            BlockHeap readFixedBlocks = reader.readBlockHeap();
            int score = readFixedBlocks.getScore();
            List<Block> BlockList = readFixedBlocks.getBlockList();

            checkBlock("J", 0, 5, 2, readControlBlock);
            assertTrue(BlockList.isEmpty());
            assertEquals(0, score);
        } catch (IOException e) {
            fail("Exception should not have been thrown.");
        }
    }
    @Test
    void testReaderGeneralGameStateAllBlockTypesFixed() {
        try {
            JsonReader reader = new JsonReader("./data/testGeneralGameStateAllBlockTypesFixed.json");
            Block readControlBlock = reader.readBlock();
            BlockHeap readFixedBlocks = reader.readBlockHeap();
            int score = readFixedBlocks.getScore();
            List<Block> BlockList = readFixedBlocks.getBlockList();

            checkBlock("Z", 0, 5, 2, readControlBlock);
            assertEquals(7, BlockList.size());
            assertEquals(70, score);
            checkBlock("I", 0, 5, 2, BlockList.get(0));
            checkBlock("J", 0, 6, 3, BlockList.get(1));
            checkBlock("L", 0, 7, 4, BlockList.get(2));
            checkBlock("O", 0, 8, 5, BlockList.get(3));
            checkBlock("S", 0, 9, 6, BlockList.get(4));
            checkBlock("T", 0, 10, 7, BlockList.get(5));
            checkBlock("Z", 0, 11, 8, BlockList.get(6));
        } catch (IOException e) {
            fail("Exception should not have been thrown.");
        }
    }

    @Test
    void testReaderGeneralGameState() {
        try {
            JsonReader reader = new JsonReader("./data/testGeneralGameState.json");
            Block readControlBlock = reader.readBlock();
            BlockHeap readFixedBlocks = reader.readBlockHeap();
            int score = readFixedBlocks.getScore();
            List<Block> BlockList = readFixedBlocks.getBlockList();

            checkBlock("T", 3, 2, 4, readControlBlock);
            assertEquals(4, BlockList.size());
            assertEquals(40, score);
            checkBlock("Z", 0, 5, 3, BlockList.get(0));
            checkBlock("O", 1, 5, 6, BlockList.get(1));
            checkBlock("L", 2, 8, 5, BlockList.get(2));
            checkBlock("O", 0, 2, 2, BlockList.get(3));
        } catch (IOException e) {
            fail("Exception should not have been thrown.");
        }
    }
}

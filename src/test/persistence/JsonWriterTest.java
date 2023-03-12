package persistence;

import model.*;
import model.shapedblocks.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

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

    @Test
    void testGeneralGameStateNoFixedBlocks() {
        try {
            Block controlBlock = new BlockJ();
            controlBlock.setAnchorPoint(5, 2);
            BlockHeap fixedBlocks = new BlockHeap();

            JsonWriter writer = new JsonWriter("./data/testGeneralGameState.json");
            writer.open();
            writer.write(fixedBlocks, controlBlock);
            writer.close();

            JsonReader reader = new JsonReader("./data/testGeneralGameState.json");
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
    void testGeneralGameStateAllBlockTypesFixed() {
        try {
            Block controlBlock = new BlockZ();
            controlBlock.setAnchorPoint(5, 2);

            BlockHeap fixedBlocks = new BlockHeap();
            Block BlockI = new BlockI();
            BlockI.setAnchorPoint(5, 2);
            Block BlockJ = new BlockJ();
            BlockJ.setAnchorPoint(6, 3);
            Block BlockL = new BlockL();
            BlockL.setAnchorPoint(7, 4);
            Block BlockO = new BlockO();
            BlockO.setAnchorPoint(8, 5);
            Block BlockS = new BlockS();
            BlockS.setAnchorPoint(9, 6);
            Block BlockT = new BlockT();
            BlockT.setAnchorPoint(10, 7);
            Block BlockZ = new BlockZ();
            BlockZ.setAnchorPoint(11, 8);
            fixedBlocks.fixBlock(BlockI);
            fixedBlocks.fixBlock(BlockJ);
            fixedBlocks.fixBlock(BlockL);
            fixedBlocks.fixBlock(BlockO);
            fixedBlocks.fixBlock(BlockS);
            fixedBlocks.fixBlock(BlockT);
            fixedBlocks.fixBlock(BlockZ);

            JsonWriter writer = new JsonWriter("./data/testGeneralGameStateAllBlockTypesFixed.json");
            writer.open();
            writer.write(fixedBlocks, controlBlock);
            writer.close();

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
    void testGeneralGameState() {
        try {
            Block controlBlock = new BlockT();
            controlBlock.setAnchorPoint(2, 4);
            controlBlock.setRotationState(3);

            BlockHeap fixedBlocks = new BlockHeap();
            Block BlockZ = new BlockZ();
            BlockZ.setAnchorPoint(5, 3);

            Block BlockO = new BlockO();
            BlockO.setAnchorPoint(5, 6);
            BlockO.setRotationState(1);

            Block BlockL = new BlockL();
            BlockL.setAnchorPoint(8, 5);
            BlockL.setRotationState(2);

            Block BlockO2 = new BlockO();
            BlockO2.setAnchorPoint(2, 2);

            fixedBlocks.fixBlock(BlockZ);
            fixedBlocks.fixBlock(BlockO);
            fixedBlocks.fixBlock(BlockL);
            fixedBlocks.fixBlock(BlockO2);

            JsonWriter writer = new JsonWriter("./data/testGeneralGameState.json");
            writer.open();
            writer.write(fixedBlocks, controlBlock);
            writer.close();

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

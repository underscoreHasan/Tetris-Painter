package model;

import model.shapedblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Test class for the BlockHeap class.
class BlockHeapTest {
    private BlockHeap testHeap;

    @BeforeEach
    public void runBefore() {
        testHeap = new BlockHeap();
    }

    @Test
    public void testConstructor() {
        assertTrue(testHeap.getBlockList().isEmpty());
        assertEquals(0, testHeap.getScore());
    }

    @Test
    public void testFixBlockOnce() {
        Block testBlock = new BlockI();
        testBlock.downOneLine();

        testHeap.fixBlock(testBlock);
        assertEquals(testHeap.getBlockList().size(), 1);
        assertEquals(testHeap.getBlockList().get(0), testBlock);
        assertEquals(testHeap.getScore(), 10);
    }

    @Test
    public void testFixBlockMultiple() {
        Block testBlock = new BlockI();
        testBlock.downOneLine();

        testHeap.fixBlock(testBlock);
        assertEquals(testHeap.getBlockList().size(), 1);
        assertEquals(testHeap.getBlockList().get(0), testBlock);
        assertEquals(testHeap.getScore(), 10);

        Block testBlock2 = new BlockJ();
        testBlock.downOneLine();
        testHeap.fixBlock(testBlock2);
        assertEquals(testHeap.getBlockList().size(), 2);
        assertEquals(testHeap.getBlockList().get(1), testBlock2);
        assertEquals(testHeap.getScore(), 20);
    }

    @Test
    public void testRemoveBlockOnce() {
        Block testBlock = new BlockI();

        testHeap.fixBlock(testBlock);
        testHeap.removeLatestBlock();
        assertTrue(testHeap.getBlockList().isEmpty());
    }

    @Test
    public void testRemoveBlockTwice() {
        Block testBlock = new BlockI();

        testHeap.fixBlock(testBlock);
        testHeap.removeLatestBlock();
        assertTrue(testHeap.getBlockList().isEmpty());
        testHeap.removeLatestBlock();
        assertTrue(testHeap.getBlockList().isEmpty());
    }
}
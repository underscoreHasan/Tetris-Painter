package model;

import model.shapedblocks.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockHeapTest {
    private BlockHeap testHeap;

    @BeforeEach
    public void runBefore() {
        testHeap = new BlockHeap();
    }

    @Test
    public void testConstructor() {
        assertTrue(testHeap.getBlockList().isEmpty());
        assertTrue(testHeap.getPointList().isEmpty());
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
}
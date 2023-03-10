package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board testBoard;

    @BeforeEach
    void runBefore() {
        testBoard = new Board();
    }

    @Test
    void testConstructor() {
        BlockHeap fixedBlocks = testBoard.getFixedBlocks();

        assertTrue(fixedBlocks.getBlockList().isEmpty());
        assertTrue(fixedBlocks.getPointList().isEmpty());
        assertEquals(0, fixedBlocks.getScore());

        assertNull(testBoard.getCurBlock());
        assertNull(testBoard.getCurBlockType());
    }

    @Test
    void getCurBlock() {

    }

    @Test
    void setCurBlock() {
    }

    @Test
    void getFixedBlocks() {
    }

    @Test
    void getCurBlockType() {
    }

    @Test
    void setCurBlockType() {
    }

    @Test
    void getBoardWidth() {
    }

    @Test
    void getBoardHeight() {
    }
}
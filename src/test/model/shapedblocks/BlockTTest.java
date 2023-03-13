package model.shapedblocks;

import model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

// Test class for the BlockT class.
class BlockTTest {

    private Block testBlockT;
    private static final Point[][] CORRECT_COORD_STATES = new Point [][] {
            {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(0,1)},
            {new Point(0,1), new Point(0,0), new Point(0,-1), new Point(1,0)},
            {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(0,-1)},
            {new Point(0,1), new Point(0,0), new Point(0,-1), new Point(-1,0)}};
    private static final Color BLOCK_T_COLOR = new Color(80, 0, 80);
    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    @BeforeEach
    public void runBefore() {
        testBlockT = new BlockT();
    }

    @Test
    void testConstructor() {
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES, testBlockT.getCoordStates()));
        assertEquals(BLOCK_T_COLOR, testBlockT.getColor());
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], testBlockT.getCoordStates()[0]));
        assertEquals(0, testBlockT.getRotationState());
        assertEquals("T", testBlockT.getBlockType());
    }

    @Test
    void testDownOneLine() {
        testBlockT.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockT.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 3), testBlockT.getAnchorPoint());
    }

    @Test
    void testDownMultipleLines() {
        testBlockT.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockT.downOneLine();
        testBlockT.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 4), testBlockT.getAnchorPoint());
    }

    @Test
    void testMoveRight() {
        testBlockT.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockT.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 1, 2), testBlockT.getAnchorPoint());
    }

    @Test
    void testMoveRightMultiple() {
        testBlockT.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockT.moveRight();
        testBlockT.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 2, 2), testBlockT.getAnchorPoint());
    }

    @Test
    void testMoveLeft() {
        testBlockT.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockT.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 1, 2), testBlockT.getAnchorPoint());
    }

    @Test
    void testMoveLeftMultiple() {
        testBlockT.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockT.moveLeft();
        testBlockT.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 2, 2), testBlockT.getAnchorPoint());
    }

    @Test
    void testRotateLeftOnceWithLoopback() {
        testBlockT.rotateLeft();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateLeftTwice() {
        testBlockT.rotateLeft();
        testBlockT.rotateLeft();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateLeftThrice() {
        testBlockT.rotateLeft();
        testBlockT.rotateLeft();
        testBlockT.rotateLeft();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateLeftFourTimes() {
        testBlockT.rotateLeft();
        testBlockT.rotateLeft();
        testBlockT.rotateLeft();
        testBlockT.rotateLeft();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }

    @Test
    void testRotateRightOnce() {
        testBlockT.rotateRight();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateRightTwice() {
        testBlockT.rotateRight();
        testBlockT.rotateRight();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateRightThrice() {
        testBlockT.rotateRight();
        testBlockT.rotateRight();
        testBlockT.rotateRight();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateRightFourTimesLoopback() {
        testBlockT.rotateRight();
        testBlockT.rotateRight();
        testBlockT.rotateRight();
        testBlockT.rotateRight();
        int rotState = testBlockT.getRotationState();
        Point[] orienState = testBlockT.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }
}
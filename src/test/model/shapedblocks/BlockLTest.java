package model.shapedblocks;

import model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

// Test class for the BlockL class.
class BlockLTest {

    private Block testBlockL;
    private static final Point[][] CORRECT_COORD_STATES = new Point [][] {
            {new Point(1, -1), new Point(0, -1), new Point(0, 0), new Point(0, 1)},
            {new Point(-1, -1), new Point(-1, 0), new Point(0, 0), new Point(1, 0)},
            {new Point(-1, 1), new Point(0, 1), new Point(0, 0), new Point(0, -1)},
            {new Point(1, 1), new Point(0, 0), new Point(1, 0), new Point(-1, 0)}};
    private static final Color BLOCK_L_COLOR = new Color(255, 127, 0);
    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    @BeforeEach
    public void runBefore() {
        testBlockL = new BlockL();
    }

    @Test
    void testConstructor() {
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES, testBlockL.getCoordStates()));
        assertEquals(BLOCK_L_COLOR, testBlockL.getColor());
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], testBlockL.getCoordStates()[0]));
        assertEquals(0, testBlockL.getRotationState());
        assertEquals("L", testBlockL.getBlockType());
    }

    @Test
    void testDownOneLine() {
        testBlockL.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockL.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 3), testBlockL.getAnchorPoint());
    }

    @Test
    void testDownMultipleLines() {
        testBlockL.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockL.downOneLine();
        testBlockL.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 4), testBlockL.getAnchorPoint());
    }

    @Test
    void testMoveRight() {
        testBlockL.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockL.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 1, 2), testBlockL.getAnchorPoint());
    }

    @Test
    void testMoveRightMultiple() {
        testBlockL.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockL.moveRight();
        testBlockL.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 2, 2), testBlockL.getAnchorPoint());
    }

    @Test
    void testMoveLeft() {
        testBlockL.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockL.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 1, 2), testBlockL.getAnchorPoint());
    }

    @Test
    void testMoveLeftMultiple() {
        testBlockL.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockL.moveLeft();
        testBlockL.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 2, 2), testBlockL.getAnchorPoint());
    }

    @Test
    void testRotateLeftOnceWithLoopback() {
        testBlockL.rotateLeft();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateLeftTwice() {
        testBlockL.rotateLeft();
        testBlockL.rotateLeft();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateLeftThrice() {
        testBlockL.rotateLeft();
        testBlockL.rotateLeft();
        testBlockL.rotateLeft();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateLeftFourTimes() {
        testBlockL.rotateLeft();
        testBlockL.rotateLeft();
        testBlockL.rotateLeft();
        testBlockL.rotateLeft();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }

    @Test
    void testRotateRightOnce() {
        testBlockL.rotateRight();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateRightTwice() {
        testBlockL.rotateRight();
        testBlockL.rotateRight();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateRightThrice() {
        testBlockL.rotateRight();
        testBlockL.rotateRight();
        testBlockL.rotateRight();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateRightFourTimesLoopback() {
        testBlockL.rotateRight();
        testBlockL.rotateRight();
        testBlockL.rotateRight();
        testBlockL.rotateRight();
        int rotState = testBlockL.getRotationState();
        Point[] orienState = testBlockL.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }
}
package model.shapedblocks;

import model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

// Test class for the BlockJ class.
class BlockJTest {

    private Block testBlockJ;
    private static final Point[][] CORRECT_COORD_STATES = new Point [][] {
            {new Point(-1,-1), new Point(0,-1), new Point(0,0), new Point(0,1)},
            {new Point(-1,1), new Point(-1,0), new Point(0,0), new Point(1,0)},
            {new Point(1,1), new Point(0,1), new Point(0,0), new Point(0,-1)},
            {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(1,-1)}};
    private static final Color BLOCK_J_COLOR = new Color(0, 0, 255);
    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    @BeforeEach
    public void runBefore() {
        testBlockJ = new BlockJ();
    }

    @Test
    void testConstructor() {
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES, testBlockJ.getCoordStates()));
        assertEquals(BLOCK_J_COLOR, testBlockJ.getColor());
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], testBlockJ.getCoordStates()[0]));
        assertEquals(0, testBlockJ.getRotationState());
    }

    @Test
    void testDownOneLine() {
        testBlockJ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockJ.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 3), testBlockJ.getAnchorPoint());
    }

    @Test
    void testDownMultipleLines() {
        testBlockJ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockJ.downOneLine();
        testBlockJ.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 4), testBlockJ.getAnchorPoint());
    }

    @Test
    void testMoveRight() {
        testBlockJ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockJ.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 1, 2), testBlockJ.getAnchorPoint());
    }

    @Test
    void testMoveRightMultiple() {
        testBlockJ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockJ.moveRight();
        testBlockJ.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 2, 2), testBlockJ.getAnchorPoint());
    }

    @Test
    void testMoveLeft() {
        testBlockJ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockJ.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 1, 2), testBlockJ.getAnchorPoint());
    }

    @Test
    void testMoveLeftMultiple() {
        testBlockJ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockJ.moveLeft();
        testBlockJ.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 2, 2), testBlockJ.getAnchorPoint());
    }

    @Test
    void testRotateLeftOnceWithLoopback() {
        testBlockJ.rotateLeft();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateLeftTwice() {
        testBlockJ.rotateLeft();
        testBlockJ.rotateLeft();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateLeftThrice() {
        testBlockJ.rotateLeft();
        testBlockJ.rotateLeft();
        testBlockJ.rotateLeft();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateLeftFourTimes() {
        testBlockJ.rotateLeft();
        testBlockJ.rotateLeft();
        testBlockJ.rotateLeft();
        testBlockJ.rotateLeft();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }

    @Test
    void testRotateRightOnce() {
        testBlockJ.rotateRight();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateRightTwice() {
        testBlockJ.rotateRight();
        testBlockJ.rotateRight();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateRightThrice() {
        testBlockJ.rotateRight();
        testBlockJ.rotateRight();
        testBlockJ.rotateRight();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateRightFourTimesLoopback() {
        testBlockJ.rotateRight();
        testBlockJ.rotateRight();
        testBlockJ.rotateRight();
        testBlockJ.rotateRight();
        int rotState = testBlockJ.getRotationState();
        Point[] orienState = testBlockJ.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }
}
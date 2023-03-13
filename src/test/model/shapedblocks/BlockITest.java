package model.shapedblocks;

import model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

// Test class for the BlockI class.
class BlockITest {

    private Block testBlockI;
    private static final Point[][] CORRECT_COORD_STATES = new Point [][] {
            {new Point(0,-1), new Point(0,0), new Point(0,1), new Point(0,2)},
            {new Point(-1,0), new Point(0,0), new Point(1,0), new Point(2,0)},
            {new Point(0,-2), new Point(0,-1), new Point(0,0), new Point(0,1)},
            {new Point(-2,0), new Point(-1,0), new Point(0,0), new Point(1,0)}};
    private static final Color BLOCK_I_COLOR = new Color(0, 255, 255);
    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    @BeforeEach
    public void runBefore() {
        testBlockI = new BlockI();
    }

    @Test
    void testConstructor() {
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES, testBlockI.getCoordStates()));
        assertEquals(BLOCK_I_COLOR, testBlockI.getColor());
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], testBlockI.getCoordStates()[0]));
        assertEquals(0, testBlockI.getRotationState());
    }

    @Test
    void testDownOneLine() {
        testBlockI.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockI.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 3),testBlockI.getAnchorPoint());
    }

    @Test
    void testDownMultipleLines() {
        testBlockI.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockI.downOneLine();
        testBlockI.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 4),testBlockI.getAnchorPoint());
    }

    @Test
    void testMoveRight() {
        testBlockI.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockI.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 1, 2),testBlockI.getAnchorPoint());
    }

    @Test
    void testMoveRightMultiple() {
        testBlockI.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockI.moveRight();
        testBlockI.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 2, 2),testBlockI.getAnchorPoint());
    }

    @Test
    void testMoveLeft() {
        testBlockI.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockI.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 1, 2),testBlockI.getAnchorPoint());
    }

    @Test
    void testMoveLeftMultiple() {
        testBlockI.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockI.moveLeft();
        testBlockI.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 2, 2),testBlockI.getAnchorPoint());
    }

    @Test
    void testRotateLeftOnceWithLoopback() {
        testBlockI.rotateLeft();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateLeftTwice() {
        testBlockI.rotateLeft();
        testBlockI.rotateLeft();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateLeftThrice() {
        testBlockI.rotateLeft();
        testBlockI.rotateLeft();
        testBlockI.rotateLeft();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateLeftFourTimes() {
        testBlockI.rotateLeft();
        testBlockI.rotateLeft();
        testBlockI.rotateLeft();
        testBlockI.rotateLeft();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }

    @Test
    void testRotateRightOnce() {
        testBlockI.rotateRight();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateRightTwice() {
        testBlockI.rotateRight();
        testBlockI.rotateRight();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateRightThrice() {
        testBlockI.rotateRight();
        testBlockI.rotateRight();
        testBlockI.rotateRight();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateRightFourTimesLoopback() {
        testBlockI.rotateRight();
        testBlockI.rotateRight();
        testBlockI.rotateRight();
        testBlockI.rotateRight();
        int rotState = testBlockI.getRotationState();
        Point[] orienState = testBlockI.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }
}
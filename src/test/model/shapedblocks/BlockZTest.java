package model.shapedblocks;

import model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BlockZTest {

    private Block testBlockZ;
    private static final Point[][] CORRECT_COORD_STATES = new Point [][] {
            {new Point(0,-1), new Point(0,0), new Point(1,0), new Point(1,1)},
            {new Point(1,-1), new Point(0,-1), new Point(0,0), new Point(-1,0)},
            {new Point(0,-1), new Point(0,0), new Point(-1,0), new Point(-1,-1)},
            {new Point(-1,1), new Point(0,1), new Point(0,0), new Point(1,0)}};
    private static final Color BLOCK_Z_COLOR = new Color(255, 0, 0);
    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    @BeforeEach
    public void runBefore() {
        testBlockZ = new BlockZ();
    }

    @Test
    void testConstructor() {
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES, testBlockZ.getCoordStates()));
        assertEquals(BLOCK_Z_COLOR, testBlockZ.getColor());
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], testBlockZ.getCoordStates()[0]));
        assertEquals(0, testBlockZ.getRotationState());
    }

    @Test
    void testDownOneLine() {
        testBlockZ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockZ.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 3), testBlockZ.getAnchorPoint());
    }

    @Test
    void testDownMultipleLines() {
        testBlockZ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockZ.downOneLine();
        testBlockZ.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 4), testBlockZ.getAnchorPoint());
    }

    @Test
    void testMoveRight() {
        testBlockZ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockZ.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 1, 2), testBlockZ.getAnchorPoint());
    }

    @Test
    void testMoveRightMultiple() {
        testBlockZ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockZ.moveRight();
        testBlockZ.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 2, 2), testBlockZ.getAnchorPoint());
    }

    @Test
    void testMoveLeft() {
        testBlockZ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockZ.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 1, 2), testBlockZ.getAnchorPoint());
    }

    @Test
    void testMoveLeftMultiple() {
        testBlockZ.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockZ.moveLeft();
        testBlockZ.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 2, 2), testBlockZ.getAnchorPoint());
    }

    @Test
    void testRotateLeftOnceWithLoopback() {
        testBlockZ.rotateLeft();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateLeftTwice() {
        testBlockZ.rotateLeft();
        testBlockZ.rotateLeft();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateLeftThrice() {
        testBlockZ.rotateLeft();
        testBlockZ.rotateLeft();
        testBlockZ.rotateLeft();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateLeftFourTimes() {
        testBlockZ.rotateLeft();
        testBlockZ.rotateLeft();
        testBlockZ.rotateLeft();
        testBlockZ.rotateLeft();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }

    @Test
    void testRotateRightOnce() {
        testBlockZ.rotateRight();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateRightTwice() {
        testBlockZ.rotateRight();
        testBlockZ.rotateRight();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateRightThrice() {
        testBlockZ.rotateRight();
        testBlockZ.rotateRight();
        testBlockZ.rotateRight();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateRightFourTimesLoopback() {
        testBlockZ.rotateRight();
        testBlockZ.rotateRight();
        testBlockZ.rotateRight();
        testBlockZ.rotateRight();
        int rotState = testBlockZ.getRotationState();
        Point[] orienState = testBlockZ.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }
}
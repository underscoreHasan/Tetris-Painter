package model.shapedblocks;

import model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BlockSTest {

    private Block testBlockS;
    private static final Point[][] CORRECT_COORD_STATES = new Point [][] {
            {new Point(0,-1), new Point(0,0), new Point(-1,0), new Point(-1,1)},
            {new Point(-1,0), new Point(0,0), new Point(0,1), new Point(1,1)},
            {new Point(1,-1), new Point(1,0), new Point(0,0), new Point(0,1)},
            {new Point(-1,-1), new Point(0,-1), new Point(0,0), new Point(1,0)}};
    private static final Color BLOCK_S_COLOR = new Color(0, 255, 0);
    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    @BeforeEach
    public void runBefore() {
        testBlockS = new BlockS();
    }

    @Test
    void testConstructor() {
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES, testBlockS.getCoordStates()));
        assertEquals(BLOCK_S_COLOR, testBlockS.getColor());
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], testBlockS.getCoordStates()[0]));
        assertEquals(0, testBlockS.getRotationState());
    }

    @Test
    void testDownOneLine() {
        testBlockS.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockS.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 3),testBlockS.getAnchorPoint());
    }

    @Test
    void testDownMultipleLines() {
        testBlockS.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockS.downOneLine();
        testBlockS.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 4),testBlockS.getAnchorPoint());
    }

    @Test
    void testMoveRight() {
        testBlockS.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockS.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 1, 2),testBlockS.getAnchorPoint());
    }

    @Test
    void testMoveRightMultiple() {
        testBlockS.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockS.moveRight();
        testBlockS.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 2, 2),testBlockS.getAnchorPoint());
    }

    @Test
    void testMoveLeft() {
        testBlockS.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockS.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 1, 2),testBlockS.getAnchorPoint());
    }

    @Test
    void testMoveLeftMultiple() {
        testBlockS.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockS.moveLeft();
        testBlockS.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 2, 2),testBlockS.getAnchorPoint());
    }

    @Test
    void testRotateLeftOnceWithLoopback() {
        testBlockS.rotateLeft();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateLeftTwice() {
        testBlockS.rotateLeft();
        testBlockS.rotateLeft();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateLeftThrice() {
        testBlockS.rotateLeft();
        testBlockS.rotateLeft();
        testBlockS.rotateLeft();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateLeftFourTimes() {
        testBlockS.rotateLeft();
        testBlockS.rotateLeft();
        testBlockS.rotateLeft();
        testBlockS.rotateLeft();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }

    @Test
    void testRotateRightOnce() {
        testBlockS.rotateRight();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateRightTwice() {
        testBlockS.rotateRight();
        testBlockS.rotateRight();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateRightThrice() {
        testBlockS.rotateRight();
        testBlockS.rotateRight();
        testBlockS.rotateRight();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateRightFourTimesLoopback() {
        testBlockS.rotateRight();
        testBlockS.rotateRight();
        testBlockS.rotateRight();
        testBlockS.rotateRight();
        int rotState = testBlockS.getRotationState();
        Point[] orienState = testBlockS.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }
}
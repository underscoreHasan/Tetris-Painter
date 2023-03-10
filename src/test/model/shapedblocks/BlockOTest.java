package model.shapedblocks;

import model.Block;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BlockOTest {

    private Block testBlockO;
    private static final Point[][] CORRECT_COORD_STATES = new Point [][] {
            {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
            {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
            {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)},
            {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)}};
    private static final Color BLOCK_O_COLOR = new Color(255, 255, 0);
    private static final int BOARD_HEIGHT = 20;
    private static final int BOARD_WIDTH = 10;

    @BeforeEach
    public void runBefore() {
        testBlockO = new BlockO();
    }

    @Test
    void testConstructor() {
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES, testBlockO.getCoordStates()));
        assertEquals(BLOCK_O_COLOR, testBlockO.getColor());
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], testBlockO.getCoordStates()[0]));
        assertEquals(0, testBlockO.getRotationState());
    }

    @Test
    void testDownOneLine() {
        testBlockO.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockO.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 3), testBlockO.getAnchorPoint());
    }

    @Test
    void testDownMultipleLines() {
        testBlockO.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockO.downOneLine();
        testBlockO.downOneLine();
        assertEquals(new Point(BOARD_WIDTH / 2, 4), testBlockO.getAnchorPoint());
    }

    @Test
    void testMoveRight() {
        testBlockO.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockO.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 1, 2), testBlockO.getAnchorPoint());
    }

    @Test
    void testMoveRightMultiple() {
        testBlockO.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockO.moveRight();
        testBlockO.moveRight();
        assertEquals(new Point(BOARD_WIDTH / 2 + 2, 2), testBlockO.getAnchorPoint());
    }

    @Test
    void testMoveLeft() {
        testBlockO.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockO.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 1, 2), testBlockO.getAnchorPoint());
    }

    @Test
    void testMoveLeftMultiple() {
        testBlockO.setAnchorPoint(BOARD_WIDTH / 2, 2);
        testBlockO.moveLeft();
        testBlockO.moveLeft();
        assertEquals(new Point(BOARD_WIDTH / 2 - 2, 2), testBlockO.getAnchorPoint());
    }

    @Test
    void testRotateLeftOnceWithLoopback() {
        testBlockO.rotateLeft();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateLeftTwice() {
        testBlockO.rotateLeft();
        testBlockO.rotateLeft();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateLeftThrice() {
        testBlockO.rotateLeft();
        testBlockO.rotateLeft();
        testBlockO.rotateLeft();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateLeftFourTimes() {
        testBlockO.rotateLeft();
        testBlockO.rotateLeft();
        testBlockO.rotateLeft();
        testBlockO.rotateLeft();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }

    @Test
    void testRotateRightOnce() {
        testBlockO.rotateRight();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(1, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[1], orienState));
    }

    @Test
    void testRotateRightTwice() {
        testBlockO.rotateRight();
        testBlockO.rotateRight();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(2, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[2], orienState));
    }

    @Test
    void testRotateRightThrice() {
        testBlockO.rotateRight();
        testBlockO.rotateRight();
        testBlockO.rotateRight();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(3, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[3], orienState));
    }

    @Test
    void testRotateRightFourTimesLoopback() {
        testBlockO.rotateRight();
        testBlockO.rotateRight();
        testBlockO.rotateRight();
        testBlockO.rotateRight();
        int rotState = testBlockO.getRotationState();
        Point[] orienState = testBlockO.getOrientation();

        assertEquals(0, rotState);
        assertTrue(Arrays.deepEquals(CORRECT_COORD_STATES[0], orienState));
    }
}
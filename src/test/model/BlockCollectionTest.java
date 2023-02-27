package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockCollectionTest {
    private BlockCollection testCollection;

    @BeforeEach
    public void runBefore() {testCollection = new BlockCollection();}

    @Test
    public void testConstructor() {
        assertTrue(testCollection.getBlockList().isEmpty());
        assertTrue(testCollection.getPointList().isEmpty());
    }
}
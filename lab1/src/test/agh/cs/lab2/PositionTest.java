package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    Position positionToTest = new Position(5, 3);
    Position positionToTest2 = new Position(1, 0);

    @Test
    public void testToString() {
        assertEquals("(5,3)", positionToTest.toString());
    }

    @Test
    public void testSmaller() {
        assertFalse(positionToTest.smaller(positionToTest2));
        assertTrue(positionToTest2.smaller(positionToTest));
        assertTrue(positionToTest2.smaller(positionToTest2));
    }

    @Test
    public void testLarger() {
        assertFalse(positionToTest2.larger(positionToTest));
        assertTrue(positionToTest2.larger(positionToTest2));
        assertTrue(positionToTest.larger(positionToTest2));
    }

    @Test
    public void testUpperRight() {
        assertEquals(new Position(5, 3), new Position(5, -1).upperRight(new Position(5, 3)));
        assertEquals(new Position(5, 3), positionToTest.upperRight(positionToTest2));
    }

    @Test
    public void testLowerLeft() {
        assertEquals(new Position(5, -1), new Position(5, -1).lowerLeft(new Position(5, 3)));
        assertEquals(new Position(-7, -1), new Position(-7, 1).lowerLeft(new Position(5, -1)));
    }

    @Test
    public void testAdd() {
        assertEquals(new Position(0, 0), new Position(0, -1).add(new Position(0, 1)));
        assertEquals(new Position(10, 2), new Position(5, -1).add(new Position(5, 3)));
        assertEquals(new Position(-10, 10), new Position(-5, 7).add(new Position(-5, 3)));
    }
}
package agh.cs.lab2;

import agh.cs.lab2.maps.MapDirection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangularMapDirectionTest {
    @Test
    public void testNext() {
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
    }

    @Test
    public void testPrevious() {
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
    }
}

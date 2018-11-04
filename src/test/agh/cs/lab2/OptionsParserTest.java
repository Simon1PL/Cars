package agh.cs.lab2;

import org.junit.Test;

import static agh.cs.lab2.MoveDirection.*;
import static agh.cs.lab2.mapElements.OptionsParser.*;
import static org.junit.Assert.assertEquals;

public class OptionsParserTest {
    @Test
    public void testSmaller() {
        assertEquals(parse(new String[]{"f", "forward", "Backward", "kot", "L", "mlik"}), new MoveDirection[]{FORWARD, FORWARD, BACKWARD, LEFT});
    }
}

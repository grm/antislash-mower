package sh.antisla.grm.automower.models.mower;

import org.junit.Test;
import sh.antisla.grm.automower.models.exceptions.UnknownInstructionException;

import static org.junit.Assert.*;

public class MowerCardinalityTest {

    @Test
    public void testRotate() throws UnknownInstructionException {
        assertEquals(MowerCardinality.E, MowerCardinality.rotate(MowerCardinality.N, 'D'));
        assertEquals(MowerCardinality.S, MowerCardinality.rotate(MowerCardinality.E, 'D'));
        assertEquals(MowerCardinality.W, MowerCardinality.rotate(MowerCardinality.S, 'D'));
        assertEquals(MowerCardinality.N, MowerCardinality.rotate(MowerCardinality.W, 'D'));

        assertEquals(MowerCardinality.W, MowerCardinality.rotate(MowerCardinality.N, 'G'));
        assertEquals(MowerCardinality.S, MowerCardinality.rotate(MowerCardinality.W, 'G'));
        assertEquals(MowerCardinality.E, MowerCardinality.rotate(MowerCardinality.S, 'G'));
        assertEquals(MowerCardinality.N, MowerCardinality.rotate(MowerCardinality.E, 'G'));
    }

    @Test
    public void testRotateWithUnkownInstruction(){
        try {
            MowerCardinality.rotate(MowerCardinality.N, 'F');
            fail("Should not be here !");
        } catch (UnknownInstructionException ex) {
            assertTrue(true);
        }
    }
}
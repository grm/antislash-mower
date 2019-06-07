package sh.antisla.grm.automower.models;

import org.junit.Before;
import org.junit.Test;
import sh.antisla.grm.automower.models.exceptions.NoMoreInstructionsException;
import sh.antisla.grm.automower.models.mower.MowerCardinality;
import sh.antisla.grm.automower.models.mower.MowerPosition;

import static org.junit.Assert.*;

public class MowerTest {

    MowerPosition position;
    Mower mower1;
    Mower mower2;

    @Before
    public void setUpCommonValues() {
        this.position = new MowerPosition(0, 0, MowerCardinality.N);
        this.mower1 = new Mower(position, "GAGAGAGAA", new Garden(5, 5));
    }

    @Test
    public void testGettersFromConstructor() {
        assertEquals(mower1.getPosition(), position);
    }

    @Test
    public void testSetters() {
        final MowerPosition position2 = new MowerPosition(1, 1, MowerCardinality.S);
        assertEquals(mower1.getPosition(), position);
        assertNotEquals(mower1.getPosition(), position2);
        mower1.setPosition(position2);
        assertNotEquals(mower1.getPosition(), position);
        assertEquals(mower1.getPosition(), position2);
    }

    @Test
    public void testgetNextMove() throws NoMoreInstructionsException{
        assertEquals(mower1.getNextInstruction(), 'G');
        assertEquals(mower1.getNextInstruction(), 'A');
        assertEquals(mower1.getNextInstruction(), 'G');
        assertEquals(mower1.getNextInstruction(), 'A');
        assertEquals(mower1.getNextInstruction(), 'G');
        assertEquals(mower1.getNextInstruction(), 'A');
        assertEquals(mower1.getNextInstruction(), 'G');
        assertEquals(mower1.getNextInstruction(), 'A');
        assertEquals(mower1.getNextInstruction(), 'A');
    }

    @Test
    public void testgetNextMoveNoMoreInstructions() throws NoMoreInstructionsException{
        Mower mower = new Mower(new MowerPosition(0,0,MowerCardinality.N), "G", new Garden(5, 5));
        mower.getNextInstruction();
        try {
            mower.getNextInstruction();
            fail("NoMoreInstructionsException should have been thrown");
        } catch (NoMoreInstructionsException ex) {
            assert(true);
        }
    }

}
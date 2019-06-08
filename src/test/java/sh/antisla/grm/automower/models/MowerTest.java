package sh.antisla.grm.automower.models;

import org.junit.Before;
import org.junit.Test;
import sh.antisla.grm.automower.models.exceptions.UnknownInstructionException;
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
        assertEquals(position, mower1.getPosition());
    }

    @Test
    public void testSetters() {
        final MowerPosition position2 = new MowerPosition(1, 1, MowerCardinality.S);
        assertEquals(position, mower1.getPosition());
        assertNotEquals(position2, mower1.getPosition());
        mower1.setPosition(position2);
        assertNotEquals(position, mower1.getPosition());
        assertEquals(position2, mower1.getPosition());
    }

    @Test
    public void testMow() {
        Garden garden = new Garden(5, 5);
        MowerPosition position1 = new MowerPosition(1, 2, MowerCardinality.N);
        Mower mower1 = new Mower(position1, "GAGAGAGAA", garden);
        mower1.mow();

        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(3, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.N, mower1.getPosition().getOrientation());
    }

    @Test
    public void testMowWithUnkownInstructions() {
        Garden garden = new Garden(5, 5);
        MowerPosition position1 = new MowerPosition(1, 2, MowerCardinality.N);
        Mower mower1 = new Mower(position1, "GAGCAGFAGEAA", garden);
        mower1.mow();

        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(3, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.N, mower1.getPosition().getOrientation());
    }


    @Test
    public void testmoveToNextPosition() throws UnknownInstructionException {
        mower1.moveToNextPosition('A');
        assertEquals(0, mower1.getPosition().getPositionX());
        assertEquals(1, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.N, mower1.getPosition().getOrientation());
        mower1.moveToNextPosition('D');
        assertEquals(0, mower1.getPosition().getPositionX());
        assertEquals(1, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.E, mower1.getPosition().getOrientation());
        mower1.moveToNextPosition('A');
        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(1, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.E, mower1.getPosition().getOrientation());
        mower1.moveToNextPosition('G');
        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(1, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.N, mower1.getPosition().getOrientation());
        mower1.moveToNextPosition('A');
        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(2, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.N, mower1.getPosition().getOrientation());
    }

    @Test
    public void testmoveToNextPositioWithUnkonwnInstruction() throws UnknownInstructionException {
        try {
            mower1.moveToNextPosition('F');
            fail("Should not be here");
        } catch (UnknownInstructionException ex) {
            assertTrue(true);
        }
    }

    @Test
    public void testToString(){
        assertTrue(
                mower1.toString().matches("Mower\\{position=sh.antisla.grm.automower.models.mower.MowerPosition@.*, mowingPlanning=\\[G, A, G, A, G, A, G, A, A\\], garden=Garden\\{xAxisLength=5, yAxisLength=5\\}\\}")
        );
    }
}
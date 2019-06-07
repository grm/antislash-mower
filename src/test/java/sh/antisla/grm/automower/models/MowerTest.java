package sh.antisla.grm.automower.models;

import org.junit.Before;
import org.junit.Test;
import sh.antisla.grm.automower.models.mower.MowerCardinality;
import sh.antisla.grm.automower.models.mower.MowerPosition;

import static org.junit.Assert.*;

public class MowerTest {

    MowerPosition position;
    Mower mower;

    @Before
    public void setUpCommonValues() {
        this.position = new MowerPosition(0, 0, MowerCardinality.N);
        this.mower = new Mower(position, "GAGAGAGAA");
    }

    @Test
    public void testGettersFromConstructor() {
        assertEquals(mower.getPosition(), position);
    }

    @Test
    public void testSetters() {
        final MowerPosition position2 = new MowerPosition(1, 1, MowerCardinality.S);
        assertEquals(mower.getPosition(), position);
        assertNotEquals(mower.getPosition(), position2);
        mower.setPosition(position2);
        assertNotEquals(mower.getPosition(), position);
        assertEquals(mower.getPosition(), position2);
    }

}
package sh.antisla.grm.automower.models;

import org.junit.Before;
import org.junit.Test;
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
        this.mower1 = new Mower(position, "GAGAGAGAA");
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
    public void testEquals() {
        Mower mower2 = new Mower(position, "GAGAGAGAA");
        Mower mowerPositionNotEquals = new Mower(new MowerPosition(1, 1, MowerCardinality.S), "GAGAGAGAA");
        Mower mowerScheduleNotEquals = new Mower(position, "GAGAGAGAAG");

        assertEquals(mower1, mower1);
        assertEquals(mower1, mower2);
        assertNotEquals(mower1, null);
        assertNotEquals(mower1, mowerPositionNotEquals);
        assertNotEquals(mower1, mowerScheduleNotEquals);
    }

    @Test
    public void testHashcode() {
        Mower mower2 = new Mower(position, "GAGAGAGAA");
        assertEquals(mower1.hashCode(), mower2.hashCode());
//        assertNotEquals(position1.hashCode(), positionDifferentX.hashCode());
//        assertNotEquals(position1.hashCode(), positionDifferentY.hashCode());
//        assertNotEquals(position1.hashCode(), positionDifferentOrientation.hashCode());
    }


}
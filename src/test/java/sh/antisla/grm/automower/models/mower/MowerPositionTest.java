package sh.antisla.grm.automower.models.mower;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MowerPositionTest {

    MowerPosition position1;
    MowerPosition position2;
    MowerPosition positionDifferentX;
    MowerPosition positionDifferentY;
    MowerPosition positionDifferentOrientation;

    @Before
    public void setUpCommonValues() {
        this.position1 = new MowerPosition(0, 0, MowerCardinality.N);
        this.position2 = new MowerPosition(0, 0, MowerCardinality.N);
        this.positionDifferentX = new MowerPosition(1, 0, MowerCardinality.N);
        this.positionDifferentY = new MowerPosition(0, 1, MowerCardinality.N);
        this.positionDifferentOrientation = new MowerPosition(0, 0, MowerCardinality.S);
    }

    @Test
    public void testGettersFromConstructor() {
        assertNotEquals(1, position1.getPositionX());
        assertNotEquals(1, position1.getPositionY());
        assertNotEquals(MowerCardinality.S, position1.getOrientation());

        assertEquals(0, position1.getPositionX());
        assertEquals(0, position1.getPositionY());
        assertEquals(MowerCardinality.N, position1.getOrientation());
    }

    @Test
    public void testSetters() {
        assertEquals(0, position1.getPositionX(), 0);
        assertEquals(0, position1.getPositionY(), 0);
        assertEquals(MowerCardinality.N, position1.getOrientation());

        position1.setPositionX(1);
        position1.setPositionY(1);
        position1.setOrientation(MowerCardinality.S);

        assertEquals(1, position1.getPositionX());
        assertEquals(1, position1.getPositionY());
        assertEquals(MowerCardinality.S, position1.getOrientation());
    }

    @Test
    public void testEquals() {
        assertEquals(position1, position1);
        assertEquals(position1, position2);
        assertNotEquals(position1, null);
        assertNotEquals(position1, new Object());
        assertNotEquals(position1, positionDifferentX);
        assertNotEquals(position1, positionDifferentY);
        assertNotEquals(position1, positionDifferentOrientation);
    }

    @Test
    public void testHashcode() {
        assertEquals(position1.hashCode(), position2.hashCode());
        assertNotEquals(position1.hashCode(), positionDifferentX.hashCode());
        assertNotEquals(position1.hashCode(), positionDifferentY.hashCode());
        assertNotEquals(position1.hashCode(), positionDifferentOrientation.hashCode());
    }

}
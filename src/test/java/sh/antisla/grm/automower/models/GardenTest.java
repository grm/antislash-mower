package sh.antisla.grm.automower.models;

import org.junit.Before;
import org.junit.Test;
import sh.antisla.grm.automower.models.mower.MowerCardinality;
import sh.antisla.grm.automower.models.mower.MowerPosition;

import static org.junit.Assert.*;

public class GardenTest {

    Garden garden1;
    Mower mower1;

    @Before
    public void setUpCommonValues() {
        this.garden1 = new Garden(5, 5);
        MowerPosition position = new MowerPosition(0, 0, MowerCardinality.N);
        this.mower1 = new Mower(position, "GAGAGAGAA");
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(garden1.getxAxisLength(), 5);
        assertEquals(garden1.getyAxisLength(), 5);
    }

    @Test
    public void testSetters() {
        assertNotEquals(garden1.getxAxisLength(), 6);
        assertNotEquals(garden1.getyAxisLength(), 6);
        garden1.setxAxisLength(6);
        garden1.setyAxisLength(6);
        assertEquals(garden1.getxAxisLength(), 6);
        assertEquals(garden1.getyAxisLength(), 6);
    }

    @Test
    public void testAddMower() {
        assertEquals(garden1.getMowers().size(), 0);
        garden1.addMower(this.mower1);
        assertEquals(garden1.getMowers().size(), 1);
    }
}
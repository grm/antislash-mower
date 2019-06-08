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
        this.mower1 = new Mower(position, "GAGAGAGAA", this.garden1);
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(5, garden1.getxAxisLength());
        assertEquals(5, garden1.getyAxisLength());
    }

    @Test
    public void testSetters() {
        assertNotEquals(6, garden1.getxAxisLength());
        assertNotEquals(6, garden1.getyAxisLength());
        garden1.setxAxisLength(6);
        garden1.setyAxisLength(6);
        assertEquals(6, garden1.getxAxisLength());
        assertEquals(6, garden1.getyAxisLength());
    }

    @Test
    public void testAddMower() {
        assertEquals(0, garden1.getMowers().size());
        garden1.addMower(this.mower1);
        assertEquals(1, garden1.getMowers().size());
    }

    @Test
    public void testAddMowerToSameLocation() {
        assertEquals(0, garden1.getMowers().size());
        garden1.addMower(this.mower1);
        MowerPosition position = new MowerPosition(0, 0, MowerCardinality.N);
        Mower mower2 = new Mower(position, "GAGAGAGAA", this.garden1);
        garden1.addMower(mower2);
        assertEquals(1, garden1.getMowers().size());
    }

    @Test
    public void mowItNow(){
        Garden garden = new Garden(5, 5);
        MowerPosition position1 = new MowerPosition(1, 2, MowerCardinality.N);
        Mower mower1 = new Mower(position1, "GAGAGAGAA", garden);
        MowerPosition position2 = new MowerPosition(3, 3, MowerCardinality.E);
        Mower mower2 = new Mower(position2, "AADAADADDA", garden);
        garden.addMower(mower1);
        garden.addMower(mower2);
        garden.mowItNow();

        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(3, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.N, mower1.getPosition().getOrientation());

        assertEquals(5, mower2.getPosition().getPositionX(), 5);
        assertEquals(1, mower2.getPosition().getPositionY(),  1);
        assertEquals(MowerCardinality.E, mower2.getPosition().getOrientation());

    }

    @Test
    public void mowItNowToLimit(){
        Garden garden = new Garden(1, 1);
        MowerPosition position1 = new MowerPosition(1, 1, MowerCardinality.N);
        MowerPosition position2 = new MowerPosition(0, 0, MowerCardinality.S);
        Mower mower1 = new Mower(position1, "AADAA", garden);
        Mower mower2 = new Mower(position2, "AADAA", garden);
        garden.addMower(mower1);
        garden.addMower(mower2);
        garden.mowItNow();

        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(1, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.E, mower1.getPosition().getOrientation());

        assertEquals(0, mower2.getPosition().getPositionX());
        assertEquals(0, mower2.getPosition().getPositionY());
        assertEquals(MowerCardinality.W, mower2.getPosition().getOrientation());
    }

    @Test
    public void mowItNowWithCollision() {
        Garden garden = new Garden(1, 1);
        MowerPosition position1 = new MowerPosition(1, 1, MowerCardinality.S);
        MowerPosition position2 = new MowerPosition(0, 0, MowerCardinality.E);
        Mower mower1 = new Mower(position1, "ADA", garden);
        Mower mower2 = new Mower(position2, "AGA", garden);
        garden.addMower(mower1);
        garden.addMower(mower2);
        garden.mowItNow();

        assertEquals(1, mower1.getPosition().getPositionX());
        assertEquals(0, mower1.getPosition().getPositionY());
        assertEquals(MowerCardinality.W, mower1.getPosition().getOrientation());

        assertEquals(0, mower2.getPosition().getPositionX());
        assertEquals(1, mower2.getPosition().getPositionY());
        assertEquals(MowerCardinality.N, mower2.getPosition().getOrientation());
    }
}
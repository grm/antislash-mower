package sh.antisla.grm.automower.models;

import java.util.Arrays;
import java.util.Objects;

import sh.antisla.grm.automower.models.exceptions.NoMoreInstructionsException;
import sh.antisla.grm.automower.models.mower.MowerPosition;

/**
 * Class to represent of mower in the garden.
 */
public class Mower {
    /**
     * The current position of the mower in the garden.
     */
    private MowerPosition position;
    /**
     * The mowing planning.
     */
    private char[] mowingPlanning;
    /**
     * The next mower instruction to execute.
     */
    private int nextInstruction = 0;

    /**
     * The garden where the mower is located.
     */
    private Garden garden;

    /**
     * Default constructor for a mower.
     * @param position The initial position of the mower in the garden.
     * @param mowingPlanning The mowing planning of the mower.
     * @param garden The garden where the mower is located.
     */
    public Mower(MowerPosition position, String mowingPlanning, Garden garden) {
        this.position = position;
        this.mowingPlanning = mowingPlanning.toCharArray();
        this.garden = garden;
    }

    /**
     * Returns the current position of the mower.
     * @return The position of the mower in the garden grid.
     */
    public MowerPosition getPosition() {
        return position;
    }

    /**
     * Defines the position of the mower in the garden.
     * @param position The position of the mower in the garden grid.
     */
    public void setPosition(MowerPosition position) {
        this.position = position;
    }

    /**
     * Returns the next instruction for the mower as a character.
     *
     * @return the character representing the next instuction for the mower.
     * @throws NoMoreInstructionsException when there are no instrucitons
     *  left to execute for the mower.
     */
    public char getNextInstruction() throws NoMoreInstructionsException{
        if (nextInstruction == mowingPlanning.length) {
            throw new NoMoreInstructionsException();
        }
        return mowingPlanning[nextInstruction++];
    }

    @Override
    public String toString() {
        return "Mower{"
                + "position=" + position
                + ", mowingPlanning=" + Arrays.toString(mowingPlanning)
                + ", nextInstruction=" + nextInstruction
                + ", garden=" + garden
                + '}';
    }
}

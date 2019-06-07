package sh.antisla.grm.automower.models;

import sh.antisla.grm.automower.models.mower.MowerPosition;

import java.util.Arrays;
import java.util.Objects;

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
     * Default constructor for a mower.
     * @param position The initial position of the mower in the garden.
     * @param mowingPlanning The mowing planning of the mower.
     */
    public Mower(MowerPosition position, String mowingPlanning) {
        this.position = position;
        this.mowingPlanning = mowingPlanning.toCharArray();
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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Mower mower = (Mower) other;
        return nextInstruction == mower.nextInstruction
                && position.equals(mower.position)
                && Arrays.equals(mowingPlanning, mower.mowingPlanning);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(position, nextInstruction);
        result = 31 * result + Arrays.hashCode(mowingPlanning);
        return result;
    }
}

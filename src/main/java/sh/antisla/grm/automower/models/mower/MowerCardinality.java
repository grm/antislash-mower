package sh.antisla.grm.automower.models.mower;

import sh.antisla.grm.automower.models.Mower;
import sh.antisla.grm.automower.models.exceptions.UnknownInstructionException;

/**
 * Enum used to represent the orientation of the mower during the mowing process.
 */
public enum MowerCardinality {
    /**
     * The North cardinality.
     */
    N,
    /**
     * The East cardinality.
     */
    E,
    /**
     * The West cardinality.
     */
    W,
    /**
     * The South cardinality.
     */
    S;

    /**
     * Calculate the rotation of the mower.
     *
     * @param current The current cardinalisty of the mower to rotate
     * @param rotation The rotation to do (can be 'D' for right and 'G' for left)
     * @return the new cardinality of the mower
     * @throws UnknownInstructionException If the instruction is not 'D' or 'G'
     */
    public static MowerCardinality rotate(final MowerCardinality current, final char rotation) throws UnknownInstructionException {
        switch(rotation) {
            case 'G':
                return MowerCardinality.rotateLeft(current);
            case 'D':
                return MowerCardinality.rotateRight(current);
            default:
                throw new UnknownInstructionException();
        }
    }

    /**
     * Rotate the mower to the right.
     * @param current The current orientation of the mower
     * @return The new Orientation
     */
    private static MowerCardinality rotateRight(final MowerCardinality current) throws UnknownInstructionException{
        switch (current) {
            case N:
                return MowerCardinality.E;
            case E:
                return MowerCardinality.S;
            case S:
                return MowerCardinality.W;
            case W:
            default:
                return MowerCardinality.N;
        }
    }

    /**
     * Rotate the mower to the left.
     * @param current The current orientation of the mower
     * @return The new Orientation
     */
    private static MowerCardinality rotateLeft(final MowerCardinality current) throws UnknownInstructionException{
        switch (current) {
            case N:
                return MowerCardinality.W;
            case W:
                return MowerCardinality.S;
            case S:
                return MowerCardinality.E;
            case E:
            default:
                return MowerCardinality.N;
        }
    }
}

package sh.antisla.grm.automower.models.mower;

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
    public static MowerCardinality rotate(MowerCardinality current, char rotation) throws UnknownInstructionException {
        switch(rotation) {
            case 'G':
                if (current.equals(MowerCardinality.N)) {
                    return MowerCardinality.W;
                } else if (current.equals(MowerCardinality.W)) {
                    return MowerCardinality.S;
                } else if (current.equals(MowerCardinality.S)) {
                    return MowerCardinality.E;
                } else {
                    return MowerCardinality.N;
                }
            case 'D':
                if (current.equals(MowerCardinality.N)) {
                    return MowerCardinality.E;
                } else if (current.equals(MowerCardinality.E)) {
                    return MowerCardinality.S;
                } else if (current.equals(MowerCardinality.S)) {
                    return MowerCardinality.W;
                } else {
                    return MowerCardinality.N;
                }
            default:
                throw new UnknownInstructionException();
        }
    }
}

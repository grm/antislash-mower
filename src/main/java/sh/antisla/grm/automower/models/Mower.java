package sh.antisla.grm.automower.models;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sh.antisla.grm.automower.models.exceptions.UnknownInstructionException;
import sh.antisla.grm.automower.models.mower.MowerCardinality;
import sh.antisla.grm.automower.models.mower.MowerPosition;

/**
 * Class to represent of mower in the garden.
 */
public class Mower {

    private static final Logger logger = LoggerFactory.getLogger(Mower.class);

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
     * Launches the mower.
     */
    public void mow() {
        while (nextInstruction < mowingPlanning.length){
            try {
                this.moveToNextPosition(mowingPlanning[nextInstruction++]);
            } catch (UnknownInstructionException ex) {
                logger.info("Unknown instruction : " + mowingPlanning[nextInstruction]);
            }
        }
        logger.info("Mower has finished : "
                + position.getPositionX() + " "
                + position.getPositionY() + " "
                + position.getOrientation());
    }

    /**
     * Move the mower to the next position.
     *
     * @param movement the instruction to be applied to the mower
     * @throws UnknownInstructionException if the instruction is unknown. It can be 'G', 'D' or 'A'.
     */
    public void moveToNextPosition(char movement) throws UnknownInstructionException {
        switch(movement) {
            case 'G':
            case 'D':
                MowerCardinality newOrientation = MowerCardinality.rotate(this.getPosition().getOrientation(), movement);
                logger.debug("Rotating mower : {} -> {}", this.position.getOrientation(), newOrientation);
                this.position.setOrientation(newOrientation);
                break;
            case 'A':
                int nextYPosition = this.getPosition().getPositionY();
                int nextXPosition = this.getPosition().getPositionX();
                if (this.getPosition().getOrientation().equals(MowerCardinality.N)) {
                    nextYPosition++;
                } else if (this.getPosition().getOrientation().equals(MowerCardinality.S)) {
                    nextYPosition--;
                } else if (this.getPosition().getOrientation().equals(MowerCardinality.W)) {
                    nextXPosition--;
                } else if (this.getPosition().getOrientation().equals(MowerCardinality.E)) {
                    nextXPosition++;
                }
                if (garden.isPositionAvailable(nextXPosition, nextYPosition)) {
                    logger.debug("Moving mower : ({}, {}) -> ({}, {})",
                            this.position.getPositionX(), this.position.getPositionY(),
                            nextXPosition, nextYPosition);
                    this.getPosition().setPositionX(nextXPosition);
                    this.getPosition().setPositionY(nextYPosition);
                } else {
                    logger.debug("Cannot move mower : ({}, {}) -> ({}, {})",
                            this.position.getPositionX(), this.position.getPositionY(),
                            this.position.getPositionX(), this.position.getPositionY());
                }
                break;
            default:
                throw new UnknownInstructionException();
        }
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

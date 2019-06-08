package sh.antisla.grm.automower.models.mower;

import java.util.Objects;

/**
 * This class represents the mower position during the mowing process.
 */
public class MowerPosition {
    private int positionX;
    private int positionY;
    private MowerCardinality orientation;

    /**
     * Constructs a basic mower position.
     *
     * @param positionX The X-axis starting position of the mwoer
     * @param positionY The Y-axis starting position of the mower
     * @param orientation The starting cardinality of the mower orientation
     */
    public MowerPosition(final int positionX, final int positionY, final MowerCardinality orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    /**
     * Returns the current position on the X-axis of the mower.
     *
     * @return the current X-axis position
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Define the X-axis position of the mower.
     *
     * @param positionX the new X-axis position
     */
    public void setPositionX(final int positionX) {
        this.positionX = positionX;
    }

    /**
     * Returns the current position on the Y-axis of the mower.
     *
     * @return the current Y-axis position
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Define the Y-axis position of the mower.
     * @param positionY the new Y-axis position
     */
    public void setPositionY(final int positionY) {
        this.positionY = positionY;
    }

    /**
     * Returns the current orientation of the mower.
     *
     * @return the current orientation
     */
    public MowerCardinality getOrientation() {
        return orientation;
    }

    /**
     * Define the orientation of the mower.
     *
     * @param orientation the new orientation
     */
    public void setOrientation(final MowerCardinality orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        MowerPosition that = (MowerPosition) other;
        return positionX == that.positionX
                && positionY == that.positionY
                && orientation == that.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY, orientation);
    }
}

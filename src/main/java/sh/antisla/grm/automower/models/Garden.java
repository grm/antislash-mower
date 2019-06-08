package sh.antisla.grm.automower.models;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class used to represent a garden to mow.
 * The Garden is considered as a grid with the starting point (0,0)
 * which corresponds to the bottom right of the grid.
 */
public class Garden {

    private static final Logger logger = LoggerFactory.getLogger(Garden.class);

    /**
     * Length of the X-axis of the grid.
     */
    private int xAxisLength;

    /**
     * Length of the Y-axis of the grid.
     */
    private int yAxisLength;

    /**
     * Available mowers in the garden.
     */
    private final List<Mower> mowers = new ArrayList<Mower>();

    /**
     * Basic contructor for the garden.
     *
     * @param xAxisLength The X-axis length of the garden's grid.
     * @param yAxisLength The Y-axis length of the garden's grid.
     */
    public Garden(final int xAxisLength, final int yAxisLength) {
        this.xAxisLength = xAxisLength;
        this.yAxisLength = yAxisLength;
        logger.info("Adding a garden : " + this.toString());
    }

    /**
     * Returns the X-axis length of the garden's grid.
     * @return The X-axis length
     */
    public int getxAxisLength() {
        return xAxisLength;
    }

    /**
     * Set the X-axis length of the garden.
     * @param xAxisLength The X-axis length
     */
    public void setxAxisLength(final int xAxisLength) {
        this.xAxisLength = xAxisLength;
    }

    /**
     * Returns the Y-axis length of the garden's grid.
     * @return The Y-axis length
     */
    public int getyAxisLength() {
        return yAxisLength;
    }

    /**
     * Set the Y-axis length of the garden.
     * @param yAxisLength The Y-axis length
     */
    public void setyAxisLength(final int yAxisLength) {
        this.yAxisLength = yAxisLength;
    }

    /**
     * Adds a mower to the garden.
     * If the space is out of grid, or the location is already occupied by a mower, the mower cannot be added.
     * @param mower The mower to be added.
     */
    public void addMower(final Mower mower) {
        if (isPositionAvailable(mower.getPosition().getPositionX(), mower.getPosition().getPositionY())) {
            logger.info("Adding a mower to the garden : ({}, {}) ",
                    mower.getPosition().getPositionX(), mower.getPosition().getPositionY());
            this.mowers.add(mower);
        } else {
            logger.info("Mower cannot be added to the garden - location not valid : ({}, {}) ",
                    mower.getPosition().getPositionX(), mower.getPosition().getPositionY());
        }
    }

    /**
     * Returns the list of available mowers.
     * @return the list of available mowers.
     */
    public List<Mower> getMowers() {
        return mowers;
    }

    /**
     * Launches all the mowers of the garden.
     */
    public void mowItNow(){
        for (Mower mower: mowers) {
            mower.mow();
        }
    }

    /**
     * Checks if the position is available. Currently, this function tests :
     *  - if the mower is not out of the grid
     *  - if the grid location is not used by another mower
     * @param xPosition the x-axis position to test
     * @param yPosition the y-axis position to test
     * @return true if the case is available, false otherwise
     */
    public boolean isPositionAvailable(final int xPosition, final int yPosition) {
        return this.checkXAxis(xPosition, yPosition)
                && this.checkYAxis(xPosition, yPosition)
                && this.checkMowerLocations(xPosition, yPosition);
    }

    /**
     * Function used to check a location validity on the Y axis
     * @param xPosition the xPosition to test
     * @param yPosition the yPosition to test
     * @return true if the location is valid, false otherwise
     */
    private boolean checkYAxis(final int xPosition, final int yPosition) {
        if (yPosition > yAxisLength || yPosition < 0) {
            logger.debug("Movement out of grid detected ({}, {}) ! (yAxis)", xPosition, yPosition);
            return false;
        }
        return true;
    }

    /**
     * Function used to check a location validity on the X axis
     * @param xPosition the xPosition to test
     * @param yPosition the yPosition to test
     * @return true if the location is valid, false otherwise
     */
    private boolean checkXAxis(final int xPosition, final int yPosition) {
        if (xPosition > xAxisLength || xPosition < 0) {
            logger.debug("Movement out of grid detected ({}, {}) ! (xAxis)", xPosition, yPosition);
            return false;
        }
        return true;
    }

    /**
     * Function used to check if a location is not already used by another mower
     * @param xPosition the xPosition to test
     * @param yPosition the yPosition to test
     * @return true if the location is valid, false otherwise
     */
    private boolean checkMowerLocations(final int xPosition, final int yPosition) {
        for (Mower mower : mowers) {
            if (mower.getPosition().getPositionX() == xPosition
                    && mower.getPosition().getPositionY() == yPosition) {
                logger.debug("Collision detected ({}, {}) !", xPosition, yPosition);
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Garden{"
                + "xAxisLength="
                + xAxisLength
                + ", yAxisLength="
                + yAxisLength
                + '}';
    }
}

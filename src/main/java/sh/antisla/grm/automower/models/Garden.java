package sh.antisla.grm.automower.models;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class used to represent a garden to mow. The Garden is considered as a grid with the starting point (0,0) which corresponds to the bottom right of the grid.
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
    private List<Mower> mowers = new ArrayList<Mower>();

    /**
     * Basic contructor for the garden.
     *
     * @param xAxisLength The X-axis length of the garden's grid.
     * @param yAxisLength The Y-axis length of the garden's grid.
     */
    public Garden(int xaxisLength, int yaxisLength) {
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
    public void setxAxisLength(int xaxisLength) {
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
    public void setyAxisLength(int yaxisLength) {
        this.yAxisLength = yAxisLength;
    }

    /**
     * Adds a mower to the garden.
     * @param mower The mower to be added.
     */
    public void addMower(Mower mower) {
        logger.info("Adding a mower to the garden : " + mower.toString());
        this.mowers.add(mower);
    }

    /**
     * Returns the list of available mowers.
     * @return the list of available mowers.
     */
    public List<Mower> getMowers() {
        return mowers;
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

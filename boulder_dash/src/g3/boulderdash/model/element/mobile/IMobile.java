package g3.boulderdash.model.element.mobile;

import java.awt.Point;

import fr.exia.showboard.IPawn;
import g3.boulderdash.model.element.IElement;
import g3.boulderdash.model.element.Permeability;

/**
 * <h1>The Interface IMobile.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IPawn
 * @see IElement
 */
public interface IMobile extends IPawn, IElement {

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    /**
     * Checks if the car crashed.
     *
     * @return the boolean
     */
    Boolean isdead();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();
    public void setclosedPoints();
    public Point[] getclosedPoints();

    Permeability closedPermeability(Side side);

	Boolean isnearObstacle();


}

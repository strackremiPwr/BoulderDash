package g3.boulderdash.model;

import g3.boulderdash.model.element.IElement;
import g3.boulderdash.model.element.mobile.IMobile;
import g3.boulderdash.model.element.mobile.Pierre;

/**
 * <h1>The Interface IBoulderDashModel.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IBoulderDashModel {

    /**
     * Gets the road.
     *
     * @return the road
     */
    IMap getMap();

    /**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    IMobile getRockFord();

    void setRockXY(final Pierre rock, final int x, final int y);
    
    IElement getRockXY(final int x, final int y);
    
    IElement[][] getRock();

}

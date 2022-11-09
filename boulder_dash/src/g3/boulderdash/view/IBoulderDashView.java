package g3.boulderdash.view;

import g3.boulderdash.model.element.IElement;
import g3.boulderdash.model.element.mobile.IMobile;
import g3.boulderdash.model.element.mobile.Side;

/**
 * <h1>The Interface IBoulderDashView.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IBoulderDashView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

    /**
     * Follow myVehicle.
     */
    void followRockFord();


    void setRock(IElement[][] element);

	

	void update(final int x,final int y, final Side side);

}

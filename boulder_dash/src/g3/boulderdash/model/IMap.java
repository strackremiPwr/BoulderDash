package g3.boulderdash.model;

import java.util.Observable;

import g3.boulderdash.model.element.IElement;

/**
 * <h1>The Interface IMap.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IMap {

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IElement getOnTheMapXY(int x, int y);

    /**
     * Sets the mobile has changed.
     */
    void setMobileHasChanged();
    
    void setOnTheMapXY(final IElement element, final int x, final int y);

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();

	void replaced(final int x, final int y);
}

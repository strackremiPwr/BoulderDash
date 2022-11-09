package g3.boulderdash.controller;

/**
 * <h1>The Interface IBoulderDashController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public interface IBoulderDashController {

    /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void play() throws InterruptedException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}

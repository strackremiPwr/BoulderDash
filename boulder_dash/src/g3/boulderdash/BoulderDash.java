package g3.boulderdash;

import java.io.IOException;

import g3.boulderdash.controller.BoulderDashController;
import g3.boulderdash.controller.IBoulderDashController;
import g3.boulderdash.model.BoulderDashModel;
import g3.boulderdash.model.IBoulderDashModel;
import g3.boulderdash.view.BoulderDashView;

/**
 * <h1>The BoulderDash Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class BoulderDash {

    /** The Constant startX. */
    private static final int startX = 5;

    /** The Constant startY. */
    private static final int startY = 4;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     *             the interrupted exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IBoulderDashModel model = new BoulderDashModel("map.txt", startX, startY);
        
        final BoulderDashView view = new BoulderDashView(model.getMap(), model.getRockFord(), model.getRock());
        final IBoulderDashController controller = new BoulderDashController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}

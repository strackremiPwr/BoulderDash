package g3.boulderdash.model.element.motionless;

import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The DitchLeft Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class DitchLeft extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('[', "DitchLeft.jpg");

    /**
     * Instantiates a new ditchLeft.
     */
    DitchLeft() {
        super(SPRITE, Permeability.BLOCKING);
    }
}

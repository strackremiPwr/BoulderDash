package g3.boulderdash.model.element.motionless;

import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class DitchRightTurnLeft extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('}', "DitchRightTurnLeft.jpg");

    /**
     * Instantiates a new ditch.
     */
    DitchRightTurnLeft() {
        super(SPRITE, Permeability.BLOCKING);
    }
}

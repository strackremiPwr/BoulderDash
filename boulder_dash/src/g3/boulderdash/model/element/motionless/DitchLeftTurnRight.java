package g3.boulderdash.model.element.motionless;

import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class DitchLeftTurnRight extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('{', "DitchLeftTurnRight.jpg");

    /**
     * Instantiates a new ditch.
     */
    DitchLeftTurnRight() {
        super(SPRITE, Permeability.BLOCKING);
    }
}

package g3.boulderdash.model.element.motionless;

import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The Ditch Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class BackGround extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('(', "background.png");

    /**
     * Instantiates a new ditch.
     */
    BackGround() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}

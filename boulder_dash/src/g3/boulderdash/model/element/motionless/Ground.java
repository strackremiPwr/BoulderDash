package g3.boulderdash.model.element.motionless;

import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The Ground Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Ground extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "ground.png");

    /**
     * Instantiates a new macadam.
     */
    Ground() {
        super(SPRITE, Permeability.BLOCKINGR);
    }
}

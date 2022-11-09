package g3.boulderdash.model.element.motionless;

import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The Wall Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class Wall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "wall.png");

    /**
     * Instantiates a new tree.
     */
    Wall() {
        super(SPRITE, Permeability.BLOCKING);
    }
}

package g3.boulderdash.model.element;

import java.awt.Image;

import fr.exia.showboard.ISquare;

/**
 * <h1>The Interface IElement.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see ISquare
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    Image getImage();

}

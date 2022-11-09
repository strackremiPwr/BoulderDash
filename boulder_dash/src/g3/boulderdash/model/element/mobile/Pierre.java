package g3.boulderdash.model.element.mobile;

import java.io.IOException;

import g3.boulderdash.model.IMap;
import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

public class Pierre extends Mobile {
	/** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "rock.png");




    /**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param map
     *            the road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Pierre(final int x, final int y, IMap map) throws IOException {
        super(x,y, sprite, map, Permeability.BLOCKING);
        

    }

    /*
     * (non-Javadoc)
     * 
     *
     * @see g3.boulderdash.model.element.mobile.Mobile#moveLeft()
     */

    public final void moveDown() {
    	
    	
    	
       	switch (this.closedPermeability(Side.DOWN)) {
       	case BLOCKING,BLOCKINGR:
    		this.die();
    		break;
    		
       	case PENETRABLE:
       		

       		super.moveDown();

            break;
            
        default:
        	doNothing();
       	} 
      
    		
    }

   
    @Override
    protected final void die() {

    	this.doNothing();
        this.setSprite(sprite);
    }
    public final void moveUp() {
    	super.moveUp();
    }
 

    public final void setY(final int y) {
      super.setY(y);
        }
    
    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
       super.setX(x);
        }
    

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }
	public Boolean isnearObstacle() {
		
		Side[] side = {Side.UP,Side.DOWN,Side.RIGHT,Side.LEFT};
		for(Side sde : side) {
			if (this.closedPermeability(sde) == Permeability.BLOCKING ||
				this.closedPermeability(sde) == Permeability.BLOCKINGR) {
					this.near = true;
		}
	
		}
		return near;
		
	}


    

}




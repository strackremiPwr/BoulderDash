package g3.boulderdash.model.element.mobile;

import java.io.IOException;

import g3.boulderdash.model.BoulderDashModel;
import g3.boulderdash.model.IMap;
import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The RockFord Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class RockFord extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "Boulder.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', "MyVehicleLeft.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "MyVehicleRight.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteExplode   = new Sprite('H', "MyVehicleExplode.png");
    
    
    

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
    public RockFord(final int x, final int y, final IMap map) throws IOException {
        super(x, y, sprite, map, Permeability.BLOCKING);
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteExplode.loadImage();
        
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
    	
       	switch (this.closedPermeability(Side.LEFT)) {
       	case BLOCKING:
    		this.die();
    		break;
    		
       	case PENETRABLE,BLOCKINGR:
       		super.moveLeft();
            break;
            
           
        default:
        	doNothing();
       	} 
    		
    }

    @Override
    public void moveDown() {
    	
    	switch (this.closedPermeability(Side.DOWN)){
       	case BLOCKING:
       		
    		this.die();
    		break;
    		
       	case PENETRABLE,BLOCKINGR:
       	
       		super.moveDown();
      
		System.out.println(this.getclosedPoints()[1] );
       		
            break;
            
        default:
        	doNothing();
       	} 
    		
    	}
    
    
    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
    	
    	
    	switch (this.closedPermeability(Side.RIGHT)) {
       	case BLOCKING:
    		this.die();
    		break;
    		
       	case PENETRABLE,BLOCKINGR:
       		super.moveRight();
            break;
            
        default:
        	doNothing();
       	} 
    		
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        doNothing();
        this.setSprite(sprite);
    }
    
    public final void moveUp() {

       	switch (this.closedPermeability(Side.UP)) {
       	case BLOCKING:
    		this.die();
    		break;
    		
       	case PENETRABLE,BLOCKINGR:
       		super.moveUp();
            break;
            
        default:
        	doNothing();
       	} 
    		
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        
        this.setSprite(sprite);
        this.setHasMoved();
    }
    
    
    public Boolean isdead(int x, int y) {
//    	System.out.println(this.getRoad().getOnTheRoadXY(this.getX(), this.getY()));
        return this.getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.BLOCKING;
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

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public void setY(final int y) {
       super.setY(y);
        }

	public Boolean isnearObstacle() {
		
		Side[] side = {Side.UP,Side.DOWN,Side.RIGHT,Side.LEFT};
		for(Side sde : side) {
			if (this.closedPermeability(sde) == Permeability.BLOCKING ) {
					this.near = true;
		}
	
		}
		return near;
		
	}
		    

}

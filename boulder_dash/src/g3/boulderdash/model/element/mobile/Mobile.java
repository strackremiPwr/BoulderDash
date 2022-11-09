package g3.boulderdash.model.element.mobile;

import java.awt.Point;

import fr.exia.showboard.IBoard;
import g3.boulderdash.model.BoulderDashModel;
import g3.boulderdash.model.IBoulderDashModel;
import g3.boulderdash.model.IMap;
import g3.boulderdash.model.element.Element;
import g3.boulderdash.model.element.IElement;
import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.Sprite;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

    /**
     * The x.
     */
    private Point   position;

    /** The alive. */
    private Boolean alive = true;
    
    protected Boolean near = false;
    
    private Permeability perm = Permeability.PENETRABLE;
    
    
    



	public int side;

    /** The map. */
    private IMap   map;

    /** The board. */
    private IBoard  board;
    
    private Point[] closedPoints ;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param map
     *            the map
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
        this.position = new Point();
        this.closedPoints =  new Point[4];
    }
    
    

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param map
     *            the map
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.setX(x);
        this.setY(y);
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#moveUp()
     */
    @Override
    public void moveUp() {
//    	System.out.println(this.getY());
    	if (this.getY()<1) {
    		doNothing();
    	} else  {
            this.setY(this.getY() - 1);
            this.setHasMoved();
    	}

 

    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() {
    	System.out.println(this.getX());
    	if (this.getX()<=0) {
    		doNothing();
    	} else  {
    	this.setX(this.getX() - 1);
    	this.setHasMoved();
    		
    	}
       
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() {
    	if (this.getMap().getHeight()-2<= this.getY()||  this.getY()<0) {
    		doNothing();
    	} else  {
        this.setY(this.getY() + 1);
     	
        
        this.setHasMoved();
    	}
    }




	/*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() {
    	if (this.getMap().getWidth() - 1 == this.getX()) {
    		doNothing();
    	} else  {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    	}
    }
    
  
    
    public Permeability closedPermeability(Side side) {
    	int i = 0;
    	
    	switch (side) {
    	case DOWN:
    		i = 1;
    		break;
    		
    	case LEFT:
    		i = 0;
    		break;
    	case RIGHT:
    		i = 2;
    		break;
    	case UP:
    		i = 3;
    		break;   		
    	
    	}    		
    		if(Rockverify(i) || Vehicleverify(i)) {
    			return Permeability.BLOCKING;
    		}else {
    			
    			return this.getMap().getOnTheMapXY(this.getclosedPoints()[i].x, this.getclosedPoints()[i].y).getPermeability();
    		}
    		
    	}
    
	public Boolean isnearObstacle() {
		return near;
		
	}
   
    
    
    
    
    
    public Boolean Rockverify(int side) {
    	this.near = false;
    	for(int x =0; x<this.getMap().getWidth(); x++) {
			for(IElement rocks: BoulderDashModel.rocks[x]) {
			
				if (rocks != null) {
					
					if (getclosedPoints()[side].x == ((IMobile) rocks).getPosition().x && getclosedPoints()[side].y == ((IMobile) rocks).getPosition().y ) {
						this.near = true ;
						break;
						} 
				}
			}
    	}
    	
    	return this.near;
    }
    
    
    public Boolean Vehicleverify(int side) {
    	this.near = false;
    	if(BoulderDashModel.rockFord.getPosition().x == getclosedPoints()[side].x && BoulderDashModel.rockFord.getPosition().y == getclosedPoints()[side].y) {
    		this.near = true;
    	
    	}
    	return this.near;
    	
    	
    }
    
    
    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    protected void setHasMoved() {
        this.getMap().setMobileHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#getX()
     */
    @Override
    public int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public void setX(final int x) {
        this.getPosition().x =(x)%  this.getMap().getWidth();
        if (this.isdead()) {
            this.die();
        }
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#getY()
     */
    @Override
    public int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the map is an infinite loop, there's a modulo
     *            based on the map height.
     */
    public void setY(final int y) {
    	this.getPosition().y = (y+ this.getMap().getHeight()) % this.getMap().getHeight();
        if (this.isdead()) {
            this.die();
            }
    }

    
    /**
     * Gets the map.
     *
     * @return the map
     */
    public IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#isAlive()
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#isCrashed()
     */
    @Override
    public Boolean isdead() {
//    	System.out.println(this.getRoad().getOnTheRoadXY(this.getX(), this.getY()));
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    


    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.element.mobile.IMobile#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }
    
    
    public void setclosedPoints() {
    	
    	
    	//left
    	this.closedPoints[0] = new Point(((this.getPosition().x-1+this.getMap().getWidth()) %this.getMap().getWidth()), (this.getPosition().y%this.getMap().getHeight()));
    	//down
    	this.closedPoints[1] = new Point((this.getPosition().x)%this.getMap().getWidth(),(this.getPosition().y+1)%this.getMap().getHeight());
    	//right
    	this.closedPoints[2] = new Point((this.getPosition().x+1)%this.getMap().getWidth(),this.getPosition().y%this.getMap().getHeight());
    	//up
    	this.closedPoints[3] = new Point((this.getPosition().x)%this.getMap().getWidth(),(this.getPosition().y-1+this.getMap().getHeight())%this.getMap().getHeight());
    	
    	
    }
    
    
    
    public Point[] getclosedPoints() {
    	setclosedPoints();
    	return this.closedPoints;
    }

}

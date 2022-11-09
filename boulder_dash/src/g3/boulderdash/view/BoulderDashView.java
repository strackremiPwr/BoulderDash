package g3.boulderdash.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.exia.showboard.BoardFrame;
import fr.exia.showboard.IPawn;
import g3.boulderdash.controller.IOrderPerformer;
import g3.boulderdash.controller.UserOrder;
import g3.boulderdash.model.BoulderDashModel;
import g3.boulderdash.model.IBoulderDashModel;
import g3.boulderdash.model.IMap;
import g3.boulderdash.model.element.IElement;
import g3.boulderdash.model.element.Permeability;
import g3.boulderdash.model.element.mobile.IMobile;
import g3.boulderdash.model.element.mobile.Pierre;
import g3.boulderdash.model.element.mobile.Side;
import g3.boulderdash.model.element.motionless.MotionlessElementsFactory;

/**
 * <h1>The BoulderDashView Class.</h1>
 *
 * @author Jade
 * @version 0.4
 */
public class BoulderDashView implements Runnable, KeyListener, IBoulderDashView {

    /** The Constant roadView. */
    private static final int mapView   = 10;

    /** The Constant squareSize. */
    private static final int squareSize = 30;

    /** The Constant closeView. */
    private Rectangle        closeView;

    /** The map. */
    private IMap            map;

    /** My vehicle. */
    private IMobile          rockFord;
    
    private IElement[][]    rocks;

    /** The view. */
    private int              view;

    /** The order performer. */
    private IOrderPerformer  orderPerformer;

    /**
     * Instantiates a new insane vehicles View.
     *
     * @param map
     *            the map
     * @param myVehicle
     *            the my vehicle
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderDashView(final IMap map, final IMobile rockFord,  final IElement[][]    Rocks) throws IOException {
        this.setView(mapView);
        this.setMap(map);
        this.setRockFord(rockFord);
        this.setRock(Rocks);
        this.getRockFord().getSprite().loadImage();
        
     
        this.setCloseView(new Rectangle(0, 0, this.getMap().getWidth(), mapView));
        SwingUtilities.invokeLater(this);
    }


	public static BoardFrame boardFrame;

	/*
     * (non-Javadoc)
     * @see g3.boulderdash.view.IBoulderDashView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
    	this.boardFrame = new BoardFrame("InsaneVehicle");
        this.boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        this.boardFrame.setDisplayFrame(this.closeView);
        this.boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);

        this.boardFrame.addKeyListener(this);
        this.boardFrame.setFocusable(true);
        this.boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
         
                this.boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
            }
        
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
            	if (this.getRock()[x][y] != null) {
            		try {
						this.getRock()[x][y].getSprite().loadImage();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    this.boardFrame.addPawn((IPawn) this.getRock()[x][y]);
            	}
         

            	
            }
            }
        
        this.boardFrame.addPawn(this.getRockFord());
		this.boardFrame.addSquare(MotionlessElementsFactory.backGround, this.getRockFord().getPosition().x, this.getRockFord().getPosition().y);
      	 this.boardFrame.setVisible(true);
  

        

        this.getMap().getObservable().addObserver(this.boardFrame.getObserver());
//        this.followMyVehicle();

        this.boardFrame.setVisible(true);
    }
    public void update(final int x, final int y,final Side side) {
    	
    	
    	
    	if (getRockFord().isnearObstacle()) {
    		
    	}else {
    	switch (side) {
    	case DOWN:
    		this.boardFrame.addSquare(this.map.getOnTheMapXY(x, y), this.getRockFord().getPosition().x, this.getRockFord().getPosition().y+1);
       	 this.boardFrame.setVisible(true);
       	 break;
       	 
    	case UP:
    		this.boardFrame.addSquare(this.map.getOnTheMapXY(x, y), this.getRockFord().getPosition().x, this.getRockFord().getPosition().y-1);
          	 this.boardFrame.setVisible(true);
          	 break;
    	case LEFT:
    		this.boardFrame.addSquare(this.map.getOnTheMapXY(x, y), this.getRockFord().getPosition().x-1, this.getRockFord().getPosition().y);
          	 this.boardFrame.setVisible(true);
          	 break;
    	case RIGHT:
    		this.boardFrame.addSquare(this.map.getOnTheMapXY(x, y), this.getRockFord().getPosition().x+1, this.getRockFord().getPosition().y);
          	 this.boardFrame.setVisible(true);
          	 break;
       	 
    	}
    	}
    	
    	
    }
    /**
     * Prints the map and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     */
//    public final void show(final int yStart) {
//        int y = yStart % this.getRoad().getHeight();
//        for (int view = 0; view < this.getView(); view++) {
//            for (int x = 0; x < this.getRoad().getWidth(); x++) {
//                if ((x == this.getMyVehicle().getX()) && (y == yStart)) {
//                    System.out.print(this.getMyVehicle().getSprite().getConsoleImage());
//                } else {
//                    System.out.print(this.getRoad().getOnTheRoadXY(x, y).getSprite().getConsoleImage());
//                }
//            }
//            y = (y + 1) % this.getRoad().getHeight();
//            System.out.print("\n");
//        }
//    }

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_DOWN:
            	 userOrder = UserOrder.DOWN;
                 break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_UP:
                userOrder = UserOrder.UP;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.view.IBoulderDashView#followMyvehicle()
     */
    @Override
    public final void followRockFord() {
        this.getCloseView().y = this.getRockFord().getY() - 1;
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    private IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
            	if( getMap().getOnTheMapXY(x, y) != null) {
            		System.out.println(getMap().getOnTheMapXY(x, y));
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
            	}
            }
        }
    }

    /**
     * Gets my vehicle.
     *
     * @return my vehicle
     */
    private IMobile getRockFord() {
        return this.rockFord;
    }

    /**
     * Sets my vehicle.
     *
     * @param myVehicle
     *            my new vehicle
     */
    private void setRockFord(final IMobile rockFord) {
        this.rockFord = rockFord;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private int getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }

    /**
     * Gets the close view.
     *
     * @return the close view
     */
    private Rectangle getCloseView() {
        return this.closeView;
    }

    /**
     * Sets the close view.
     *
     * @param closeView
     *            the new close view
     */
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Gets the order performer.
     *
     * @return the order performer
     */
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    /**
     * Sets the order performer.
     *
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
    
    public void setRock(IElement[][] element) {
    	this.rocks = element;
    }
    public IElement[][] getRock() {
    	return this.rocks;
    }
}

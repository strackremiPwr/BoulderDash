package g3.boulderdash.controller;

import java.io.IOException;

import g3.boulderdash.model.IBoulderDashModel;
import g3.boulderdash.model.element.mobile.IMobile;
import g3.boulderdash.model.element.mobile.Pierre;
import g3.boulderdash.model.element.mobile.Side;
import g3.boulderdash.view.IBoulderDashView;

/**
 * <h1>The Class BoulderDashController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public class BoulderDashController implements IBoulderDashController, IOrderPerformer {

    /** The Constant speed. */
    private static final int     speed = 50;

    /** The view. */
    private IBoulderDashView  view;

    /** The model. */
    private IBoulderDashModel model;

    /** The stack order. */
    private UserOrder            stackOrder;

    /**
     * Instantiates a new insane vehicles controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public BoulderDashController(final IBoulderDashView view, final IBoulderDashModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
   
    }

    
    /*
     * (non-Javadoc)
     * @see g3.boulderdash.controller.IBoulderDashController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getRockFord().isAlive()) {
         	
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
//                	this.getModel().getRoad().replaced(this.getModel().getMyVehicle().getPosition().x,this.getModel().getMyVehicle().getPosition().y);
//                	System.out.println(this.getModel().getRoad().getOnTheRoadXY(this.getModel().getMyVehicle().getPosition().x, this.getModel().getMyVehicle().getPosition().y));
//                    
                    replace();
                    update(Side.RIGHT);
                    this.getModel().getRockFord().moveRight();
                   
                    break;
                case LEFT:
                	replace();
                	update(Side.LEFT);
                    this.getModel().getRockFord().moveLeft();

                   
                    break;
                case DOWN:
                	replace();
                	update(Side.DOWN);
                	this.getModel().getRockFord().moveDown();
                	
                	break;
                case UP:
                	replace();
                	update(Side.UP);
                	this.getModel().getRockFord().moveUp();
                
                	break;
                case NOP:
                default:
                    this.getModel().getRockFord().doNothing();
                    break;
            }
            
            
            for(int y=0; y < this.getModel().getMap().getHeight(); y++) {
            	for(int x = 0; x < getModel().getMap().getWidth(); x++) {
            		if (this.getModel().getRockXY(x, y)!= null) {
            			
            			((IMobile) this.getModel().getRockXY(x, y)).moveDown();
            		}
            }
            }
            
            
            this.clearStackOrder();
//            if (this.getModel().getMyVehicle().isAlive()) {
//                this.getModel().getMyVehicle().moveDown();
//            }
//            this.getView().followMyVehicle();
//            System.out.println(this.getModel().getMyVehicle().getY());
        }
        this.getView().displayMessage("Dead!!!!!");
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.controller.IOrderPerformed#orderPerform(g3.boulderdash.
     * controller.UserOrder)
     */
    /*
     * (non-Javadoc)
     * @see g3.boulderdash.controller.IBoulderDashController#orderPerform(fr.exia.
     * insanevehicles.controller.UserOrder)
     */
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private IBoulderDashView getView() {
        return this.view;
    }
    
    
    public void replace() {
    	this.getModel().getMap().replaced((this.getModel().getRockFord().getPosition().x) %(this.getModel().getMap().getWidth()), (this.getModel().getRockFord().getPosition().y)%(this.getModel().getMap().getHeight()));
    }
    
    public void update(Side side) {
    	
    	
    	 this.getView().update((this.getModel().getRockFord().getPosition().x)%(this.getModel().getMap().getWidth()), (this.getModel().getRockFord().getPosition().y)%(this.getModel().getMap().getHeight()),side);
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IBoulderDashView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    private IBoulderDashModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IBoulderDashModel model) {
        this.model = model;
    }

    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /*
&     * (non-Javadoc)
     * @see g3.boulderdash.controller.IBoulderDashController#getOrderPeformer()
     */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}

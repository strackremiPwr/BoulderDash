package g3.boulderdash.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import g3.boulderdash.model.element.IElement;
import g3.boulderdash.model.element.mobile.IMobile;
import g3.boulderdash.model.element.mobile.Pierre;
import g3.boulderdash.model.element.motionless.MotionlessElementsFactory;

/**
 * <h1>The Map Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
class Map extends Observable implements IMap {

    /** The width. */
    private int          width;

    /** The height. */
    private int          height;
    

    /** The on the road. */
    private IElement[][] onTheMap;

    



    /**
     * Instantiates a new road with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Map(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
        
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
            	if (line.toCharArray()[x] != '/') {
          
                this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }else {
            	this.setOnTheMapXY(MotionlessElementsFactory.backGround, x, y);

            	
            }
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.IMap#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.IMap#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.IMap#getOnTheRoadXY(int, int)
     */
    @Override
    public final IElement getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }
    




    /**
     * Sets the on the road XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void setOnTheMapXY(final IElement element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }
    



    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.IMap#setMobileHasChanged()
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     * @see g3.boulderdash.model.IMap#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
    }
    
    public void replaced(final int x, final int y) {
    	
    	setOnTheMapXY(MotionlessElementsFactory.backGround, x, y);
    }
}

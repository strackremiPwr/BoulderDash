package g3.boulderdash.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import g3.boulderdash.model.element.IElement;
import g3.boulderdash.model.element.mobile.IMobile;
import g3.boulderdash.model.element.mobile.Pierre;
import g3.boulderdash.model.element.mobile.RockFord;
import g3.boulderdash.model.element.motionless.MotionlessElementsFactory;

/**
 * <h1>The Class BoulderDashModel.</h1>
 */
public class BoulderDashModel implements IBoulderDashModel {

    /** The map. */
    private IMap   map;

    /** The my vehicle. */
    public static IMobile rockFord;
    
    public static IElement [][] rocks ;


	/**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myVehicleStartX
     *            the my vehicle start X
     * @param myVehicleStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderDashModel(final String fileName, final int rockFordStartX, final int rockFordStartY)
            throws IOException {
    	
    	
        this.setMap(new Map(fileName));
        this.setRockFord(new RockFord(rockFordStartX, rockFordStartY, this.getMap()));
        this.rocks = new IElement[this.getMap().getWidth()][this.getMap().getHeight()];
        loadRocksFromFile(fileName);
    }
    
    
    private void loadRocksFromFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        line = buffer.readLine();
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
            	if (line.toCharArray()[x] == '/') {
            		this.setRockXY(new Pierre(x,y,this.getMap()), x, y);
            	}
          
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

        
        
       
        
    

    /* (non-Javadoc)
     * @see g3.boulderdash.model.IBoulderDashModel#getRoad()
     */
    @Override
    public final IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the map to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /* (non-Javadoc)
     * @see g3.boulderdash.model.IBoulderDashModel#getMyVehicle()
     */
    @Override
    public final IMobile getRockFord() {
        return this.rockFord;
        }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setRockFord(final IMobile rockFord) {
        this.rockFord = rockFord;
    }

    public void setRockXY(final Pierre rock, final int x, final int y) {
    	this.rocks[x][y] = rock;
    }
    public IElement getRockXY(final int x, final int y) {
    	return  this.rocks[x][y];
    }
    
    public IElement[][] getRock(){
    
    	return  this.rocks;
    }

}

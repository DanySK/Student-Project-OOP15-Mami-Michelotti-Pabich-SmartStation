package application.model.buildables.area;

import java.util.List;

import application.model.buildables.Buildable;
import application.model.buildables.pump.Pump;
import application.model.consumers.Vehicle;

/**
 * Interface containing all the logic of an Area.
 * @author Alessandro Mami
 *
 */
public interface Area{	
    
    /**
     * Gets the vehicle inside the area if there is one.
     * @return Object of vehicle's type or else null.
     */
    Vehicle getVehicle();
    
    /**
     * Returns a list of every pump of an area.
     * @return List of pump's type.
     */
    List<Pump> getAllPumps();
    
    /**
     * Returns the number of pumps of an area.
     * @return Integer of pump's number.
     */
    int getPumpsCount();
	
    /**
     * Returns the coordinate x of an Area.
     * @return Integer of position x.
     */
    int getXPosition();
    
    /**
     * Returns the coordinate y of an Area.
     * @return Integer of position y.
     */
    int getYPosition();
    
    /**
     * Builds the area in a certain position.
     * @param Integer coordinate of position x.
     * @param Integer coordinate of position y.
     */
    void setPosition(int x, int y);
    
    /**
     * Builds a pump inside an area.
     * @param Object of pump's type.
     */
    void addPump(final Pump pump);
    
    /**
     * Builds a list of pumps inside an area.
     * @param List of pumps objects.
     */
    void addPumps(final List<Pump> pumps);
    
    /**
     * Removes a specific pump from the area.
     * @param Object of pump's type.
     */
    void removePump(final Pump pump);
    
    /**
     * Checks if the pump is occupied by a vehicle.
     * @return Boolean of true if occupied or else false.
     */
    boolean isOccupied();
}

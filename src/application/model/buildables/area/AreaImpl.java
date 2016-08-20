package application.model.buildables.area;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import application.model.buildables.pump.Pump;
import application.model.consumers.Vehicle;

/**
 * Implements the Area interface and contains the logic of every area.
 * @author Alessandro Mami
 */
public class AreaImpl implements Area{
    
    /**
     * Space for the vehicle inside the area.
     */
    private final Optional<Vehicle> vehicles;
    /**
     * List of pumps inside the area.
     */
    private final List<Pump> pumps;
    /**
     * Declaring coordinate types.
     */
    private int x, y;
    
    /**
     * Constructor for the AreaImpl that builds avery area.
     * @param Coordinates of the area.
     * @param List of pumps of an area.
     */
    public AreaImpl(final int x, final int y, final List<Pump> pumps) {
        this.vehicles = Optional.ofNullable(null);
        this.pumps = pumps;
        this.x = x;
        this.y = y;       
    }

    //PARAMETERS GETTERS
    @Override
    public Vehicle getVehicle() {
        return this.vehicles.orElse(null);   	
    }
	
    @Override
    public List<Pump> getAllPumps() {
	return new ArrayList<Pump> (this.pumps);	
    }
    
    @Override
    public int getPumpsCount() {
       return pumps.size();
    }
	
    @Override
    public int getXPosition() {
        return this.x;      
    }

    @Override
    public int getYPosition() {
        return this.y;
    }
    
    //PARAMETERS SETTER
    @Override
    public void setPosition(final int x, final int y) {
	this.x = x;
	this.y = y;
    }
    
    //PUMP BUILDERS
    @Override
    public void addPump(final Pump pump) {
        this.pumps.add(pump);       
    }

    @Override
    public void addPumps(final List<Pump> pumps) {
        pumps.clear();
        this.pumps.addAll(pumps);   
    }

    @Override
    public void removePump(final Pump pump) {
        this.pumps.remove(pump);
    }
    
    //VEHICLE CONTROL
    @Override
    public boolean isOccupied() {
	return vehicles.isPresent();
    }
}

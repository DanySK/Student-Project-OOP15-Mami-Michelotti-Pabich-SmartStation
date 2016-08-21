package application.model.buildables.area;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import application.model.Station;
import application.model.buildables.pump.Pump;
import application.model.consumers.Vehicle;

/**
 * Implements the Area interface and contains the logic of every area.
 * @author Alessandro Mami
 * 
 */
public class AreaImpl implements Area{
    
    /** 
     * Area's attributes declaration. 
     */
    private Optional<Vehicle> vehicle;
    private final List<Pump> pumps;
    private int x, y;
    private final Station station;
    
    /**
     * Constructor for the AreaImpl that builds avery area.
     * @param Coordinate x integer.
     * @param Coordinate y integer.
     * @param Pump's type list.
     * @param Station's type object.
     */
    public AreaImpl(final int x, final int y, final List<Pump> pumps, Station s) {
        this.vehicle = Optional.empty();
        this.pumps = pumps;
        this.x = x;
        this.y = y;
        this.station = s;
    }

    //GETTERS AND SETTERS
    @Override
    public Vehicle getVehicle() {
        return this.vehicle.orElse(null);   	
    }
    
    @Override
    public boolean setVehicle(Vehicle v) {
        if(!this.vehicle.isPresent()) {
            this.vehicle = Optional.of(v);
            return true;
        }
        return false;       
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
      
    @Override
    public boolean setPosition(final int x, final int y) {
        if(x <= station.getMaxAreas() && y <= station.getMaxAreas()) {
            this.x = x;
    	    this.y = y;
    	    return true;
        }
        return false;
    }
    
    //AREA ADDERS AND REMOVERS
    @Override
    public boolean addPump(final Pump pump) {
        if(pumps.size() <= station.getMaxPumps()) {
            this.pumps.add(pump);
            return true;
        } 
        return false;          
    }

    @Override
    public boolean addPumps(final List<Pump> pumps) {
        if(pumps.size() <= station.getMaxPumps()) {
            pumps.clear();
            this.pumps.addAll(pumps);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePump(final Pump pump) {
        if(pumps.size() > 0) {
            this.pumps.remove(pump);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeVehicle(final Vehicle vehicle) {
        if(this.vehicle.isPresent()) {
            this.vehicle = null;
            return true;
        }
        return false;
    }
    
    //VEHICLE CONTROL
    @Override
    public boolean isOccupied() {
	return vehicle.isPresent();
    }
}

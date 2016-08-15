package application.model.buildables.area;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import application.model.buildables.BuildableImpl;
import application.model.buildables.pump.Pump;
import application.model.consumers.Vehicle;

public class AreaImpl extends BuildableImpl implements Area{
    
    private final Optional<Vehicle> vehicles;
    private final List<Pump> pumps;
    private int x, y;
	
    public AreaImpl(final int maxDurability, final int actualDurability, final int cost, final int repairCost, final int x, final int y) {
	super(maxDurability, actualDurability, cost, repairCost);
        this.vehicles = Optional.ofNullable(null);
        this.pumps = new ArrayList<Pump>();
        this.x = x;
        this.y = y;
    }

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
    
    @Override
    public void setPosition(final int x, final int y) {
	this.x = x;
	this.y = y;
    }

    @Override
    public void addPump(final Pump pump) {
        this.pumps.add(pump);       
    }

    @Override
    public void addAllPumps(final List<Pump> pumps) {
        this.pumps.addAll(pumps);   
    }

    @Override
    public void removePump(final Pump pump) {
        this.pumps.remove(pump);    
    }
    
    @Override
    public boolean isOccupied() {
	return vehicles.isPresent();
    }
}

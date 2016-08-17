package application.model.area;

import java.util.List;

import application.model.buildables.Buildable;
import application.model.buildables.pump.Pump;
import application.model.consumers.Vehicle;

public interface Area{	
	
    Vehicle getVehicle();
	
    List<Pump> getAllPumps();
    
    int getPumpsCount();
	
    int getXPosition();
	
    int getYPosition();
	
    void setPosition(int x, int y);
    
    void addPump(final Pump pump);
    
    void addAllPumps(final List<Pump> pumps);
    
    void removePump(final Pump pump);
	
    boolean isOccupied();
}

package application.model.buildables.area;

import java.util.List;

import application.model.buildables.Buildable;
import application.model.buildables.pump.Pump;
import application.model.consumers.Vehicle;

public interface Area extends Buildable{	
	
	Vehicle getVehicle();
	
	List<Pump> getAllPumps();
	
	int getXPosition();
	
	int getYPosition();
	
	void setPosition(int x, int y);
	
	boolean isOccupied();
	
}

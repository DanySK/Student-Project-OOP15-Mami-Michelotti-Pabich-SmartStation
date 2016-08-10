package application.model.buildables.reserve;

import application.model.buildables.Buildable;
import application.model.services.Fuel;

public interface Reserve extends Buildable{
	
	Fuel getType();
	
	void setType(Fuel type);
	
	int getCapacity();
	
	void setCapacity(int capacity);
	
	int getRemaining();
	
	void setRemaining(int remaining);
	
	void refill(int refill);

}

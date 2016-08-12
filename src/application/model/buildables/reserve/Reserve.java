package application.model.buildables.reserve;

import application.model.buildables.Buildable;
import application.model.services.Fuel;

public interface Reserve extends Buildable{
	
    Fuel getType();
	
    void setType(final Fuel type);
	
    int getCapacity();
	
    void setCapacity(final int capacity);
	
    int getRemaining();
	
    void setRemaining(final int remaining);
	
    void refill(final int refill);
}

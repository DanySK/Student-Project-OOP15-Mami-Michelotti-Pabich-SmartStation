package application.model.buildables.pump;

import application.model.buildables.Buildable;
import application.model.services.Fuel;

public interface Pump extends Buildable{
	
    String getName();
	
    void setName(final String name);
	
    Fuel getType();
	
    void setType(final Fuel type);
	
    int getSpeed();
	
    void setSpeed(final int speed);
}

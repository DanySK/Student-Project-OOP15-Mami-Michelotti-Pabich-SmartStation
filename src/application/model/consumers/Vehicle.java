package application.model.consumers;

import application.model.services.Fuel;

public interface Vehicle {

    Fuel getFuel();
    	
    void setFuel(final Fuel fuel);
    	
    int getRequest();
    	
    void setRequest(final int request);
    	
    void serve();
}

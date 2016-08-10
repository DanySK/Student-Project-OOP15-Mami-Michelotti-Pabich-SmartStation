package application.model.consumers;

import application.model.services.Fuel;

public interface Vehicle {

	Fuel getFuel();
	
	void setFuel(Fuel fuel);
	
	int getRequest();
	
	void setRequest(int request);
	
	void serve();
}

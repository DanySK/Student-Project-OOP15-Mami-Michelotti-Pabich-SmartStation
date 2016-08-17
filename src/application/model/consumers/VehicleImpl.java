package application.model.consumers;

import application.model.services.Fuel;

public class VehicleImpl implements Vehicle {
	
    private Fuel type;         
    private int request;
    private int received;
    
    public VehicleImpl(final Fuel type, final int request) {
        this.type = type;
        this.request = request;
        this.received = 0;
    }

    @Override
    public Fuel getFuel() {
    	return this.type;
    }
    
    @Override
    public void setFuel(final Fuel fuel) {
    	this.type = fuel;	
    }
    
    @Override
    public int getRequest() { 
    	return this.request;
    }
    
    @Override
    public void setRequest(final int request) {
    	this.request = request;	
    }
    
    @Override
    public void serve() {
    	this.received += request;		
    }
}

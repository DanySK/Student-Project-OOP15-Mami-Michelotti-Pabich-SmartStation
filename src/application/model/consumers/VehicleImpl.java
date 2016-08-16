package application.model.consumers;

import application.model.services.Fuel;

public class VehicleImpl implements Vehicle {
	
    private Fuel type;          //tipo di benzina che vuole
    private int request;               //quante ne vuole
    private int received;       //quanta ne ha ricevuto
    
    public VehicleImpl(final Fuel type, final int request) {
        this.type = type;
        this.request = request;
        this.received = 0;              //non riceve un cazzo all'arrivo
    }

    @Override
    public Fuel getFuel() {                        //torna il suo tipo di benzina
    	return this.type;
    }
    
    @Override
    public void setFuel(final Fuel fuel) {               //quando la genero setto
    	this.type = fuel;	
    }
    
    @Override
    public int getRequest() {                      //torna la sua richiesta  
    	return this.request;
    }
    
    @Override
    public void setRequest(final int request) {          //quando la genero setto
    	this.request = request;	
    }
    
    @Override
    public void serve() {                          //servo la macchina dando quello che posso
    	this.received += request;		
    }
}

package application.model.services;

import java.util.ArrayList;
import java.util.List;

import application.model.buildables.reserve.Reserve;

public class FuelManagerImpl implements FuelManager{
	
    private final List<Fuel> fuels; 
    
    public FuelManagerImpl() {
    	this.fuels = new ArrayList<>();
    }
    
    @Override
    public Fuel getFuel(final String fuel) {
    	for(Fuel f : this.fuels){
    	    if(f.getName() == fuel){
    		return f;
    	    }
    	}
    	return null;
    }
    	
    @Override
    public List<Fuel> getAllFuels() {
    	return new ArrayList<>(this.fuels);
    }
    
    @Override
    public void addFuel(final Fuel name) {
    	fuels.add(name);	
    }
    
    @Override
    public void removeFuel(final Fuel name) {
    	fuels.remove(name);	
    }
    
    @Override
    public void removeFuels() {
    	fuels.clear();
    }
}

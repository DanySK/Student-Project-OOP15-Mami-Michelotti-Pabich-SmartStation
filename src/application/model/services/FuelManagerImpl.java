package application.model.services;

import java.util.ArrayList;
import java.util.List;

import application.model.buildables.pump.Pump;
import application.model.buildables.reserve.Reserve;
import javafx.scene.paint.Color;

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
    public void addFuel(final String name, final int price, final int wholeSalePrice, final Color color){
    	this.fuels.add(new FuelImpl(name, price, wholeSalePrice, color));	
    }
    
    @Override
    public void removeFuel(final String name) {
        for(Fuel f : this.fuels){
            if(f.getName() == name){
                fuels.remove(f);
            }
        }	
    }
    
    @Override
    public void removeFuels() {
    	fuels.clear();
    }
}

package application.model.services;

import java.util.ArrayList;
import java.util.List;

import application.model.buildables.pump.Pump;
import application.model.buildables.reserve.Reserve;
import javafx.scene.paint.Color;

/**
 * Implements the FuelManager interface.
 * @author Alessandro Mami
 *
 */
public class FuelManagerImpl implements FuelManager{
    
    /**
    * List of fuels.
    */
    private final List<Fuel> fuels; 
    

    /**
     * Constructor for the FuelManagerImpl that stores every pump.
     */
    public FuelManagerImpl() {
    	this.fuels = new ArrayList<>();
    }
    
    //FUEL GETTERS
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
    
    //FUEL ADDERS AND REMOVERS
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

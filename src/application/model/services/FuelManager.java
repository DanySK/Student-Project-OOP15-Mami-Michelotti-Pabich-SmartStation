package application.model.services;

import java.util.List;

public interface FuelManager {
	
    Fuel getFuel(String fuel);
    
    List<Fuel> getAllFuels();
    
    void addFuel(final Fuel name);
    
    void removeFuel(final Fuel name);
    
    void removeFuels();
}

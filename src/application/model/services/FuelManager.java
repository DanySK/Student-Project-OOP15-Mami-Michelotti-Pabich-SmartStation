package application.model.services;

import java.util.List;

import javafx.scene.paint.Color;

public interface FuelManager {
	
    Fuel getFuel(String fuel);
    
    List<Fuel> getAllFuels();
    
    void addFuel(final String name, final int price, final int wholeSalePrice, final Color color);
    
    void removeFuel(final String name);
    
    void removeFuels();
}

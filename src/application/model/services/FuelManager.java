package application.model.services;

import java.util.List;

import javafx.scene.paint.Color;

/**
 * Interface containing all the logic to create a fuel.
 * @author Alessandro Mami
 * 
 */
public interface FuelManager {
    
    /**
     * Gets a fuel by name.
     * @param String name of the fuel.
     * @return Object of fuel's type.
     */
    Fuel getFuel(String fuel);
    
    /**
     * Gets every fuel.
     * @return List of fuel's type.
     */
    List<Fuel> getAllFuels();
    
    /**
     * Adds a new fuel.
     * @param String of fuel's name.
     * @param Integer of fuel's price.
     * @param Integer of fuel's whole sale price.
     * @param Object of color's type.
     */
    void addFuel(String name, int price, int wholeSalePrice, Color color);
    
    /**
     * Removes a fuel by name.
     * @param String of fuel's name.
     */
    void removeFuel(String name);
    
    /**
     * Removes every fuel.
     */
    void removeFuels();
}

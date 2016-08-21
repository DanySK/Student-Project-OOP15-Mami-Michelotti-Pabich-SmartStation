package application.model.services;

import javafx.scene.paint.Color;

/**
 * Interface containing all the logic of a Pump extended by Buildable.
 * @author Alessandro Mami
 *
 */
public interface Fuel {
    
    /**
     * Gets the name of a fuel.
     * @return String of fuel's name.
     */
    String getName();
    
    /**
     * Gives the name to a fuel.
     * @param String of fuel's name.
     */
    void setName(String name);
    
    /**
     * Gets the price of a fuel.
     * @return Integer of fuel's price.
     */
    int getPrice();
    
    /**
     * Sets the fuel's price of a pump.
     * @param Integer of fuel's price.
     */
    void setPrice(int price);
    
    /**
     * Gets the whole sale price of a fuel.
     * @return Integer of fuel's wholeSalePrice.
     */
    int getWholeSalePrice();
    
    /**
     * Sets the whole sale price of a fuel.
     * @param Integer of fuel's wholeSalePrice.
     */
    void setWholeSalePrice(int wholeSalePrice);
    
    /**
     * Gets the color of a fuel.
     * @return Object of color's type.
     */
    Color getColor();
    
    /**
     * Sets the color of a fuel.
     * @param Object of color's type.
     */
    void setColor(Color color);
}

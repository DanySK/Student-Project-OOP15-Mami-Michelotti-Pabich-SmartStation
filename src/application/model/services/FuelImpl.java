package application.model.services;

import javafx.scene.paint.*;

/**
 * Implements the Fuel interface.
 * @author Alessandro Mami
 * 
 */
public class FuelImpl implements Fuel{
    
    /** 
     * Pump's attributes declaration.
     */
    private String name;
    private int price;
    private int wholeSalePrice;
    private Color color;
    
    /**
     * Constructor for the FuelImpl that creates every fuel.
     * @param String of fuel's name.
     * @param Integer of fuel's price.
     * @param Integer of fuel's whole sale price.
     * @param Object of color's type.
     */
    public FuelImpl(final String name, final int price, final int wholeSalePrice, final Color color) {
        this.name = name;
        this.price = price;
        this.wholeSalePrice = wholeSalePrice;
        this.color = color;
    }
    
    //GETTERS AND SETTERS OF MAIN ATTRIBUTES
    @Override
    public String getName() {
    	return this.name;
    }
    
    @Override
    public void setName(String name) {
    	this.name = name;	
    }
    
    @Override
    public int getPrice() {
    	return this.price;
    }
    
    @Override
    public void setPrice(int price) {
    	this.price = price;
    }
    
    @Override
    public int getWholeSalePrice() {
    	return this.wholeSalePrice;
    }
    
    @Override
    public void setWholeSalePrice(int wholeSalePrice) {
    	this.wholeSalePrice = wholeSalePrice;	
    }
    
    @Override
    public Color getColor() {
    	return this.color;
    }
    
    @Override
    public void setColor(Color color) {
    	this.color = color;		
    }
}

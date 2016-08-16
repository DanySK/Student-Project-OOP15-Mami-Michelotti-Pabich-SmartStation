package application.model.services;

import javafx.scene.paint.*;

public class FuelImpl implements Fuel{
	
    private String name;
    private int price;
    private int wholeSalePrice;
    private Color color;
    
    public FuelImpl(final String name, final int price, final int wholeSalePrice, final Color color) {
        this.name = name;
        this.price = price;
        this.wholeSalePrice = wholeSalePrice;
        this.color = color;
    }

    @Override
    public String getName() {
    	return this.name;
    }
    
    @Override
    public void setName(final String name) {
    	this.name = name;	
    }
    
    @Override
    public int getPrice() {
    	return this.price;
    }
    
    @Override
    public void setPrice(final int price) {
    	this.price = price;
    }
    
    @Override
    public int getWholeSalePrice() {
    	return this.wholeSalePrice;
    }
    
    @Override
    public void setWholeSalePrice(final int wholeSalePrice) {
    	this.wholeSalePrice = wholeSalePrice;	
    }
    
    @Override
    public Color getColor() {
    	return this.color;
    }
    
    @Override
    public void setColor(final Color color) {
    	this.color = color;		
    }
}

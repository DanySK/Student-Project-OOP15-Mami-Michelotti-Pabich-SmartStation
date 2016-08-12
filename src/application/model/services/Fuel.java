package application.model.services;

import javafx.scene.paint.Color;

public interface Fuel {
	
    String getName();
	
    void setName(final String name);
	
    int getPrice();
    	
    void setPrice(final int price);
    	
    int getWholeSalePrice();
    	
    void setWholeSalePrice(final int wholeSalePrice);
    	
    Color getColor();
    	
    void setColor(final Color color);
}

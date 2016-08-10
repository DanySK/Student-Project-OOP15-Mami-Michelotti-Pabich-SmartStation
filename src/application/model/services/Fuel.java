package application.model.services;

import javafx.scene.paint.Color;

public interface Fuel {
	
    String getName();
	
    void setName(String name);
	
	int getPrice();
	
	void setPrice(int price);
	
	int getWholeSalePrice();
	
	void setWholeSalePrice(int wholeSalePrice);
	
	Color getColor();
	
	void setColor(Color color);
}

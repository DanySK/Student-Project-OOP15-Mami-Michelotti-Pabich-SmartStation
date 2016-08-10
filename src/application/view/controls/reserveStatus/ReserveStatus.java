package application.view.controls.reserveStatus;

import javax.xml.parsers.DocumentBuilder;

/**
 * Interface that contain all methods needed to manage a ReserveStatus.
 * @author Marcin Pabich
 */
public interface ReserveStatus {
	
    /**
     * Get the remaining reserve quantity.
     * @return reserve quantity
     */
    Double getReserve();

    /**
     * Set the remaining reserve quantity.
     * @param value the quantity to set
     */
    void setReserve(Double value);
    
    /**
     * Get the fuel name.
     * @return the fuel name
     */
    String getFuelName();
    
    /**
     * Set the fuel name.
     * @param name the nam of the fuel
     */
    void setFuelName(String name);
    
    /**
     * Set the price of fuel.
     * @param value price of fule
     */
    void setPrice(Double value);
    
    /**
     * Get the price of fuel.
     * @return the price of fuel
     */
    Double getPrice();
    
}

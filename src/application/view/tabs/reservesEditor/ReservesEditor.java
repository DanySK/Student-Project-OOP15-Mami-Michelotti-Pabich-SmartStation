package application.view.tabs.reservesEditor;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;

import application.controller.tabs.ReservesEditorCtrl;

/**
 * Interface containing all the logic for the Reserves Editor tab.
 * @author Marcin Pabich
 *
 */
public interface ReservesEditor {

    /**
     * Set the controller for the class.
     * @param controller the controller for the class
     */
    void setController(ReservesEditorCtrl controller);
    
    
    
    //LOADING METHODS
    
    /**
     * Load avaiable reserves into the comboboxes.
     * @param reserves List of strings that represents avaiable reserves
     */
    void loadReserves(List<String> reserves);
    
    /**
     * Load avaiable fuels into the comboboxes.
     * @param fuels List of strings that represents avaiable fuels
     */
    void loadFuels(List<String > fuels);
    
    
    
    
    //GETTERS AND SETTERS FOR MODIFYING
    
    /**
     * Get te vaule of the selected reserve.
     * @return String containing the value
     */
    String getModifyReserve();
    
    /**
     * Get te vaule of the fuel textfield.
     * @return String containing the value
     */
    String getModifyFuel();
    
    /**
     * Set the value of the fuel textfield.
     * @param fuel String containing the value
     */
    void setModifyFuel(String fuel);
    
    /**
     * Get te vaule of the capacity textfield.
     * @return String containing the value
     */
    String getModifyCapacity();
    
    /**
     * Set the value of the capaciy textfield.
     * @param capacity String containing the value
     */
    void setModifyCapacity(String capacity);
    
    /**
     * Get te vaule of the price textfield.
     * @return String containing the value
     */
    String getModifyPrice();
    
    /**
     * Set the value of the price textfield.
     * @param price String containing the value
     */
    void setModifyPrice(String price);
    
    /**
     * Get the value of the durability textfield.
     * @return String containing the value
     */
    String getModifyDurability();
    
    /**
     * Set the value of the durability textfield.
     * @param durability String containing the value
     */
    void setModifyDurability(String durability);
    
    /**
     * Get the value of the repair cost textfield.
     * @return String containing the value
     */
    String getModifyRepairCost();
    
    /**
     * Set the value of the repair cost textfield.
     * @param repairCost String containing the value
     */
    void setModifyRepairCost(String repairCost);
    
    
    
    //REFILL METHODS
    
    /**
     * Get the refill value of the textfield.
     * @return String that represent the value
     */
    String getRefill();
    
    
    //REPAIR METHODS
    
    /**
     * Get the repair value of the slider.
     * @return Double from 0 to 100 that represents the value
     */
    Double getRepairValue();
    
    /**
     * Set the current selected value of repairing.
     * @param value String that represent the value of the slider.
     */
    void setRepairValue(String value);
    
}

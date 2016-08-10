package application.view.tabs.fuelsEditor;

import java.util.List;

import application.controller.tabs.FuelsEditorCtrl;

/**
 * Interface containing all the logic for the Fuels Editor tab.
 * @author Marcin Pabich
 *
 */
public interface FuelsEditor {

    /**
     * Set the controller for the view.
     * @param controller the controller
     */
    void setController(FuelsEditorCtrl controller);
    
    /**
     * Load the fuels in the combobox, clearing previous values.
     * @param fuels List of string describing avaiable fuels
     */
    void loadFuels(List<String> fuels);
    
    /**
     * Get the actual selected fuel.
     * @return String that represent the fuel selected
     */
    String getSelectedFuel();
    
    /**
     * Get the modified fuel name.
     * @return String that represent the name
     */
    String getModifyName();
    
    /**
     * Set the content of the name textfield.
     * @param name String that will be show in the textfield
     */
    void setModifyName(String name);
    
    /**
     * Get the modified fuel price.
     * @return String that represent the price
     */
    String getModifyPrice();
    
    /**
     * Set the content of the price textfield.
     * @param price String that will be show in the textfield
     */
    void setModifyPrice(String price);
    
    /**
     * Get the modified fuel whoesale price.
     * @return String that represent the whoesale price
     */
    String getModifyWhoesalePrice();
    
    /**
     * Set the content of the whoesale price textfield.
     * @param wprice String that will be show in the textfield
     */
    void setModifyWhoesalePrice(String wprice);
    
    /**
     * Get the modified color of the fuel.
     * @return String that represent the color
     */
    String getModifyColor();
    
    /**
     * Set the content of the color textfield.
     * @param color String that will be show in the textfield
     */
    void setModifyColor(String color);
    
    /**
     * Set the modifying panel visibility.
     * @param visibility TRUE if it must be visible, FALSE otherwise
     */
    void setModifyPanelVisibility(boolean visibility);
    
    
    
    /**
     * Get the fuel name.
     * @return String that represent the name
     */
    String getFuelName();
    
    /**
     * Get the fuel price.
     * @return String that represent the price
     */
    String getFuelPrice();
    
    /**
     * Get the fuel whoesale price.
     * @return String that represent the whoesale price
     */
    String getFuelWhoesalePrice();
    
    /**
     * Get the color of the fuel.
     * @return String that represent the color
     */
    String getFuelColor();
    
}

package application.view.tabs.stationEditor;

import java.util.List;

import application.controller.tabs.StationEditorCtrl;
import application.model.buildables.area.Area;
import application.model.buildables.pump.Pump;

/**
 * Interface containing all the logic for the Station Editor tab.
 * @author Marcin Pabich
 *
 */
public interface StationEditor {

    
    //Controller
    /**
     * Set the controller for the class.
     * @param controller the controller for the class
     */
    void setController(StationEditorCtrl controller);
    
    
    //Loading and refreshing
    /**
     * Fill the comboboxes with selectible coordinates.
     * @param x Max X coordinate (0-based)
     * @param y Max Y coordinate (0-based)
     */
    void loadCoordinates(int x, int y);
    
    /**
     * Load avaiable pumps into the view.
     * @param pumps List of avaiable pumps
     */
    void loadPumps(List<Pump> pumps);
    
    /**
     * Redraw the grid with areas.
     * @param areas List of updated areas
     */
    void refreshGrid(List<Area> areas);
    
    
    
    //Disable / Enable views
    /**
     * Show the panel that permit to modifying areas.
     */
    void showModifyngPanel();  
    
    /**
     * Show details panel if selections was ok.
     */
    void showDetailsPanel();
    
    /**
     * Show details panel if selections wasn't ok.
     */
    void hideDetailsPanel();    
    
    /**
     * Show a panel that permit to add new areas.
     */
    void showAddingPanel();
    
   
    
    /**
     * Tell if the adding panel is visible.
     * @return TRUE if it's visible, FALSE otherwise
     */
    boolean isAddingPanelVisible();
    
    /**
     * Tell if the modifying panel is visible.
     * @return TRUE if it's visible, FALSE otherwise
     */
    boolean isModifyingPanelVisible();
    
    /**
     * Tell if the details panel is visible.
     * @return TRUE if it's visible, FALSE otherwise
     */
    boolean isDetailsPanelVisible();
    
    
   
    //Adding new AREA
    /**
     * Get the X coordinate of a new area.
     * @return X coordinate of a new area.
     */
    String getXCoords();
    
    /**
     * Get the Y coordinate of a new area.
     * @return Y coordinate of a new area.
     */
    String getYCoords();
    
    
    /**
     * Get the price of a new area.
     * @return price of a new area.
     */
    String getPrice();
    
    
    /**
     * Get the pumps of a new area.
     * @return pumps of a new area.
     */
    List<String> getPumps();
    
    
    
    //Modifying an AREA
    /**
     * Get the X coordinate of selected area.
     * @return X coordinate of selected area
     */
    String getModifyX();
    
    /**
     * Get the Y coordinate of selected area.
     * @return Y coordinate of selected area
     */
    String getModifyY();
    
    /**
     * Get the cost of selected area.
     * @return cost of selected area
     */
    String getModifyCost();
    
    /**
     * Set the content of cost textfield.
     * @param cost cost to show
     */
    void setModifyCost(String cost);
    
    /**
     * Get the modifyied X of selected area.
     * @return modifyied X of selected area
     */
    String getModifyChangeX();
    
    /**
     * Set the content of X coordinate textfield.
     * @param x X coorinate yo show
     */
    void setModifyXChange(String x);
    
    /**
     * Get the modifyied Y of selected area.
     * @return modifyied Y of selected area
     */
    String getModifyChangeY();
    
    /**
     * Set the content of Y coordinate textfield.
     * @param y Y coorinate yo show
     */
    void setModifyYChange(String y);
    
    /**
     * Get the modifyied pumps of selected area.
     * @return modifyied pumps of selected area
     */
    List<String> getModifyPumps();
    
    /**
     * Set the modifyied pumps of selected area.
     * @param pumps modifyied pumps of selected area
     */
    void setModifyPumps(List<String> pumps);
    
    

    //Error messages
    /**
     * Allow to write an error message.
     * @param s string with the error message
     */
    void showAddErrorMessage(String s);
    
    /**
     * Allow to hide the error message.
     */
    void hideAddErrorMessage();
    
    /**
     * Allow to write an error message.
     * @param s string with the error message
     */
    void showModifyErrorMessage(String s);
    
    /**
     * Allow to hide the error message.
     */
    void hideModifyErrorMessage();
    
    /**
     * Allow to write an error during coords change.
     * @param s string with the error message
     */
    void showModifyCoordsMessage(String s);
    
    /**
     * Allow to hide the error message.
     */
    void hideModifyCoordsMessage();
    
    
}

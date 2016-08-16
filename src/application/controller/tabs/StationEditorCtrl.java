package application.controller.tabs;

import application.view.tabs.stationEditor.StationEditor;

/**
 * Interface that contains all methods needed to manage the station editor controller.
 * @author Matteo Michelotti
 */
public interface StationEditorCtrl {

    /**
     * Set the view of the controller.
     * @param stationEditor the view for the class
     */
    void setView(final StationEditor stationEditor);
    
    /**
     * Load the coordinates for areas.
     * @param x coordinate
     * @param y coordinate
     */
    void loadData(final int x, final int y);
    
    /**
     * Select the area and load data.
     */
    void selectionConfirm();
    
    /**
     * Change the price of area.
     */
    void changePrice();
    
    /**
     * Change the position of area.
     */
    void changePosition();
    
    /**
     * Confirm the change of pumps of the area.
     */
    void confirmPumps();
    
    /**
     * Create new area.
     */
    void insertArea();
    
    /**
     * Delete the area selected.
     */
    void removeArea();
    
    /**
     * Switch between add and modify panel.
     */
    void switchPanel();
}

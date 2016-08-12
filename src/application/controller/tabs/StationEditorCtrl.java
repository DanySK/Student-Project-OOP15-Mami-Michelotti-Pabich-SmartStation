package application.controller.tabs;

import application.view.tabs.stationEditor.StationEditor;
import javafx.scene.input.MouseEvent;

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
     * @param e mouse event
     */
    void btnOK_click(final MouseEvent e);
    
    /**
     * Change the price of area.
     * @param e mouse event
     */
    void btnChangePrice_click(final MouseEvent e);
    
    /**
     * Change the position of area.
     * @param e mouse event
     */
    void btnChangePosition_click(final MouseEvent e);
    
    /**
     * Confirm the change of pumps of the area.
     * @param e mouse event
     */
    void btnConfirmPumps_click(final MouseEvent e);
    
    /**
     * Remove the pump selected?.
     * @param e mouse event
     */
    void btnRemoveSelected_click(final MouseEvent e);
    
    /**
     * Add pump at area selected.
     * @param e mouse event
     */
    void btnAddPump_click(final MouseEvent e);
    
    /**
     * Delete the area selected.
     * @param e mouse event
     */
    void btnRemoveArea_click(final MouseEvent e);
    
    /**
     * Switch between add and modify panel.
     * @param e mouse event
     */
    void btnSwitch_click(final MouseEvent e);
}

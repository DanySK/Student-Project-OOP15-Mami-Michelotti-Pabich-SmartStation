package application.controller.tabs;

import application.view.tabs.reservesEditor.ReservesEditor;
import javafx.scene.input.MouseEvent;

/**
 * Interface that contain all methods needed to manage the reserves editor controller.
 * @author Matteo Michelotti
 */
public interface ReservesEditorCtrl {

    /**
     * Set the view of the controller.
     * @param reservesEditor the view for the class
     */
    void setView(final ReservesEditor reservesEditor);
    
    /**
     * Selected the reserve for modify dates.
     * @param e mouse event
     */
    void btnSelectEdit_click (MouseEvent e);
    
    /**
     * Change the type of reserve selected.
     * @param e mouse event
     */
    void btnChangeFuelType_click (MouseEvent e);
    
    /**
     * Change the capacity of reserve selected.
     * @param e mouse event
     */
    void btnChangeCapacity_click (MouseEvent e);
    
    /**
     * Change the repair cost of reserve selected.
     * @param e mouse event
     */
    void btnChangeRepairCost_click (MouseEvent e);
    
    /**
     * Change the cost of reserve selected.
     * @param e mouse event
     */
    void btnChangePrice_click (MouseEvent e);
    
    /**
     * Change the durability of reserve selected.
     * @param e mouse event
     */
    void btnChangeDurability_click (MouseEvent e);
    
    /**
     * Select the reserve for refill.
     * @param e mouse event
     */
    void btnSelectRefill_click (MouseEvent e);
    
    /**
     * Refill the quantity selected for reserve select.
     * @param e mouse event
     */
    void btnRefill_click (MouseEvent e);
    
    /**
     * Select the reserve for repair.
     * @param e mouse event
     */
    void btnSelectRepair_click (MouseEvent e);
    
    /**
     * Repair the quantity selected for reserve select.
     * @param e mouse event
     */
    void btnRepair_click (MouseEvent e);
    
    /**
     * Add new reserve for the station.
     * @param e mouse event
     */
    void btnAddReserve_click (MouseEvent e);
}

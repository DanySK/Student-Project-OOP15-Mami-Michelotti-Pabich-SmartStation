package application.controller.tabs;

import application.view.tabs.pumpsEditor.PumpsEditor;
import javafx.scene.input.MouseEvent;

/**
 * Interface that contain all methods needed to manage the pump editor controller.
 * @author Matteo Michelotti
 */
public interface PumpsEditorCtrl {

    /**
     * Set the view of the controller.
     * @param pumpsEditor the view for the class
     */
    void setView(final PumpsEditor pumpsEditor);
    
    /**
     * Select the pump for modify character. 
     * @param e mouse event
     */
    void btnSelectEdit_click(final MouseEvent e);
    
    /**
     * Change the name of pump selected.
     * @param e mouse event
     */
    void btnChangePumpName_click(final MouseEvent e);
    
    /**
     * Change the speed of pump selected.
     * @param e mouse event
     */
    void btnChangeSpeed_click(final MouseEvent e);
    
    /**
     * Change the durability of pump selected.
     * @param e mouse event
     */
    void btnChangeDurability_click(final MouseEvent e);
    
    /**
     * Change the cost of pump selected.
     * @param e mouse event
     */
    void btnChangePrice_click(final MouseEvent e);
    
    /**
     * Change the repair cost of pump selected.
     * @param e mouse event
     */
    void btnChangeRepairCost_click(final MouseEvent e);
    
    /**
     * Selected the pump for repair.
     * @param e mouse event
     */
    void btnSelectRepair_click(final MouseEvent e);
    
    /**
     * Repair the pump selected.
     * @param e mouse event
     */
    void btnRepair_click(final MouseEvent e);
    
    /**
     * Create new pump.
     * @param e mouse event
     */
    void btnAddPump_click(final MouseEvent e);
}

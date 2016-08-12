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
    
    //MODIFYING EVENT HANDLERS
    void btnSelectEdit_click (MouseEvent e);
    
    void btnChangeFuelType_click (MouseEvent e);
    
    void btnChangeCapacity_click (MouseEvent e);
    
    void btnChangeRepairCost_click (MouseEvent e);
        
    void btnChangePrice_click (MouseEvent e);
    
    void btnChangeDurability_click (MouseEvent e);
    

    //REFILL EVENT HANDLERS
    void btnSelectRefill_click (MouseEvent e);
    
    void btnRefill_click (MouseEvent e);
    
    
    //REPAIR EVENT HANDLERS
    void btnSelectRepair_click (MouseEvent e);
    
    void btnRepair_click (MouseEvent e);
    
    
    //ADDING EVENT HANDLERS
    void btnAddReserve_click (MouseEvent e);
}

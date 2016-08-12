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
    
    void btnSelectEdit_click(final MouseEvent e);
    
    void btnChangePumpName_click(final MouseEvent e);
    
    void btnChangeSpeed_click(final MouseEvent e);
    
    void btnChangeDurability_click(final MouseEvent e);
    
    void btnChangePrice_click(final MouseEvent e);
    
    void btnChangeRepairCost_click(final MouseEvent e);
    
    void btnSelectRepair_click(final MouseEvent e);
    
    void btnRepair_click(final MouseEvent e);
    
    void btnAddPump_click(final MouseEvent e);
}

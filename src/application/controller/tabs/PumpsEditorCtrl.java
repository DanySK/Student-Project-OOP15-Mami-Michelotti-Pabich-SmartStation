package application.controller.tabs;

import java.util.List;
import application.model.buildables.pump.Pump;
import application.model.services.Fuel;
import application.view.tabs.pumpsEditor.PumpsEditor;

/**
 * Interface that contain all methods needed to manage the pump editor controller.
 * @author Matteo Michelotti
 */
public interface PumpsEditorCtrl {

    /**
     * Set the view of the controller.
     */
    void setView(final PumpsEditor pumpsEditor);
    
    /**
     * Load configuration for pump editor tab.
     * @param fuels list of fuel
     * @param pumps list of pump
     */
    void loadData(final List<Fuel> fuels, final List<Pump> pumps);
    
    /**
     * Select the pump for modify character.
     */
    void selectEdit();
    
    /**
     * Change the name of pump selected.
     */
    void changePumpName();
    
    /**
     * Change the speed of pump selected.
     */
    void changeSpeed();
    
    /**
     * Change the durability of pump selected.
     */
    void changeDurability();
    
    /**
     * Change the cost of pump selected.
     */
    void changePrice();
    
    /**
     * Change the repair cost of pump selected.
     */
    void changeRepairCost();
    
    /**
     * Selected the pump for repair.
     */
    void selectRepair();
    
    /**
     * Repair the pump selected.
     */
    void repair();
    
    /**
     * Create new pump.
     */
    void addPump();
}

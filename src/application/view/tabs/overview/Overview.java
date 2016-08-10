package application.view.tabs.overview;

import java.util.List;

import application.controller.tabs.OverviewCtrl;
import application.model.buildables.area.Area;

/**
 * Interface that contains all methods to correct use of the overview tab.
 * @author Marcin Pabich
 */
public interface Overview {

    /**
     * Set the controller for the overview TAB.
     * @param controller - an OverviewCtrl object that will be the controller of this tab
     */
    void setController(OverviewCtrl controller);
	
    /** 
     * Add a fuel to the overview.
     * @param name - the name of the fuel
     * @param price - price at one unity
     * @param reserve - remaining fuel on reserve
     */
    void addReserveStatus(String name, Double price, Double reserve);
    
    /**
     * Remove all the reserves from the bar.
     */
    void removeReserves();
    
    
    /**
     * Redraw the grid with areas.
     * @param areas List of updated areas
     */
    void refreshGrid(List<Area> areas);
    
}

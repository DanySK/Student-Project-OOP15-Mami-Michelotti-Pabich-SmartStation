package application.controller.tabs;

import application.view.tabs.overview.Overview;

/**
 * Interface that contains all methods needed to manage overview controller.
 * @author Matteo Michelotti
 */
public interface OverviewCtrl {

    /**
     * Set the view of the controller.
     * @param overview the view for the class
     */
    void setView(final Overview overview);
}

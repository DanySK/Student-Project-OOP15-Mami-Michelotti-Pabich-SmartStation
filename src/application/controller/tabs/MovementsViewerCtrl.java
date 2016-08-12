package application.controller.tabs;

import application.view.tabs.movementsViewer.MovementsViewer;

/**
 * Interface that contain all methods needed to manage the movements viewer controller.
 * @author Matteo Michelotti
 */
public interface MovementsViewerCtrl {

    /**
     * Set the view of the controller.
     * @param movementsViewer the view for the class
     */
    void setView (final MovementsViewer movementsViewer);
}

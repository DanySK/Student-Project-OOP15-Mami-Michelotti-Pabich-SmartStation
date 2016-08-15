package application.controller.tabs;

import application.controller.MainController;
import application.view.tabs.movementsViewer.MovementsViewer;

public class MovementsViewerCtrlImpl implements MovementsViewerCtrl {

    private final MainController mainController;
    private MovementsViewer movementsViewer;
    
    public MovementsViewerCtrlImpl(MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(MovementsViewer movementsViewer) {
	this.movementsViewer = movementsViewer;
    }
}

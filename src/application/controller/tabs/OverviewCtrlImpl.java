package application.controller.tabs;

import application.controller.MainController;
import application.view.tabs.overview.Overview;

public class OverviewCtrlImpl implements OverviewCtrl {

    private final MainController mainController;
    private Overview overview;
    
    public OverviewCtrlImpl(MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(Overview overview) {
	this.overview = overview;
    }
}

package application.controller.tabs;

import java.util.List;
import application.controller.MainController;
import application.model.buildables.area.Area;
import application.model.buildables.reserve.Reserve;
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

    @Override
    public void loadData(final List<Area> areas) {
	this.overview.refreshGrid(areas);
	
	for(Reserve r : this.mainController.getModel().getReserveManager().getAllReserves()) {
	    double progress = r.getRemaining() / r.getCapacity();
	    this.overview.addReserveStatus(r.getType().getName(), String.valueOf(r.getCost()),
		                           String.valueOf(r.getRemaining()), String.valueOf(r.getCapacity()), progress);
	}
    }
}

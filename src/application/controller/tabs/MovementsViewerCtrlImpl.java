package application.controller.tabs;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import application.controller.MainController;
import application.model.moneyManager.Movement;
import application.model.moneyManager.MovementType;
import application.view.tabs.movementsViewer.MovementsViewer;

public class MovementsViewerCtrlImpl implements MovementsViewerCtrl {

    private final MainController mainController;
    private MovementsViewer movementsViewer;
    
    /**
     * Initialize the reference of controller.
     * @param mainController reference of the main controller
     */
    public MovementsViewerCtrlImpl(final MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(final MovementsViewer movementsViewer) {
	this.movementsViewer = movementsViewer;
    }

    @Override
    public void loadData() {
	final List<String> filters = new ArrayList<>();
	filters.add("higher");
	filters.add("lower");
	filters.add("default");
	
	this.movementsViewer.loadFilters(filters);
	this.movementsViewer.setCurrentBalance(String.valueOf(this.mainController.getModel()
		                                                  .getMoneyManager().getActualBalance()));
    }

    @Override
    public void loadBalance() {
	this.mainController.getModel().getMoneyManager().getActualBalance();
    }

    @Override
    public void applyFilter() {
	if (this.movementsViewer.getFilter() == "defoult") {
	    for (Movement m : this.mainController.getModel().getMoneyManager().getAllMovements()) {
		this.movementsViewer.clearList();
		this.movementsViewer.addElementToList(m.getType().toString());
		this.movementsViewer.addElementToList(String.valueOf(m.getMoney()));
		this.movementsViewer.addElementToList(m.getDescription().toString());
	    }
	} else if (this.movementsViewer.getFilter() == "higher") {
	    List<Movement> list = new ArrayList<>();
	    list = this.orderAcrescing();
	    
	    for (Movement m : list) {
		this.movementsViewer.clearList();
		this.movementsViewer.addElementToList(m.getType().toString());
		this.movementsViewer.addElementToList(String.valueOf(m.getMoney()));
		this.movementsViewer.addElementToList(m.getDescription().toString());
	    }
	} else if (this.movementsViewer.getFilter() == "lower") {
	    List<Movement> list = new ArrayList<>();
	    list = this.orderAcrescing();
	    Collections.reverse(list);
	    
	    for (Movement m : list) {
		this.movementsViewer.clearList();
		this.movementsViewer.addElementToList(m.getType().toString());
		this.movementsViewer.addElementToList(String.valueOf(m.getMoney()));
		this.movementsViewer.addElementToList(m.getDescription().toString());
	    }
	} else {
	    this.movementsViewer.showInformationAlert("Error", "error of load", "Select the filter");
	}
    }

    @Override
    public void addMovement() {
	if (this.movementsViewer.getDescription() != "" && this.movementsViewer.getMoney() != "") {
	    this.mainController.getModel().getMoneyManager()
	                                  .addMovement(MovementType.valueOf(this.movementsViewer.getDescription()),
	                                	       Integer.parseInt(this.movementsViewer.getMoney()),
	                                	       "Adding movimente");
	    this.mainController.getModel().getMoneyManager().getActualBalance();
	} else {
	    this.movementsViewer.showInformationAlert("Error", "error of load", "Complete the moviment");
	}
    }

    private List<Movement> orderAcrescing() {
	final List<Movement> max = new ArrayList<>();
	max.addAll(this.mainController.getModel().getMoneyManager().getAllMovements());
	for (int i = 0; i < max.size() -1; i++) {
	    for (int j = 0; j < max.size() -1; j++) {
		if (max.get(i).getMoney() < max.get(j).getMoney()) {
		    Movement m = max.get(i);
		    max.add(i, max.get(j));
		    max.add(j, m);
		}
	    }
	}
	return max;
    }
}

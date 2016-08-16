package application.controller.tabs;

import java.util.ArrayList;
import java.util.List;
import application.controller.MainController;
import application.model.buildables.area.Area;
import application.model.buildables.pump.Pump;
import application.view.tabs.stationEditor.StationEditor;

public class StationEditorCtrlImpl implements StationEditorCtrl {

    private final MainController mainController;
    private StationEditor stationEditor;
    
    public StationEditorCtrlImpl(MainController mainController) {
        this.mainController = mainController;
    }
    
    @Override
    public void setView(StationEditor stationEditor) {
        this.stationEditor = stationEditor;
    }
    
    @Override
    public void loadData(final int x, final int y) {
	this.stationEditor.loadCoordinates(x, y);
    }
    
    @Override
    public void selectionConfirm() {
	final int x;
	final int y;
	if(this.stationEditor.getModifyX() != null && this.stationEditor.getModifyChangeY() != null) {
	    this.stationEditor.hideModifyErrorMessage();
	    x = Integer.parseInt(this.stationEditor.getModifyX());
	    y = Integer.parseInt(this.stationEditor.getModifyY());
	    
	    if(this.mainController.getModel().getAreaManager().getArea(x, y) != null) {
		this.stationEditor.hideModifyErrorMessage();
		this.stationEditor.showModifyngPanel();
		
		final List<String> list = new ArrayList<>();
		for(Pump p : this.mainController.getModel().getAreaManager().getArea(x, y).getAllPumps()) {
		    list.add(p.getName());
		}
		this.stationEditor.setModifyCost(String.valueOf(this.mainController.getModel().getAreaManager().getArea(x, y).getCost()));
		this.stationEditor.setModifyXChange(String.valueOf(this.mainController.getModel().getAreaManager().getArea(x, y).getXPosition()));
		this.stationEditor.setModifyYChange(String.valueOf(this.mainController.getModel().getAreaManager().getArea(x, y).getYPosition()));
		this.stationEditor.setModifyPumps(list);
	    } else {
		this.stationEditor.showModifyErrorMessage("Area not found");
		this.stationEditor.hideModifyingPanel();
	    }
	} else {
	    this.stationEditor.showModifyErrorMessage("Select area");
	}
    }

    @Override
    public void changePosition() {
	final int tempx = Integer.parseInt(this.stationEditor.getModifyChangeX());
	final int tempy = Integer.parseInt(this.stationEditor.getModifyChangeY());
	
	if(this.mainController.getModel().getAreaManager().getArea(Integer.parseInt(this.stationEditor.getModifyX()),
			                                           Integer.parseInt(this.stationEditor.getModifyY())) == null) {
	    this.stationEditor.hideModifyCoordsMessage();
	    this.mainController.getModel().getAreaManager()
	                                  .getArea(Integer.parseInt(this.stationEditor.getModifyX()),
		                                   Integer.parseInt(this.stationEditor.getModifyY()))
	                                  .setPosition(tempx, tempy);
	} else {
	    this.stationEditor.showModifyCoordsMessage("Area arleady occupied");
	}
    }

    @Override
    public void confirmPumps() {
	 /*this.mainController.getModel().getAreaManager().getArea(Integer.parseInt(this.stationEditor.getModifyX()),
                                                                 Integer.parseInt(this.stationEditor.getModifyY()))
	                                                .getAllPumps(this.stationEditor.getModifyPumps());*/
    }

    @Override
    public void insertArea() {
	final int x, y;
	final List<String> list = new ArrayList<>();
	boolean occupation = false;
	x = Integer.parseInt(this.stationEditor.getXCoords());
	y = Integer.parseInt(this.stationEditor.getYCoords());
	list.addAll(this.stationEditor.getPumps());
	
	//this.stationEditor.getPrice();
	
	for(Area a : this.mainController.getModel().getAreaManager().getAllAreas()) {
	    if(a.getXPosition() == x && a.getYPosition() == y) {
		occupation = true;
	    } else if(occupation) {
		this.stationEditor.showAddErrorMessage("Area arleady occupied");
		break;
	    } else {
		//this.mainController.getModel().getAreaManager().addArea(x, y, list);
		break;
	    }
	}
    }

    @Override
    public void removeArea() {
	this.mainController.getModel().getAreaManager().removeArea(Integer.parseInt(this.stationEditor.getModifyX()),
		                                                   Integer.parseInt(this.stationEditor.getModifyY()));
    }

    @Override
    public void switchPanel() {
        if (this.stationEditor.isAddingPanelVisible()) {
            this.stationEditor.showModifyngPanel();
            this.stationEditor.changeButtonText("Switch to add panel");
        } else {
            this.stationEditor.showAddingPanel();
            this.stationEditor.changeButtonText("Switch to modify panel");
        }
    }
}

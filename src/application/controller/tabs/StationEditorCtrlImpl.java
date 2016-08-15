package application.controller.tabs;

import java.util.ArrayList;
import java.util.List;
import application.controller.MainController;
import application.model.buildables.area.Area;
import application.model.buildables.area.AreaImpl;
import application.model.buildables.pump.Pump;
import application.view.tabs.stationEditor.StationEditor;

public class StationEditorCtrlImpl implements StationEditorCtrl {

    private final MainController mainController;
    private StationEditor stationEditor;
    private Area area;
    
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
	if(this.stationEditor.getModifyX() != null && this.stationEditor.getModifyChangeY() != null) {
	    this.stationEditor.hideModifyErrorMessage();
	    final int x = Integer.parseInt(this.stationEditor.getModifyX());
	    final int y = Integer.parseInt(this.stationEditor.getModifyY());
	    
	    this.area = this.mainController.getModel().getAreaManager().getArea(x,y);
	} else {
	    this.stationEditor.showModifyErrorMessage("Select area");
	}
	
	if(this.area != null) {
	    this.stationEditor.hideModifyErrorMessage();
	    this.stationEditor.showModifyngPanel();
	    
	    final List<String> list = new ArrayList<>();
	    final List<Pump> pList = new ArrayList<>();
	    pList.addAll(this.area.getAllPumps());
	    for(Pump p : pList) {
		list.add(p.getName());
	    }
	    this.stationEditor.showModifyngPanel();
	    this.stationEditor.setModifyCost(String.valueOf(this.area.getCost()));
	    this.stationEditor.setModifyXChange(String.valueOf(this.area.getXPosition()));
	    this.stationEditor.setModifyYChange(String.valueOf(this.area.getYPosition()));
	    this.stationEditor.setModifyPumps(list);
	} else {
	    this.stationEditor.showModifyErrorMessage("Area not found");
	    this.stationEditor.hideModifyingPanel();
	}
    }

    @Override
    public void changePrice() {
	this.area.setCost(Integer.parseInt(this.stationEditor.getPrice()));
    }

    @Override
    public void changePosition() {
	final int tempx = Integer.parseInt(this.stationEditor.getModifyChangeX());
	final int tempy = Integer.parseInt(this.stationEditor.getModifyChangeY());
	
	if(this.area == null) {
	    this.stationEditor.hideModifyCoordsMessage();
	    this.area.setPosition(tempx, tempy);
	} else {
	    this.stationEditor.showModifyCoordsMessage("Area arleady occupied");
	}
    }

    @Override
    public void confirmPumps() {
	final List<String> list = new ArrayList<>();
	list.addAll(this.stationEditor.getModifyPumps());
	
	for(int i = 0; i < list.size(); i++) {
	    this.area.getAllPumps().get(i).setName(list.get(i));
	}
    }

    @Override
    public void pump() {
	final int x, y;
	x = Integer.parseInt(this.stationEditor.getXCoords());
	y = Integer.parseInt(this.stationEditor.getYCoords());
	final Area a = new AreaImpl(0, Integer.parseInt(this.stationEditor.getPrice()), 0, x, y);
	
	this.mainController.getModel().getAreaManager().addArea(a);
	
    }

    @Override
    public void removeArea() {
	this.mainController.getModel().getAreaManager().removeArea(this.area);
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

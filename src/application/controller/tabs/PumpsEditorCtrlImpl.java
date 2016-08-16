package application.controller.tabs;

import java.util.List;

import application.controller.MainController;
import application.model.buildables.pump.Pump;
import application.model.services.Fuel;
import application.view.tabs.pumpsEditor.PumpsEditor;

public class PumpsEditorCtrlImpl implements PumpsEditorCtrl {

    private final MainController mainController;
    private PumpsEditor pumpsEditor;
    
    public PumpsEditorCtrlImpl(MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(PumpsEditor pumpsEditor) {
	this.pumpsEditor = pumpsEditor;
    }

    @Override
    public void loadData(final List<Fuel> fuels, final List<Pump> pumps) {
	this.pumpsEditor.loadFuels(fuels);
	this.pumpsEditor.loadPumps(pumps);
    }

    @Override
    public void selectEdit() {
	for(Pump p : this.mainController.getModel().getPumpManager().getAllPumps()) {
	    if(p.getName() == this.pumpsEditor.getModifySelectedPump()) {
		this.pumpsEditor.setModifyFuelType(p.getName());
		this.pumpsEditor.setModifySpeed(String.valueOf(p.getSpeed()));
		this.pumpsEditor.setModifyDurability(String.valueOf(p.getDurability()));
		this.pumpsEditor.setModifyPrice(String.valueOf(p.getCost()));
		this.pumpsEditor.setModifyRepairCost(String.valueOf(p.getRepairCost()));
	    }
	}
    }

    @Override
    public void changePumpName() {
	this.mainController.getModel().getPumpManager().getPumpByName(this.pumpsEditor.getModifySelectedPump())
	                                               .setName(this.pumpsEditor.getModifyFuelType());
    }

    @Override
    public void changeSpeed() {
	this.mainController.getModel().getPumpManager().getPumpByName(this.pumpsEditor.getModifySelectedPump())
	                                               .setSpeed(Integer.parseInt(this.pumpsEditor.getModifySpeed()));
    }

    @Override
    public void changeDurability() {
	this.mainController.getModel().getPumpManager().getPumpByName(this.pumpsEditor.getModifySelectedPump())
	                                               .setMaxDurability(Integer.parseInt(this.pumpsEditor.getModifyDurability()));
    }

    @Override
    public void changePrice() {
	this.mainController.getModel().getPumpManager().getPumpByName(this.pumpsEditor.getModifySelectedPump())
	                                               .setCost(Integer.parseInt(this.pumpsEditor.getModifyPrice()));
    }

    @Override
    public void changeRepairCost() {
	this.mainController.getModel().getPumpManager().getPumpByName(this.pumpsEditor.getModifySelectedPump())
	                                               .setRepairCost(Integer.parseInt(this.pumpsEditor.getModifyRepairCost()));
    }

    @Override
    public void selectRepair() {
	for(Pump p : this.mainController.getModel().getPumpManager().getAllPumps()) {
	    if(p.getName() == "// manca metodo per prendere il nome") {
		this.pumpsEditor.setRepairValue(String.valueOf(p.getDurability()));
	    }
	}
    }

    @Override
    public void repair() {
	
    }

    @Override
    public void addPump() {
	/*this.mainController.getModel().getPumpManager().addPump(this.pumpsEditor.getFuelType(),
		Integer.parseInt(this.pumpsEditor.getSpeed()), Integer.parseInt(this.pumpsEditor.getDurability()),
		Integer.parseInt(this.pumpsEditor.getPrice()), Integer.parseInt(this.pumpsEditor.getRepairCost()));*/
    }
}

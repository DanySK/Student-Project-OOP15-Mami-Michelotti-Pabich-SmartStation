package application.controller.tabs;

import java.util.ArrayList;
import java.util.List;
import application.controller.MainController;
import application.model.buildables.pump.Pump;
import application.model.buildables.pump.PumpImpl;
import application.model.services.FuelManager;
import application.model.services.FuelManagerImpl;
import application.view.tabs.pumpsEditor.PumpsEditor;
import javafx.scene.input.MouseEvent;

public class PumpsEditorCtrlImpl implements PumpsEditorCtrl {

    private final MainController mainController;
    private PumpsEditor pumpsEditor;
    private List<Pump> pumps;
    private int i;
    
    public PumpsEditorCtrlImpl(MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(PumpsEditor pumpsEditor) {
	this.pumpsEditor = pumpsEditor;
    }

    @Override
    public void btnSelectEdit_click(MouseEvent e) {
	//
	//
	for(int i = 0; i < this.pumps.size(); i++) {
	    if(this.pumps.get(i).getName() == this.pumpsEditor.getModifySelectedPump()) {
		this.i = i;
		this.pumpsEditor.setModifyFuelType(this.mainController.getModel().getFuelManager().getFuel(this.pumpsEditor.getModifySelectedPump()).getName());
		this.pumpsEditor.setModifySpeed(String.valueOf(this.pumps.get(i).getSpeed()));
		this.pumpsEditor.setModifyDurability(String.valueOf(this.pumps.get(i).getDurability()));
		this.pumpsEditor.setModifyPrice(String.valueOf(this.pumps.get(i).getCost()));
		this.pumpsEditor.setModifyRepairCost(String.valueOf(this.pumps.get(i).getRepairCost()));
	    }
	}
    }

    @Override
    public void btnChangePumpName_click(MouseEvent e) {
	this.mainController.getModel().getPumpManager().getPump(i).setName(this.pumpsEditor.getModifyFuelType());
    }

    @Override
    public void btnChangeSpeed_click(MouseEvent e) {
	this.mainController.getModel().getPumpManager().getPump(i).setSpeed(Integer.parseInt(this.pumpsEditor.getModifySpeed()));
    }

    @Override
    public void btnChangeDurability_click(MouseEvent e) {
	this.mainController.getModel().getPumpManager().getPump(i).setMaxDurability(Integer.parseInt(this.pumpsEditor.getModifyDurability()));
    }

    @Override
    public void btnChangePrice_click(MouseEvent e) {
	this.mainController.getModel().getPumpManager().getPump(i).setCost(Integer.parseInt(this.pumpsEditor.getModifyPrice()));
    }

    @Override
    public void btnChangeRepairCost_click(MouseEvent e) {
	this.mainController.getModel().getPumpManager().getPump(i).setRepairCost(Integer.parseInt(this.pumpsEditor.getModifyRepairCost()));
    }

    @Override
    public void btnSelectRepair_click(MouseEvent e) {
	//
	//
	for(int i = 0; i < this.pumps.size(); i++) {
	    if(this.pumps.get(i).getName() == String.valueOf(this.pumpsEditor.getRepairValue())) {
		this.i = i;
		this.pumpsEditor.setRepairValue(String.valueOf(this.pumps.get(i).getDurability()));
	    }
	}
    }

    @Override
    public void btnRepair_click(MouseEvent e) {
	this.mainController.getModel().getPumpManager().getPump(i).repair(this.pumpsEditor.getRepairValue());
    }

    @Override
    public void btnAddPump_click(MouseEvent e) {
	final Pump pump;
	final FuelManager fuelManager = new FuelManagerImpl();
	pump = new PumpImpl(Integer.parseInt(this.pumpsEditor.getDurability()), 
		            Integer.parseInt(this.pumpsEditor.getPrice()), 
		            Integer.parseInt(this.pumpsEditor.getRepairCost()), 
		            "", //name not found
		            fuelManager.getFuel(this.pumpsEditor.getFuelType()), 
		            Integer.parseInt(this.pumpsEditor.getSpeed()));
	
	
	this.mainController.getModel().getPumpManager().addPump(pump);
    }
    
    private void loadPumps() {
	this.pumps = this.mainController.getModel().getPumpManager().getAllPumps();
	
	List<String> list = new ArrayList<>();
	for(int i = 0; i < pumps.size(); i++) {
	    list.add(pumps.get(i).getName());
	}
	this.pumpsEditor.loadFuels(list);
    }
}

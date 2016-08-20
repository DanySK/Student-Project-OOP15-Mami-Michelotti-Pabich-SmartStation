package application.controller.tabs;

import java.util.List;
import application.controller.MainController;
import application.model.buildables.pump.Pump;
import application.model.moneyManager.MovementType;
import application.model.services.Fuel;
import application.view.tabs.pumpsEditor.PumpsEditor;

public class PumpsEditorCtrlImpl implements PumpsEditorCtrl {

    private final MainController mainController;
    private PumpsEditor pumpsEditor;
    private Pump pumpSelected, pumpRepair;
    
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
		this.pumpSelected = p;
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
	final boolean isTake = this.isFree(this.pumpsEditor.getModifyFuelType());
	if(isTake) {
	    this.mainController.getModel().getPumpManager().getPumpByName(this.pumpSelected.getName())
	                                                   .setName(this.pumpsEditor.getModifyFuelType());
	    this.pumpSelected.setName(this.pumpsEditor.getModifyFuelType());
	}
    }

    @Override
    public void changeSpeed() {
	final boolean isNum = this.isNumber(this.pumpsEditor.getModifySpeed());
	if(isNum) {
	    this.mainController.getModel().getPumpManager().getPumpByName(this.pumpSelected.getName())
	                                                   .setSpeed(Integer.parseInt(this.pumpsEditor.getModifySpeed()));
	}
    }

    @Override
    public void changeDurability() {
	final boolean isNum = this.isNumber(this.pumpsEditor.getModifyDurability());
	if(isNum) {
	    this.mainController.getModel().getPumpManager().getPumpByName(this.pumpSelected.getName())
	                                                   .setMaxDurability(Integer.parseInt(this.pumpsEditor.getModifyDurability()));
	}
    }

    @Override
    public void changePrice() {
	final boolean isNum = this.isNumber(this.pumpsEditor.getModifyPrice());
	if(isNum) {
	    this.mainController.getModel().getPumpManager().getPumpByName(this.pumpSelected.getName())
	                                                   .setCost(Integer.parseInt(this.pumpsEditor.getModifyPrice()));
	}
    }

    @Override
    public void changeRepairCost() {
	final boolean isNum = this.isNumber(this.pumpsEditor.getModifyRepairCost());
	if(isNum) {
	    this.mainController.getModel().getPumpManager().getPumpByName(this.pumpSelected.getName()).setRepairCost(Integer.parseInt(this.pumpsEditor.getModifyRepairCost()));
	}
    }

    @Override
    public void selectRepair() {
	for(Pump p : this.mainController.getModel().getPumpManager().getAllPumps()) {
	    if(p.getName() == this.pumpsEditor.getRepairSelectedPump()) {
		this.pumpRepair = p;
		this.pumpsEditor.setRepairQuantities(String.valueOf(p.getDurability()), String.valueOf(p.getMaxDurability()));
	    }
	}
    }

    @Override
    public void repair() {
	final int damage = this.pumpRepair.getMaxDurability() - this.pumpRepair.getDurability();
	
	if(damage == 0) {
	    final int repair = (int)((damage * this.pumpsEditor.getRepairValue()) / 100);
	    this.mainController.getModel().getPumpManager().getPumpByName(this.pumpRepair.getName()).repair(repair);
	    
	    //adding the movement
	    this.mainController.getModel().getMoneyManager()
                                          .addMovement(MovementType.REPAIR, this.pumpRepair.getCost() * repair,
        	                                       "Repaying pump " + this.pumpRepair.getName());
	    
	    //load the balance for movements tab
	    this.mainController.getMovementsViewerController().loadBalance();
	}
    }

    @Override
    public void addPump() {
	final boolean isFre = this.isFree(this.pumpsEditor.getFuelType());
	final boolean speed = this.isNumber(this.pumpsEditor.getSpeed());
	final boolean durab = this.isNumber(this.pumpsEditor.getDurability());
	final boolean price = this.isNumber(this.pumpsEditor.getPrice());
	final boolean repCos = this.isNumber(this.pumpsEditor.getRepairCost());
	if(isFre && speed && durab && price && repCos) {
	    /*this.mainController.getModel().getPumpManager().addPump(this.pumpsEditor.getFuelType(),
	                                                            Integer.parseInt(this.pumpsEditor.getSpeed()),
	                                                            Integer.parseInt(this.pumpsEditor.getDurability()),
	                                                            Integer.parseInt(this.pumpsEditor.getPrice()),
	                                                            Integer.parseInt(this.pumpsEditor.getRepairCost()));*/
	    this.pumpsEditor.loadPumps(this.mainController.getModel().getPumpManager().getAllPumps());
	    
	    //adding the movement
	    this.mainController.getModel().getMoneyManager()
	                                  .addMovement(MovementType.BUILD, Integer.parseInt(this.pumpsEditor.getPrice()),
	                                	       "Adding pump " + this.pumpsEditor.getFuelType());
	    
	    //load the balance for movements tab
	    this.mainController.getMovementsViewerController().loadBalance();
	}
    }

    //control of name is already taken
    private boolean isFree(String name) {
	for(Pump p : this.mainController.getModel().getPumpManager().getAllPumps()) {
	    if(p.getName() == name) {
		return false;
	    }
	}
	return true;
    }

    //control if numbers is right
    private boolean isNumber(String str) {
	try {
	    Integer.parseInt(str);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }
}

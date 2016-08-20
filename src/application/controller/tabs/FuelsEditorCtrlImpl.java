package application.controller.tabs;

import java.util.List;
import application.controller.MainController;
import application.model.moneyManager.MovementType;
import application.model.services.Fuel;
import application.view.tabs.fuelsEditor.FuelsEditor;
import javafx.scene.paint.Color;

public class FuelsEditorCtrlImpl implements FuelsEditorCtrl {

    private final MainController mainController;
    private FuelsEditor fuelsEditor;
    private Fuel fuel;
    
    public FuelsEditorCtrlImpl(MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(FuelsEditor fuelsEditor) {
	this.fuelsEditor = fuelsEditor;
    }

    @Override
    public void loadData(final List<Fuel> fuels) {
	this.fuelsEditor.loadFuels(fuels);
    }

    @Override
    public void select() {
	for(Fuel f : this.mainController.getModel().getFuelManager().getAllFuels()) {
	    if(f.getName() == this.fuelsEditor.getSelectedFuel()) {
		this.fuel = f;
		this.fuelsEditor.setModifyName(f.getName());
		this.fuelsEditor.setModifyPrice(String.valueOf(f.getPrice()));
		this.fuelsEditor.setModifyWhoesalePrice(String.valueOf(f.getWholeSalePrice()));
		this.fuelsEditor.setModifyColor(String.valueOf(f.getColor()));
	    }
	}
    }

    @Override
    public void changeName() {
	final boolean isFree = this.isFree(this.fuelsEditor.getModifyName());
	if(isFree) {
	    this.mainController.getModel().getFuelManager().getFuel(this.fuel.getName())
	                                                    .setName(this.fuelsEditor.getModifyName());
	    this.fuel.setName(this.fuelsEditor.getModifyName());
	}
    }

    @Override
    public void changePrice() {
	final boolean isNum = this.isNumber(this.fuelsEditor.getModifyPrice());
	if(isNum) {
	    this.mainController.getModel().getFuelManager().getFuel(this.fuel.getName())
	                                  .setPrice(Integer.parseInt(this.fuelsEditor.getModifyPrice()));
	}
    }

    @Override
    public void changeWPrice() {
	final boolean isNum = this.isNumber(this.fuelsEditor.getModifyWhoesalePrice());
	if(isNum) {
	    this.mainController.getModel().getFuelManager().getFuel(this.fuel.getName())
	                                  .setWholeSalePrice(Integer.parseInt(this.fuelsEditor.getModifyWhoesalePrice()));
	}
    }

    @Override
    public void changeColor() {
	final boolean isColor = this.isColor(this.fuelsEditor.getModifyColor());
	if(isColor) {
	    this.mainController.getModel().getFuelManager().getFuel(this.fuel.getName())
	                                  .setColor(Color.valueOf(this.fuelsEditor.getModifyColor()));
	}
    }

    @Override
    public void addFuel() {
	final boolean isFre = this.isFree(this.fuelsEditor.getFuelName());
	final boolean isPri = this.isNumber(this.fuelsEditor.getFuelPrice());
	final boolean isWPr = this.isNumber(this.fuelsEditor.getFuelWhoesalePrice());
	final boolean isCol = this.isColor(this.fuelsEditor.getFuelColor());
	
	if(isFre && isPri && isWPr && isCol) {
	    /*this.mainController.getModel().getFuelManager().addFuel(this.fuelsEditor.getFuelName(),
		                                                    Integer.parseInt(this.fuelsEditor.getFuelPrice()),
		                                                    Integer.parseInt(this.fuelsEditor.getFuelWhoesalePrice()),
		                                                    Color.valueOf(this.fuelsEditor.getFuelColor()));*/
	    this.fuelsEditor.loadFuels(this.mainController.getModel().getFuelManager().getAllFuels());
	    
	    //adding the movement
	    this.mainController.getModel().getMoneyManager()
	                                  .addMovement(MovementType.BUILD,
		                                       Integer.parseInt(this.fuelsEditor.getFuelPrice()),
		                                       "Adding fuel " + this.fuelsEditor.getFuelName());
	    
	    //load the balance for movements tab
	    this.mainController.getMovementsViewerController().loadBalance();
	}
    }

    //control of name is already taken
    private boolean isFree(String name) {
	for(Fuel f : this.mainController.getModel().getFuelManager().getAllFuels()) {
	    if(f.getName() == name) {
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

    //control if color is right
    private boolean isColor(String str) {
	try {
	    Color.valueOf(str);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }
}

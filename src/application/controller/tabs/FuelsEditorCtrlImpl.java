package application.controller.tabs;

import java.util.List;
import application.controller.MainController;
import application.model.services.Fuel;
import application.view.tabs.fuelsEditor.FuelsEditor;
import javafx.scene.paint.Color;

public class FuelsEditorCtrlImpl implements FuelsEditorCtrl {

    private final MainController mainController;
    private FuelsEditor fuelsEditor;
    
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
		this.fuelsEditor.setModifyPanelVisibility(true);
		this.fuelsEditor.setModifyName(f.getName());
		this.fuelsEditor.setModifyPrice(String.valueOf(f.getPrice()));
		this.fuelsEditor.setModifyWhoesalePrice(String.valueOf(f.getWholeSalePrice()));
		this.fuelsEditor.setModifyColor(String.valueOf(f.getColor()));
	    }
	}
    }

    @Override
    public void changeName() {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setName(this.fuelsEditor.getModifyName());
    }

    @Override
    public void changePrice() {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setPrice(Integer.parseInt(this.fuelsEditor.getModifyPrice()));
    }

    @Override
    public void changeWPrice() {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setWholeSalePrice(Integer.parseInt(this.fuelsEditor.getModifyWhoesalePrice()));
    }

    @Override
    public void changeColor() {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setColor(Color.valueOf(this.fuelsEditor.getModifyColor()));
    }

    @Override
    public void addFuel() {
	/*this.mainController.getModel().getFuelManager().addFuel(this.fuelsEditor.getFuelName(),
		                                                  Integer.parseInt(this.fuelsEditor.getFuelPrice()),
		                                                  nteger.parseInt(this.fuelsEditor.getFuelWhoesalePrice()),
		                                                  Color.valueOf(this.fuelsEditor.getFuelColor()));*/
    }
}

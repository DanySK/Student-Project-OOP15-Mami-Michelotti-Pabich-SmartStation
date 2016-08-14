package application.controller.tabs;

import java.util.ArrayList;
import java.util.List;
import application.controller.MainController;
import application.model.services.Fuel;
import application.model.services.FuelImpl;
import application.view.tabs.fuelsEditor.FuelsEditor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FuelsEditorCtrlImpl implements FuelsEditorCtrl {

    private final MainController mainController;
    private FuelsEditor fuelsEditor;
    private List<Fuel> fuels;
    private int i;
    
    public FuelsEditorCtrlImpl(MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(FuelsEditor fuelsEditor) {
	this.fuelsEditor = fuelsEditor;
    }

    @Override
    public void btnSelect_click(MouseEvent e) {
	this.fuelsEditor.setModifyPanelVisibility(true);
	for(int i = 0; i < this.fuels.size(); i++) {
	    if(this.fuels.get(i).getName() == this.fuelsEditor.getSelectedFuel()) {
		this.i = i;
		this.fuelsEditor.setModifyName(this.fuels.get(i).getName());
		this.fuelsEditor.setModifyPrice(String.valueOf(this.fuels.get(i).getPrice()));
		this.fuelsEditor.setModifyWhoesalePrice(String.valueOf(this.fuels.get(i).getWholeSalePrice()));
		this.fuelsEditor.setModifyColor(String.valueOf(this.fuels.get(i).getColor()));
	    }
	}
    }

    @Override
    public void btnChangeName_click(MouseEvent e) {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setName(this.fuelsEditor.getModifyName());
	this.fuels.get(this.i).setName(this.fuelsEditor.getModifyName());
    }

    @Override
    public void btnChangePrice_click(MouseEvent e) {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setPrice(Integer.parseInt(this.fuelsEditor.getModifyPrice()));
	this.fuels.get(this.i).setPrice(Integer.parseInt(this.fuelsEditor.getModifyPrice()));
    }

    @Override
    public void btnChangeWPrice_click(MouseEvent e) {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setWholeSalePrice(Integer.parseInt(this.fuelsEditor.getModifyWhoesalePrice()));
	this.fuels.get(this.i).setWholeSalePrice(Integer.parseInt(this.fuelsEditor.getModifyWhoesalePrice()));
    }

    @Override
    public void btnChangeColor_click(MouseEvent e) {
	this.mainController.getModel().getFuelManager().getFuel(this.fuelsEditor.getSelectedFuel())
	                              .setColor(Color.valueOf(this.fuelsEditor.getModifyColor()));
	this.fuels.get(this.i).setColor(Color.valueOf(this.fuelsEditor.getModifyColor()));
    }

    @Override
    public void btnAddFuel_click(MouseEvent e) {
	final Fuel fuel;
	fuel = new FuelImpl(this.fuelsEditor.getFuelName(), 
		            Integer.parseInt(this.fuelsEditor.getFuelPrice()), 
		            Integer.parseInt(this.fuelsEditor.getFuelWhoesalePrice()), 
		            Color.valueOf(this.fuelsEditor.getFuelColor()));
	this.mainController.getModel().getFuelManager().addFuel(fuel);
	this.loadFuels();
    }

    private void loadFuels() {
	if(this.fuels != null) {
	    this.fuels.clear();
	}
	this.fuels = this.mainController.getModel().getFuelManager().getAllFuels();
	
	final List<String> list = new ArrayList<>();
	for(int i = 0; i < this.fuels.size(); i++) {
	    list.add(this.fuels.get(i).getName());
	}
	this.fuelsEditor.loadFuels(list);
    }
}

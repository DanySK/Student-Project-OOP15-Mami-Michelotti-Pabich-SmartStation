package application.controller.tabs;

import application.controller.MainController;
import application.view.tabs.reservesEditor.ReservesEditor;

public class ReservesEditorCtrlImpl implements ReservesEditorCtrl {

    private final MainController mainController;
    private ReservesEditor reservesEditor;
    
    public ReservesEditorCtrlImpl(MainController mainController) {
	this.mainController = mainController;
    }

    @Override
    public void setView(ReservesEditor reservesEditor) {
	this.reservesEditor = reservesEditor;
    }

    @Override
    public void selectEdit() {
	
    }

    @Override
    public void changeFuelType() {
	
    }

    @Override
    public void changeCapacity() {
	
    }

    @Override
    public void changeRepairCost() {
	
    }

    @Override
    public void changePrice() {
	
    }

    @Override
    public void changeDurability() {
	
    }

    @Override
    public void selectRefill() {
	
    }

    @Override
    public void refill() {
	
    }

    @Override
    public void selectRepair() {
	
    }

    @Override
    public void repair() {
	
    }

    @Override
    public void addReserve() {
	
    }
}

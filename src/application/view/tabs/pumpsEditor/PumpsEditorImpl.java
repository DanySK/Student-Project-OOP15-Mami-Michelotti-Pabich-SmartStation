package application.view.tabs.pumpsEditor;

import java.util.List;

import application.ExitStatus;
import application.Main;
import application.controller.tabs.PumpsEditorCtrl;
import application.model.buildables.pump.Pump;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * Implements the StationEditor interface and contains the logic of StationEditor.
 * @author Marcin Pabich
 */
public class PumpsEditorImpl extends BorderPane implements PumpsEditor {

    private PumpsEditorCtrl controller;
    
    
    //for modifying
    @FXML
    private ComboBox<String> cmbPumpsEdit, cmbEditFuelType;
    
    @FXML
    private TextField txfEditSpeed, txfEditDurability, txfEditPrice, txfEditRepairCost;
    
    
    //for repairing
    @FXML
    private ComboBox<String> cmbPumpRepair;
    
    @FXML
    private Slider sldRepair;
    
    @FXML
    private Button btnRepair;
    
    
    //for adding
    @FXML
    private ComboBox<String> cmbFuelType;
    
    @FXML
    private TextField txfSpeed, txfDurability, txfPrice, txfRepairCost;
	
    
    /**
     * Constructor for the StationEditor that loads the content.
     */
    public PumpsEditorImpl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PumpsEditor.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
     
        try {
            fxmlLoader.load();
        } catch (Exception exception) {
            ExitStatus.showErrorDialog("FXML Loading Exception", "PumpsEditor.fxml could not be loaded", "Exception message: " + exception.getMessage());
            Main.close(ExitStatus.FXMLLoadingExcp);
        }
              
    }
    

    @Override
    public void setController(final PumpsEditorCtrl ctrl) {
        this.controller = ctrl;
    }
    
    //MODIFYING EVENT HANDLERS
    @FXML
    private void btnSelectEdit_click(final MouseEvent e) {
        this.controller.selectEdit();
    }
    
    @FXML
    private void btnChangePumpName_click(final MouseEvent e) {
        this.controller.changePumpName();
    }
    
    @FXML
    private void btnChangeSpeed_click(final MouseEvent e) {
        this.controller.changeSpeed();
    } 
    
    @FXML
    private void btnChangeDurability_click(final MouseEvent e) {
        this.controller.changeDurability();
    }
        
    @FXML
    private void btnChangePrice_click(final MouseEvent e) {
        this.controller.changePrice();
    }
    
    @FXML
    private void btnChangeRepairCost_click(final MouseEvent e) {
        this.controller.changeRepairCost();
    }
   
    
    
    //REPAIR EVENT HANDLERS
    @FXML
    private void btnSelectRepair_click(final MouseEvent e) {
        this.controller.selectRepair();
    }
    
    @FXML
    private void btnRepair_click(final MouseEvent e) {
        this.controller.repair();
    }
    
    
    //ADDING EVENT HANDLERS
    @FXML
    private void btnAddPump_click(final MouseEvent e) {
        this.controller.addPump();
    }


    
    //Implemented methods
    
    
    
    //LOADING
    
    @Override
    public void loadPumps(final List<Pump> pumps) {
        this.cmbPumpsEdit.getItems().clear();
        this.cmbPumpRepair.getItems().clear();
        
        pumps.forEach(p -> {
            this.cmbPumpsEdit.getItems().add(p.getName());
            this.cmbPumpRepair.getItems().add(p.getName());
        });
    }


    @Override
    public void loadFuels(final List<String> fuels) {
        this.cmbEditFuelType.getItems().clear();
        this.cmbFuelType.getItems().clear();
        
        this.cmbEditFuelType.getItems().addAll(fuels);
        this.cmbFuelType.getItems().addAll(fuels);
    }

    
    
    //MODIFYING

    @Override
    public String getModifySelectedPump() {
        return this.cmbPumpsEdit.getValue();
    }


    @Override
    public String getModifyFuelType() {
        return this.cmbEditFuelType.getValue();
    }


    @Override
    public void setModifyFuelType(final String fuelType) {
        this.cmbEditFuelType.setValue(fuelType);
    }


    @Override
    public String getModifySpeed() {
        return this.txfEditSpeed.getText();
    }


    @Override
    public void setModifySpeed(final String speed) {
        this.txfEditSpeed.setText(speed);
    }


    @Override
    public String getModifyDurability() {
        return this.txfEditDurability.getText();
    }


    @Override
    public void setModifyDurability(final String durability) {
        this.txfEditDurability.setText(durability);
    }


    @Override
    public String getModifyPrice() {
        return this.txfEditPrice.getText();
    }


    @Override
    public void setModifyPrice(final String price) {
        this.txfEditPrice.setText(price);
    }


    @Override
    public String getModifyRepairCost() {
        return this.txfEditRepairCost.getText();
    }


    @Override
    public void setModifyRepairCost(final String repairPrice) {
        this.txfEditRepairCost.setText(repairPrice);
    }


    
    //REPAIR
    
    @Override
    public Double getRepairValue() {
        return this.sldRepair.getValue();
    }


    @Override
    public void setRepairValue(final String value) {
        this.btnRepair.setText("Repair (" + value + "%)");
    }


    
    //ADDING
    
    @Override
    public String getFuelType() {
        return this.cmbFuelType.getValue();
    }


    @Override
    public String getSpeed() {
        return this.txfSpeed.getText();
    }


    @Override
    public String getDurability() {
        return this.txfDurability.getText();
    }


    @Override
    public String getPrice() {
        return this.txfPrice.getText();
    }


    @Override
    public String getRepairCost() {
        return this.txfRepairCost.getText();
    }

    
}

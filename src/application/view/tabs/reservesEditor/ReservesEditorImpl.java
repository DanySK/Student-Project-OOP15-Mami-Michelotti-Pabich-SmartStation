package application.view.tabs.reservesEditor;

import java.util.List;

import application.ExitStatus;
import application.Main;
import application.controller.tabs.ReservesEditorCtrl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Implements the StationEditor interface and contains the logic of StationEditor.
 * @author Marcin Pabich
 */
public class ReservesEditorImpl extends BorderPane implements ReservesEditor {
	 
    private ReservesEditorCtrl controller; 
    
    
    //Comboboxes
    @FXML
    private ComboBox<String> cmbReservesEdit, cmbReserveRefill, cmbReserveRepair;
    
    @FXML
    private ComboBox<String> cmbEditFuelType, cmbFuelType;
    
    
    //Texfields
    @FXML
    private TextField txfEditCapacity, txfEditPrice, txfEditDurability, txfEditRepairCost, txfRefill;
    
    @FXML
    private TextField txfCapacity, txfPrice, txfDurability, txfRepairCost;
    
    
    //Slider
    @FXML
    private Slider sldRepair; 
    
    //Significant buttons   
    @FXML
    private Button btnRepair;
    
    //Modifying section
    @FXML
    private VBox vbxModifyingPanel;
	
    
    /**
     * Constructor for the StationEditor that loads the content.
     */
    public ReservesEditorImpl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReservesEditor.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
     
        try {
            fxmlLoader.load();
        } catch (Exception exception) {
            ExitStatus.showErrorDialog("FXML Loading Exception", "ReservesEditor.fxml could not be loaded", "Exception message: " + exception.getMessage());
            Main.close(ExitStatus.FXMLLoadingExcp);
        }
      
       
    }

    //Controller
    @Override
    public void setController(final ReservesEditorCtrl ctrl) {
	this.controller = ctrl;
    }
    
    
    //MODIFYING EVENT HANDLERS
    @FXML
    private void btnSelectEdit_click(final MouseEvent e) {
        this.controller.btnSelectEdit_click(e);
    }
    
    @FXML
    private void btnChangeFuelType_click(final MouseEvent e) {
        this.controller.btnChangeFuelType_click(e);
    }
    @FXML
    private void btnChangeCapacity_click(final MouseEvent e) {
        this.controller.btnChangeCapacity_click(e);
    } 
    
    @FXML
    private void btnChangeRepairCost_click(final MouseEvent e) {
        this.controller.btnChangeRepairCost_click(e);
    }
        
    @FXML
    private void btnChangePrice_click(final MouseEvent e) {
        this.controller.btnChangePrice_click(e);
    }
    
    @FXML
    private void btnChangeDurability_click(final MouseEvent e) {
        this.controller.btnChangeDurability_click(e);
    }
    

    //REFILL EVENT HANDLERS
    @FXML
    private void btnSelectRefill_click(final MouseEvent e) {
        this.controller.btnSelectRefill_click(e);
    }
    
    @FXML
    private void btnRefill_click(final MouseEvent e) {
        this.controller.btnRefill_click(e);
    }
    
    
    //REPAIR EVENT HANDLERS
    @FXML
    private void btnSelectRepair_click(final MouseEvent e) {
        this.controller.btnSelectRepair_click(e);
    }
    
    @FXML
    private void btnRepair_click(final MouseEvent e) {
        this.controller.btnRepair_click(e);
    }
    
    
    //ADDING EVENT HANDLERS
    @FXML
    private void btnAddReserve_click(final MouseEvent e) {
        this.controller.btnAddReserve_click(e);
    }

    
    
    //Loading methods
    @Override
    public void loadReserves(final List<String> reserves) {        
        this.cmbReserveRefill.getItems().clear();
        this.cmbReserveRepair.getItems().clear();
        this.cmbReservesEdit.getItems().clear();
        
        this.cmbReserveRefill.getItems().addAll(reserves);
        this.cmbReserveRepair.getItems().addAll(reserves);
        this.cmbReservesEdit.getItems().addAll(reserves);   
    }

    @Override
    public void loadFuels(final List<String> fuels) {
        this.cmbFuelType.getItems().clear();
        this.cmbEditFuelType.getItems().clear();
        
        this.cmbFuelType.getItems().addAll(fuels);
        this.cmbEditFuelType.getItems().addAll(fuels);
    }
    
    
    //Show/hide panels
    @Override
    public void showEditingPanel() {
        this.vbxModifyingPanel.setVisible(true);
    }

    @Override
    public void hideEditingPanel() {
        this.vbxModifyingPanel.setVisible(false);
    }

    @Override
    public boolean isEditingPanelVisible() {
        return this.vbxModifyingPanel.isVisible();
    }
    

    
    //Getters/setters for modifying
    @Override
    public String getModifyReserve() {
        return this.cmbEditFuelType.getValue();
    }

    @Override
    public String getModifyFuel() {
        return this.cmbEditFuelType.getValue();
    }

    @Override
    public void setModifyFuel(final String fuel) {
        this.cmbEditFuelType.setValue(fuel);
    }

    @Override
    public String getModifyCapacity() {
        return this.txfEditCapacity.getText();
    }

    @Override
    public void setModifyCapacity(final String capacity) {
        this.txfEditCapacity.setText(capacity);
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
    public String getModifyDurability() {
        return this.txfEditDurability.getText();
    }

    @Override
    public void setModifyDurability(final String durability) {
        this.txfEditDurability.setText(durability);
    }

    @Override
    public String getModifyRepairCost() {
        return this.txfEditRepairCost.getText();
    }

    @Override
    public void setModifyRepairCost(final String repairCost) {
        this.txfEditRepairCost.setText(repairCost);
    }

    
    
    //Getters for refill
    @Override
    public String getRefill() {
        return this.txfRefill.getText();
    }
    

    
    //Getters/setters for repair
    @Override
    public Double getRepairValue() {
        return this.sldRepair.getValue();
    }

    @Override
    public void setRepairValue(final String value) {
        this.btnRepair.setText("Repair (" + value.toString() + ")");
    }


    
    

    
    
    
   
    
    
    
    
    
    
    
}

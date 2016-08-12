package application.view.controls.reserveStatus;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

/**
 * Implements the ReserveStatus interface and contain all the logic of a reservestatus management.
 * @author Marcin Pabich
 */
public class ReserveStatusImpl extends HBox implements ReserveStatus {

    @FXML
    private ProgressBar pgbReserve;
	
    @FXML
    private Label lblName, lblPrice;

    /**
     * Main constructor for the ReserveStatus.
     */
    public ReserveStatusImpl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReserveStatus.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    /**
     * Secondary constructor for Reserve status that permit to set a name and reserve quantity.
     * @param name name of the fuel
     * @param reserve reserve quantity
     * @param price price of the fuel
     */
    public ReserveStatusImpl(final String name, final Double price, final Double reserve) {
    	this();
 
        //Set controls values
        this.setFuelName(name);
        this.setReserve(reserve);
        this.setPrice(price);
    }

    @Override
    public Double getReserve() {
        return pgbReserve.getProgress();
    }

    @Override
    public void setReserve(final Double value) {
        pgbReserve.setProgress(value);
    }
    
    @Override
    public String getFuelName() {
    	return lblName.getText();
    }
    
    @Override
    public void setFuelName(final String name) {
    	lblName.setText(name);
    }

    @Override
    public void setPrice(final Double value) {
        lblPrice.setText(value.toString());
    }

    @Override
    public Double getPrice() {
        return Double.parseDouble(lblPrice.getText());
    }
}

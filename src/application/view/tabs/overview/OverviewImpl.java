package application.view.tabs.overview;

import java.util.List;

import application.ExitStatus;
import application.Main;
import application.controller.tabs.OverviewCtrl;
import application.model.buildables.area.Area;
import application.view.controls.areasGrid.AreasGridImpl;
import application.view.controls.reserveStatus.ReserveStatusImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Implenets the Overview interface and contains all the logic for the overview tab.
 * @author Marcin Pabich
 */
public class OverviewImpl extends BorderPane implements Overview {

    @FXML
    private VBox vbxReserves;
    
    @FXML
    private AreasGridImpl areasGrid;
     
	
    //private OverviewCtrl controller;
    
	
    /**
     * Constructor for the overview that loads the content.
     */
    public OverviewImpl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Overview.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
     

        try {
            fxmlLoader.load();
        } catch (Exception exception) {
            ExitStatus.showErrorDialog("FXML Loading Exception", "Overview.fxml could not be loaded", "Exception message: " + exception.getMessage());
            Main.close(ExitStatus.FXMLLoadingExcp);
        }    
    }

    @Override
    public void setController(final OverviewCtrl ctrl) {
	//this.controller = ctrl;
    }

    @Override
    public void addReserveStatus(final String name, final Double price, final Double reserve) {
	this.vbxReserves.getChildren().add(new ReserveStatusImpl(name, price, reserve));
    }
    
    @Override
    public void removeReserves() {
        this.vbxReserves.getChildren().clear();
    }


    @Override
    public void refreshGrid(final List<Area> areas) {
        this.areasGrid.drawArea(areas);
    }

}

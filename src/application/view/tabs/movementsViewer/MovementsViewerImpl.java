package application.view.tabs.movementsViewer;

import java.util.List;

import application.ExitStatus;
import application.Main;
import application.controller.tabs.MovementsViewerCtrl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * Implements the StationEditor interface and contains the logic of StationEditor.
 * @author Marcin Pabich
 */
public class MovementsViewerImpl extends BorderPane implements MovementsViewer {

    //private MovementsViewerCtrl controller;
    
    @FXML
    private ComboBox<String> cmbFilters;
    
    @FXML
    private ListView<String> lsvElements;
    
    /**
     * Constructor for the StationEditor that loads the content.
     */
    public MovementsViewerImpl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MovementsViewer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
     
        try {
            fxmlLoader.load();
        } catch (Exception exception) {
            ExitStatus.showErrorDialog("FXML Loading Exception", "MovementsViewer.fxml could not be loaded", "Exception message: " + exception.getMessage());
            Main.close(ExitStatus.FXMLLoadingExcp);
        }
              
    }
    

    //Controller setter
    @Override
    public void setController(final MovementsViewerCtrl ctrl) {
       //this.controller = ctrl;
    }
    
      
    //Loading filters
    @Override
    public void loadFilters(final List<String> filters) {
        this.cmbFilters.getItems().clear();       
        this.cmbFilters.getItems().addAll(filters);
    }

    
    //Get selected filter 
    @Override
    public String getFilter() {
        return this.cmbFilters.getValue();
    }

    
    //Add a single element
    @Override
    public void addElementToList(final String element) {
        this.lsvElements.getItems().add(element);
    }

    @Override
    public void addAllElementsToList(final List<String> elements, final boolean clear) {
        if (clear) {
            this.clearList();
        }
        
        this.lsvElements.getItems().addAll(elements);
    }

    @Override
    public void clearList() {
        this.lsvElements.getItems().clear();
    }


    
    @FXML
    private void btnApplyFilter_click(final MouseEvent e) {
        //this.controller.btnApplyFilter_click(e);
    }
    
}

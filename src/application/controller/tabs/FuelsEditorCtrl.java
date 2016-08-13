package application.controller.tabs;

import application.view.tabs.fuelsEditor.FuelsEditor;
import javafx.scene.input.MouseEvent;

/**
 * Interface that contain all methods needed to manage the fuels editor controller.
 * @author Matteo Michelotti
 */
public interface FuelsEditorCtrl {

    /**
     * Set the view of the controller.
     * @param fuelsEditor the view for the class
     */
    void setView(final FuelsEditor fuelsEditor);
    
    /**
     * selection of the fuel and load the dates.
     * @param e mouse event
     */
    void btnSelect_click (MouseEvent e);
    
    /**
     * Change the name of fuel selected.
     * @param e mouse event
     */
    void btnChangeName_click (MouseEvent e);
    
    /**
     * Change the price of fuel selected.
     * @param e mouse event
     */
    void btnChangePrice_click (MouseEvent e);
    
    /**
     * Change the wholesale price of fuel selected.
     * @param e mouse event
     */
    void btnChangeWPrice_click (MouseEvent e);
    
    /**
     * Change the color of fuel selected.
     * @param e mouse event
     */
    void btnChangeColor_click (MouseEvent e);

    /**
     * Add new fuel.
     * @param e mouse event
     */
    void btnAddFuel_click(MouseEvent e);
}

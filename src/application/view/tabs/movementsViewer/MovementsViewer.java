package application.view.tabs.movementsViewer;

import java.util.List;

import application.controller.tabs.MovementsViewerCtrl;

/**
 * Interface containing all the logic for the Movements Viewer tab.
 * @author Marcin Pabich
 *
 */
public interface MovementsViewer {

    /**
     * Set the controller for the view.
     * @param controller the controller
     */
    void setController(MovementsViewerCtrl controller);
    
    
    /**
     * Load avaiable filters to the combobox.
     * @param filters List of the filters
     */
    void loadFilters(List<String> filters);
    
    /**
     * Gets the filter of the combobox.
     * @return String representing the filter
     */
    String getFilter();
    
    /**
     * Add a single element to the list.
     * @param element Element to add
     */
    void addElementToList(String element);
    
    /**
     * Add an entire list of elements to the list, specifying if clear previous.
     * @param elements List of elements to add
     * @param clear TRUE if clear previous | FALSE will not clear previous values
     */
    void addAllElementsToList(List<String> elements, boolean clear);
    
    /**
     * Clear the entire list.
     */
    void clearList();

}

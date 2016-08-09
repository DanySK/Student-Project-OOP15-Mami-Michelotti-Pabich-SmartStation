package mnmlwindow.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.BoundingBox;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import mnmlwindow.controller.MinimalWindowC;
import mnmlwindow.controller.MinimalWindowCImpl;

/**
 * Class that implements the view of a minimal window logic.
 * @author Marcin Pabich
 */
public class MinimalWindowViewImpl extends BorderPane implements MinimalWindowView {
        
    //Values injected from the FXML
    @FXML
    private BorderPane mainWindow, contentArea;
        
    @FXML
    private Label lblTitle, lblFooter;
    
    @FXML
    private Button btnMax, btnResize;
    
    @FXML
    private ImageView imgLogo;
    
    //Reference to the primaryStage
    private final Stage stage;
    
    //References to min/max width/height and the shadow effect
    private final int MINWIDTH, MINHEIGHT;
    
    //Things for the resizing/moving window
    private double actualX, actualY;
    private boolean isMovable = true;
    
    //Saving of screen bounds
    private BoundingBox savedBounds;
    
    //Status of the window, because of "bugged" isMaximized of stage
    private boolean isMaximized;
    
    //The controller
    private MinimalWindowC controller;
    

    
    
    /**
     * Constructor for the minimal window view.
     * @param stage Stage that will be used
     * @param minwidth minimum width of the window
     * @param minheight minimum height of the window
     */
    public MinimalWindowViewImpl(final Stage stage, final int minwidth, final int minheight) {
        //First, take the reference to the stage
        this.stage = stage;
            
        //Taking the references to the window
        this.MINWIDTH = minwidth;
        this.MINHEIGHT = minheight;       
        
        //It's start not maximized
        this.isMaximized = false;
        
        //Then load the window, setting the root and controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mnmlwindow/view/MinimalWindow.fxml"));
        loader.setRoot(this);
        loader.setController(this);             
        
        //Try to load
        try {
            loader.load();            
        } catch (Exception e) {
            e.printStackTrace();
            //TODO Show a message error
            System.exit(1);
        }
    }
    
    
    
    /////////////////////////////
    // Getters and Setters
    /////////////////////////////
    
    //Setter for the controller
    @Override
    public void setWindowControllerer(final MinimalWindowCImpl controller) {
        this.controller = controller;
    }
    
    
    //Getter and setter for the window logo
    @Override
    public void setWindowLogo(final ImageView logo) { 
        
    }
    @Override
    public ImageView getWindowLogo() { 
        return this.imgLogo;
    }
    
    
    //Getter and setter for the title
    @Override
    public void setWindowTitle(final String s) { 
        lblTitle.setText(s); 
    }
    
    @Override
    public String getWindowTitle() { 
        return this.lblTitle.getText(); 
    }
    
    
    //Getter and setter for the footer
    @Override
    public void setWindowFooter(final String s) { 
        lblFooter.setText(s); 
    }
    
    @Override
    public String getWindowFooter() { 
        return this.lblFooter.getText(); 
    }
    
    
    //Getter and setter for the main content
    @Override
    public void setWindowContent(final Node node) { 
        contentArea.setCenter(node); 
    }
    
    @Override
    public Node getWindowContent() { 
        return contentArea; 
    }
    
    
    //Getters and setters for the window movable status
    @Override
    public boolean isWindowMovable() { 
        return this.isMovable; 
    }
    
    @Override
    public void setNotMovableWindow() { 
        this.isMovable = false; 
    }
    
    @Override
    public void setMovableWindow() { 
        this.isMovable = true; 
    }
    
    
    //Getters and setters for actualX
    @Override
    public double getWindowActualX() { 
        return this.actualX; 
    }
    
    @Override
    public void setWindowActualX(final double x) { 
        this.actualX = x; 
    }
    
    
    //Getters and setters for actualY
    @Override
    public double getWindowActualY() { 
        return this.actualY; 
    }
    @Override
    public void setWindowActualY(final double y) { 
        this.actualY = y; 
    }
    
    
    //Getters and setters for X
    @Override
    public double getWindowX() { 
        return this.stage.getX(); 
    }
    @Override
    public void setWindowX(final double x) { 
        this.stage.setX(x); 
    }
    
    
    //Getters and setters for Y
    @Override
    public double getWindowY() { 
        return this.stage.getY(); 
    }
    @Override
    public void setWindowY(final double y) { 
        this.stage.setY(y); 
    }
    
    
    //Getter for the shadow size
    @Override
    public int getWindowShadowSize() { 
        return (int) WindowStatus.NORMAL.getShadowSpace().getLeft(); 
    }
    
    
    //Methods to change window status [iconified (min) / maximize (full) / normal (window)]
    @Override
    public void minimizeWindow() { 
        this.stage.setIconified(true); 
    }
    @Override
    public void maximizeWindow() { 
        changeWindowStatus(WindowStatus.MAXIMIZED); 
    }
    @Override
    public void normalizeWindow() { 
        changeWindowStatus(WindowStatus.NORMAL); 
    }
    
    
    //Getter for the maximize property
    @Override
    public boolean isWindowMaximized() { 
        return this.isMaximized;
    }
    
    
    //Getters and setters for width properities
    @Override
    public void setWindowWidth(final double width) { 
        this.stage.setWidth(width); 
    }
    @Override
    public double getWindowMinWidth() { 
        return this.MINWIDTH; 
    }
    @Override
    public double getWindowWidth() { 
        return this.stage.getWidth(); 
    }
    
    
    //Getters and setters for height properties
    @Override
    public void setWindowHeight(final double height) { 
        this.stage.setHeight(height); 
    }
    @Override
    public double getWindowMinHeight() { 
        return this.MINHEIGHT; 
    }
    @Override
    public double getWindowHeight() { 
        return this.stage.getHeight(); 
    }
    
    
    //Setting the mouse cursor
    @Override
    public void setMouseCursor(final Cursor cursor) { 
        this.mainWindow.setCursor(cursor); 
    }
    
    
    //Closing the window
    @Override
    public void closeWindow() { 
        this.stage.close(); 
    }
    
    
    
    //Private methods
    private void changeWindowStatus(final WindowStatus status) {
            
        //If the window shoud be normalized
        if (status.equals(WindowStatus.NORMAL)) {
            //Take previous bounds        
            stage.setX(savedBounds.getMinX());
            stage.setY(savedBounds.getMinY());
            stage.setWidth(savedBounds.getWidth());
            stage.setHeight(savedBounds.getHeight());        
        } else {
            //Take the screen size (muliscren support)
            ObservableList<Screen> screensForRectangle = Screen.getScreensForRectangle(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight());
            Screen screen = screensForRectangle.get(0);
            Rectangle2D visualBounds = screen.getVisualBounds();      
            
            //Save the previous dimensions
            savedBounds = new BoundingBox(stage.getX(), stage.getY(), stage.getWidth(), stage.getHeight());
            
            //Take the ref (initialized when started the logic)           
            stage.setX(visualBounds.getMinX());
            stage.setY(visualBounds.getMinY());
            stage.setWidth(visualBounds.getWidth());
            stage.setHeight(visualBounds.getHeight());
        }
        
        //Set some buttons and UI changes
        this.isMaximized = status.getWindowMaximizedStatus();
        this.btnResize.setVisible(status.getResizeButtonVisibility());
        this.btnMax.setStyle(status.getMaximizeLogoPath());
        this.mainWindow.setPadding(status.getShadowSpace());
    }
    
    
    /////////////////////////////
    // Event handlers
    /////////////////////////////
    
    
    // MIMIZIE | MAXIMIZE | CLOSE 
    
    //When pressed, will minimize the window to tray
    @FXML
    private void btnMin_click(final MouseEvent e) {
            this.controller.btnMin_clickAction(e);
    }
    
    //When pressed, check if it must maximize or restore the window
    @FXML
    private void btnMax_click(final MouseEvent e) {
            this.controller.btnMax_clickAction(e);           
    }
    
    //When pressed, will kill the window
    @FXML
    private void btnCls_click(final MouseEvent e) {
            this.controller.btnCls_clickAction(e);
    }
    
    
    // WINDOW MOVING
    
    //When i must update the XY of the click
    @FXML
    private void root_onMousePressed(final MouseEvent e) {
            this.controller.root_onMousePressedAction(e);
    }
    
    //When pressing and dragging the mouse it will move the window
    @FXML
    private void root_onMouseDragged(final MouseEvent e) {
            this.controller.root_onMouseDraggedAction(e);
    }
    
    //Update the status of the window from not movable to movable, after "normalize" effect
    //from the dragging it when it's maximized
    @FXML
    private void root_onMouseReleased(final MouseEvent e) {
            this.controller.root_onMouseReleasedAction(e);
    }
    
    
    // WINDOW RESIZING
            
    @FXML
    private void btnResize_onMouseClicked(final MouseEvent e) {
            this.controller.btnResize_OnMouseClickedAction(e);
    }
    
    @FXML
    private void btnResize_OnMouseReleased(final MouseEvent e) {
            this.controller.btnResize_OnMouseReleasedAction(e);
    }
            
    @FXML
    private void btnResize_onMouseEntered(final MouseEvent e) {
            this.controller.btnResize_onMouseEntered(e);
    }
    
    @FXML
    private void btnResize_onMouseExited(final MouseEvent e) {
            this.controller.btnResize_onMouseExited(e);
    }
    
    @FXML
    private void btnResize_onMouseDragged(final MouseEvent e) {
            this.controller.btnResize_onMouseDragged(e);
    }
}

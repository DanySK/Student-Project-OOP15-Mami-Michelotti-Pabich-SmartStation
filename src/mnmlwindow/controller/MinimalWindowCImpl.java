package mnmlwindow.controller;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import mnmlwindow.view.MinimalWindowView;

/**
 * Class that implements all the controller methods of the minimal window.
 * @author Matteo Michelotti
 */
public class MinimalWindowCImpl implements MinimalWindowC {
    
    private MinimalWindowView minimalWindow;
    
    /**
     * Constructor for the controller of minimal window.
     * @param mnmlWindow MinimalWindowView object that will be "controlled"
     */ 
    public MinimalWindowCImpl(final MinimalWindowView mnmlWindow) {
        this.minimalWindow = mnmlWindow;
        this.minimalWindow.setWindowControllerer(this);
    }
    
    @Override
    public void btnMin_clickAction(final MouseEvent e) {
        this.minimalWindow.minimizeWindow();
    }

    @Override
    public void btnMax_clickAction(final MouseEvent e) {
        if (this.minimalWindow.isWindowMaximized()) {
            this.minimalWindow.normalizeWindow();
            this.minimalWindow.setMovableWindow();
        } else {
            this.minimalWindow.maximizeWindow();
            this.minimalWindow.setNotMovableWindow();
        }
    }

    @Override
    public void btnCls_clickAction(final MouseEvent e) {
        this.minimalWindow.closeWindow();
        System.exit(0);
    }

    @Override
    public void btnResize_OnMouseClickedAction(final MouseEvent e) {
        updateXY(e);
    }

    @Override
    public void btnResize_OnMouseReleasedAction(final MouseEvent e) {
        setCursorDefault(e);
    }

    @Override
    public void btnResize_onMouseEntered(final MouseEvent e) {
        this.minimalWindow.setMouseCursor(Cursor.NW_RESIZE);
    }

    @Override
    public void btnResize_onMouseExited(final MouseEvent e) {
        setCursorDefault(e);
    }

    @Override
    public void btnResize_onMouseDragged(final MouseEvent e) {
        updateXY(e);
            
        if (this.minimalWindow.getWindowActualX() > this.minimalWindow.getWindowMinWidth()) {
            this.minimalWindow.setWindowWidth(this.minimalWindow.getWindowActualX());
        } else {
            this.minimalWindow.setWindowWidth(this.minimalWindow.getWindowMinWidth());
        }
        
        if (this.minimalWindow.getWindowActualY() > this.minimalWindow.getWindowMinHeight()) {
            this.minimalWindow.setWindowHeight(this.minimalWindow.getWindowActualY());
        } else {
            this.minimalWindow.setWindowHeight(this.minimalWindow.getWindowMinHeight());
        }
    }

    @Override
    public void root_onMousePressedAction(final MouseEvent e) {
        updateXY(e);
    }

    @Override
    public void root_onMouseDraggedAction(final MouseEvent e) {
        if (this.minimalWindow.isWindowMovable()) {
            this.minimalWindow.setWindowX(e.getScreenX() - this.minimalWindow.getWindowActualX());
            this.minimalWindow.setWindowY(e.getScreenY() - this.minimalWindow.getWindowActualY());
        }
    }

    @Override
    public void root_onMouseReleasedAction(final MouseEvent e) {
        if (!this.minimalWindow.isWindowMaximized()) {
            this.minimalWindow.setMovableWindow();
        }
    }
    
    private void setCursorDefault(final MouseEvent e) {
        if (!e.isPrimaryButtonDown()) {
            this.minimalWindow.setMouseCursor(Cursor.DEFAULT);
        }
    }
    
    private void updateXY(final MouseEvent e) {      
        this.minimalWindow.setWindowActualX(e.getSceneX());
        this.minimalWindow.setWindowActualY(e.getSceneY());
    }
}

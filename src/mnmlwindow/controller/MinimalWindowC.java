package mnmlwindow.controller;


import javafx.scene.input.MouseEvent;

/**
 * Interface that has all methods needed for a window.
 * @author Matteo Michelotti
 */
public interface MinimalWindowC {
    
    /**
     * Perform the operations to minimize the window.
     * @param e = MouseEvent variable, if needed
     */
    void btnMin_clickAction(MouseEvent e);
    
    /**
     * Perform the operations to maximize or normalize the window.
     * @param e = MouseEvent variable, if needed
     */
    void btnMax_clickAction(MouseEvent e);
    
    /**
     * Perform the operations to close the window.
     * @param e = MouseEvent variable, if needed
     */
    void btnCls_clickAction(MouseEvent e);
    
    
    
    /**
     * Perform the operations when resize button is clicked.
     * @param e = MouseEvent variable, if needed
     */
    void btnResize_OnMouseClickedAction(MouseEvent e);
    
    /**
     * Perform the operations when resize button released.
     * @param e = MouseEvent variable, if needed
     */
    void btnResize_OnMouseReleasedAction(MouseEvent e);
    
    /**
     * Perform the operations when the mouse enter in the resize button.
     * @param e = MouseEvent variable, if needed
     */
    void btnResize_onMouseEntered(MouseEvent e);
    
    /**
     * Perform the operations when the mouse leave the the resize button.
     * @param e = MouseEvent variable, if needed
     */
    void btnResize_onMouseExited(MouseEvent e);
    
    /**
     * Perform the operations when the mouse drag the resize button.
     * @param e = MouseEvent variable, if needed
     */
    void btnResize_onMouseDragged(MouseEvent e);
                    
    
    
    
    /**
     * Perform the operations when window is pressed.
     * @param e = MouseEvent variable, if needed
     */
    void root_onMousePressedAction(MouseEvent e);
    
    /**
     * Perform the operations when window is dragged.
     * @param e = MouseEvent variable, if needed
     */
    void root_onMouseDraggedAction(MouseEvent e);
    
    /**
     * Perform the operations when window is released.
     * @param e = MouseEvent variable, if needed
     */
    void root_onMouseReleasedAction(MouseEvent e);
}

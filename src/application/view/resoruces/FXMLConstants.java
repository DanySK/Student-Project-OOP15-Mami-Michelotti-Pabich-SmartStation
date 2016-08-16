package application.view.resoruces;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class FXMLConstants {
    
    private static final DoubleProperty defaultMargin = new SimpleDoubleProperty(10);
    private static final DoubleProperty infinite = new SimpleDoubleProperty(9999);
    private static final DoubleProperty panelWidth = new SimpleDoubleProperty(250);
    private static final DoubleProperty smallSpacing = new SimpleDoubleProperty(3);
    private static final DoubleProperty mediumSpacing = new SimpleDoubleProperty(5);
    private static final DoubleProperty bigSpacing = new SimpleDoubleProperty(10);
    private static final DoubleProperty halfWidth = new SimpleDoubleProperty(55);
    private static final DoubleProperty notFullWidth = new SimpleDoubleProperty(70);
    private static final DoubleProperty fullWidth = new SimpleDoubleProperty(90);
    
   


    /**
     * Get default margin value.
     * @return value of the property
     */
    public static DoubleProperty getDefaultMargin() {
        return defaultMargin;
    }
    
    /**
     * Get default margin value.
     * @return value of the property
     */
    public static DoubleProperty getInfinite() {
        return infinite;
    }
    
    /**
     * Get the default panel width.
     * @return value of the property
     */
    public static DoubleProperty getPanelWidth() {
        return panelWidth;
    }
    
    /**
     * Get the default small spacing value.
     * @return value of the property
     */
    public static DoubleProperty getSmallSpacing() {
        return smallSpacing;
    }
    
    /**
     * Get the default medium spacing value.
     * @return value of the property
     */
    public static DoubleProperty getMediumSpacing() {
        return mediumSpacing;
    }
    
    /**
     * Get the default big spacing value.
     * @return value of the property
     */
    public static DoubleProperty getBigSpacing() {
        return bigSpacing;
    }
    
    /**
     * Get the default halfWidth value.
     * @return value of the property
     */
    public static DoubleProperty getHalfWidth() {
        return halfWidth;
    }

    /**
     * Get the default notFullWidth value.
     * @return value of the property
     */
    public static DoubleProperty getNotFullWidth() {
        return notFullWidth;
    }

    /**
     * Get the default fullWidth value.
     * @return value of the property
     */
    public static DoubleProperty getFullwidth() {
        return fullWidth;
    }
    
}

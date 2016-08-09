package mnmlwindow;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mnmlwindow.controller.MinimalWindowCImpl;
import mnmlwindow.view.MinimalWindowViewImpl;

/**
 * Class that implements the interface for a custom window logic.
 * @author Marcin Pabich
 */
public class MinimalWindowImpl implements MinimalWindow {
    
    private final MinimalWindowViewImpl view;
    private final Stage mainStage;
    
    /** 
     * Constructor for the MinimalWindow logic.
     * @param stage - the primaryStage of the method launch
     * @param minWidth - the minimum width of the window
     * @param minHeight - the minimum height of the window
     */
    public MinimalWindowImpl(final Stage stage, final int minWidth, final int minHeight) {
        //Takes the reference to primaryStage of launch method
        this.mainStage = stage;
        
        //Create the VIEW and respective CONTROLLER
        this.view = new MinimalWindowViewImpl(this.mainStage, minWidth, minHeight);
        new MinimalWindowCImpl(this.view);
        
        //Set the scene with all it needs
        final Scene scene = new Scene(this.view, minWidth, minHeight);
        scene.setFill(null);
        
        //Initialize the stage to make it ready to show
        this.mainStage.initStyle(StageStyle.TRANSPARENT);
        this.mainStage.setScene(scene);
    }

    @Override
    public void setTitle(final String title) {
        this.view.setWindowTitle(title);    
    }

    @Override
    public String getTitle() {
        return view.getWindowTitle();
    }

    @Override
    public void setLogo(final ImageView logo) {
        this.view.setWindowLogo(logo);    
    }

    @Override
    public ImageView getLogo() {
        return this.view.getWindowLogo();
    }

    @Override
    public void setFooter(final String footer) {
        this.view.setWindowFooter(footer);     
    }

    @Override
    public String getFooter() {
        return this.view.getWindowFooter();
    }

    @Override
    public void setContent(final Node node) {
        this.view.setWindowContent(node);      
    }

    @Override
    public void showWindow() {
        this.mainStage.show();       
    }


}

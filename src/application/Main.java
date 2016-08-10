package application;

import application.controller.MainController;
import application.controller.MainControllerImpl;
import application.model.Station;
import application.model.StationImpl;
import application.view.MainContentImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import mnmlwindow.MinimalWindow;
import mnmlwindow.MinimalWindowImpl;


/**
 * Main class of the application that launch it.
 * @author Pabich, Michelotti, Mami
 */
public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) {
        try {
            //First set all the models, views and controllers
            final Station model = new StationImpl(false, "<nome>", "<indirizzo>");
            final MainContentImpl view = new MainContentImpl();
            final MainController controller = new MainControllerImpl();               
            
            //Set the view's controller
            view.setController(controller);
            
            //Set the controller's ref to model and view
            controller.setModel(model);
            controller.setView(view);
            
            //Load the configuration file
            controller.loadConfiguration();
                        
            //Creating the style for the custom window
            final MinimalWindow minimalWindow = new MinimalWindowImpl(primaryStage, 840, 670);
            minimalWindow.setContent(view);
            minimalWindow.setTitle("Smart Station");
            minimalWindow.setFooter("JavaFX Project  |  Smart Station  |  M: Mami  |  V: Pabich  |  C: Michelotti");
            //TODO minimalWindowControl.setIcon("<source>");
                        
            //Finally, show the entire window
            minimalWindow.showWindow();
                        
                        
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
        
    /**
     * main method of the Main class, that launches the app.
     * @param args Eventual arguments when the app starts
     */
    public static void main(final String[] args) {
        launch(args);
    }
        
    /**
     * Kill the application.    
     * @param error Error given when the app is killed
     */
    public static void close(final int error) {
        System.exit(error);
    }
}
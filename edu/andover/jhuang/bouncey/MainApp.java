package edu.andover.jhuang.bouncey;

import java.io.IOException;

import edu.andover.jhuang.bouncey.model.Ball;
import edu.andover.jhuang.bouncey.model.BallEnvironment;
import edu.andover.jhuang.bouncey.view.MainScreenController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private BallEnvironment environment;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bouncey");

        initRootLayout();

        showScreen();
    }
    
 /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void initBallEnvironment() {
    	
    }
    /**
     * Shows the person overview inside the root layout.
     */
    public void showScreen() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainScreen.fxml"));
            AnchorPane mainScreen = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainScreen);
            
            // Give the controller access to the main app.
            MainScreenController controller = loader.getController();
            controller.setMainApp(this);
            
            environment = new BallEnvironment(controller.getNumberOfBalls());
            Ball[] b = environment.getBalls();
            
            for (int i = 0; i < b.length; i++) {
                mainScreen.getChildren().add(b[i]);
            }
            
            double width = controller.getWidth();
            double height = controller.getHeight();
            Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), e->
            environment.updatePositions(400, 
            		398, controller.getSpeed())));
            tl.setCycleCount(Timeline.INDEFINITE);
            tl.play();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);

    }
}

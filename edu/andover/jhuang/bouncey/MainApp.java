package edu.andover.jhuang.bouncey;

import java.io.IOException;

import edu.andover.jhuang.bouncey.model.Ball;
import edu.andover.jhuang.bouncey.model.BallEnvironment;
import edu.andover.jhuang.bouncey.view.MainScreenController;
import edu.andover.jhuang.bouncey.view.StartScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * BouncyBall Main App
 * 
 * BOUNCY_SOUND found on www.GRSites.com
 * 
 * Jenny Huang
 * JavaFX Demo App
 * COMP-630: Software Design, Instructor: Dr. Miles
 * 27 October 2015
 */

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private BallEnvironment environment;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bouncey");
        initRootLayout();
        showStartScreen();
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
    
    public void showStartScreen() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/StartScreen.fxml"));
            AnchorPane startScreen = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(startScreen);
            
            StartScreenController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the main screen inside the root layout.
     */
    public void showMainScreen(int numBalls) {
        try {
            // Load main screen.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainScreen.fxml"));
            AnchorPane mainScreen = (AnchorPane) loader.load();

            // Set main screen into the center of root layout.
            rootLayout.setCenter(mainScreen);
            
            // Give the controller access to the main app.
            MainScreenController controller = loader.getController();
            controller.setMainApp(this);
            
            //create new ball environment
            environment = new BallEnvironment(numBalls);
            Ball[] b = environment.getBalls();
            
            //add balls to screen
            for (int i = 0; i < b.length; i++) {
                mainScreen.getChildren().add(b[i]);
            }
            
            //timeline that updates ball movement and animations
            double ballScreenWidth = 400.0;
            double ballScreenLength = 400.0;
        	Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), e->
        		render(ballScreenWidth, ballScreenLength, controller.getSpeed(), 
        		controller)));
        	tl.setCycleCount(Timeline.INDEFINITE);
        	tl.play();
        	
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shows the end screen inside the root layout.
     */
    public void showEndScreen() {
        try {
            // Load end screen
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EndScreen.fxml"));
            AnchorPane endScreen = (AnchorPane) loader.load();
            
            // Set end screen into the center of root layout.
            rootLayout.setCenter(endScreen);

        } catch (IOException e) {
            e.printStackTrace();
        }	
    }
   
    // update positions or switch to end screen if at bounce limit
	public void render(double width, double height, double speed, 
						MainScreenController controller) {
		int bounceLimit = 1000;
		// switch to end screen when past bounce limit
		if (environment.getTotalNumBounces() >= bounceLimit) {
			showEndScreen();
		}
		
		// update positions and total number of bounces
		else {
			environment.updatePositions(width, height, speed);
			controller.setNumBouncesText(environment.getTotalNumBounces());
		}	
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}

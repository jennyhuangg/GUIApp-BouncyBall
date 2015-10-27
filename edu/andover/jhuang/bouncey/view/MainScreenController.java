package edu.andover.jhuang.bouncey.view;

import javafx.fxml.FXML;

import edu.andover.jhuang.bouncey.MainApp;
import edu.andover.jhuang.bouncey.model.BallEnvironment;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;


public class MainScreenController {
	@FXML
    private Label bounces;

    @FXML
    private Slider speed;
    
    @FXML
    private AnchorPane ballSpace;
    
    private BallEnvironment environment;
    private int numBalls;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MainScreenController() {

    }
    
    public double getWidth() {
    	return ballSpace.getWidth();
    }
    
    public double getHeight() {
    	return ballSpace.getHeight();
    }
    
    public double getSpeed() {
    	return speed.getValue() + 0.01;
    }
    public void getLabelText() {

    }
    
    public void setNumberOfBalls(int n) {
    	numBalls = n;
    }
    
    public int getNumberOfBalls(int n) {
    	return numBalls;
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
}

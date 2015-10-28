package edu.andover.jhuang.bouncey.view;

import javafx.fxml.FXML;

import java.io.IOException;

import edu.andover.jhuang.bouncey.MainApp;
import edu.andover.jhuang.bouncey.model.BallEnvironment;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

/*
 * BouncyBall Main Screen Controller
 * 
 * Jenny Huang
 * JavaFX Demo App
 * COMP-630: Software Design, Instructor: Dr. Miles
 * 27 October 2015
 */

public class MainScreenController {
	@FXML
    private Label bounces;

    @FXML
    private Slider speed;
    
    @FXML
    private AnchorPane ballSpace;
    
    private BallEnvironment environment;
    private int numBalls;
    private int numTotalBounces;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */

 
    public double getWidth() {
    	return ballSpace.getWidth();
    }
    
    public double getHeight() {
    	return ballSpace.getHeight();
    }
    
    public double getSpeed() {
    	return speed.getValue() + 0.01;
    }
    public void setNumBouncesText(int n) {
    	bounces.setText("" + n);
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

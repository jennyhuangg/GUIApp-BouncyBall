package edu.andover.jhuang.bouncey.view;

import edu.andover.jhuang.bouncey.MainApp;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;

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
    private Label pauseLabel;

    // Reference to the main application.
    private MainApp mainApp;
    
    public double getSpeed() {
    	return speed.getValue() + 0.01;
    }
    public void setNumBouncesText(int n) {
    	bounces.setText("" + n);
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}

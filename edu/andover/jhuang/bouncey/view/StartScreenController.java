package edu.andover.jhuang.bouncey.view;

import java.io.IOException;

import edu.andover.jhuang.bouncey.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/*
 * BouncyBall Start Screen Controller
 * 
 * Jenny Huang
 * JavaFX Demo App
 * COMP-630: Software Design, Instructor: Dr. Miles
 * 27 October 2015
 */

public class StartScreenController {
	@FXML
	private TextField numBalls;
	
	@FXML
	private Button btn;
	
	@FXML
	private Label error;
	
    // Reference to the main application.
    private MainApp mainApp;
    
    @FXML
    private void handleButtonAction() throws IOException {
    	try {
    		String s = numBalls.getText();
			int n = Integer.parseInt(s);
			mainApp.showMainScreen(n);
			
		 //error if text input is not an integer
		 } catch(IllegalArgumentException e) {
			 error.setText("Please enter an integer.");
		 }
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

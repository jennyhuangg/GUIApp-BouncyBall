package edu.andover.jhuang.bouncey.view;

import java.io.IOException;

import edu.andover.jhuang.bouncey.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartScreenController {
	@FXML
	private TextField numBalls;
	
	@FXML
	private Button btn;
	
	@FXML
	private Label error;
	
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    
    @FXML
    private void handleButtonAction() throws IOException {
    	mainApp.showMainScreen(3);
    }
    
    public int getNumBalls() {
    	String s = numBalls.getText();
    	try {
			int n = Integer.parseInt(s);
			return n;
			
		 } catch(IllegalArgumentException e) {
			 error.setText("Please enter an integer.");
		 }
    	
    	return -1;
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}

package edu.andover.jhuang.bouncey.view;

import edu.andover.jhuang.bouncey.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StartScreenController {
	@FXML
	private TextField numBalls;
	
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    
	
	
	
	
}

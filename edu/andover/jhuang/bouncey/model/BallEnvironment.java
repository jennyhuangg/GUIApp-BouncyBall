package edu.andover.jhuang.bouncey.model;

import edu.andover.jhuang.bouncey.MainApp;
import edu.andover.jhuang.bouncey.view.MainScreenController;
import javafx.scene.paint.Color;

/*
 * BouncyBall Ball Environment Class
 * 
 * Jenny Huang
 * JavaFX Demo App
 * COMP-630: Software Design, Instructor: Dr. Miles
 * 27 October 2015
 */

public class BallEnvironment {

	private Ball[] balls;
	public int totalNumBounces;
	
	public BallEnvironment(int n) {
		balls = new Ball[n];
		for (int i = 0; i < n; i++) {
			int r = (int)(256*Math.random());
			int g = (int)(256*Math.random());
			int b = (int)(256*Math.random());
			Color randomColor = Color.rgb(r,g,b);
			balls[i] = new Ball(397*Math.random(),397*Math.random(),randomColor);
		}
	}
	
	public Ball[] getBalls() {
		return balls;
	}
	
	public void updatePositions(double width, double height, double speed) {
		for (int i = 0; i < balls.length; i++) {
			balls[i].updateSpeed(speed);
			balls[i].moveBall(width, height);
			totalNumBounces += balls[i].getNumBounces();
		}
	}
	
	public int getTotalNumBounces() {
		return totalNumBounces;
	}
	

}

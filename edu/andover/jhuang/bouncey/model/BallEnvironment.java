package edu.andover.jhuang.bouncey.model;

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
			int r = (int)(150*Math.random())+106;
			int g = (int)(150*Math.random())+106;
			int b = (int)(150*Math.random())+106;
			Color c = Color.rgb(r,g,b);
			balls[i] = new Ball(350*Math.random()+20,350*Math.random()+20, c);
		}
	}
	
	public Ball[] getBalls() {
		return balls;
	}
	
	public int getTotalNumBounces() {
		return totalNumBounces;
	}
	
	public void updatePositions(double width, double height, double speed) {
		for (int i = 0; i < balls.length; i++) {
			balls[i].updateSpeed(speed);
			balls[i].moveBall(width, height);
			totalNumBounces += balls[i].getNumBounces();
		}
	}
}

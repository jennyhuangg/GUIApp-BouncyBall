package edu.andover.jhuang.bouncey.model;

import java.util.Random;

import javafx.scene.paint.Color;

public class BallEnvironment {

	private Ball[] balls;
	
	public BallEnvironment(int n) {
		balls = new Ball[n];
		for (int i = 0; i < n; i++) {
			Random rand = new Random();
			int r = rand.nextInt(255);
			int g = rand.nextInt(255);
			int b = rand.nextInt(255);
			Color randomColor = Color.rgb(r,g,b);
			balls[i] = new Ball(398*Math.random(),398*Math.random(),randomColor);
		}
	}
	
	public Ball[] getBalls() {
		return balls;
	}
	
	public void updatePositions(double width, double height, double speed) {
		for (int i = 0; i < balls.length; i++) {
			balls[i].updateSpeed(speed);
			balls[i].moveBall(width, height);
		}
	}
}

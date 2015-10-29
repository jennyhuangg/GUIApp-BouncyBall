package edu.andover.jhuang.bouncey.model;

import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
 * BouncyBall Ball Class
 * 
 * Jenny Huang
 * JavaFX Demo App
 * COMP-630: Software Design, Instructor: Dr. Miles
 * 27 October 2015
 */

public class Ball extends Circle {

	private final double initialDx;
	private final double initialDy;
	private double dx; //change in x position each move
    private double dy; //change in y position each move
    private int numBounces; //0 if no bounce, 1 if bounce for that move

    public Ball(double x, double y, Color c) {
      super(x,y,12,c);
      initialDx = Math.random();
      initialDy = Math.sqrt(1 - initialDx*initialDx);
      dx = 0;
      dy = 0;
    }
    
    public double getDx() {
    	return dx;
    }
    
    public double getDy() {
    	return dy;
    }
    
    public void setDx(double newDx) {
    	dx = newDx;
    }
    
    public void setDy(double newDy) {
    	dy = newDy;
    }
    
    public int getNumBounces() {
    	return numBounces;
    }
    
    public void updateSpeed(double speed) {
    	if (dx < 0)
    		dx = -1*initialDx*speed/2.0;
    	else
    		dx = initialDx*speed/2.0;
    	if (dy < 0)
    		dy = -1*initialDy*speed/2.0;
    	else
    		dy = initialDy*speed/2.0;
    }
    
    public void moveBall(double width, double height) {
    	numBounces = 0;
    	
    	//move ball
    	setCenterX(getDx() + getCenterX());
    	setCenterY(getDy() + getCenterY());
   
          //while hits edge
	      while(getCenterY()+getRadius()> height||getCenterY()-getRadius()<0||
	    		  getCenterX()+getRadius()>width||getCenterX()-getRadius()<0)
	      {
	    	  //if ball past height
	    	  if(getCenterY()+getRadius()>height)
	    	  {
	    		  //reflect the point of impact back over the line
	    		  setCenterY(2*height-getCenterY()-2*getRadius());
	    		  dy *= -1;
	    	  }
	    	  //if ball past 0
	    	  if(getCenterY()-getRadius()<0)
	    	  {
	    		  //reflect the point of impact back over the line
	    		  setCenterY(2*0-getCenterY()+2*getRadius());
	    		  dy *= -1;
	    	  }
	    	  //if ball past width
	    	  if(getCenterX()+getRadius()>width)
	    	  {
	    		  //reflect the point of impact back over the line
	    		  setCenterX(2*width-getCenterX()-2*getRadius());
	    		  dx *= -1;
	    	  }
	    	  //if ball past 0
	    	  if(getCenterX()-getRadius()<0)
	    	  {
	    		  //This will reflect the point of impact back over the line
	    		  setCenterX(2*0-getCenterX()+2*getRadius());
	    		  dx *= -1;
	    	  }
	    	  numBounces++;
	    	  
	    	  //play bounce sound
	    	  AudioClip BOUNCE_SOUND = new AudioClip("file:src/cartoon015.wav");
	    	  BOUNCE_SOUND.play();
	      }    
    }
}

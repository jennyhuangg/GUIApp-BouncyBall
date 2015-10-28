package edu.andover.jhuang.bouncey.model;

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

    private double dx;
    private double dy;
    private int numBounces; //0 if no bounce, 1 if bounce for that move

    public Ball(double x, double y, Color c) {
      super(x,y,8,c);
      dx = 1;
      dy = 1;
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
    		dx = -1*speed/4.0;
    	else
    		dx = speed/4.0;
    	if (dy < 0)
    		dy = -1*speed/4.0;
    	else
    		dy = speed/4.0;
    }
    
    public void moveBall(double width, double height) {
    	
    	numBounces = 0;
        setCenterX(getDx() + getCenterX());
        setCenterY(getDy() + getCenterY());
        
      while(getCenterY()+getRadius()> height||getCenterY()-getRadius()<0||getCenterX()+getRadius()>width||getCenterX()-getRadius()<0)//Begin of actual collisions thing
      {
        if(getCenterY()+getRadius()>height)//Tests to see if went beyond the height
        {
          setCenterY(2*height-getCenterY()-2*getRadius());//This will reflect the point of impact back over the line
          dy *= -1;
        }
        if(getCenterY()-getRadius()<0)//Tests to see if went beyond the 0
        {
          setCenterY(2*0-getCenterY()+2*getRadius());//This will reflect the point of impact back over the line
          dy *= -1;
        }
        if(getCenterX()+getRadius()>width)//Tests to see if it went too far to the width
        {
          setCenterX(2*width-getCenterX()-2*getRadius());//This will reflect the point of impact back over the line
          dx *= -1;
        }
        if(getCenterX()-getRadius()<0)//Tests to see if it went too far to the 0
        {
          setCenterX(2*0-getCenterX()+2*getRadius());//This will reflect the point of impact back over the line
          dx *= -1;
        }
        numBounces++;
      }     

    }
    
    public void moveBall2(double width, double height) {
    	
        setCenterX(dx + getCenterX());
        setCenterY(dy + getCenterY());
          if (getCenterX() <= getRadius() || getCenterX() >= width-getRadius()) {
            dx *= -1;
          }
          if (getCenterY() <= getRadius() || getCenterY() >= height-getRadius()) {
            dy *= -1;
          } 

   }
}

package edu.andover.jhuang.bouncey.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {

    private double dx;
    private double dy;

    public Ball(double x, double y, Color c) {
      super(x,y,4,c);
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
   
   /* public void moveBall4(double width, double height) {
    	centerX += dx;
    	centerY += dy;
        
      while(centerY+4> height||centerY-4<0||centerX+4>width||centerX+4<0)//Begin of actual collisions thing
      {
        if(centerY+4>height)//Tests to see if went beyond the height
        {
          centerY = 2*height-centerY-2*4;//This will reflect the point of impact back over the line
          dy *= -1;
        }
        if(getCenterY()-getRadius()<0)//Tests to see if went beyond the 0
        {
          centerY = 2*0-centerY+2*4;//This will reflect the point of impact back over the line
          dy *= 1;
        }
        if(getCenterX()+getRadius()>width)//Tests to see if it went too far to the width
        {
          centerX = 2*width-centerX-2*4;//This will reflect the point of impact back over the line
          dx *= -1;
        }
        if(getCenterX()-getRadius()<0)//Tests to see if it went too far to the 0
        {
          centerX = 2*0-centerX +2*4;//This will reflect the point of impact back over the line
          dx *= -1;
        }
      }     
    	
    }
    */
    
    public void moveBall2(double width, double height) {
   
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
      }     

    }
    
    public void moveBall(double width, double height) {
    	
        setCenterX(dx + getCenterX());
        setCenterY(dy + getCenterY());
          if (getCenterX() <= getRadius() +4 || getCenterX() >= width-getRadius()) {
            dx *= -1;
          }
          if (getCenterY() <= getRadius() + 4|| getCenterY() >= height-getRadius()) {
            dy *= -1;
          } 

   }
}

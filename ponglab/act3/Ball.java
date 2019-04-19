//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
  public Ball(int x, int y){
	super(x,y);
	xSpeed = 3;
	ySpeed = 1;
  }

public Ball(int x, int y, int w, int h){
	super(x,y,w,h);
	xSpeed = 3;
	ySpeed = 1;
}

public Ball(int x, int y, int w, int h, Color c){
	super(x,y,w,h,c);
	xSpeed = 3;
	ySpeed = 1;
}

public Ball(int x, int y, int w, int h, Color c, int up, int side){
	super(x,y,w,h,c);
	xSpeed = up;
	ySpeed=side;
}

  //add the set methods
public void setXSpeed(int x){
	xSpeed = x;
}
public void setYSpeed(int y){
	ySpeed = y;
}
public int getYSpeed(){
	return ySpeed;
}
public int getXSpeed(){
	return xSpeed;
}
  public void moveAndDraw(Graphics window)
  {
	window.setColor(Color.WHITE);
	window.fillRect(getX(),getY(),getWidth(),getHeight());
    //draw a white ball at old ball location
	

	setX(getX()+xSpeed);
	setY(getY()+ySpeed);
    //setY
	window.setColor(getColor());
	window.fillRect(getX(),getY(),getWidth(),getHeight());
    //draw the ball at its new location
  }
   
  public boolean equals(Object obj)
  {
	Ball b = (Ball)obj;
    return super.equals(obj)&&xSpeed==b.xSpeed&&ySpeed==b.ySpeed;
  }   

  //add the get methods
public String toString(){
	return super.toString()+ " " + xSpeed+ " " + ySpeed;
}
  //add a toString() method
}

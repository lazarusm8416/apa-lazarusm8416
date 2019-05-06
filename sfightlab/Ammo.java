//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
  private int speed;

  public Ammo()
  {
    this(0,0,20);
  }

  public Ammo(int x, int y)
  {
    this(x,y,20);
  }

  public Ammo(int x, int y, int s)
  {
    super(x,y,5,5);
	speed=s;
	System.out.println("bullet");
  }

  public void setSpeed(int s)
  {
    speed=s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void draw( Graphics window )
  {
	window.setColor(Color.YELLOW);
    window.drawRect(getX(),getY(),getWidth(),getHeight());
  }
   
  public void move( String direction )
  {
    if (direction.equals("shoot"))
	setY(getY()-speed);
  }

  public boolean didColide(Alien al){
	if (getX()>=al.getX()&&getX()<=al.getX()+al.getWidth()&&getY()>=al.getY()&&getY()<=al.getY()+al.getHeight()){
		System.out.println("colide");
		return true;
	}
	return false;
  }

  public String toString()
  {
    return super.toString() + " " + speed;
  }
}

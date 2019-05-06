//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
  private int speed;
  private Image image;

  public Alien()
  {
    this(0,0,30,30,1);
  }

  public Alien(int x, int y)
  {
    this(x,y,50,50,1);
  }

  public Alien(int x, int y, int s)
  {
    this(x,y,50,50,s);
  }

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x, y, w, h);
    speed=s;
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      System.out.println("alien");
    }
  }

  public void setSpeed(int s)
  {
    speed=s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void move(String direction)
  {
	if (direction.equals("up"))
		setY(getY()-speed);
	if (direction.equals("down"))
		setY(getY()+speed*3);
	if (direction.equals("right"))
		setX(getX()+speed);
	if (direction.equals("left"))
		setX(getX()-speed);
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString()+" "+speed;
  }
}

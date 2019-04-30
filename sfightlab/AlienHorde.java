//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;

  public AlienHorde(int size)
  {
	aliens=new ArrayList<Alien>(size);
  }

  public void add(Alien al)
  {
	aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
	for (Alien al : aliens){
		al.draw(window);
	}
  }

  public void moveEmAll()
  {
	for (Alien al : aliens){
		for (int i =0; i<50; i++)
			al.move("right");
		for (int j =0; j<50;j++)
			al.move("down");
		for (int a=0; a<50; a++)
			al.move("left");
	}
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
  }

  public String toString()
  {
	String output = "";
	for (Alien al : aliens)
		output+=" "+ al;
	return output;
  }
}

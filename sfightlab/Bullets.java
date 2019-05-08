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

public class Bullets
{
  private List<Ammo> ammo;

  public Bullets()
  {
	ammo = new ArrayList<Ammo>(0);
  }

  public void add(Ammo al)
  {
	ammo.add(al);
  }

  //post - draw each Ammo
  public void drawEmAll( Graphics window )
  {
	for (Ammo b : ammo){
		b.draw(window);
	}
  }

  public void moveEmAll()
  {
	for (Ammo b : ammo)
		b.move("shoot");
  }
  public int fired(){
	return ammo.size();
  }

  public void cleanEmUp()
  {
	if (ammo.size()>0){
		for (int i=ammo.size()-1; i>=0; i--){
			if (ammo.get(i).getY()<10){
				ammo.remove(i);
				System.out.println("bullet vanish");
			}
		}
	  }
  }

  public List<Ammo> getList()
  {
    return ammo;
  }

  public String toString()
  {
    return "Bullets: " +ammo.size();
  }
}

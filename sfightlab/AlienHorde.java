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
	int s=size*50;
	if (s>0){
		for (int x = 50; x<= s+50; x+=100){
			for (int y = 50; y<=s; y+=100){
				aliens.add(new Alien(x,y,1));
			}
		}
	}
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
		if (al.getX()<=570){
			al.move("right");
		}
		if (al.getX()==570){
			al.move("down");
			al.setSpeed(al.getSpeed()*-1);
		}
		if (al.getX()==30){
			al.setSpeed(al.getSpeed()*-1);
			al.move("down");
		}
	}
  }

  public void removeDeadOnes(List<Ammo> shots)
  {
	if (aliens.size()>0&&shots.size()>0){
		System.out.println("there are bullets&aliens");
		for (int i = aliens.size()-1; i<0 ;i--){
			for (int j=shots.size()-1; j<0; j--){
				if (shots.get(j).didColide(aliens.get(i))){
					System.out.println("hit");
					aliens.remove(i);
				}
			}
		}
	}

  }

  public String toString()
  {
	String output = "";
	for (Alien al : aliens)
		output+=" "+ al;
	return output;
  }
}

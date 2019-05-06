//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private Ship ship;
 // private Alien alienOne;
  //private Alien alienTwo;

  
   private AlienHorde horde;
   private Bullets shots;
  

  private boolean[] keys;
  private BufferedImage back;

  public OuterSpace()
  {
    setBackground(Color.black);

    keys = new boolean[5];
	horde = new AlienHorde(4);
	shots = new Bullets();
	ship = new Ship(400,300,50,50,3);

	//alienOne = new Alien(200,100);
	//alienTwo = new Alien(100,100);
    //instantiate other instance variables
    //Ship, Alien

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();

    graphToBack.setColor(Color.BLUE);
    graphToBack.drawString("StarFighter ", 25, 50 );
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);

	ship.draw(graphToBack);
	horde.drawEmAll(graphToBack);
	horde.moveEmAll();
	shots.drawEmAll(graphToBack);
	shots.moveEmAll();
	shots.cleanEmUp();
	horde.removeDeadOnes(shots.getList());


    if(keys[0] == true)
    {System.out.println("AAAAAA");
        ship.move("left");
    }
    if (keys[1]==true){
	System.out.println("BBBB");
	ship.move("right");
	}

    if (keys[2]==true){
	System.out.println("CCCCCC");
	ship.move("up");
	}

    if (keys[3]==true){
	System.out.println("DDDDDD");
	ship.move("down");
	}
	
	if (keys[4]==true){
		System.out.println("shooot");
		shots.add(new Ammo(ship.getX()+(ship.getWidth()/2),ship.getY(),6));
		keys[4]=false;
	}
    //add code to move Ship, Alien, etc.


    //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship


    twoDGraph.drawImage(back, null, 0, 0);
	//System.out.println(ship);
  }


  public void keyPressed(KeyEvent e)
  {
	//System.out.println("KEYPRESS");
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
	//System.out.println("keyRELEASED");
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}


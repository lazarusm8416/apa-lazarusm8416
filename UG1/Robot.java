//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    head(window);
    //call other methods
    upperBody(window);
    
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.YELLOW);
    
    window.fillOval(300, 100, 200, 100);
   
    window.setColor(Color.BLACK);

    window.drawOval(350, 125, 25, 25);
    window.drawOval(450, 125, 25, 25);
    window.drawArc(400, 160, 100, 50, 90, 90);

    //add more code here
    
  }

  public void upperBody( Graphics window )
  {
	window.setColor(Color.RED);
	window.fillRect(300, 200, 200, 100);
	window.fillRect(300, 350, 200, 150);

	window.setColor(Color.BLACK);
	window.drawLine(500, 200, 600, 100);
	window.drawLine(300, 200, 200, 100);

	window.drawLine(300, 500, 200, 600);
	window.drawLine(500, 500, 600, 600);
  }

  public void lowerBody( Graphics window )
  {

    //add more code here
    
  }
}

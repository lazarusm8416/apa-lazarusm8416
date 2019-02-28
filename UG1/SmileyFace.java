//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class SmileyFace extends Canvas
{
   public SmileyFace()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      smileyFace(window);
   }

   public void smileyFace( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString("SMILEY FACE LAB ", 35, 35);

      window.setColor(Color.YELLOW);
      window.fillOval( 220, 200, 400, 400 );

	window.setColor(Color.BLACK);
	window.fillOval(350, 250, 20, 20);
	window.fillOval(500, 250, 20, 20);

	window.drawLine(300, 300, 400, 400);
	window.drawLine(400, 400, 500, 300);
		//add more code here


   }
}

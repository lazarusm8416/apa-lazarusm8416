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

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  private boolean[] keys;
  private BufferedImage back;

	private Score score;
	private Block top;
	private Block l;
	private Block r;
	private Block bot;
  public Pong()
  {
    //set up all variables related to the game
	top = new Block(1,1,798,3);
	l = new Block(1,1,3,598);
	r = new Block(796,1,3,598);
	bot = new Block(1,596,798,3);
	ball = new Ball();
	leftPaddle = new Paddle(20,15,3,100);
	rightPaddle = new Paddle(770,300,3,100);
	score = new Score();

    keys = new boolean[4];

    
    setBackground(Color.WHITE);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);		//starts the key thread to log key strokes
  }
	
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
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

    top.draw(graphToBack);
    l.draw(graphToBack);
    r.draw(graphToBack);
    bot.draw(graphToBack);
    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    graphToBack.drawString(score.toString(),400,300);

    //see if ball hits left wall or right wall
    if(!(ball.getX()>=10 && ball.getX()<=780))
    {
	if (ball.getX()<15)
		score.rScore();
	else
		score.lScore();
      ball.setXSpeed(ball.getXSpeed()*-1);
      ball.setYSpeed(ball.getYSpeed()*-1);
    }

		
    //see if the ball hits the top or bottom wall 
	if(ball.getY()==0||ball.getY()==600){
		ball.setYSpeed(ball.getYSpeed()*-1);
	}


    //see if the ball hits the left paddle
	if(leftPaddle.getY()<ball.getY()&&ball.getY()<leftPaddle.getY()+leftPaddle.getHeight())
		if(leftPaddle.getX()+leftPaddle.getWidth()+Math.abs(ball.getXSpeed())==ball.getX())
			ball.setXSpeed(ball.getXSpeed()*-1);
		
		
    //see if the ball hits the right paddle
	if(rightPaddle.getY()<ball.getY() && ball.getY()<rightPaddle.getY()+rightPaddle.getHeight())
		if(rightPaddle.getX()-Math.abs(ball.getXSpeed())==ball.getX())
			ball.setXSpeed(ball.getXSpeed()*-1);
		
		


    //see if the paddles need to be moved

   if (keys[0])
    {
      //move left paddle up and draw it on the wind
      leftPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[1])
    {
      //move left paddle down and draw it on the window
        leftPaddle.moveDownAndDraw(graphToBack);

    }
    if (keys[2])
    {
        rightPaddle.moveUpAndDraw(graphToBack);
    }
    if (keys[3])
    {
        rightPaddle.moveDownAndDraw(graphToBack);
    }




		
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(true)
      {
	Thread.currentThread().sleep(8);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}

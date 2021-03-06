import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
///////////////////////lab assesment////////////////////////

/*public void blur(int x, int y, int w, int h){
	Pixel[][] pixels = this.getPixels2D();
	//Pixel blurring = null;
	int red = 0;
	int blue = 0;
	int green = 0;
	int count = 0;

	for (int r = x; r<w+x; r++)
		for (int c = y; c<h+y;c++){
			//blurring = pixels[r][c];

			for (int i=-1;i<2;i++)
				for (int j=-1;j<2;j++)
					if (r+i>0&&r+i<pixels.length&&c+j>0&&c+j<pixels[0].length){
						red+=pixels[r+i][c+j].getRed();
						blue+=pixels[r+i][c+j].getBlue();
						green+=pixels[r+i][c+j].getGreen();
						count+=1;
					}
			red/=count;
			green/=count;
			blue/=count;

			pixels[r][c].setRed(0);
			pixels[r][c].setGreen(0);
			pixels[r][c].setBlue(0);

			red=0;
			green=0;
			blue=0;
			count=0;
		}
}*/
public void blur(int x, int y, int w, int h){
	Pixel[][] pixels = this.getPixels2D();
	Pixel blur = null;
	int red = 0;
	int green = 0;
	int blue = 0;
	int count = 0;
	
	for (int r = x;r<x+w;r++)
		for (int c = y; c<y+h;c++){
		blur = pixels[r][c];

		for (int i=-1;i<2;i++)
			for (int j =-1; j<2;j++)
				if (r+i>=0 && r+i<=pixels.length && c+j>=0 && c+j<=pixels[0].length){
					red+=pixels[r+i][c+j].getRed();
					green+=pixels[r+i][c+j].getGreen();
					blue+=pixels[r+i][c+j].getBlue();
					count+=1;
				}
		
		red=red/count;
		green=green/count;
		blue=blue/count;
		
		blur.setRed(red);
		blur.setGreen(green);
		blur.setBlue(blue);
		}
}

////////////////////////activities////////////////////////////

  public void mirrorArms() {
	int rowTop = 160;
	int rowBot = 192;
	int colLeft = 106;
	int colRight = 171;
	
	int widthBetween = 70 + (colRight-colLeft);

	mirrorSquare(colLeft,colRight,rowTop,rowBot,-8,68);
	mirrorSquare(colLeft+widthBetween,colRight + widthBetween, rowTop,rowBot,4,68);
  }
  
  /**Method that duplicates a seagull in a picture
   * so that there are two seagulls near eachother */
  public void mirrorGull() {
	int rowTop = 236;
	int rowBot = 325;	  
	int colLeft = 239;
	int colRight = 345;
	int width = colRight-colLeft;
		
	mirrorSquare(colLeft, colRight, rowTop, rowBot, -5 -width,0); 
  }


public void myCollage(Picture pic1, Picture pic2, Picture pic3){
	Pixel p = null;
	Pixel o = null;
	Pixel x = null;
	Pixel[][] coll = this.getPixels2D();
	Pixel[][] one = pic1.getPixels2D();
	Pixel[][] two = pic2.getPixels2D();
	Pixel[][] three = pic3.getPixels2D();
	for (int r=0; r<coll.length/2;r++)
		for (int c=0;c<coll[0].length/2;c++){
			p=coll[r][c];
			o=one[r][c];
			p.setColor(o.getColor());
		}
	for (int r = coll.length/2; r<coll.length-1; r++)
		for (int c = 0;c<coll[0].length/2;c++){
			p=coll[r][c];
			o=two[r][c];
			p.setColor(o.getColor());
		}
	for (int r = 0; r<coll.length/2; r++)
		for (int c=coll[0].length/2;c<coll[0].length;c++){
			p=coll[r][c];
			x=coll[coll.length-r-1][c];
			o=three[r][c];
			p.setColor(o.getColor());
			x.setColor(o.getColor());
		}
}




public void keepOnlyBlue(){
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] row : pixels)
		for (Pixel p : row){
			p.setRed(0);
			p.setGreen(0);
		}
}


public void negate(){
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] row : pixels)
		for (Pixel p : row){
			p.setRed(255-p.getRed());
			p.setBlue(255-p.getBlue());
			p.setGreen(255-p.getGreen());
		}
}


public void grayScale(){
	Pixel[][] pixels = this.getPixels2D();
	for (Pixel[] row : pixels)
		for (Pixel p : row){
			int g = (int)(0.21*p.getRed() + 0.72*p.getGreen() + 0.07*p.getBlue());
			p.setRed(g);
			p.setBlue(g);
			p.setGreen(g);

		}
}


public void findFish(){
	Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels)
			for (Pixel p : row){
				p.setRed(p.getRed()+10);
				p.setBlue(p.getBlue()-20);
				p.setGreen(p.getGreen()-10);
			}
}

public void vertMirror(){
	Pixel[][] pixels = this.getPixels2D();
	Pixel left = null;
	Pixel right = null;
	int width = pixels[0].length;
	for (int r = 0; r<pixels.length; r++)
		for (int c=0; c<width/2; c++){
			left=pixels[r][c];
			right = pixels[r][width-1-c];
			left.setColor(right.getColor());
		}
}

public void horMirror(){
	Pixel[][] pixels = this.getPixels2D();
	Pixel top = null;
	Pixel bot = null;
	int height = pixels.length;
	for (int r = 0; r<height/2;r++)
		for (int c =0; c<pixels[0].length;c++){
			top = pixels[r][c];
			bot = pixels[height-r-1][c];
			bot.setColor(top.getColor());
		}
}

public void horMirror2(){
	Pixel[][] pixels = this.getPixels2D();
	Pixel top = null;
	Pixel bot = null;
	int height = pixels.length;
	for (int r = 0; r<height/2; r++)
		for (int c = 0; c<pixels[0].length; c++){
			top = pixels[r][c];
			bot = pixels[height-r-1][c];
			top.setColor(bot.getColor());
		}
}

public void Diag(){
	Pixel[][] pixels = this.getPixels2D();
	int h = pixels.length;
	int w = pixels[0].length;
	Pixel t = null;
	Pixel b = null;
	int height = h;
	int width = w;
	for (int r = 0; r<height; r++){
		for (int c = 0; c<width; c++){
		t=pixels[r][c];
		b=pixels[h-r-1][w-c-1];
		t.setColor(b.getColor());
		}
	width--;
	}
}

public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical){
	Pixel one = null;
	Pixel two = null;
	Pixel[][] pixels = this.getPixels2D();
	int height = y2-y1;
	int width = x2-x1;
	if (vertical){
		for (int r = x1; r<x2; r++)
			for (int c = y1; c<y2/2; c++){
				one = pixels[r][c];
				two = pixels[r][width-c-1];
				one.setColor(two.getColor());
			}
	}
	if (!vertical){
		for (int r = x1; r<x2/2; r++)
			for (int c=y1; c<y2; c++){
				one = pixels[r][c];
				two = pixels[height-r-1][c];
				one.setColor(two.getColor());
			}
	}
}

  public void mirrorSquare(int x1, int x2, int y1, int y2, int xShift, int yShift) {
  
	int colLeft = x1;
	int colRight = x2;
	int rowTop = y1;
	int rowBot = y2;


	Pixel pixelOne = null;
	Pixel pixelTwo = null;
	Pixel[][] pixels = this.getPixels2D();
		  
	for(int col = colLeft ; col < colRight; col++) {
		for (int row = rowTop; row < rowBot; row++) {
			pixelOne = pixels[row][col];
			pixelTwo = pixels[row + yShift][col+xShift];
			pixelTwo.setColor(pixelOne.getColor());
		}
	}
  }

 public void copy2(Picture fromPic, int startRow, int startCol, int startX, int endX, int startY, int endY) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    
    for (int fromRow = startY, toRow = startRow; fromRow < endY && toRow < toPixels.length; fromRow++, toRow++){
      for (int fromCol = startX, toCol = startCol; fromCol < endX && toCol < toPixels[0].length; fromCol++, toCol++){
    	fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
 }
//////////////////////////////////////////////////////////
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
 public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  


  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
	count+=1;
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  public void edgeDetection2(int edgeDist){
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel bottomPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  Color bottomColor = null;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; 
	           col < pixels[0].length-1; col++)
	      {
	    	if(row != pixels.length-1) {
	    		bottomPixel = pixels[row+1][col];
	    	}
	    	else {
	    		bottomPixel = pixels[row][col];
	    	}
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][col+1];
	        bottomColor = bottomPixel.getColor();
	        rightColor = rightPixel.getColor();
	        if (leftPixel.colorDistance(rightColor) > 
	            edgeDist || (leftPixel.colorDistance(bottomColor)  > edgeDist))
	          leftPixel.setColor(Color.BLACK);
	        else
	          leftPixel.setColor(Color.WHITE);
	      }
	    }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this

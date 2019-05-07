/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
//////////////////////////lab//////////
public static void testBlur(int x, int y, int w, int h, int n){
	Picture swan = new Picture("swan.jpg");
	for (int i = 0; i<n;i++)
		swan.blur(x,y,w,h);
	swan.explore();
}

///////////////////////
	
public static void testMirrorrms(){
	Picture snow = new Picture("snowman.jpg");
	snow.explore();
	snow.mirrorArms();
	snow.explore();
}
	
public static void testMirrorGull(){
	Picture gull = new Picture("seagull.jpg");
	gull.explore();
	gull.testMirrorGull();
	gull.explore();
}

public static void testKeepOnlyBlue(){
	Picture swan = new Picture("swan.jpg");
	swan.explore();
	swan.keepOnlyBlue();
	swan.explore();
}

public static void testNegate(){
	Picture beach = new Picture("beach.jpg");
	beach.explore();
	beach.negate();
	beach.explore();
}

public static void testGrayscale(){
	Picture beach = new Picture("beach.jpg");
	beach.explore();
	beach.grayScale();
	beach.explore();
}

public static void fixUnderwater(){
	Picture fish = new Picture("water.jpg");
	fish.explore();
	fish.findFish();
	fish.explore();
}
public static void testMirrorVerticalLeftToRight(){
	Picture water = new Picture("water.jpg");
	water.explore();
	water.vertMirror();
	water.explore();
}
public static void testHorizantalMirror(){
	Picture p = new Picture("swan.jpg");
	p.explore();
	p.horMirror();
	p.explore();
}
public static void testHorizantalMirrorBotToTop(){
	Picture p = new Picture("swan.jpg");
	p.explore();
	p.horMirror2();
	p.explore();
}

public static void testDiagonal(){
	Picture p = new Picture ("swan.jpg");
	p.explore();
	p.Diag();
	p.explore();
}
/////////////////

  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testBlur(300,50,50,100,10);
    testHorizantalMirror();
    testHorizantalMirrorBotToTop();
    findFish();
    testZeroBlue();
    testKeepOnlyBlue();
    testKeepOnlyRed();
    testKeepOnlyGreen();
    testNegate();
    testGrayscale();
    testFixUnderwater();
    testMirrorVertical();
    testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}

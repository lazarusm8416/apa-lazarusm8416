//Name -
//Date -
//Class -
//Lab  - 


public abstract class Card
{
  public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
                                        "FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

  private String suit;
  private int face;

  public Card (){
	// int f = (int)(Math.random()*13);
	face = 0;
	suit = "";
	/*int s = (int)(Math.random()*4);
	if (s==0)
		suit = "HEARTS";
	if (s==1)
		suit = "DIAMONDS";
	if (s==2)
		suit = "SPADES";
	if (s==3)
		suit = "CLUBS";*/
  }
  public Card(int f, String s){
  	suit =s;
	face =f;
  }
  // modifiers
  public void setFace(int f){
	face = f;
  }

  public void setSuit(String s){
	suit =s;
  }

 

  //accessors

  public String getSuit(){
	return suit;
  }

  public int getFace(){
	return face;
  }



  public abstract int getValue();

  public boolean equals(Object obj)
  {
	Card o=(Card)obj;
	if (suit.equals(o.getSuit()))
		if (face==o.getFace())
			return true;
    return false;
  }

  //toString
  public String toString(){
	return FACES[face]+ " of " + suit;
  }
}

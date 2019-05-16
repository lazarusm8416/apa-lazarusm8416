//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
  private int value;
  //constructors
  public BlackJackCard(){
	super();
	value=getFace();
	if (value>10)
		value=10;
  }
  public BlackJackCard(int f, String s){
	super(f,s);
	value=f;
	if (value>10)
		value=10;
	if (value==1)
		value=11;
  }

  public int getValue()
  {
    //enables you to build the value for the game into the card
    //this makes writing the whole program a little easier
	

    return value;
  }
        
  public String toString(){
	return super.toString()+ " | value : " + value;
  }
}

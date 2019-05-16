//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  public static final int NUMFACES = 13;
  public static final int NUMSUITS = 4;
  public static final int NUMCARDS = 52;

  public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

  private int topCardIndex;
  private ArrayList<Card> stackOfCards;

  public Deck ()
  {
    //initialize data - stackOfCards - topCardIndex
	stackOfCards=new ArrayList<Card>(0);
        topCardIndex=51;
    //loop through suits
    //loop through faces
    //add in a new card
	for (int i =0; i<4;i++){
		for (int j=1;j<14; j++){
			stackOfCards.add(new BlackJackCard(j,SUITS[i]));
		}
	}
  }

  //modifiers
  public void shuffle ()
  {
	topCardIndex=51;
    for (int i=0; i<stackOfCards.size(); i++){
	int r = (int)(Math.random()*51);
	Card temp = stackOfCards.get(r);
	stackOfCards.set(r,stackOfCards.get(i));
	stackOfCards.set(i,temp);
  }
    //reset variables as needed
  }

  //accessors
  public int size ()
  {
    return stackOfCards.size();
  }

  public int numCardsLeft()
  {
    return stackOfCards.size();
  }

  public Card nextCard()
  {
    	return stackOfCards.get(topCardIndex--);
  }

  public String toString()
  {
    return stackOfCards + "   topCardIndex = " + topCardIndex;
  } 
}

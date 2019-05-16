//Name -
//Date -
//Class -
//Lab  - 


//define Dealer class here
  public class Dealer extends AbstractPlayer{
	

	private Deck deck;

	public Dealer(){
		deck = new Deck();
	}

	public void shuffle(){
		deck.shuffle();
	}

	public Card deal(){
		return deck.nextCard();
	}


	public boolean hit(){
		if (getHandValue()<=15)
			return true;
		return false;
	}
  }

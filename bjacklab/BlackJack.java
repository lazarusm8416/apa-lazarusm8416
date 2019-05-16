//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
  private Player player;
  private Dealer dealer;
//add in Player instance variable
  //add in Dealer instance variable

  public BlackJack()
  {
	player = new Player();
	dealer = new Dealer();
	dealer.shuffle();
  }

  public void playGame()
  {
    dealer.shuffle();
    player.resetHand();
    dealer.resetHand();
    Scanner keyboard = new Scanner(System.in);
    String choice = "";
    boolean bust = false;
	player.addCardToHand(dealer.deal());
	player.addCardToHand(dealer.deal());

	while(player.getHandValue()<21){
		System.out.println(player);
		System.out.println();
		System.out.println("Would you like to hit?(Y/N)\n");
		choice = keyboard.next();
		if (choice.equals("y")||choice.equals("Y")){
			player.addCardToHand(dealer.deal());
		} else {
			break;
		}
	}
		if (player.getHandValue()>21){
			System.out.println(player);
			System.out.println("You Busted.\n");
			bust = true;
			dealer.setWinCount(dealer.getWinCount()+1);
		}
		if (!bust){
			dealer.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());

			while(dealer.getHandValue()<15){
				dealer.addCardToHand(dealer.deal());
			}

			System.out.println("YOU: "+player + "\n\n" + "HOUSE: "+dealer);
			if (dealer.getHandValue()>21){
				player.setWinCount(player.getWinCount()+1);
				System.out.println("House Busted. YOU WIN.");
			}
			else if (player.getHandValue()>dealer.getHandValue()){
				player.setWinCount(player.getWinCount()+1);
				System.out.println("YOU WIN");
			} else {
				dealer.setWinCount(dealer.getWinCount()+1);
				System.out.println("YOU LOSE");
			}

		}
 }
  
       

  public static void main(String[] args)
  {
	Scanner keyboard = new Scanner(System.in);
	String in = "y";
		BlackJack game = new BlackJack();
		System.out.println("Would you like to play BlackJack? (Y/N)\n");
		in=keyboard.next();
		while (in.equals("y")||in.equals("Y")){
			game.playGame();
			System.out.println("\n\nagain? (Y/N)");
			in=keyboard.next();
		}
  }
}

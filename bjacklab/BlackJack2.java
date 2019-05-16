//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BlackJack2
{
  private ArrayList<Playerable> players;
//add in Player instance variable
  //add in Dealer instance variable

  public BlackJack2(int playahs)
  {
	players = new ArrayList<Playerable>();
	players.add(new Dealer());
	for (int i =0; i<playahs; i++){
		players.add(new Player());
	}
  }

  public void playGame()
  {
    Dealer dealer = (Dealer)players.get(0);
    dealer.shuffle();
    for (Playerable p : players){
	p.resetHand();
    }
    Scanner keyboard = new Scanner(System.in);
    String choice = "";
    for (int i = 1; i<players.size(); i++){
	players.get(i).addCardToHand(dealer.deal());
	players.get(i).addCardToHand(dealer.deal());

	while(players.get(i).getHandValue()<21){
		System.out.println("Player "+i+ "::\n" + players.get(i));
		System.out.println();
		System.out.println("Would you like to hit?(Y/N)\n");
		choice = keyboard.next();
		if (choice.equals("y")||choice.equals("Y")){
			players.get(i).addCardToHand(dealer.deal());
		} else {
			break;
		}
	}
	if (players.get(i).getHandValue()>21){
		System.out.println(players.get(i));
		System.out.println("You Busted.\n");
	}
    }
	
			dealer.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
//dealer hits with 15 or less, a risky man
			while(dealer.getHandValue()<16){
				dealer.addCardToHand(dealer.deal());
			}
	System.out.println("----------------------------");
			String output = "";
			output+="DEALER(CPU):\n "+dealer;
			for (int i =1; i<players.size(); i++){
				output +="\n\nPlayer "+i+ ":\n" + players.get(i);
			}
			System.out.println(output);



 }
  
       

  public static void main(String[] args)
  {
	Scanner keyboard = new Scanner(System.in);
	String in = "y";
	int playahs = 0;

		System.out.println("How many would like to play BlackJack? (ENTER A NUMBER)\n");
		playahs = keyboard.nextInt();
		BlackJack2 game = new BlackJack2(playahs);
		while (in.equals("y")||in.equals("Y")){
			game.playGame();
			System.out.println("\n\nagain? (Y/N)");
			in=keyboard.next();
		}
  }
}

import java.util.*;

public class BlackJackRunner {

	static Scanner input = new Scanner(System.in);	
	
	public static void main(String[] args) {
		//Player dealer = new RegularDealer();   //Regular blackjack
		//Understand the power of polymorphism.  The whole game can change
		//just by changing the actual object type of the dealer object!!
		//You don't have to rewrite tons of code - just change ONE part
		//of ONE line!
		Player dealer = new CheatingDealer();    //Cheater!!!!
		Deck myDeck = new Deck();
		String response = "Y";  //does the player want to play again - default to Y to get into loop
		String decision = "H";  //default to H to get into loop (do while loops would be better here)
		ArrayList<Card> playerCards;			//The List of player cards
		ArrayList<Card> dealerCards;			//The List of dealer cards
		int money = 2000;						//initial money is 2000
		int wager;								//the player's wager
		int playerPoints, dealerPoints;			//the point values of the player's and dealer's hands
		printWelcome();							//Print a welcome message.		
		while (money > 0 && response.equals("Y")) {     //as long as the player has money and wants to play again
			//myDeck = new Deck(); Would prevent the SMALL case in which the point value needed is no longer in the Deck
			System.out.println("You currently have $" + money);   
			playerCards = new ArrayList<Card>();  //clear out old player hand
			dealerCards = new ArrayList<Card>();  //clear out old dealer hand			
			myDeck.shuffle();					  //shuffle the deck!
			wager = getWager(money);
			//Deal the cards:
			playerCards.add(myDeck.getTopCard()); 
			dealerCards.add(myDeck.getTopCard());
			playerCards.add(myDeck.getTopCard());
			dealerCards.add(myDeck.getTopCard());
			System.out.println("Player Hand: \n");
			printHand(playerCards);
			//Now I want to print the first card of the dealer's hand
			System.out.println("\nDealer is showing: \n");
			System.out.println(dealerCards.get(0).getFace() + " of " + dealerCards.get(0).getSuit() + "\n");
			//Check to make sure neither dealer nor player have blackjack
			dealerPoints = calculatePoints(dealerCards);
			playerPoints = calculatePoints(playerCards);
			if (dealerPoints == 21 && playerPoints == 21) {
				System.out.println("It's a push!");
			} else if (dealerPoints == 21) {
				System.out.println("Oh! I'm so sorry!  Dealer has blackjack!");
				money -= wager;
			} else if (playerPoints == 21) {
				System.out.println("You have Blackjack!");
				money += (wager * 2);
			} else {
				decision = "H";  //sloppy code on my part - a do-while loop would be better
				//Ask the player want they want to do
				while (playerPoints < 21 && decision.equals("H")) {
					System.out.println("You have " + playerPoints + " points.");
					System.out.print("(H)it or (S)tay: ");
					decision = input.next(); 
					if (decision.equals("H")) {
						playerCards.add(myDeck.getTopCard());
						printHand(playerCards);
						playerPoints = calculatePoints(playerCards);						
					}
				}
				if (playerPoints > 21) {
					System.out.println("BUST!");
					money -= wager;
				} else {  //computer has to go.
					/********Here is the polymorphic line of code***********/
					//The correct act method of whatever dealer ACTUALLY is
					//will be called here.  LATE/DYNAMIC BINDING!
					dealerPoints = dealer.act(dealerCards, myDeck);
					System.out.println("Dealer ended with this hand: ");
					printHand(dealerCards);
					if (dealerPoints > 21) {
						System.out.println("Dealer busts! You win!");
						money += wager;
					} else if(dealerPoints > playerPoints) {
						System.out.println("Dealer has more points than you!");
						money -= wager;
					} else if (playerPoints > dealerPoints) {
						money+=wager;
					} else {
						System.out.println("It's a push!");
					}
				}
			}
			//Done with the round.  Does the player have money to be asked to play again?
			if (money > 0) {
				System.out.println("Do you want to play again (Y/N): ");
				response = input.next();
			}
		}
		//We are done with the entire game
		if (money > 0) {
			System.out.println("You are leaving with $" + money);
			System.out.println("Have a nice day!");
		} else {
			System.out.println("Sorry you lost it all.");
			System.out.println("At least you still have your shirt.");
		}
		
	}
	
	/**
	 * Prints a welcome message!
	 */
	public static void printWelcome() {
		System.out.println("Welcome to the Weir Casino: Where You Come in Rich and Leave Unhappy TM");
	}
	
	/**
	 * Gets a valid wager from the keyboard.  A valid wager is one which is
	 * positive and not greater than the current amount of player money.
	 * @param money - the amount of currency the player currently has; money > 0
	 * @return a valid wager
	 */
	public static int getWager(int money) {
		int wager;		
		do {
			System.out.print("Enter a valid wager: ");
			wager = input.nextInt();
			if (wager < 0) {
				System.out.println("Wager must be positive.");
			} 
			if (wager > money) {
				System.out.println("You don't have that much!");
			}
		} while (wager < 0 || wager > money);
		return wager;
	}
	
	/**
	 * Prints out the List of cards in form "face of suit"
	 * @param hand the List of cards
	 */
	public static void printHand(ArrayList<Card> hand) {
		for(int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).getFace() + " of " + hand.get(i).getSuit());
		}
	}
	
	/**
	 * Calculates the point value of a List of cards
	 * @param hand the List of cards
	 * @return the total point value of the List of cards
	 */
	public static int calculatePoints(ArrayList<Card> hand) {
		int sum = 0;
		for (int i = 0; i < hand.size(); i++) {
			sum += hand.get(i).getPoints();
		}
		return sum;
	}	
	
}

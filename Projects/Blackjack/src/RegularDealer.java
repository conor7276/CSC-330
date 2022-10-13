import java.util.ArrayList;

/**
 * Class that represents a normal blackjack dealer
 * @author Weir
 *
 */

public class RegularDealer extends Player {

	/**
	 * Does the normal dealer algorithm for BlackJack
	 * Returns the point value of the final hand
	 */
	public int act(ArrayList<Card> myCards, Deck theDeck) {
		int myPoints = calculatePoints(myCards);
		//Let's do the normal BlackJack Dealer thing 
		//   hit on anything 16 or lower.
		//   stay on anything 17 or higher.
		while (myPoints <= 16) {
			Card topCard = theDeck.getTopCard();
			myCards.add(topCard);
			System.out.println("Computer hits and gets a " + topCard.getFace() + " of " + topCard.getSuit());
			myPoints = calculatePoints(myCards);
		}
		return myPoints;
	}
	
}
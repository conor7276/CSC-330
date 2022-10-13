import java.util.ArrayList;

/**
 * Class representing a cheating blackjack dealer!
 * What's that up his sleeve?!
 * @author Weir
 *
 */

public class CheatingDealer extends Player {

	/**
	 * CHEATS!
	 * Returns 21 always.  Always finds the Cards it needs
	 * to complete a hand with point value 21!
	 * Boooooo!
	 */
	public int act(ArrayList<Card> myCards, Deck theDeck) {
		//Cheating dealer always gets 21.
		int myPoints = calculatePoints(myCards);
		//How many points do I need?
		int neededPoints = 21 - myPoints;
		Card cardToAdd = null;
		//If the computer needs more than ten points (aces are not 11 here), keep drawing until
		//difference is less than or equal to 10
		while (neededPoints >= 10) {
			myCards.add(theDeck.getTopCard());
			neededPoints = 21 - calculatePoints(myCards);
		}
		//Let's do a SEQUENTIAL SEARCH for what we need.
		for(int i = 0; i < theDeck.size(); i++) {
			Card currCard = theDeck.getCardAt(i);
			if (currCard.getPoints() == neededPoints) {
				cardToAdd = theDeck.removeCardAt(i);
			}
		}
		myCards.add(cardToAdd);
		return 21;   //it's going to be 21. We are cheating.		
	}
	
}
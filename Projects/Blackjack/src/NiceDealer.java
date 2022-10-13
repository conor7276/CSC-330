import java.util.*;

public class NiceDealer extends Player {

	//Cheating dealer always gets 21.
	public int act(ArrayList<Card> myCards, Deck theDeck) {
		while (calculatePoints(myCards) <= 21) {
			myCards.add(theDeck.getTopCard());			
		}				
		return calculatePoints(myCards);   //oops, we always bust.
	}
	
}
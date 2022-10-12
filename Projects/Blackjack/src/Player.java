import java.util.ArrayList;

/**
 * Class representing a vague Player object.
 * @author Weir
 *
 */

public class Player {

	/**
	 * Returns the total points of its hand after it acts
	 * Doesn't do anything. Just returns the current point value.
	 * @param myCards
	 * @return
	 */
	public int act(ArrayList<Card> myCards, Deck theDeck) {
		System.out.println("I am throwing my cards into the air!!!");
		return calculatePoints(myCards);
	}

	/**
	 * Calculates the total number of points in the List of Cards
	 * @param hand the List of Cards
	 * @return the total point value of all Cards in the List
	 */
	public int calculatePoints(ArrayList<Card> hand) {
		int sum = 0;
		for (int i = 0; i < hand.size(); i++) {
			sum += hand.get(i).getPoints();
		}
		return sum;
	}
	
}
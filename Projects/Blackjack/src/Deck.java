import java.util.*;

/**
 * Class representing a Deck of Card objects
 * @author Weir
 *
 */

public class Deck {

	/**
	 * The List of Cards
	 */
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	/**
	 * Class constructor
	 */
	public Deck() {
		initialize();
	}
	
	/**
	 * Calls the Collections.shuffle method 100 times on the List of Cards.
	 */
	public void shuffle() {
		for (int i = 0; i < 100; i++) {
			Collections.shuffle(deck);
		}
	}
	
	/**
	 * Initializes the Deck with values of a normal 52 card deck of playing cards.
	 */
	public void initialize() {
		deck.add(new Card(1, "ace", "hearts"));
		deck.add(new Card(2, "two", "hearts"));
		deck.add(new Card(3, "three", "hearts"));
		deck.add(new Card(4, "four", "hearts"));
		deck.add(new Card(5, "five", "hearts"));
		deck.add(new Card(6, "six", "hearts"));
		deck.add(new Card(7, "seven", "hearts"));
		deck.add(new Card(8, "eight", "hearts"));
		deck.add(new Card(9, "nine", "hearts"));
		deck.add(new Card(10, "ten", "hearts"));
		deck.add(new Card(10, "jack", "hearts"));
		deck.add(new Card(10, "king", "hearts"));
		deck.add(new Card(10, "queen", "hearts"));
		deck.add(new Card(1, "ace", "diamonds"));
		deck.add(new Card(2, "two", "diamonds"));
		deck.add(new Card(3, "three", "diamonds"));
		deck.add(new Card(4, "four", "diamonds"));
		deck.add(new Card(5, "five", "diamonds"));
		deck.add(new Card(6, "six", "diamonds"));
		deck.add(new Card(7, "seven", "diamonds"));
		deck.add(new Card(8, "eight", "diamonds"));
		deck.add(new Card(9, "nine", "diamonds"));
		deck.add(new Card(10, "ten", "diamonds"));
		deck.add(new Card(10, "jack", "diamonds"));
		deck.add(new Card(10, "king", "diamonds"));
		deck.add(new Card(10, "queen", "diamonds"));
		deck.add(new Card(1, "ace", "clubs"));
		deck.add(new Card(2, "two", "clubs"));
		deck.add(new Card(3, "three", "clubs"));
		deck.add(new Card(4, "four", "clubs"));
		deck.add(new Card(5, "five", "clubs"));
		deck.add(new Card(6, "six", "clubs"));
		deck.add(new Card(7, "seven", "clubs"));
		deck.add(new Card(8, "eight", "clubs"));
		deck.add(new Card(9, "nine", "clubs"));
		deck.add(new Card(10, "ten", "clubs"));
		deck.add(new Card(10, "jack", "clubs"));
		deck.add(new Card(10, "king", "clubs"));
		deck.add(new Card(10, "queen", "clubs"));
		deck.add(new Card(1, "ace", "spades"));
		deck.add(new Card(2, "two", "spades"));
		deck.add(new Card(3, "three", "spades"));
		deck.add(new Card(4, "four", "spades"));
		deck.add(new Card(5, "five", "spades"));
		deck.add(new Card(6, "six", "spades"));
		deck.add(new Card(7, "seven", "spades"));
		deck.add(new Card(8, "eight", "spades"));
		deck.add(new Card(9, "nine", "spades"));
		deck.add(new Card(10, "ten", "spades"));
		deck.add(new Card(10, "jack", "spades"));
		deck.add(new Card(10, "king", "spades"));
		deck.add(new Card(10, "queen", "spades"));
		shuffle();
	}
	
	/**
	 * Removes the top card from the List of Cards
	 * @return the top card of the deck (index 0)
	 */
	public Card getTopCard() {
		Card c = deck.remove(0);   //get the top card
		if (deck.size() == 0) {
			initialize();
		}
		return c;
	}
	
	/**
	 * returns the Card object at index i of the List of Cards
	 * used primarily by the CheatingDealer class
	 * @param i index of Card
	 * @return the Card at index i of the List of Cards
	 */
	public Card getCardAt(int i) {
		return deck.get(i);
	}
	
	/**
	 * Removes the Card object at index i of the List of Cards
	 * @param i index of Card to remove
	 * @return the Card at index i of the List of Cards
	 */
	public Card removeCardAt(int i) {
		return deck.remove(i);
	}
	
	/**
	 * Returns the size of the List of Cards
	 * @return the size of the List of Cards
	 */
	public int size() {
		return deck.size();
	}
	
}
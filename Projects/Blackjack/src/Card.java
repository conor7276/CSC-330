/**
 * Class representing a playing card
 * @author Weir
 *
 */
public class Card {

	private int points;			
	private String suit;
	private String face;
	
	/**
	 * Non-default constructor
	 * @param p - points
	 * @param s - face value
	 * @param f = suit
	 */
	public Card(int p, String s, String f) {
		points = p;
		suit = f;
		face = s;
	}
	
	/**
	 * Accessor for points
	 * @return point value
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Accessor for suit
	 * @return suit value
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Accessor for face
	 * @return face value
	 */
	public String getFace() {
		return face;
	}		
	
	/**
	 * Sets the value of a Card (used for Aces)
	 * @param n new point value for this Card
	 */
	public void setValue(int n) {
		points = n;
	}
	
}
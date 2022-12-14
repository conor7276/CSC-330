package application;

import javafx.scene.image.ImageView;

public abstract class PlayerSuper extends GridSquare{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3406430474031510001L;
	private transient ImageView trail;
	private String trailString;
	private GridSquare[][] game_state;
	
	/**
	 * 
	 * @param t set the URL for the trail color that the slime will leave behind after moving
	 */
	public void setTrail(ImageView t)
	{
		trail = t;
	}

	/**
	 * 
	 * @return grab the URL for the trail color that the slime will leave behind after moving
	 */
	public ImageView getTrail()
	{
		return trail;
	}

	/**
	 * 
	 * @param updated_state the gameboard after movement has been finished
	 * @param direction the direction you inputed
	 * @return new gameboard
	 *
	 **/
	public abstract GridSquare[][] Movement(GridSquare[][] updated_state, String direction);
	
	/**
	 * 
	 * @return the color of the slime trail the icon will leave behind
	 */
	public String getTrailString() {
		return trailString;
	}

	/**
	 * 
	 * @param s give the color of the trail the slime will leave behind when moving
	 */
	public void setTrailString(String s) {
		this.trailString = s;
	}

	
}

package application;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public abstract class PlayerSuper extends GridSquare {
	
	private transient ImageView trail;
	private String trailString;
	private GridSquare[][] game_state;
	
	
	public void setTrail(ImageView t)
	{
		trail = t;
	}
	public ImageView getTrail()
	{
		return trail;
	}
	public abstract GridSquare[][] Movement(GridSquare[][] updated_state, String direction);
	
	public GridSquare[][] getGame_state() {
		return game_state;
	}
	public void setGame_state(GridSquare[][] game_state) {
		this.game_state = game_state;
	}
	public String getTrailString() {
		return trailString;
	}
	public void setTrailString(String s) {
		this.trailString = s;
	}

	
}

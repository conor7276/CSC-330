package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class Vertical_Beam  extends GridSquare implements Items{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7281341276925544307L;
	transient MediaPlayer beam_sound;
	File beam_sound_location = new File("Assets/laser_sound.wav");
	/**
	 * 
	 * @param URL image path of the vertical laser power
	 * @param img_size size of the image
	 */
	
	Vertical_Beam(String URL, int img_size)
	{
	this.setURL(URL);
		
	try {
		this.setGraphic(new ImageView(new Image(new FileInputStream(URL),img_size,img_size,false,false)));
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}	
	}
	/**
	 * default constructor for vertical laser
	 */
	
	Vertical_Beam()
	{
		
	}
	/**
	 * Logic for using the item. changes all the tiles in that column to the slime's trail color except for
	 * other slime players
	 */
	
	@Override
	public GridSquare[][] Use(GridSquare[][] gameboard, String slime_trail_string, int[] location, PlayerSuper slime) {
		// TODO Auto-generated method stub
		beam_sound = null;
		beam_sound = new MediaPlayer(new Media(beam_sound_location.toURI().toString()));
		beam_sound.setVolume(1.5);
		beam_sound.play();
		System.out.println("Hello From V_beam!");
		System.out.println("Beaming Vertically " + gameboard.length);
		for(int square = 0; square < gameboard.length; square++) {
			if(gameboard[square][location[1]].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[square][location[1]].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[square][location[1]].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[square][location[1]].getURL().equals("Assets/Pink_Slime_Icon.png")== false)
			{
				gameboard[square][location[1]].setURL(slime.getTrailString());
			
				try {
					gameboard[square][location[1]].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
					gameboard[square][location[1]].setURL(slime.getTrailString());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return gameboard;
	}

}

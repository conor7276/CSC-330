package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class Horizontal_Beam  extends GridSquare implements Items{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8451975933362463700L;
	transient MediaPlayer beam_sound;
	File beam_sound_location = new File("Assets/laser_sound.wav");
   /**
	 * 
	 * @param URL image path of the horizontal laser power
	 * @param img_size size of the image
	 */
	
	Horizontal_Beam(String URL, int img_size)
	{
	this.setURL(URL);
		
	try {
		this.setGraphic(new ImageView(new Image(new FileInputStream(URL),img_size,img_size,false,false)));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	/**
	 * default constructor for horizontal laser
	 */
	
	Horizontal_Beam()
	{
		
	}
	/**
	 * Logic for using the item. changes all the tiles in that row to the slime's trail color except for
	 * other slime players
	 */
	
	@Override
	public GridSquare[][] Use(GridSquare[][] gameboard, String slime_trail_string, int[] location, PlayerSuper slime) {
		// TODO Auto-generated method stub
		beam_sound = null;
		beam_sound = new MediaPlayer(new Media(beam_sound_location.toURI().toString()));
		beam_sound.setVolume(1.5);
		beam_sound.play();
		System.out.println("Hello From H_beam!");
		System.out.println("Beaming Horizontally!");
		for(int square = 0; square < gameboard.length; square++) {
			if(gameboard[location[0]][square].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0]][square].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0]][square].getURL().equals("Assets/Green_Slime_Icon.png")== false &&
					gameboard[location[0]][square].getURL().equals("Assets/Pink_Slime_Icon.png")== false) 
			{
				gameboard[location[0]][square].setURL(slime.getTrailString());
				try {
					gameboard[location[0]][square].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
					gameboard[location[0]][square].setURL(slime.getTrailString());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return gameboard;
	}

}

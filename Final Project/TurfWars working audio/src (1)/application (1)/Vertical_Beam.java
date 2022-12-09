package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Vertical_Beam  extends GridSquare implements Items{
	  MediaPlayer beam_sound;
	  String beam_sound_location = "C:\\Users\\chris\\eclipse-workspace\\TurfWars\\Assets\\laser_sound.wav";
	Vertical_Beam(String URL, int img_size)
	{
	this.setURL(URL);
		
	try {
		this.setGraphic(new ImageView(new Image(new FileInputStream(URL),img_size,img_size,false,false)));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	Vertical_Beam()
	{
		
	}
	
	@Override
	public GridSquare[][] Use(GridSquare[][] gameboard, String SlimeTrail_String) {
		beam_sound = null;
		beam_sound = new MediaPlayer(new Media(new File(beam_sound_location).toURI().toString()));
		beam_sound.setVolume(1.5);
		beam_sound.play();
		System.out.println("Hello From V_beam!");
		
		
		return null;
	}

}

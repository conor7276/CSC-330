package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Bomb extends GridSquare implements Items{

	MediaPlayer bomb_sound;
String bomb_sound_location = "C:\\Users\\chris\\eclipse-workspace\\TurfWars\\Assets\\bomb_sound.mp3";
	Bomb(String URL, int img_size)
	{
	this.setURL(URL);
		
	try {
		this.setGraphic(new ImageView(new Image(new FileInputStream(URL),img_size,img_size,false,false)));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	Bomb()
	{
		
	}
	@Override
	public GridSquare[][] Use(GridSquare[][] gameboard, String SlimeTrail_String) {
		bomb_sound = null;
		bomb_sound = new MediaPlayer(new Media(new File(bomb_sound_location).toURI().toString()));
		bomb_sound.setVolume(1.5);
		bomb_sound.play();
		System.out.println("Hello From Bomb!");
		return null;
	}

}

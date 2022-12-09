package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class Horizontal_Beam  extends GridSquare implements Items{
	MediaPlayer beam_sound;
	String beam_sound_location = "C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Final Project\\TurfWars\\Assets\\laser_sound.wav";
    // C:\\Users\\chris\\eclipse-workspace\\TurfWars\\Assets\\laser_sound.wav
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
	Horizontal_Beam()
	{
		
	}
	@Override
	public GridSquare[][] Use(GridSquare[][] gameboard, String slime_trail_string, int[] location, PlayerSuper slime) {
		// TODO Auto-generated method stub
		beam_sound = null;
		beam_sound = new MediaPlayer(new Media(new File(beam_sound_location).toURI().toString()));
		beam_sound.setVolume(1.5);
		beam_sound.play();
		System.out.println("Hello From H_beam!");
		System.out.println("Beaming Horizontally!");
		for(int square = 0; square < gameboard.length; square++) {
			if(gameboard[location[0]][square].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0]][square].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0]][square].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0]][square].getURL() != "Assets/Pink_Slime_Icon.png") {
				System.out.println(gameboard[location[0]][square]);
				gameboard[location[0]][square].setURL(slime.getTrailString());
				//gameboard[location[0]][square].setCardinalConnections(gameboard);
				//this.setCardinalConnections(gameboard);
//				GridSquare temp;
				//System.out.println("are we getting here?");
//				temp = gameboard[slime.getLocation()[0]][square];
				try {
					gameboard[location[0]][square].setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				temp.setURL(slime.getTrailString());
//				gameboard[slime.getLocation()[0]][square]=slime;	
//		        slime.setLocation((slime.getLocation()[0]),square);
//				    gameboard[temp.getLocation()[0]][square]=temp;
//			    temp.setLocation(temp.getLocation()[0], square);
//				temp.setCardinalConnections(gameboard);
//				slime.setCardinalConnections(gameboard);
				
			}
		}
		return gameboard;
	}

}

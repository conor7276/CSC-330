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
	String bomb_sound_location = "C:\\Users\\Conor\\Desktop\\School\\Fall 2022\\CSC 330\\Final Project\\TurfWars\\Assets\\bomb_sound.mp3";
	// C:\\Users\\chris\\eclipse-workspace\\TurfWars\\Assets\\bomb_sound.mp3

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
	public GridSquare[][] Use(GridSquare[][] gameboard, String SlimeTrail_String, int[] location,PlayerSuper trail) {
		// TODO Auto-generated method stub
		bomb_sound = null;
		bomb_sound = new MediaPlayer(new Media(new File(bomb_sound_location).toURI().toString()));
		bomb_sound.setVolume(1.5);
		bomb_sound.play();
		System.out.println("Hello From Bomb!");
		System.out.println("Bombing the place!");
		try {
			if(gameboard[location[0]+ 1][location[1]].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0]+ 1][location[1]].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0]+ 1][location[1]].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0]+ 1][location[1]].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0] + 1][location[1]].setURL(trail.getTrailString());
			}
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0]- 1][location[1]].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0]- 1][location[1]].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0]- 1][location[1]].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0]- 1][location[1]].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0] - 1][location[1]].setURL(trail.getTrailString());
			}
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0]][location[1] + 1].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0]][location[1] + 1].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0]][location[1] + 1].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0]][location[1] + 1].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0]][location[1] + 1].setURL(trail.getTrailString());
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0]][location[1] - 1].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0]][location[1] - 1].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0]][location[1] - 1].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0]][location[1] - 1].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0]][location[1] - 1].setURL(trail.getTrailString());
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] + 1][location[1] + 1].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0] + 1][location[1] + 1].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0] + 1][location[1] + 1].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0] + 1][location[1] + 1].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0] + 1][location[1] + 1].setURL(trail.getTrailString());
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] + 1][location[1] - 1].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0] + 1][location[1] - 1].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0] + 1][location[1] - 1].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0] + 1][location[1] - 1].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0]][location[1] - 1].setURL(trail.getTrailString());
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] - 1][location[1] + 1].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0] - 1][location[1] + 1].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0] - 1][location[1] + 1].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0] - 1][location[1] + 1].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0] - 1][location[1] + 1].setURL(trail.getTrailString());
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] - 1][location[1] - 1].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[location[0] - 1][location[1] - 1].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[location[0] - 1][location[1] - 1].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[location[0] - 1][location[1] - 1].getURL() != "Assets/Pink_Slime_Icon.png") {
				gameboard[location[0] - 1][location[1] - 1].setURL(trail.getTrailString());
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		return gameboard;
	}

}

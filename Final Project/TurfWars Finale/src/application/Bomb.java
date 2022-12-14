package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Bomb extends GridSquare implements Items{
	
	private static final long serialVersionUID = -4509508869418575737L;
	transient MediaPlayer bomb_sound;
	File bomb_sound_location = new File("Assets/bomb_sound.mp3");
	/**
	 * 
	 * @param URL image path of the bomb power
	 * @param img_size size of the image
	 */
	
	Bomb(String URL, int img_size)
	{
	this.setURL(URL);
		
	try {
		this.setGraphic(new ImageView(new Image(new FileInputStream(URL),img_size,img_size,false,false)));
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}	
	}

	/**
	 * default constructor for bomb
	 */
	
	Bomb()
	{
		
	}
	@Override

	/**
	 * Logic for using bomb. Changes all tiles in a 1 tile radius of the slime to its slime trail color
	 */

	public GridSquare[][] Use(GridSquare[][] gameboard, String SlimeTrail_String, int[] location,PlayerSuper slime) {
		
		bomb_sound = null;
		bomb_sound = new MediaPlayer(new Media(bomb_sound_location.toURI().toString()));
		bomb_sound.setVolume(1.5);
		bomb_sound.play();
		System.out.println("Hello From Bomb!");
		System.out.println("Bombing the place!");
		try {
			if(gameboard[location[0]+ 1][location[1]].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0]+ 1][location[1]].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0]+ 1][location[1]].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0]+ 1][location[1]].getURL().equals("Assets/Pink_Slime_Icon.png") == false) {
				gameboard[location[0] + 1][location[1]].setURL(slime.getTrailString());
				try {
					gameboard[location[0] + 1][location[1]].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0]- 1][location[1]].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0]- 1][location[1]].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0]- 1][location[1]].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0]- 1][location[1]].getURL().equals("Assets/Pink_Slime_Icon.png") == false) {
				gameboard[location[0] - 1][location[1]].setURL(slime.getTrailString());
				try {
					gameboard[location[0] - 1][location[1]].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0]][location[1] + 1].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0]][location[1] + 1].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0]][location[1] + 1].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0]][location[1] + 1].getURL().equals("Assets/Pink_Slime_Icon.png") == false) {
				gameboard[location[0]][location[1] + 1].setURL(slime.getTrailString());
				try {
					gameboard[location[0]][location[1] + 1].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0]][location[1] - 1].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0]][location[1] - 1].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0]][location[1] - 1].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0]][location[1] - 1].getURL().equals("Assets/Pink_Slime_Icon.png") == false) {
				gameboard[location[0]][location[1] - 1].setURL(slime.getTrailString());
				try {
					gameboard[location[0]][location[1] - 1].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] + 1][location[1] + 1].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0] + 1][location[1] + 1].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0] + 1][location[1] + 1].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0] + 1][location[1] + 1].getURL().equals("Assets/Pink_Slime_Icon.png") == false) {
				gameboard[location[0] + 1][location[1] + 1].setURL(slime.getTrailString());
				try {
					gameboard[location[0] + 1][location[1] + 1].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] + 1][location[1] - 1].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0] + 1][location[1] - 1].getURL().equals("Assets/Blue_Slime_Icon.png") == false&& 
					gameboard[location[0] + 1][location[1] - 1].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0] + 1][location[1] - 1].getURL().equals("Assets/Pink_Slime_Icon.png") == false ) {
				gameboard[location[0]][location[1] - 1].setURL(slime.getTrailString());
				try {
					gameboard[location[0] + 1][location[1] - 1].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] - 1][location[1] + 1].getURL().equals("Assets/Purple_Slime_Icon.png") == false &&
					gameboard[location[0] - 1][location[1] + 1].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0] - 1][location[1] + 1].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0] - 1][location[1] + 1].getURL().equals("Assets/Pink_Slime_Icon.png") == false) {
				gameboard[location[0] - 1][location[1] + 1].setURL(slime.getTrailString());
				try {
					gameboard[location[0] - 1][location[1] + 1].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		try {
			if(gameboard[location[0] - 1][location[1] - 1].getURL().equals("Assets/Purple_Slime_Icon.png") == false&&
					gameboard[location[0] - 1][location[1] - 1].getURL().equals("Assets/Blue_Slime_Icon.png") == false && 
					gameboard[location[0] - 1][location[1] - 1].getURL().equals("Assets/Green_Slime_Icon.png") == false &&
					gameboard[location[0] - 1][location[1] - 1].getURL().equals("Assets/Pink_Slime_Icon.png")== false) {
				gameboard[location[0] - 1][location[1] - 1].setURL(slime.getTrailString());
				try {
					gameboard[location[0] - 1][location[1] - 1].setGraphic(new ImageView(new Image(new FileInputStream(slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			System.out.println("Can't bomb this area");
		}
		return gameboard;
	}

}
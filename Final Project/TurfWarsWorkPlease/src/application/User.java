package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class User extends PlayerSuper{
	private String slimePlayer;
	private String slimeTrail;
	
	public User() {
		slimePlayer = "";
		slimeTrail = "";
	}
	
	
	public User(String sp, String st) {
		slimePlayer = sp;
		slimeTrail = st;
	}
	
	public String getSlimePlayer() {
		return slimePlayer;
	}
	
	public void setSlimePlayer(String sp) {
		slimePlayer = sp;
	}
	
	public String getSlimeTrail() {
		return slimeTrail;
	}
	
	public void setSlimeTrail(String st) {
		slimeTrail = st;
	}
	
	
	GridSquare temp;
	@Override
	public GridSquare[][] Movement(GridSquare[][] updated_state, String direction) {
		if(direction == "west") {
		if (this.GetWest() == null || this.GetWest().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Green_SlimeTrail.png" || this.GetWest().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("cannot move there");
			} else {
					this.setLocation(this.getLocation()[0], this.getLocation()[1]-1);
					this.setCardinalConnections(updated_state);
				try {
					updated_state[this.getLocation()[0]][this.getLocation()[1]].setGraphic(
							new ImageView(new Image(new FileInputStream(slimePlayer),
									50, 50, false, false)));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
				
			try {
				updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setGraphic(new ImageView(new Image(new FileInputStream(slimeTrail),
						50, 50, false, false)));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
		return updated_state;
	}
}

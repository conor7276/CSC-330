package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AI extends PlayerSuper {
	
//	String[] options = {"north", "down", "left", "right"};
		
	@Override
	public GridSquare[][] Movement(GridSquare[][] updated_state, String direction) {
		// TODO Auto-generated method stub
		GridSquare temp;
//		Random randomOpt = new Random();
//		int CPUact = randomOpt.nextInt(4);
		
		if(direction == "west") {
			this.setCardinalConnections(updated_state);
			if (this.GetWest() == null || this.GetWest().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Green_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("cannot move there");
			} else {
				System.out.println("are we getting here?");
				temp = updated_state[this.getLocation()[0]][this.getLocation()[1]-1];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				temp.setURL(getTrailString());
				updated_state[this.getLocation()[0]][this.getLocation()[1]-1]=this;	
		        this.setLocation(this.getLocation()[0],(this.getLocation()[1]-1));
	 		    updated_state[temp.getLocation()[0]][temp.getLocation()[1]+1]=temp;
			    temp.setLocation(temp.getLocation()[0], temp.getLocation()[1]+1);
				temp.setCardinalConnections(updated_state);
				this.setCardinalConnections(updated_state);
				System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
			
			}
			if(direction == "east") {
				this.setCardinalConnections(updated_state);
				if (this.GetEast() == null || this.GetEast().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetEast().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetEast().getURL() == "Assets/Green_Slime_Icon.png" || this.GetEast().getURL() == "Assets/Pink_Slime_Icon.png") {
					System.out.println("cannot move there");
				} else {
					System.out.println("are we getting here?");
					temp = updated_state[this.getLocation()[0]][this.getLocation()[1]+1];
					try {
						temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						temp.setURL(getTrailString());
					updated_state[this.getLocation()[0]][this.getLocation()[1]+1]=this;	
			        this.setLocation(this.getLocation()[0],(this.getLocation()[1]+1));
		 		    updated_state[temp.getLocation()[0]][temp.getLocation()[1]-1]=temp;
				    temp.setLocation(temp.getLocation()[0], temp.getLocation()[1]-1);
					temp.setCardinalConnections(updated_state);
					this.setCardinalConnections(updated_state);
					System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
				}
				
				}
			if(direction == "south") {
				this.setCardinalConnections(updated_state);
				if (this.GetSouth() == null || this.GetSouth().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetSouth().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetSouth().getURL() == "Assets/Green_Slime_Icon.png" || this.GetSouth().getURL() == "Assets/Pink_Slime_Icon.png") {
					System.out.println("cannot move there");
				} else {
					System.out.println("are we getting here?");
					temp = updated_state[this.getLocation()[0]+1][this.getLocation()[1]];
					try {
						temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						temp.setURL(getTrailString());
					updated_state[this.getLocation()[0]+1][this.getLocation()[1]]=this;	
			        this.setLocation(this.getLocation()[0]+1,(this.getLocation()[1]));
		 		    updated_state[temp.getLocation()[0]-1][temp.getLocation()[1]]=temp;
				    temp.setLocation(temp.getLocation()[0]-1, temp.getLocation()[1]);
					temp.setCardinalConnections(updated_state);
					this.setCardinalConnections(updated_state);
					System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
				}
				
				}
			if(direction == "north") {
				this.setCardinalConnections(updated_state);
				if (this.GetNorth() == null || this.GetNorth().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetNorth().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetNorth().getURL() == "Assets/Green_Slime_Icon.png" || this.GetNorth().getURL() == "Assets/Pink_Slime_Icon.png") {
					System.out.println("cannot move there");
				} else {
					System.out.println("are we getting here?");
					temp = updated_state[this.getLocation()[0]-1][this.getLocation()[1]];
					try {
						temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						temp.setURL(getTrailString());
					updated_state[this.getLocation()[0]-1][this.getLocation()[1]]=this;	
			        this.setLocation(this.getLocation()[0]-1,(this.getLocation()[1]));
		 		    updated_state[temp.getLocation()[0]+1][temp.getLocation()[1]]=temp;
				    temp.setLocation(temp.getLocation()[0]+1, temp.getLocation()[1]);
					temp.setCardinalConnections(updated_state);
					this.setCardinalConnections(updated_state);
					System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
				}
				
				}
			return updated_state;
	}

}

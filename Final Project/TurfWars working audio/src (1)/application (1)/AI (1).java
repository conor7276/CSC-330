package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
public class AI extends PlayerSuper {
	
//	String[] options = {"north", "down", "left", "right"};
		
	@Override
	public GridSquare[][] Movement(GridSquare[][] updated_state, String direction) {
		// TODO Auto-generated method stub
		GridSquare temp;
//		Random randomOpt = new Random();
//		int CPUact = randomOpt.nextInt(4);
		
		// Second argument direction is technically no longer needed but I left it alone for now
		// Priority movement checks all possibilities before it moves depending on what color the tile is
		// A direction in the set will be removed if the slime cannot move in that direction
		HashSet<String> options = new HashSet<String>();
		options.add("North");
		options.add("South");
		options.add("East");
		options.add("West");
		
		this.setCardinalConnections(updated_state);
		// Check for nulls and icons, remove directions if so
		if(this.GetNorth() == null ||
				this.GetNorth().getURL() == "Assets/Purple_Slime_Icon.png" ||
				this.GetNorth().getURL() == "Assets/Blue_Slime_Icon.png" || 
				this.GetNorth().getURL() == "Assets/Green_Slime_Icon.png" ||
				this.GetNorth().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("Cannot go north");
				options.remove("North");
			}
		if(this.GetSouth() == null ||
				this.GetSouth().getURL() == "Assets/Purple_Slime_Icon.png" ||
				this.GetSouth().getURL() == "Assets/Blue_Slime_Icon.png" || 
				this.GetSouth().getURL() == "Assets/Green_Slime_Icon.png" ||
				this.GetSouth().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("Cannot go south");
				options.remove("South");
			}
		
		if(this.GetEast() == null ||
				this.GetEast().getURL() == "Assets/Purple_Slime_Icon.png" ||
				this.GetEast().getURL() == "Assets/Blue_Slime_Icon.png" || 
				this.GetEast().getURL() == "Assets/Green_Slime_Icon.png" ||
				this.GetEast().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("Cannot go east");
				options.remove("East");
			}
		
		if(this.GetWest() == null ||
			this.GetWest().getURL() == "Assets/Purple_Slime_Icon.png" ||
			this.GetWest().getURL() == "Assets/Blue_Slime_Icon.png" || 
			this.GetWest().getURL() == "Assets/Green_Slime_Icon.png" ||
			this.GetWest().getURL() == "Assets/Pink_Slime_Icon.png") {
			System.out.println("Cannot go west");
			options.remove("West");
		}
		if(options.size() == 0) { 
			// rare edge case would only be possible if the 3 AI slimes surround the player or AI
			// and is backed up against a wall which will probably never happen
			System.out.println("It seems that I am stuck.");
			return updated_state;
		}
		
		// ArrayList instead of Set because of random choice
		ArrayList<String> othertiles = new ArrayList<String>(); //colors that are not the AIs
		ArrayList<String> sametiles = new ArrayList<String>(); //colors that are the AIs
		
		for(String dir : options) { // check if trail is not the same as the AIs
			if(dir == "North") {
				if(this.GetNorth().getURL() != this.getTrailString()) { // different trail
					othertiles.add("North");
				}
				else { // same trail
					sametiles.add("North");
				}
			}
			if(dir == "South") {
				if(this.GetSouth().getURL() != this.getTrailString()) { // different trail
					othertiles.add("South");
				}
				else { // same trail
					sametiles.add("South");
				}
			}
			if(dir == "East") {
				if(this.GetEast().getURL() != this.getTrailString()) { // different trail
					othertiles.add("East");
				}
				else { // same trail
					sametiles.add("East");
				}
			}
			if(dir == "West") {
				if(this.GetWest().getURL() != this.getTrailString()) { // different trail
					othertiles.add("West");
				}
				else { // same trail
					sametiles.add("West");
				}
			}
		}
		
		if(othertiles.size() != 0) { // prioritize other tile colors
			Random randomOpt = new Random();
			int choice = randomOpt.nextInt(othertiles.size());
			String dir = othertiles.get(choice);
			if(dir == "North") {
				
				System.out.println("are we getting here?");
				temp = updated_state[this.getLocation()[0]-1][this.getLocation()[1]];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
				temp.setURL(this.getTrailString());
				updated_state[this.getLocation()[0]-1][this.getLocation()[1]]=this;	
		        this.setLocation(this.getLocation()[0]-1,(this.getLocation()[1]));
	 		    updated_state[temp.getLocation()[0]+1][temp.getLocation()[1]]=temp;
			    temp.setLocation(temp.getLocation()[0]+1, temp.getLocation()[1]);
				temp.setCardinalConnections(updated_state);
				this.setCardinalConnections(updated_state);
				System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
			
			if(dir == "South") {
				
				System.out.println("are we getting here?");
				temp = updated_state[this.getLocation()[0]+1][this.getLocation()[1]];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
				temp.setURL(this.getTrailString());
				updated_state[this.getLocation()[0]+1][this.getLocation()[1]]=this;	
		        this.setLocation(this.getLocation()[0]+1,(this.getLocation()[1]));
	 		    updated_state[temp.getLocation()[0]-1][temp.getLocation()[1]]=temp;
			    temp.setLocation(temp.getLocation()[0]-1, temp.getLocation()[1]);
				temp.setCardinalConnections(updated_state);
				this.setCardinalConnections(updated_state);
				System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
			
			if(dir == "East") {
				
				System.out.println("are we getting here?");
				temp = updated_state[this.getLocation()[0]][this.getLocation()[1]+1];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
				temp.setURL(this.getTrailString());
				updated_state[this.getLocation()[0]][this.getLocation()[1]+1]=this;	
		        this.setLocation(this.getLocation()[0],(this.getLocation()[1]+1));
	 		    updated_state[temp.getLocation()[0]][temp.getLocation()[1]-1]=temp;
			    temp.setLocation(temp.getLocation()[0], temp.getLocation()[1]-1);
				temp.setCardinalConnections(updated_state);
				this.setCardinalConnections(updated_state);
				System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
			
			if(dir == "West") {
				
				System.out.println("are we getting here?");
				temp = updated_state[this.getLocation()[0]][this.getLocation()[1]-1];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				temp.setURL(this.getTrailString());
				updated_state[this.getLocation()[0]][this.getLocation()[1]-1]=this;	
		        this.setLocation(this.getLocation()[0],(this.getLocation()[1]-1));
	 		    updated_state[temp.getLocation()[0]][temp.getLocation()[1]+1]=temp;
			    temp.setLocation(temp.getLocation()[0], temp.getLocation()[1]+1);
				temp.setCardinalConnections(updated_state);
				this.setCardinalConnections(updated_state);
				System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}

		}
		else { // If the AI has no different tile colors around it.
			Random randomOpt = new Random();
			int choice = randomOpt.nextInt(sametiles.size());
			String dir = sametiles.get(choice);
			if(dir == "North") {
				this.setCardinalConnections(updated_state);
				System.out.println("are we getting here?");
					temp = updated_state[this.getLocation()[0]-1][this.getLocation()[1]];
					try {
						temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						
					temp.setURL(this.getTrailString());
					updated_state[this.getLocation()[0]-1][this.getLocation()[1]]=this;	
			        this.setLocation(this.getLocation()[0]-1,(this.getLocation()[1]));
		 		    updated_state[temp.getLocation()[0]+1][temp.getLocation()[1]]=temp;
				    temp.setLocation(temp.getLocation()[0]+1, temp.getLocation()[1]);
					temp.setCardinalConnections(updated_state);
					this.setCardinalConnections(updated_state);
					System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
			
			if(dir == "South") {
				this.setCardinalConnections(updated_state);
				System.out.println("are we getting here?");
					temp = updated_state[this.getLocation()[0]+1][this.getLocation()[1]];
					try {
						temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						
					temp.setURL(this.getTrailString());
					updated_state[this.getLocation()[0]+1][this.getLocation()[1]]=this;	
			        this.setLocation(this.getLocation()[0]+1,(this.getLocation()[1]));
		 		    updated_state[temp.getLocation()[0]-1][temp.getLocation()[1]]=temp;
				    temp.setLocation(temp.getLocation()[0]-1, temp.getLocation()[1]);
					temp.setCardinalConnections(updated_state);
					this.setCardinalConnections(updated_state);
					System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
			
			if(dir == "East") {
				
				System.out.println("are we getting here?");
				temp = updated_state[this.getLocation()[0]][this.getLocation()[1]+1];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
				temp.setURL(this.getTrailString());
				updated_state[this.getLocation()[0]][this.getLocation()[1]+1]=this;	
			    this.setLocation(this.getLocation()[0],(this.getLocation()[1]+1));
	 		    updated_state[temp.getLocation()[0]][temp.getLocation()[1]-1]=temp;
			    temp.setLocation(temp.getLocation()[0], temp.getLocation()[1]-1);
				temp.setCardinalConnections(updated_state);
				this.setCardinalConnections(updated_state);
				System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
			
			if(dir == "West") {
				
				System.out.println("are we getting here?");
				temp = updated_state[this.getLocation()[0]][this.getLocation()[1]-1];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				temp.setURL(this.getTrailString());
				updated_state[this.getLocation()[0]][this.getLocation()[1]-1]=this;	
		        this.setLocation(this.getLocation()[0],(this.getLocation()[1]-1));
	 		    updated_state[temp.getLocation()[0]][temp.getLocation()[1]+1]=temp;
			    temp.setLocation(temp.getLocation()[0], temp.getLocation()[1]+1);
				temp.setCardinalConnections(updated_state);
				this.setCardinalConnections(updated_state);
				System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
			}
		}
		
		return updated_state;
		
		// OLDER CODE WITHOUT PRIORITY MOVEMENT
		//
		//
		//
		//
		/*
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
				*/
			
	}

}

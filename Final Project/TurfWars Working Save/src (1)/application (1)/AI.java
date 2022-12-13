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
	
/**
	 * 
	 */
	private static final long serialVersionUID = -4244871036464700509L;
//	String[] options = {"north", "down", "left", "right"};
		
	@Override
	public GridSquare[][] Movement(GridSquare[][] updated_state, String direction) {
		// TODO Auto-generated method stub
		GridSquare temp;
//		Random random_opt = new Random();
//		int CPUact = random_opt.nextInt(4);
		
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
		try {
		if(this.GetNorth() == null){
				System.out.println(this.getURL() + " Cannot go north");
				options.remove("North");
			}
		else if(this.GetNorth().getURL()==("Assets/Purple_Slime_Icon.png") ||
				this.GetNorth().getURL()==("Assets/Blue_Slime_Icon.png") || 
				this.GetNorth().getURL()==("Assets/Green_Slime_Icon.png") ||
				this.GetNorth().getURL()==("Assets/Pink_Slime_Icon.png")) {
			System.out.println(this.getURL() + " Cannot go north");
			options.remove("North");
			
		}
		if(this.GetSouth() == null) {
				System.out.println(this.getURL() + " Cannot go south");
				options.remove("South");
			}
		else if(this.GetSouth().getURL()==("Assets/Purple_Slime_Icon.png") ||
				this.GetSouth().getURL()==("Assets/Blue_Slime_Icon.png") || 
				this.GetSouth().getURL()==("Assets/Green_Slime_Icon.png") ||
				this.GetSouth().getURL()==("Assets/Pink_Slime_Icon.png"))
		{
			
			System.out.println(this.getURL() + " Cannot go south");
			options.remove("South");
		}
		
		if(this.GetEast() == null) {
				System.out.println(this.getURL() + " Cannot go east");
				options.remove("East");
			}
		else if(this.GetEast().getURL()==("Assets/Purple_Slime_Icon.png") ||
				this.GetEast().getURL()==("Assets/Blue_Slime_Icon.png") || 
				this.GetEast().getURL()==("Assets/Green_Slime_Icon.png") ||
				this.GetEast().getURL()==("Assets/Pink_Slime_Icon.png"))
		{
			System.out.println(this.getURL() + " Cannot go east");
			options.remove("East");
		}
		
		if(this.GetWest() == null) {
			System.out.println(this.getURL() + " Cannot go west");
			options.remove("West");
		}
		else if(this.GetWest().getURL()==("Assets/Purple_Slime_Icon.png") ||
				this.GetWest().getURL()==("Assets/Blue_Slime_Icon.png") || 
				this.GetWest().getURL()==("Assets/Green_Slime_Icon.png") ||
				this.GetWest().getURL()==("Assets/Pink_Slime_Icon.png"))
		{
			System.out.println(this.getURL() + " Cannot go west");
			options.remove("West");
		}
		}
		catch(NullPointerException e)
		{
			
		}
		
		if(options.size() == 0) { 
			// rare edge case would only be possible if the 3 AI slimes surround the player or AI
			// and is backed up against a wall which will probably never happen
			System.out.println("It seems that I am stuck.");
			return updated_state;
		}
		
		// ArrayList instead of Set because of random choice
		ArrayList<String> other_tiles = new ArrayList<String>(); //colors that are not the AIs
		ArrayList<String> same_tiles = new ArrayList<String>(); //colors that are the AIs
		
		for(String dir : options) { // check if trail is not the same as the AIs
			if(dir == "North") {
				if(this.GetNorth().getURL() != this.getTrailString()) { // different trail
					other_tiles.add("North");
				}
				else { // same trail
					same_tiles.add("North");
				}
			}
			if(dir == "South") {
				if(this.GetSouth().getURL() != this.getTrailString()) { // different trail
					other_tiles.add("South");
				}
				else { // same trail
					same_tiles.add("South");
				}
			}
			if(dir == "East") {
				if(this.GetEast().getURL() != this.getTrailString()) { // different trail
					other_tiles.add("East");
				}
				else { // same trail
					same_tiles.add("East");
				}
			}
			if(dir == "West") {
				if(this.GetWest().getURL() != this.getTrailString()) { // different trail
					other_tiles.add("West");
				}
				else { // same trail
					same_tiles.add("West");
				}
			}
		}
		
		if(other_tiles.size() != 0) { // prioritize other tile colors
			Random random_opt = new Random();
			int choice = random_opt.nextInt(other_tiles.size());
			String dir = other_tiles.get(choice); // prioritize items first
			if((dir == "North" && this.GetNorth().getURL()==("Assets/V_laser_tile.jpg")) || (dir == "North" && this.GetNorth().getURL()==("Assets/H_laser_tile.jpg")) || (dir == "North" && this.GetNorth().getURL()==("Assets/Bomb_tile.jpg"))) {
				System.out.println(this.GetNorth().getURL() + " has been picked up!");
				if(this.GetNorth().getURL()==("Assets/V_laser_tile.jpg")) {
					
					updated_state = moveNorth(updated_state);
					Vertical_Beam v = new Vertical_Beam();
					updated_state = v.Use(updated_state, this.getURL(), this.getLocation(), this);
				}
				else if(this.GetNorth().getURL()==("Assets/H_laser_tile.jpg")) {
					
					updated_state = moveNorth(updated_state);
					Horizontal_Beam h = new Horizontal_Beam();
					updated_state = h.Use(updated_state, this.getURL(),this.getLocation(), this);
				}
				else if(this.GetNorth().getURL()==("Assets/Bomb_tile.jpg")) {
					
					updated_state = moveNorth(updated_state);
					Bomb b = new Bomb();
					updated_state = b.Use(updated_state,this.getURL(),this.getLocation(), this);
				}
				
				return updated_state;
			}
			else if((dir == "South" && this.GetSouth().getURL()==("Assets/V_laser_tile.jpg")) || (dir == "South" && this.GetSouth().getURL()==("Assets/H_laser_tile.jpg")) || (dir == "South" && this.GetSouth().getURL()==("Assets/Bomb_tile.jpg"))) {
				System.out.println(this.GetSouth().getURL() + " has been picked up!");
				if(this.GetSouth().getURL()==("Assets/V_laser_tile.jpg")) {
					updated_state = moveSouth(updated_state);
					Vertical_Beam v = new Vertical_Beam();
					updated_state = v.Use(updated_state, this.getURL(),this.getLocation(), this);
				}
				else if(this.GetSouth().getURL()==("Assets/H_laser_tile.jpg")) {
					updated_state = moveSouth(updated_state);
					Horizontal_Beam h = new Horizontal_Beam();
					updated_state = h.Use(updated_state, this.getURL(),this.getLocation(), this);
				}
				else if(this.GetSouth().getURL()==("Assets/Bomb_tile.jpg")) {
					updated_state = moveSouth(updated_state);
					Bomb b = new Bomb();
					updated_state = b.Use(updated_state,this.getURL(),this.getLocation(), this);
				}
				
				return updated_state;
			}
			else if((dir == "East" && this.GetEast().getURL()==("Assets/V_laser_tile.jpg")) || (dir == "East" && this.GetEast().getURL()==("Assets/H_laser_tile.jpg")) || (dir == "East" && this.GetEast().getURL()==("Assets/Bomb_tile.jpg"))) {
				System.out.println(this.GetEast().getURL() + " has been picked up!");
				if(this.GetEast().getURL()==("Assets/V_laser_tile.jpg")) {
					updated_state = moveEast(updated_state);
					Vertical_Beam v = new Vertical_Beam();
					updated_state = v.Use(updated_state, this.getURL(),this.getLocation(), this);
				}
				else if(this.GetEast().getURL()==("Assets/H_laser_tile.jpg")) {
					updated_state = moveEast(updated_state);
					Horizontal_Beam h = new Horizontal_Beam();
					updated_state = h.Use(updated_state, this.getURL(),this.getLocation(), this);
				}
				else if(this.GetEast().getURL()==("Assets/Bomb_tile.jpg")) {
					updated_state = moveEast(updated_state);
					Bomb b = new Bomb();
					updated_state = b.Use(updated_state,this.getURL(),this.getLocation(), this);
				}
				
				return updated_state;
			}
			else if((dir == "West" && this.GetWest().getURL()==("Assets/V_laser_tile.jpg")) || (dir == "West" && this.GetWest().getURL()==("Assets/H_laser_tile.jpg")) || (dir == "West" && this.GetWest().getURL()==("Assets/Bomb_tile.jpg"))) {
				System.out.println(this.GetWest().getURL() + " has been picked up!");
				if(this.GetWest().getURL()==("Assets/V_laser_tile.jpg")) {
					updated_state = moveWest(updated_state);
					Vertical_Beam v = new Vertical_Beam();
					updated_state = v.Use(updated_state, this.getURL(),this.getLocation(), this);
				}
				else if(this.GetWest().getURL()==("Assets/H_laser_tile.jpg")) {
					updated_state = moveWest(updated_state);
					Horizontal_Beam h = new Horizontal_Beam();
					updated_state = h.Use(updated_state, this.getURL(),this.getLocation(), this);
				}
				else if(this.GetWest().getURL()==("Assets/Bomb_tile.jpg")) {
					updated_state = moveWest(updated_state);
					Bomb b = new Bomb();
					updated_state = b.Use(updated_state,this.getURL(),this.getLocation(), this);
				}
				
				return updated_state;
			}
			else {
				if(dir == "North") {
					
					updated_state = moveNorth(updated_state);
				}
				else if(dir == "South") {
					
					updated_state = moveSouth(updated_state);
				}
				else if(dir == "East") {
					
					updated_state = moveEast(updated_state);
				}
				else if(dir == "West") {
					
					updated_state = moveWest(updated_state);
				}
			}
		}
		else { // If the AI has no different tile colors around it.
			Random random_opt = new Random();
			int choice = random_opt.nextInt(same_tiles.size());
			String dir = same_tiles.get(choice);
			if(dir == "North") {
				updated_state = moveNorth(updated_state);
			}
			
			if(dir == "South") {
				updated_state = moveSouth(updated_state);
			}
			
			if(dir == "East") {
				
				updated_state = moveEast(updated_state);
			}
			
			if(dir == "West") {
				
				updated_state = moveWest(updated_state);
			}
		}
		
		return updated_state;
		
	
	}
	GridSquare[][] moveNorth(GridSquare[][] updated_state) {
		GridSquare temp;
		//System.out.println("are we getting here?");
		temp = updated_state[this.getLocation()[0]-1][this.getLocation()[1]];
		try {
			temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
		//System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
		return updated_state;
	}
	
	GridSquare[][] moveSouth(GridSquare[][] updated_state) {
		GridSquare temp;
		//System.out.println("are we getting here?");
		temp = updated_state[this.getLocation()[0]+1][this.getLocation()[1]];
		try {
			temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
		//System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
		return updated_state;
	}
	GridSquare[][] moveEast(GridSquare[][] updated_state) {
		GridSquare temp;
		//System.out.println("are we getting here?");
		temp = updated_state[this.getLocation()[0]][this.getLocation()[1]+1];
		try {
			temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
		//System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
		return updated_state;
	}
	GridSquare[][] moveWest(GridSquare[][] updated_state) {
		GridSquare temp;
		//System.out.println("are we getting here?");
		temp = updated_state[this.getLocation()[0]][this.getLocation()[1]-1];
		try {
			temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
		//System.out.println(this.getLocation()[0] + ", " + this.getLocation()[1]);
		return updated_state;
	}
}

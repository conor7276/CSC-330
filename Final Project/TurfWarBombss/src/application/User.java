package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class User extends PlayerSuper{
	
	transient MediaPlayer move_sound;
	//C:\\Users\\chris\\eclipse-workspace\\TurfWars\\Assets\\movment_splat.mp3
	String move_sound_location = "Assets/movment_splat.mp3";
	@Override
	public GridSquare[][] Movement(GridSquare[][] updated_state, String direction) {
		
		if(direction == "west") {
			this.setCardinalConnections(updated_state);
			
		if (this.GetWest() == null || this.GetWest().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Green_Slime_Icon.png" || this.GetWest().getURL() == "Assets/Pink_Slime_Icon.png") {
			System.out.println("cannot move there");
		}
	    else if(this.GetWest().getURL() == "Assets/V_laser_tile.jpg" || this.GetWest().getURL() == "Assets/Bomb_tile.jpg"|| this.GetWest().getURL() == "Assets/H_laser_tile.jpg")
	    {
	    	
	    	//this will set the item to a temp variable to be later used and replace its location with the slime icon
	    	GridSquare temp;
	    	temp = updated_state[this.getLocation()[0]][this.getLocation()[1]-1];
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1] = this;
	    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1]= new GridSquare();
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setLocation(this.getLocation()[0], this.getLocation()[1]+1);
	    	try {
	    		updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
	    		updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setPadding(new Insets(0, 0, 0, 0));
	    	} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setCardinalConnections(updated_state);
	    	this.setCardinalConnections(updated_state);
	    	
	    	//if entered the if statement this check will determine what item was eaten and 
	    	//will call the used method for that item at the location it was last
	    	if(temp.getURL() == "Assets/V_laser_tile.jpg")
	    	{
	    		Vertical_Beam v_beam = new Vertical_Beam();
	    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
	    		v_beam.setCardinalConnections(updated_state);
	    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
	    	}
	    	else if(temp.getURL() == "Assets/Bomb_tile.jpg")
	    	{
	    		Bomb bomb = new Bomb();
	    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
	    		bomb.setCardinalConnections(updated_state);
	    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
	    	}
	    	else if(temp.getURL() == "Assets/H_laser_tile.jpg")
	    	{
	    		Horizontal_Beam h_beam = new Horizontal_Beam();
	    		h_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
	    		h_beam.setCardinalConnections(updated_state);
	    		h_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
	    	}
	    }
	    else {
	    	move_sound = null;
			move_sound = new MediaPlayer(new Media(new File(move_sound_location).toURI().toString()));
			move_sound.setVolume(0.7);
			move_sound.play();
			GridSquare temp;
			temp = updated_state[this.getLocation()[0]][this.getLocation()[1]-1];
			try {
				temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
			
			
		}
	
		}
		if(direction == "east") {
			this.setCardinalConnections(updated_state);
			if (this.GetEast() == null || this.GetEast().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetEast().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetEast().getURL() == "Assets/Green_Slime_Icon.png" || this.GetEast().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("cannot move there");
			}
		    else if(this.GetEast().getURL() == "Assets/V_laser_tile.jpg" || this.GetEast().getURL() == "Assets/Bomb_tile.jpg"|| this.GetEast().getURL() == "Assets/H_laser_tile.jpg")
				    {
		    			GridSquare temp;
		    			temp = updated_state[this.getLocation()[0]][this.getLocation()[1]+1];
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1] = this;
				    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1]= new GridSquare();
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setLocation(this.getLocation()[0], this.getLocation()[1]-1);
				    	try {
				    		updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				    		updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setPadding(new Insets(0, 0, 0, 0));
				    	} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setCardinalConnections(updated_state);
				    	this.setCardinalConnections(updated_state);

				    	if(temp.getURL() == "Assets/V_laser_tile.jpg")
				    	{
				    		Vertical_Beam v_beam = new Vertical_Beam();
				    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
				    		v_beam.setCardinalConnections(updated_state);
				    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
				    	}
				    	else if(temp.getURL() == "Assets/Bomb_tile.jpg")
				    	{
				    		Bomb bomb = new Bomb();
				    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
				    		bomb.setCardinalConnections(updated_state);
				    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
				    	}
				    	else if(temp.getURL() == "Assets/H_laser_tile.jpg")
				    	{
				    		Horizontal_Beam h_beam = new Horizontal_Beam();
				    		h_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
				    		h_beam.setCardinalConnections(updated_state);
				    		h_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
				    	}
				    }
			else {
				move_sound = null;
				move_sound = new MediaPlayer(new Media(new File(move_sound_location).toURI().toString()));
				move_sound.setVolume(0.7);
				move_sound.play();
				GridSquare temp;
				temp = updated_state[this.getLocation()[0]][this.getLocation()[1]+1];
				System.out.println(temp);
				System.out.println(this.getTrailString());
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
				
			}
			
			}
		if(direction == "south") {
			this.setCardinalConnections(updated_state);
			if (this.GetSouth() == null || this.GetSouth().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetSouth().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetSouth().getURL() == "Assets/Green_Slime_Icon.png" || this.GetSouth().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("cannot move there");
			}
			 else if(this.GetSouth().getURL() == "Assets/V_laser_tile.jpg" || this.GetSouth().getURL() == "Assets/Bomb_tile.jpg"|| this.GetSouth().getURL() == "Assets/H_laser_tile.jpg")
			    {
			    	
				 	GridSquare temp;
			    	temp = updated_state[this.getLocation()[0] + 1][this.getLocation()[1]];
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]] = this;
			    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]]= new GridSquare();
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setLocation(this.getLocation()[0]-1, this.getLocation()[1]);
			    	try {
			    		updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
			    		updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setPadding(new Insets(0, 0, 0, 0));
			    	} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setCardinalConnections(updated_state);
			    	this.setCardinalConnections(updated_state);

			    	if(temp.getURL() == "Assets/V_laser_tile.jpg")
			    	{
			    		Vertical_Beam v_beam = new Vertical_Beam();
			    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		v_beam.setCardinalConnections(updated_state);
			    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL() == "Assets/Bomb_tile.jpg")
			    	{
			    		Bomb bomb = new Bomb();
			    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		bomb.setCardinalConnections(updated_state);
			    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL() == "Assets/H_laser_tile.jpg")
			    	{
			    		Horizontal_Beam h_beam = new Horizontal_Beam();
			    		h_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		h_beam.setCardinalConnections(updated_state);
			    		h_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    }
			else {
				move_sound = null;
				move_sound = new MediaPlayer(new Media(new File(move_sound_location).toURI().toString()));
				move_sound.setVolume(0.7);
				move_sound.play();
				System.out.println(this.getTrailString());
				GridSquare temp;
				temp = updated_state[this.getLocation()[0]+1][this.getLocation()[1]];
	            try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
				
			}
			
			}
		if(direction == "north") {
			this.setCardinalConnections(updated_state);
			if (this.GetNorth() == null || this.GetNorth().getURL() == "Assets/Purple_Slime_Icon.png" || this.GetNorth().getURL() == "Assets/Blue_Slime_Icon.png" || this.GetNorth().getURL() == "Assets/Green_Slime_Icon.png" || this.GetNorth().getURL() == "Assets/Pink_Slime_Icon.png") {
				System.out.println("cannot move there");
				} 
			 else if(this.GetNorth().getURL() == "Assets/V_laser_tile.jpg" || this.GetNorth().getURL() == "Assets/Bomb_tile.jpg"|| this.GetNorth().getURL() == "Assets/H_laser_tile.jpg")
			    {
			    	GridSquare temp;
			    	temp = updated_state[this.getLocation()[0]-1][this.getLocation()[1]];
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]] = this;
			    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]]= new GridSquare();
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setLocation(this.getLocation()[0]+1, this.getLocation()[1]);
			    	try {
			    		updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
			    		updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setPadding(new Insets(0, 0, 0, 0));
			    	} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setCardinalConnections(updated_state);
			    	this.setCardinalConnections(updated_state);

			    	if(temp.getURL() == "Assets/V_laser_tile.jpg")
			    	{
			    		Vertical_Beam v_beam = new Vertical_Beam();
			    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		v_beam.setCardinalConnections(updated_state);
			    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL() == "Assets/Bomb_tile.jpg")
			    	{
			    		Bomb bomb = new Bomb();
			    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		bomb.setCardinalConnections(updated_state);
			    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL() == "Assets/H_laser_tile.jpg")
			    	{
			    		Horizontal_Beam h_beam = new Horizontal_Beam();
			    		h_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		h_beam.setCardinalConnections(updated_state);
			    		h_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    }
			else {
				move_sound = null;
				move_sound = new MediaPlayer(new Media(new File(move_sound_location).toURI().toString()));
				move_sound.setVolume(0.7);
				move_sound.play();
				GridSquare temp;
				temp = updated_state[this.getLocation()[0]-1][this.getLocation()[1]];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
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
				
			}
			
			}
		return updated_state;
	}

}

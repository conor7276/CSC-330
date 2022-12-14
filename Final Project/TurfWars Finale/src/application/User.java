package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class User extends PlayerSuper{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4848872316230694190L;
	GridSquare temp;
	transient MediaPlayer move_sound;
	
	String move_sound_location = "Assets\\movment_splat.mp3";
	@Override
	/**
	 * movement logic for the player. We check what direction the string reads and grabs that GridSquare's
	 * "get-DirectionName-()" to move to that direction
	 */
	
	public GridSquare[][] Movement(GridSquare[][] updated_state, String direction) {
		try {
		if(direction ==  "west") {
			this.setCardinalConnections(updated_state);
			
		if (this.GetWest().equals(null) == true || this.GetWest().getURL().equals("Assets/Purple_Slime_Icon.png") == true || this.GetWest().getURL().equals("Assets/Blue_Slime_Icon.png") == true || this.GetWest().getURL().equals("Assets/Green_Slime_Icon.png") == true || this.GetWest().getURL().equals("Assets/Pink_Slime_Icon.png") == true) {
			System.out.println("cannot move there");
		}
	    else if(this.GetWest().getURL().equals("Assets/V_laser_tile.jpg") == true || this.GetWest().getURL().equals("Assets/Bomb_tile.jpg") == true|| this.GetWest().getURL().equals("Assets/H_laser_tile.jpg") == true)
	    {
	    	//this will set the item to a temp variable to be later used and replace its location with the slime icon
	    	temp = this.GetWest();
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1] = this;
	    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1]= new GridSquare();
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setLocation(this.getLocation()[0], this.getLocation()[1]+1);
	    	try {
	    		updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
	    		updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setPadding(new Insets(0, 0, 0, 0));
	    		updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setURL(this.getTrailString());
	    	} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
	    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1].setCardinalConnections(updated_state);
	    	this.setCardinalConnections(updated_state);
	    	
	    	//if entered the if statement this check will determine what item was eaten and 
	    	//will call the used method for that item at the location it was last
	    	if(temp.getURL().equals("Assets/V_laser_tile.jpg") == true)
	    	{
	    		Vertical_Beam v_beam = new Vertical_Beam();
	    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
	    		v_beam.setCardinalConnections(updated_state);
	    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
	    	}
	    	else if(temp.getURL().equals("Assets/Bomb_tile.jpg") == true)
	    	{
	    		Bomb bomb = new Bomb();
	    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
	    		bomb.setCardinalConnections(updated_state);
	    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
	    	}
	    	else if(temp.getURL().equals("Assets/H_laser_tile.jpg") == true)
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
			move_sound.setVolume(0.3);
			move_sound.play();
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
			if (this.GetEast().equals(null) == true || this.GetEast().getURL().equals("Assets/Purple_Slime_Icon.png") == true|| this.GetEast().getURL().equals("Assets/Blue_Slime_Icon.png") == true || this.GetEast().getURL().equals("Assets/Green_Slime_Icon.png") == true || this.GetEast().getURL().equals("Assets/Pink_Slime_Icon.png") == true) {
				System.out.println("cannot move there");
			}
			 else if(this.GetEast().getURL().equals("Assets/V_laser_tile.jpg") == true || this.GetEast().getURL().equals("Assets/Bomb_tile.jpg") == true|| this.GetEast().getURL().equals("Assets/H_laser_tile.jpg") == true)
				    {
				    	
				    	temp = this.GetEast();
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]+1] = this;
				    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1]= new GridSquare();
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setLocation(this.getLocation()[0], this.getLocation()[1]-1);
				    	try {
				    		updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				    		updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setPadding(new Insets(0, 0, 0, 0));
				    		updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setURL(this.getTrailString());
				    	} catch (FileNotFoundException e) {
							
							e.printStackTrace();
						}
				    	updated_state[this.getLocation()[0]][this.getLocation()[1]-1].setCardinalConnections(updated_state);
				    	this.setCardinalConnections(updated_state);

				    	if(temp.getURL().equals("Assets/V_laser_tile.jpg") == true)
				    	{
				    		Vertical_Beam v_beam = new Vertical_Beam();
				    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
				    		v_beam.setCardinalConnections(updated_state);
				    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
				    	}
				    	else if(temp.getURL().equals("Assets/Bomb_tile.jpg") == true)
				    	{
				    		Bomb bomb = new Bomb();
				    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
				    		bomb.setCardinalConnections(updated_state);
				    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
				    	}
				    	else if(temp.getURL().equals("Assets/H_laser_tile.jpg") == true)
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
				move_sound.setVolume(0.3);
				move_sound.play();
				temp = updated_state[this.getLocation()[0]][this.getLocation()[1]+1];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
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
			if (this.GetSouth().equals(null) == true || this.GetSouth().getURL().equals("Assets/Purple_Slime_Icon.png") == true || this.GetSouth().getURL().equals("Assets/Blue_Slime_Icon.png") == true || this.GetSouth().getURL().equals("Assets/Green_Slime_Icon.png") == true|| this.GetSouth().getURL().equals("Assets/Pink_Slime_Icon.png") == true) {
				System.out.println("cannot move there");
			}
			 else if(this.GetSouth().getURL().equals("Assets/V_laser_tile.jpg") == true || this.GetSouth().getURL().equals("Assets/Bomb_tile.jpg") == true|| this.GetSouth().getURL().equals("Assets/H_laser_tile.jpg") == true)
			    {
			    	
			    	temp = this.GetSouth();
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]] = this;
			    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]]= new GridSquare();
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setLocation(this.getLocation()[0]-1, this.getLocation()[1]);
			    	try {
			    		updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
			    		updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setPadding(new Insets(0, 0, 0, 0));
			    		updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setURL(this.getTrailString());
			    	} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]].setCardinalConnections(updated_state);
			    	this.setCardinalConnections(updated_state);

			    	if(temp.getURL().equals("Assets/V_laser_tile.jpg") == true)
			    	{
			    		Vertical_Beam v_beam = new Vertical_Beam();
			    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		v_beam.setCardinalConnections(updated_state);
			    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL().equals("Assets/Bomb_tile.jpg") == true)
			    	{
			    		Bomb bomb = new Bomb();
			    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		bomb.setCardinalConnections(updated_state);
			    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL().equals("Assets/H_laser_tile.jpg") == true)
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
				move_sound.setVolume(0.3);
				move_sound.play();
				System.out.println(this.getTrailString());
				temp = updated_state[this.getLocation()[0]+1][this.getLocation()[1]];
	            try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
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
			
			if (this.GetNorth().equals(null) == true|| this.GetNorth().getURL().equals("Assets/Purple_Slime_Icon.png") == true || this.GetNorth().getURL().equals("Assets/Blue_Slime_Icon.png") == true || this.GetNorth().getURL().equals("Assets/Green_Slime_Icon.png") == true || this.GetNorth().getURL().equals("Assets/Pink_Slime_Icon.png") == true) {
				System.out.println("cannot move there");
				} 
			 else if(this.GetNorth().getURL().equals("Assets/V_laser_tile.jpg") == true || this.GetNorth().getURL().equals("Assets/Bomb_tile.jpg") == true|| this.GetNorth().getURL().equals("Assets/H_laser_tile.jpg") == true)
			    {
			    	
			    	temp = this.GetNorth();
			    	updated_state[this.getLocation()[0]-1][this.getLocation()[1]] = this;
			    	this.setLocation(temp.getLocation()[0],(temp.getLocation()[1]));
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]]= new GridSquare();
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setLocation(this.getLocation()[0]+1, this.getLocation()[1]);
			    	try {
			    		updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
			    		updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setPadding(new Insets(0, 0, 0, 0));
			    		updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setURL(this.getTrailString());
			    	} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}
			    	updated_state[this.getLocation()[0]+1][this.getLocation()[1]].setCardinalConnections(updated_state);
			    	this.setCardinalConnections(updated_state);

			    	if(temp.getURL().equals("Assets/V_laser_tile.jpg") == true)
			    	{
			    		Vertical_Beam v_beam = new Vertical_Beam();
			    		v_beam.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		v_beam.setCardinalConnections(updated_state);
			    		v_beam.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL().equals("Assets/Bomb_tile.jpg") == true)
			    	{
			    		Bomb bomb = new Bomb();
			    	    bomb.setLocation(temp.getLocation()[0], temp.getLocation()[1]);
			    		bomb.setCardinalConnections(updated_state);
			    		bomb.Use(updated_state, this.getTrailString(), this.getLocation(), this);
			    	}
			    	else if(temp.getURL().equals("Assets/H_laser_tile.jpg") == true)
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
				move_sound.setVolume(0.3);
				move_sound.play();
				temp = updated_state[this.getLocation()[0]-1][this.getLocation()[1]];
				try {
					temp.setGraphic(new ImageView(new Image(new FileInputStream(this.getTrailString()),getTrail().getImage().getHeight(),getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					
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
		}
			catch(NullPointerException e)
			{
				
			}
		return updated_state;
	}

}

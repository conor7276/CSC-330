package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Vertical_Beam  extends GridSquare implements Items{

	Vertical_Beam(String URL, int img_size)
	{
	this.setURL(URL);
		
	try {
		this.setGraphic(new ImageView(new Image(new FileInputStream(URL),img_size,img_size,false,false)));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	Vertical_Beam()
	{
		
	}
	
	@Override
	public GridSquare[][] Use(GridSquare[][] gameboard, String SlimeTrail_String, int[] location, PlayerSuper slime) {
		// TODO Auto-generated method stub
	
		System.out.println("Beaming Vertically " + gameboard.length);
		for(int square = 0; square < gameboard.length; square++) {
			if(gameboard[square][location[1]].getURL() != "Assets/Purple_Slime_Icon.png" &&
					gameboard[square][location[1]].getURL() != "Assets/Blue_Slime_Icon.png" && 
					gameboard[square][location[1]].getURL() != "Assets/Green_Slime_Icon.png" &&
					gameboard[square][location[1]].getURL() != "Assets/Pink_Slime_Icon.png") {
				System.out.println(gameboard[square][location[1]] + SlimeTrail_String);
				gameboard[square][location[1]].setURL(SlimeTrail_String);
				GridSquare temp;
				
				//temp = gameboard[square][slime.getLocation()[1]];
				//gameboard[square][location[1]].setCardinalConnections(gameboard);
				//this.setCardinalConnections(gameboard);
				try {
					gameboard[square][location[1]].setGraphic(new ImageView(new Image(new FileInputStream("Assets/"+slime.getTrailString()),slime.getTrail().getImage().getHeight(),slime.getTrail().getImage().getWidth(),false,false)));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//temp.setURL(slime.getTrailString());
				//gameboard[square][slime.getLocation()[1]]=slime;	
				//slime.setLocation(square,(slime.getLocation()[1]));
//				    gameboard[square][temp.getLocation()[1]]=temp;
//			    temp.setLocation(square, temp.getLocation()[1]);
//				temp.setCardinalConnections(gameboard);
//				slime.setCardinalConnections(gameboard);
			}
		}
		return gameboard;
	}

}

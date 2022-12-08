package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb extends GridSquare implements Items{


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
		System.out.println("Bombing the place!");
		return gameboard;
	}

}

package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Search {
	
    public GridSquare[][] Check_Unconnected(PlayerSuper player,GridSquare gameboard[][],int Size_Graphic)
    {
    	Boolean found_player = false;
    	//Array lists are here to later optimize the search, any objects searched in Linear_Search should be past returned and saved to not be searched again.
//    	ArrayList<GridSquare> searched_true = new ArrayList<GridSquare>(gameboard.length*gameboard.length);
//    	ArrayList<GridSquare> searched_false = new ArrayList<GridSquare>(gameboard.length*gameboard.length);
    	for(int i = 0; i < gameboard.length; i++)
    	{
    		for(int j = 0; j < gameboard.length; j++)
        	{
    			if(gameboard[i][j] != null)
    			{
        		if(gameboard[i][j].getURL() == player.getTrailString())
        		{
        			
        			found_player = Linear_Search(gameboard[i][j],player);
        			if(found_player == false)
        			{
        				gameboard[i][j].setURL("Assets/Gray_square_tile .PNG");
        				try {
							gameboard[i][j].setGraphic(new ImageView(new Image(new FileInputStream("Assets/Gray_square_tile .PNG"),Size_Graphic, Size_Graphic, false, false)));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
        			}
        		}
        		}
        	
        	}
    	
    	}

    	
		return gameboard;
    	
    }
    
    private Boolean Linear_Search(GridSquare current_tile, PlayerSuper player)
	{
    	if(current_tile.GetNorth() != null) {
    		
    	if(current_tile.GetNorth().getURL() ==  player.getTrailString())
    	{
    		if(Linear_Search( current_tile.GetNorth(),player)==true)
    		{
    			return true;
    		}
    	}
    	else if(current_tile.GetNorth().getURL() ==  player.getURL()){
    		
    		return true;
    	}
    	
    	}
    	if(current_tile.GetEast() != null) {
    		
    	if(current_tile.GetEast().getURL() ==  player.getTrailString())
    	{
    		Linear_Search( current_tile.GetEast(),player);
    	}
    	else if(current_tile.GetEast().getURL() ==  player.getURL()){
    		
    		return true;
    	}
    	
    	}
    	if(current_tile.GetWest() != null) {
    		
        	if(current_tile.GetWest().getURL() ==  player.getTrailString())
        	{
        		Linear_Search( current_tile.GetSouth(),player);
        	}
        	else if(current_tile.GetSouth().getURL() ==  player.getURL()){
        		
        		return true;
        	}
        	
        	}
    	if(current_tile.GetSouth() != null) {
    		
    	if(current_tile.GetSouth().getURL() ==  player.getTrailString())
    	{
    		Linear_Search( current_tile.GetSouth(),player);
    	}
    	else if(current_tile.GetSouth().getURL() ==  player.getURL()){
    		
    		return true;
    	}
    	
    	}
    	
    	return false;
		
		
	}
	
}



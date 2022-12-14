package application;

import java.io.Serializable;

import javafx.scene.control.Button;

public class GridSquare extends Button implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String URL;
private int location[] = new int[2];
private GridSquare west;
private GridSquare east;
private GridSquare north;
private GridSquare south;
/**
 * 
 * @param row grab the GridSquare's row number
 * @param col grab the GridSquare's column number
 */
	public void setLocation(int row, int col)
	{
		location[0] = row;
		location[1] = col;
	}
	/**
	 * 
	 * @return the location of the GridSquare by row, column
	 */
	
	public int[] getLocation() {
		return location;
	}
	/**
	 * 
	 * @param grid set the polar coordinates that are adjacent to the GridSquare to keep track 
	 * of where it can move next.
	 */
	
	public void setCardinalConnections(GridSquare grid[][])
	{
		try
		{
		west = grid[this.location[0]][this.location[1]-1];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			west = null;
		}
		try
		{
		east = grid[this.location[0]][this.location[1]+1];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			east = null;
		}
		try 
		{
		north = grid[this.location[0]-1][this.location[1]];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			north = null;
		}
		try
		{
		south = grid[this.location[0]+1][this.location[1]];
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			south = null;
		}
	}
	/**
	 * 
	 * @return the left of the GridSquare's location
	 */
	
	public GridSquare GetWest()
	{
		return west;
		
	}

	/**
	 * 
	 * @return the right of the GridSquare's location
	 */
	
	public GridSquare GetEast()
	{
		return east;
		
	}

	/**
	 * 
	 * @return the north of the GridSquare's location
	 */
	
	public GridSquare GetNorth()
	{
		return north;
		
	}
	/**
	 * 
	 * @return the south of the GridSquare's location
	 */
	
	public GridSquare GetSouth()
	{
		return south;
		
	}

	/**
	 * 
	 * @return the GridSquare's URL to either render on the grid or check for collision on the board
	 */
	
	public String getURL() {
		return URL;
	}

	/**
	 * 
	 * @param uRL grab the GridSquare's URL
	 */
	
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public String toString() {
		String s = "";
		s += getLocation()[0] + ", " + getLocation()[1];
		return s;
	}

}

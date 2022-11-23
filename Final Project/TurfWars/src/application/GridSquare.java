package application;

import javafx.scene.control.Button;

public class GridSquare extends Button{

private int location[]= new int[2];
private GridSquare west;
private GridSquare east;
private GridSquare north;
private GridSquare south;
    public void setLoction(int row, int col)
    {
        location[0] = row;
        location[1] = col;
    }
    public int[] getLocation() {
        return location;
    }
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
    public GridSquare GetWest()
    {
        return west;

    }
    public GridSquare GetEast()
    {
        return east;

    }
    public GridSquare GetNorth()
    {
        return north;

    }
    public GridSquare GetSouth()
    {
        return south;

    }
}
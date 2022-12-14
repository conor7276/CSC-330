package application;

public interface Items {
	/**
	 * 
	 * @param gameboard the whole grid
	 * @param SlimeTrail_String the slime's trail color
	 * @param location gameboard coordinates
	 * @param slime the players
	 * @return new gamboard after items affect occurs
	 */
	public GridSquare[][] Use(GridSquare[][] gameboard, String SlimeTrail_String, int[] location, PlayerSuper slime);
	
}

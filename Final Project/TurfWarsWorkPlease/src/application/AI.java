package application;
import java.util.Random;

public class AI extends PlayerSuper {
	
	String[] options = {"up", "down", "left", "right"};
		
	@Override
	public GridSquare[][] Movement(GridSquare[][] updated_state, String direction) {
		// TODO Auto-generated method stub
		Random randomOpt = new Random();
		int CPUact = randomOpt.nextInt(4);
		
		return updated_state;
	}

}

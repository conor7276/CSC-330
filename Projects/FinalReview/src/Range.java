public class Range implements NumberGroup {

	private int min;
	private int max;
	
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public boolean contains(int num) {
		if (num >= min && num <= max) return true;
		else return false;
		
		//return (num >= min && num <= max);
	}
	
}

//This is the answer to 2c

/** Returns true if at least one of the number groups in       
* this multiple group contains num; false otherwise.
*/
	/*public boolean contains(int num) {
		for(NumberGroup ng : groupList) {
			if (ng.contains(num)) return true;
		}
		//for loop:
		//for(int i = 0; i < groupList.size(); i++) {
		//	   if (groupList.get(i).contains(num)) return true;
		//}
		//If I get here, num is not in any NG in groupList
		return false;
	}*/


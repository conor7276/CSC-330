public class LoudDog extends Dog {

	public LoudDog(String n) {
		super(n);
	}
	
	public String speak() {
		//use super to call the parent method!
		return super.speak() + super.speak();
	}
		
}

/** answer to 3c:
 * 
 * public void allSpeak() {
 *      for(int i = 0; i < petList.size(); i++) {
 *           System.out.println(petList.get(i).speak());
 *      }
 * }
 * 
 */
 
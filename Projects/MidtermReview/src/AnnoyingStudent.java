public class AnnoyingStudent extends Student {

	private double volumeLevel;
	private boolean hasDetention;

	public AnnoyingStudent() {
		volumeLevel = 0;
		hasDetention = false;
	}	
	//part a – Write constructor for parameterized constructor

	public AnnoyingStudent(String n, int id, double average, double vl, boolean hd) {
		super(n, id, average);   //MAKE SURE TO CALL PARENT CONSTRUCTOR!!
		volumeLevel = vl;
		hasDetention = hd;
	}
	
//accessor methods getVolumeLevel() and getHasDetention(); //mutator method setVolumeLevel(double d) are not shown

	/** 
	 * Returns true if this Student’s volume level is over 50, 
	 *false otherwise
	 *@return this Student’s detention status*/
	public boolean giveDetention() {
		//part b
		if (volumeLevel > 50)
			return true;
		else
			return false;
	}
	
	//part c and d
	public static void main(String[] args) {
		Student s1 = new Student("John", 1, 64.9);
		Student s2 = new Student("Sam", 2, 99);
		System.out.println(s1 + " " + s2); //print info
		swap(s1, s2);
	}

	public static void swap(Student first, Student second) {
		/*Student temp = first;
		first = second;
		second = temp;  dumb*/
		//deep copy
		String tempName = first.getName();
		int tempId = first.getID();
		double tempAverage = first.getAverage();
		//set values for first
		first.setName(second.getName());
		first.setID(second.getID());
		first.setAverage(second.getAverage());
		//set values for second
		second.setName(tempName);
		second.setID(tempId);
		second.setAverage(tempAverage);		
	}

	
}

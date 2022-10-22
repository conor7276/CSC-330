public class Student implements Comparable<Student> {

	//data
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public void setAverage(double average) {
		this.average = average;
	}

	private int id;
	private double average;

	//constructors
	public Student() { 
		name = "Not Sure";
		id = 1;
		average = 75;
	}
	public Student(String n, int i, double a) { 
		name = n;
		id = i;
		average = a;
	}

	//methods
	public int compareTo(Student other) { //parts a and b}
		//part a
		/*if (this.getAverage() > other.getAverage()) {
			return 1;
		} else if (this.getAverage() < other.getAverage()) {
			return -1;
		} else
			return 0;*/
		//return (int)((this.getAverage() - other.getAverage())*100);
		
		//part b
		return this.name.compareTo(other.name);
		//otherwise, you'd have to write a for loop to iterate through both Strings
		//and keep checking chars until either they are unequal, or you run out
		//of characters in one String or the other or both. o_O
		
	}
	
	public double getAverage() {
		return average;
	}
	
	//part c
	public boolean equals(Student other) {
		return this.id == other.id;  //or this.getID() == ...ints! == not .equals
	}
	
	
}

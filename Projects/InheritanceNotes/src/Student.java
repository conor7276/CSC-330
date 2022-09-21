// The keywords for inheritence is extends
//
// With inheritance, a child class inherits (gets)
// ALL public and protected data and behavior no rewritting shit
// YOU DO NOT GET THE PRIVATE STUFF

public class Student extends Person{
    
    private double gpa;
    private String level;
    private int emplID;

    public Student(){
        // In Java, in a default constructor, you get a
        // free call to a parent's default constructor
        this.gpa = 0.0;
        this.level = "unknown";
        this.emplID = -1;
    }

    public Student(String firstName, String lastName, double gpa, String level, int emplID){
        // you are allowed to modify the parent fields only once *very fucking important*
        // it must be the first line of code in your constructor
        // keyword for anything related to a parent class in Java is super
        // super() explicitally calling the mf default constructor
        super(firstName, lastName);
        this.gpa = gpa;
        this.level = level;
        this.emplID = emplID;
    }

    public int getEmplID() {
        return emplID;
    }

    public double getGpa() {
        return gpa;
    }

    public String getLevel() {
        return level;
    }

    public String toString(){
        // MIDTERM BITCH
        // METHOD OVERLOADING MEGA IMPORTANT
        String s = "";
        s += super.toString(); // gets the parent toString
        s += "GPA: " + gpa + "\n";
        s += "Level: " + level + "\n";
        s += "EmplID: " + emplID + "\n";
        return s;
    }
}

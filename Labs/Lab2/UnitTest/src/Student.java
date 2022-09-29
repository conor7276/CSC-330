public class Student {
    private String lastName;
    private String firstName;
    private double average;
    /**
     * Default constructor
     */
    public Student(){
        this.firstName = "";
        this.lastName = "";
        this.average = 0.0;
    }
    
    /**
     * Other constructor that should be used
     * @param firstName first name of student
     * @param lastName last name of student
     * average : double is always 0.0
     */
    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = 0.0;
    }

    
    /**
     * returns students average
     * @return average : double
     */
    public double getAverage() {
        return average;
    }
    /**
     * sets the students average to the parameter
     * @param average value that the students average will be set to
     */
    public void setAverage(double average) {
        this.average = average;
    }

    /**
     * returns the students first name
     * @return firstName : String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * returns the students last name
     * @return lastName : String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * returns the students fields to be printed
     * @return s : String
     */
    public String toString(){
        String s = "";
        s += firstName + " ";
        s += lastName + " ";
        s += average + " ";
        return s;
    }

}

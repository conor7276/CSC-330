public class Student {
    private String lastName;
    private String firstName;
    private double average;

    public Student(){
        this.firstName = "";
        this.lastName = "";
        this.average = 0.0;
    }
    
    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = 0.0;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



}

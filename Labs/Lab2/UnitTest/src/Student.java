public class Student {
    private String lastName;
    private String firstName;
    private double average;

    public Student(){
        this.firstName = "";
        this.lastName = "";
        this.average = 0.0;
    }
    
    public Student(String firstName, String lastName, double average){
        this.firstName = firstName;
        this.lastName = lastName;
        this.average = average;
    }

    
}

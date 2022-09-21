// Inheritance is a means by which we can create
// relationships between related classs. In this
// way, data and behavior can be inherited.



public class Person {
    private String firstName;
    private String lastName;
    protected int silly; // can directly access protected items in child classes
    public Person(){
        firstName = "Sam";
        lastName = "Doe";
        silly = 6;
    }

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(){
        // MIDTERM

        String s = "";
        s += "First Name: " + firstName + "\n";
        s += "Last Name: " + lastName + "\n";     
        return s;   
    }
}

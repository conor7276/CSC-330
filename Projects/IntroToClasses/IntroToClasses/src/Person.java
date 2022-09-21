/**
 * A class is a collection of data and behavior
 * Data are nouns.
 * Behavior are verbs (methods/functions)
 * 
 * Classes are written in a conventional format:
 * 
 * 
 */


public class Person{
    // 1().
    //First things to list are data
    //It is considered global data to this class.

    /* Data encapsulation (data hiding)
     * We can control visibility access to variables within a class
     * 
     * 
     * You don't want all data in a class to be public.
     * 
     * There are three levels of visibility
     * 
     * public- all files/classes can see and alter this information (can be dangerous)
     * 
     * protected- this class and children(subclasses) of this class can see and alter the information
     * 
     * private- only this class has access to this information
     * 
     * 
     */

    private String name; // name of this person
    private int age;    // age of this person
    private int height; // height of person in inches
    private int weight; // weight of this person



    // There can be public static items.
    // keyword static means there is only one of these items for all instantiations of the class.
    // an instantiation is an actual instance of this class also known as objects
    public static int num = 0;

    //2) Constructors 
    // CONSTRUCToRS ARE ALL PUBLIC no static
    // public classname
    // Default Constructor - no parameters
    // gives default meaningful values
    // int = 0
    // double = 0.0
    // char = ''
    // All Objects (Strings) are NULL (Very Bad) 
    public Person(){
        name = "John Doe";
        age = 18;
        height = 72;
        weight = 130;
    }

    // non default constructor

    public Person(String name, int age, int height, int weight){
        //left hand side of = must be global variable name
        //right hand side must be local variable name
        // the this keyword is the way an object refers to itself pointer to the object
        // name = name == bad it makes the variable equal to itself
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // another non default constructor
    public Person(String n, int h){
        name = n; // this is fine because there is no confusion between local and global variables
        height = h;
        age = 10; // must give missing variables a default otherwise it will default to 0
        //num++;
    }


    // 3) All methods/functions

    // Special Ones!
    // accessor methods - access information that is not public
    // create getter and setter for variables 
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getHeight(){
        return height;
    }

    public int getWeight(){
        return weight;
    }

    // mutator methods - change information

    public void setName(String n){
        name = n;
    }

    public void setAge(int a){
        age = a;
    }

    public void setHeight(int h){
        height = h;
    }

    public void setWeight(int w){
        weight = w;
    }

    public void getOlder(){
        age++;
    }




}
       


import java.awt.Color;
// To use abstract classes, you extend them


// I need to define all abstract methods from my parent abstract class
// OR... I need to define this class as abstract also. BAD

public class Rectangle extends Shape {
    
    private double length, width;

    public Rectangle(){
        // Invisible call to super only in default constructor of subclass
        // if there is a default constructor in superclass.
        length = 0;
        width = 0;
    }

    public Rectangle(Color c, int s, double l, double w){
        super(c,s);
        length = l;
        width = w;
    }

    public double getPerimeter(){
        return (2* width + 2 * length);
    }

    // method overriding to define parent abstract method
    public double getArea(){
        return length * width;
    }

    public double getVolume(){
        System.out.println("I am not a 2D Shape. I cannot get a volume");
        return -1;
    }

    public void attack(Shape other){
        // Lets check to see what other really is
        if(other instanceof Dodecahedron){
            System.out.println("Ha I am strong against dodecahedrons!");
            System.out.println("Rectangle cleaves the dodecahedron with one of its sharp edges!!!!!!!!!!!!");

        }
        else{
            System.out.println(other.getClass() + " is unphased.");
        }

    }

    public int compareTo(Shape other){

        // one way of doing it
        if(this.getStrength() > other.getStrength()){
            return 1; // a positive return implies "this" is greater than other
        }
        else if (this.getStrength() < other.getStrength()){
            return -1; // a negative return implies "this" is less than other
        }
        else{
            return 0; // a zero implies equality
        }

        // another way is to return the difference of the values
        /*
         * return this.getStrength() - other.getStrength();
         */
    }


}

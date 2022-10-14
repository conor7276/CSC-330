import java.awt.Color;

// Classes than "use an interface" need the keyword implement


// Implementing an interface represents a contract between this object
// and an interface.

// The deal is this class MUST define all methods listed in
// the interface. OR ELSE(else .... will be defined later)

public class Car extends Vehicle implements IMobileObject{
    
    public int numWheels;
    public Car(){
        numWheels = 4;

    }   
    // must pass in all the data
    public Car(String m, double ms, Color c, int nw){
        super(m,ms,c);
        numWheels = nw;
    }

    public void go(){
        System.out.println("Car goes VROOOOM!");
    }

    public void stop(){
        System.out.println("EEEEEEEEEEEHHHHHHHHHHHHRRRRRRRRRRR");
    }
    

}

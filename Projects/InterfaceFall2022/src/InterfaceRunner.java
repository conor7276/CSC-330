import java.awt.Color;
public class InterfaceRunner {
    public static void main(String[] args){
        /************
         * YOU CANNOT EVER CREATE AN INSTANCE
         * OF AN INTERFACE OBJECT
         * AN INTERFACE IS NOT A CLASS.
         */ 

        // IMobileObject mystery = new IMobileObject(); Bad very bad
        Vehicle v = new Vehicle();
        Car car = new Car("Porsche", 220, Color.WHITE, 4);
        Boat boat = new Boat("SeaDoo", 80, Color.PINK, 2);
        Plane plane = new Plane("Boeing",1000, Color.blue, 3);
        SeaPlane seaplane = new SeaPlane("Airbus",500, Color.MAGENTA);

        // But where is the polymorphism??????
        // The following is ok.
        // I am permitted to have a reference to an object
        // that implements IMobileObject
        IMobileObject mystery = new SeaPlane("Boeing", 100, Color.white);

        // But you need to be careful:
        // Can I do this?
        // Can an IMobileobject move()??
        mystery.go(); // yes
        mystery.stop(); // yes
        //mystery.getMaxSpeed(); // you can't do this without the casting do not use casting
        // IMobile Object does not have a getMaxSpeed() method.

        // You really should be using polymorphism with interfaces only
        // for the methods that hey need defined.

        IMobileObject[] allVehicles = new IMobileObject[5];
        allVehicles[0] = car;
        allVehicles[1] = boat;
        allVehicles[2] = plane;
        allVehicles[3] = seaplane;
        allVehicles[4] = mystery;

        for(IMobileObject imo : allVehicles){ // IMobileObject has access to the go and stop method.
            imo.go();
            imo.stop();
        }


    }
}

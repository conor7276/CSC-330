import java.util.ArrayList;

public class ShipRunner {
    public static void main(String[] args){
        ArrayList<Ship> ships = new ArrayList<Ship>();

        Ship boat = new Ship("Tug", "1904");
        Ship cruise = new CruiseShip("Floater", "2007",30);
        Ship cargo = new CargoShip("Evergreen", "2040", 1000);
        Ship mysteryShip = new Ship();

        ships.add(boat);
        ships.add(cruise);
        ships.add(cargo);
        ships.add(mysteryShip);

        int index = 1;

        for(Ship ship: ships){
            System.out.println("Boat: " + index++);
            String s = ship.toString();
            System.out.println(s);
        }
    }
}

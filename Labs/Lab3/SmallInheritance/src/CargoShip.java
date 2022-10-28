public class CargoShip extends Ship {
    private int capacity;
    
    public CargoShip(){
        capacity = 0;
    }

    public CargoShip(String n, String s, int capacity){
        super(n,s);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString(){
        String s = "";
        s += getName() + "\n";
        s += "The max capacity of the ship in tonnage is: " + getCapacity() + "\n";
        return s;
    }


}


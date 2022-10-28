public class CruiseShip extends Ship{
    private int maxPassengers;
    public CruiseShip(){
        maxPassengers = 0;
    }

    public CruiseShip(String n, String s, int maxPassengers){
        super(n,s);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String toString(){
        String s = "";
        //s += super.toString(); // overloaded method from superclass
        //s.replaceAll("The ships year made is: " + super.getName(),"");
        s += getName() + "\n";
        s += "The maximum number of passengers is: " + getMaxPassengers() + "\n";
        return s;

    }
}

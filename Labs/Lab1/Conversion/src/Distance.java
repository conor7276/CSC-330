public class Distance {
    private double meters;
    /**
     * The only constructor that should be used
     * @param meters meters given by user input
     */
    Distance(double meters){ // constructor
        this.meters = meters;
    }
    /**
     * accessor method for meters
     * @return
     */
    public double getMeters() { 
        return meters;
    }
    /**
     * mutator method for meters
     * @param meters
     */
    public void setMeters(double meters) {
        this.meters = meters;
    }
    /**
     * turns meters from user input into inches and returns the value
     * @param meters from user input
     * @return returns inches
     */
    public double getInches(double meters){ // calculates meters into inches
        // inches = meters * 39.37
        return meters * 39.37;
    }
    /**
     * turns meters from user input into feet and returns the value
     * @param meters from user input
     * @return returns feet
     */
    public double getFeet(double meters){ // calculates meters into feet
        // feet = getInches() * 12
        return getInches(meters) / 12;
    }
    /**
     * prints the object
     * @return return printable object
     */
    public String toString(){
        String s = "";
        s += "Inches: " + getInches(meters);
        s += " Feet: " + getFeet(meters);
        return s;
    }
}

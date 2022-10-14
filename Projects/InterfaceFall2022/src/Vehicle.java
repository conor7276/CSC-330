import java.awt.Color;

public class Vehicle {

    private String make;
    private double maxSpeed;
    private Color color;

    public Vehicle(){
        make = "Weirmobile";
        maxSpeed = 10;
        color = Color.PINK;
    }
    
    public Vehicle(String m, double ms, Color c){
        make = m;
        maxSpeed = ms;
        color = c;
    }

    public Color getColor() {
        return color;
    }
    public String getMake() {
        return make;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    
}

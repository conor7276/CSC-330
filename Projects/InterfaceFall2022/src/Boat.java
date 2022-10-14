import java.awt.Color;
public class Boat extends Vehicle implements IMobileObject{
    private int numSails;
    public Boat(){
        numSails = 1;
    }

    public Boat(String m, double ms, Color c, int ns){
        super(m,ms,c);
        numSails = ns;
    }

    public void go(){
        System.out.println("Boat floats");
    }

    public void stop(){
        System.out.println("Hit the dock");
    }
    public int getNumSails() {
        return numSails;
    }
    public void setNumSails(int numSails) {
        this.numSails = numSails;
    }
}

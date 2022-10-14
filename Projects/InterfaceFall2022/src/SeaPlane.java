import java.awt.Color;

public class SeaPlane extends Vehicle implements IMobileObject{
    

    public SeaPlane(){

    }

    public SeaPlane(String m, double ms, Color c){
        super(m,ms,c);

    }

    public void go(){
        System.out.println("Seaplane: I can be in the air or the water");
    }

    public void stop(){
        System.out.println("Seaplane: I either am in the air or water");
    }
}

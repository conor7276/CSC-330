import java.awt.Color;

public class Plane extends Vehicle implements IMobileObject{

    private int numEngines;

    public Plane(){
        numEngines = 2;
    }

    public Plane(String m, double ms, Color c, int ne){
        super(m,ms,c);
        numEngines = ne;
    }
    
    public void go(){
        System.out.println("Neeeeeeeeeyaaaammmmmmmm");
    }

    
    public void stop(){
        System.out.println("Oof Ehehehehehehheheheheheh *Claps*");
    }
    
    public int getNumEngines() {
        return numEngines;
    }
    public void setNumEngines(int numEngines) {
        this.numEngines = numEngines;
    }
}

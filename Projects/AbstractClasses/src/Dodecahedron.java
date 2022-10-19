import java.awt.Color;
public class Dodecahedron extends Shape {
    
    private double edgeLength;

    public Dodecahedron(){
        edgeLength = 1;
    }

    public Dodecahedron(Color c, int s, double el){
        super(c,s);
        edgeLength = el;
    }


    @Override
    public double getArea() {
        System.out.println("I am a 3D shape. I cannot calculate an area");
        return -1;
    }
    @Override
    public double getVolume() {
        
        return ((15 + 7) * (Math.sqrt(5) / 4)) * Math.pow(edgeLength,3);
    }
    @Override
    public void attack(Shape other) {
        if (other instanceof Circle){
            System.out.println("CRITICAL. The dodecahedron rolls over the Circle ");
        }
        else{
            System.out.println(other.getClass() + " laughs at you. FUcking idiot");
        }
    }
    @Override
    public Color getColor() {
       
        return super.getColor();
    }
    @Override
    public int getStrength() {
        
        return super.getStrength();
    }
    public double getEdgeLength() {
        return edgeLength;
    }
    @Override
    public void setColor(Color color) {
        
        super.setColor(color);
    }
    @Override
    public void setStrength(int strength) {
        
        super.setStrength(strength);
    }
    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    public int compareTo(Shape other){
        // imagine the beautiful 3d distance vector formula
        //return Math.sqrt(Math.pow(this.getColor.getRed() - other.getColor().getRed(),2,edgeLength));
        //return 1;

        // one way of doing it
        if(this.getStrength() > other.getStrength()){
            return 1; // a positive return implies "this" is greater than other
        }
        else if (this.getStrength() < other.getStrength()){
            return -1; // a negative return implies "this" is less than other
        }
        else{
            return 0; // a zero implies equality
        }
    }
}

import java.awt.Color;
public class Circle extends Shape{

    public double radius;

    public Circle(){
        radius =0;
    }

    public Circle(Color c, int s, double r){
        super(c,s);
        radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double getVolume() {
        System.out.println("I am a 2D shape. I cannot get a volume");
        return -1;
    }

    @Override
    public void attack(Shape other) {
        System.out.println("Circle meekly rolls over a " + other.getClass());
    }

    public int compareTo(Shape other){
        System.out.println("Fuck it we ball");
        return 0;
    }
}

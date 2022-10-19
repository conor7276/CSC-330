import java.awt.Color;
public class ShapeRunner {
    public static void main(String[] args){
        Rectangle rec = new Rectangle(Color.BLUE, 57, 6, 12);
        // YOU CANNOT DO THIS
        // SHAME ON YOU
        // YOU CANNOT CREATE AN INSTANCE OF AN ABSTRACT CLASS!!!!!!!
        // Shape shape = new Shape(Color.GREEN, 4); // NOOOOOOOOOOOO
        Shape what = new Rectangle();
        Circle circ = new Circle(Color.YELLOW, 10, 28);
        Dodecahedron dodie = new Dodecahedron(Color.RED, 100, 5);

        System.out.println(rec.getArea());
        System.out.println(rec.getVolume());
        rec.attack(circ);
        
        System.out.println(circ.getArea());
        System.out.println(circ.getVolume());
        circ.attack(rec);

        System.out.println(dodie.getArea());
        System.out.println(dodie.getVolume());
        dodie.attack(circ);

        Shape[] allShapes = new Shape[3];
        allShapes[0] = rec;
        allShapes[1] = dodie;
        allShapes[2] = circ;

        
        // How to compare shapes
        for (Shape s : allShapes){
            System.out.println(s.getArea());

        }

        // how to compare shapes, done in if statements

        // we are doing this because we can't do this if rec > circ

        if(rec.compareTo(circ) > 0){
            System.out.println("Rec has a greater strength than circ");
        }
        else{
            System.out.println("rec has a less than or equal to strenght than circ");
        }



        // Compare song titles
        /* uses the string compareTo to compare song titles
         * public int compareTo(Song other){
         *      return this.title.compareTo(other.title);
         * }
         */

        
    }
}

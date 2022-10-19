import java.awt.Color;

// An abstract class is like a blueprint for an actual class
// a "real" class is called a concrete class

// An abstract class is permitted to have data and
// defined methods.

// An abstract class should have abstract methods:
// Which are like interface methods

// All methods in an interface are abstract

// There is an interface in Java called Comparable wiht one method inside:
// public int compareTo(Object other)

// Comparable uses Java Generics  < >

public abstract class Shape implements Comparable<Shape> {
    
    private Color color;
    private int strength;
    
    public Shape(){
        color = Color.red;
        strength = 1;
    }

    public Shape(Color c, int s){
        color = c;
        strength = s;
    }

    public Color getColor() {
        return color;
    }
    public int getStrength() {
        return strength;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // abstract classes cannot be defined in the abstract class

    public abstract double getArea();
    public abstract double getVolume();
    public abstract void attack(Shape other); // polymorphism


    
}

package InheritanceAndInterfaces;

import java.util.ArrayList;
import java.util.Collections;

interface Shape extends Comparable<Shape>{
    double getVolume();

    @Override
    default int compareTo(Shape other){
        return Double.compare(this.getVolume(), other.getVolume());
    }
}

abstract class SolidOfRevolution implements Shape{
    protected double radius;

    public SolidOfRevolution(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
}

class Ball extends SolidOfRevolution{

    @Override
    public double getVolume(){
        return Math.PI * Math.pow(this.radius, 3) * 4 / 3;
    }

    public Ball(double radius){
        super(radius);
    }
}

class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double radius, double height){
        super(radius);
        this.height = height;
    }

    @Override
    public double getVolume(){
        return Math.PI * Math.pow(this.radius, 2) * this.height;
    }
}

class Pyramid implements Shape{
    private double square;
    private double height;

    public Pyramid(double square, double height){
        this.square = square;
        this.height = height;
    }
    @Override
    public double getVolume(){
        return this.square * this.height / 3;
    }
}

class Box implements Shape{
    private ArrayList<Shape> shapes = new ArrayList<>();
    private double available;
    private double volume;

    public Box(double available){
        this.available = available;
    }
    @Override
    public double getVolume(){
        return volume;
    }

    public boolean add(Shape shape){
        if(shape.getVolume() <= this.available){
            shapes.add(shape);
            this.available -= shape.getVolume();
            return true;
        }else return false;
    }

    public ArrayList<Shape> getShapes(){
        return this.shapes;
    }
}

public class InheritanceAndInterfaces {

    public static void main(String[] args) {
        Ball ball = new Ball(4.5);
        Cylinder cylyinder = new Cylinder(2, 2);
        Pyramid pyramid = new Pyramid(100, 100);

        Box box = new Box(1000);

        System.out.println(box.add(ball)); // ok
        System.out.println(box.add(cylyinder)); // ok
        System.out.println(box.add(pyramid)); // failed

        // Sorting:
        ArrayList<Shape> shapes = box.getShapes();
        Collections.sort(shapes); // sorted by Volume!
    }


}

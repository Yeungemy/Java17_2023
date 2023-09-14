package OOP.physicShape.shape;

public class Sphere extends Shape {
    /** Create a constructor inside Sphere that invokes the parent constructor */
    public Sphere(double radius){
        super(radius);
    }

    public String toString(){
        return "Sphere - radius: " + super.getRadius();
    }
}
package OOP.physicShape.shape;

import java.text.DecimalFormat;

public class Sphere extends Shape {
    DecimalFormat df = new DecimalFormat("#.##");

    /** Create a constructor inside Sphere that invokes the parent constructor */
    public Sphere(double radius){
        super(radius);
    }

    public String toString(){
        return "\nSphere - radius: " + super.getRadius();
    }

    @Override
    public double getArea(){
        return Double.parseDouble(df.format(4 * Math.PI * Math.pow(super.getRadius(), 2)));
    }

    @Override
    public double getVolume(){
        return Double.parseDouble(df.format(4/3 * Math.PI * Math.pow(super.getRadius(), 3)));
    }
}
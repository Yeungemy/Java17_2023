package OOP.physicShape;
import OOP.physicShape.shape.Cylinder;
import OOP.physicShape.shape.Sphere;

public class Main {
    public static void main(String[] args) {
        double cylinderRadius = 1.0;
        double cylinderHeight = 2.0;
        double sphereRadius = 1.0;

        Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
        Sphere sphere = new Sphere(sphereRadius);

        System.out.println(sphere);
        System.out.println("The area of sphere: " + sphere.getArea());
        System.out.println("The volume of sphere: " + sphere.getVolume());

        System.out.println(cylinder);
        System.out.println("The area of cylinder: " + cylinder.getArea());
        System.out.println("The volume of cylinder: " + cylinder.getVolume());
    }
}

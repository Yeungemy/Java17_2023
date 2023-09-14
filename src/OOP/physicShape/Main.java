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
        System.out.println(cylinder);
    }
}

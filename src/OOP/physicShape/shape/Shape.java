package OOP.physicShape.shape;

public class Shape {    
    private double radius;

    public Shape(){}

    public Shape(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        if(radius <= 0){
            throw new IllegalArgumentException("Radius should be greater than 0.");
        }

        this.radius = radius;
    }
}
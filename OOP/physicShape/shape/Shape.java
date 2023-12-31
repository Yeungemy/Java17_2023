package OOP.physicShape.shape;

public abstract class Shape {    
    private double radius;

    /** Create a constructor inside Shape that updates the radius of the current object. */
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

    public String toString(){
        return "radius: " + this.radius;
    }

    public abstract double getArea();

    public abstract double getVolume();
}
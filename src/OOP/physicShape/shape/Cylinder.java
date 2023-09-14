package OOP.physicShape.shape;

public class Cylinder extends Shape {
    private double height;

    /** Create a constructor inside Cylinder that invokes the parent constructor and updates height */
    public Cylinder(double radius, double height){
        super(radius);
        setHeight(height);
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("The height should be greater than 0.");
        }

        this.height = height;
    } 
    
    public String toString(){
        return "Cylinder - radius: " + super.getRadius() + ", and height: " + this.getHeight();
    }
}
  
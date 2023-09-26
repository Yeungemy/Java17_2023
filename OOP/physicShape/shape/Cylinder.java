package OOP.physicShape.shape;

import java.text.DecimalFormat;

public class Cylinder extends Shape {
    private double height;
    DecimalFormat df = new DecimalFormat("#.##");

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
        return "\nCylinder - radius: " + super.getRadius() + ", and height: " + this.getHeight();
    }

    @Override
    public double getArea(){        
        return Double.parseDouble(df.format(2 * Math.PI * super.getRadius() * (super.getRadius() + this.height)));
    }

    @Override
    public double getVolume(){
        return Double.parseDouble(df.format(Math.PI * Math.pow(super.getRadius(), 2) * this.height));
    }
}
  
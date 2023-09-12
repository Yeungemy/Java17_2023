package OOP.carDealership;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Car {
    private String make;
    private double price;
    private int year;
    private String color;
    private String[] parts;

    public String[] getParts() {
        return Arrays.copyOf(this.parts, this.parts.length);
    }

    public void setParts(String[] parts) {
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    public Car(String make, double price, int year, String color, String[] parts) {
        this.make = make;
        this.price = price;
        this.year = year;
        this.color = color;
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    public Car(Car source) {
        this.make = source.make;
        this.price = source.price;
        this.year = source.year;
        this.color = source.color;
        this.parts = Arrays.copyOf(source.parts, source.parts.length);
    }

    public String toString(){
        String carParts = "";
        for (int i = 0; i < this.getParts().length; i++) {
            carParts += this.getParts()[i];
            if (i < this.getParts().length - 1)
                carParts += ", ";
        }

        return "\tMake: " + this.make + "\n\tPrice: $"
                + new DecimalFormat("#.##").format(this.price) + "\n\tYear: "
                + year + "\n\tColor: " + this.color + "\n\tParts: " + carParts.trim();
    }

    public String getMake() {
        return this.make;
    }

    public double getPrice() {
        return (this.price);
    }

    public int getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public void setMake(String make) {
        if(make == null || make.isBlank()){
            throw new IllegalArgumentException("Make cannot be null or blank!");
        }

        this.make = make;
    }

    public void setPrice(double price) {
        if( price < 0){
            throw new IllegalArgumentException("Price cannot be less than 0");
        }

        this.price = price;
    }

    public void setYear(int year) {
        if( year < 0){
            throw new IllegalArgumentException("Year cannot be less than 0");
        }

        this.year = year;
    }

    public void setColor(String color) {
        if(color == null || color.isBlank()){
            throw new IllegalArgumentException("Color cannot be null or blank!");
        }

        this.color = color;
    }

    public void drive() {
        System.out.println("You bough a beautiful " + this.year + " " + this.color + " " + this.make + " for $"
                + new DecimalFormat("##.##").format(this.price) + ". \nPlease drive it to the nearest exit!");
    }
}

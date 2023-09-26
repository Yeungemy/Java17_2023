package OOP.carDealership;

import java.text.DecimalFormat;
import java.util.Arrays;

import OOP.carDealership.constants.BodyType;
import static OOP.carDealership.constants.Price.*;
import OOP.carDealership.constants.TrafficLights;

public class Car {
    private String make;
    private double price;
    private int year;
    private String modal;
    private String color;

    public String getModal() {
        return this.modal;
    }

    public void setModal(String modal) {
        if(modal == null || modal.isBlank()){
            throw new IllegalArgumentException("Model cannot be null or blank.");
        }

        this.modal = modal;
    }
    private String[] parts;
    private BodyType bodyType;

    public BodyType getBodyType() {
        return this.bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        if(bodyType == null){
            throw new IllegalArgumentException("Body type should not be blank or null!");
        }
        
        this.bodyType = bodyType;
    }

    public String[] getParts() {
        return Arrays.copyOf(this.parts, this.parts.length);
    }

    public void setParts(String[] parts) {
        this.parts = Arrays.copyOf(parts, parts.length);
    }

    public Car(String make, String model, BodyType bodyType, int year, double price, String color, String[] parts) {
        setMake(make);
        setBodyType(bodyType);
        setModal(model);
        setYear(year);
        setPrice(price);
        setColor(color);
        setParts(parts);
    }

    public Car(Car source) {
        this.make = source.make;
        this.bodyType = source.bodyType;
        this.modal = source.modal;
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

        return "\tMake: " + this.make + "\n\tModel: " + this.modal + "\n\tBodyType: " + this.bodyType + "\n\tPrice: $"
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
            throw new IllegalArgumentException("Make cannot be null or blank.");
        }

        this.make = make;
    }

    public void setPrice(double price) {
        if( price < MIN_PRICE || price > MAX_PRICE){
            throw new IllegalArgumentException("Price cannot be less than 0 and greater than ");
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

    public void drive(TrafficLights trafficLight){
        if(trafficLight == null){
            throw new IllegalArgumentException("TrafficLight can only be 'RED', 'GREEN', or 'YELLOW'!");
        }

        switch(trafficLight){
            case RED: System.out.println("STOP"); break;
            case GREEN: System.out.println("DRIVE"); break;
            case YELLOW: System.out.println("SLOW DOWN"); break;
        }
    }
}

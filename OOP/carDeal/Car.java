package OOP.carDeal;

import java.text.DecimalFormat;

public class Car {
    String make;
    double price;
    int year;
    String color;

    public Car(String make, double price, int year, String color) {
        this.make = make;
        this.price = price;
        this.year = year;
        this.color = color;
    }

    public void displayCarInfo() {
        System.out.println("Below is car information: " + "\n\tMake: " + this.make + "\n\tPrice: $" + new DecimalFormat("#.##").format(this.price) + "\n\tYear: "
                + year + "\n\tColor: " + this.color);
    }
}

package OOP.dealership;

import java.util.ArrayList;
import java.util.Arrays;

public class Dealership {
    private Car[] cars;

    public Dealership(Car[] cars){
        this.cars = new Car[cars.length];

        for(int i = 0; i < cars.length; i++){
            this.cars[i] = new Car(cars[i]);
        }
    }

    public void displayCarsInfo(){

        for(int i = 0; i < this.cars.length; i++){
            System.out.println(this.cars[i]);
        }
    }
}

package OOP.carDealership;
import java.util.Scanner;

import shared.NumberUtil;

import static OOP.carDealership.constants.BodyType.*;

import static OOP.carDealership.constants.TrafficLights.*;


public class Main {
    public static void main(String[] args) {
        NumberUtil numberUtil = new NumberUtil();
        Scanner scanner = new Scanner(System.in);
        int userInput = 99;
        Car[] cars = new Car[] {
            new Car("Toyota", "Camry", SEDAN, 2020, 30000, "red", new String[] {"tires", "keys"}),
            new Car("Dodge", "Camry", COUPE, 2020, 30000,  "blue", new String[] {"tires", "keys"}),
            new Car("Nissan", "Camry", SUV, 2020, 30000,  "yellow", new String[] {"tires", "filter"}),
            new Car("Honda", "Camry", HATCHBACK, 2020, 30000,  "orange", new String[] {"tires", "filter"}),
            new Car("Mercedes", "Camry", TRUCK, 2020, 30000,  "jet black", new String[] {"tires", "filter", "transmission"})
        };

        cars[3].setColor("black");
        Dealership dealership = new Dealership();
        dealership.addCars(cars);

        System.out.println("Feel free to browser our collection of cars as below: ");
        System.out.println(dealership);

        // ensure user enter a correct park spot number
        userInput = numberUtil.userInputIntegerNumber(scanner, 0, 4);

        System.out.println("\nYor are going to buy the following car at parking spot #" + userInput + ": \n" + dealership.getCar(userInput) + "\n\n");

        // sell the car chosen by user
        dealership.sellCar(userInput);
        Car soldCar = new Car(dealership.getCar(userInput));
        
        soldCar.drive(GREEN);
        
        // update inventory
        dealership.removeCar(userInput);     

        // display new inventory
        System.out.println("\nFeel free to browser our new collection of cars as below: \n" + dealership);
        
        scanner.close();
    }
}

package OOP.carDealership;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 99;
        Car[] cars = new Car[] {
            new Car("Nissan", 5000, 2020, "red", new String[] {"tires", "keys"}),
            new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
            new Car("Nissan", 5000, 2017, "yellow", new String[] {"tires", "filter"}),
            new Car("Honda", 7000, 2019, "orange", new String[] {"tires", "filter"}),
            new Car("Mercedes", 12000, 2015, "jet black", new String[] {"tires", "filter", "transmission"})
        };

        cars[3].setColor("black");
        Dealership dealership = new Dealership(cars);

        System.out.println("Feel free to browser our collection of cars as below: ");
        System.out.println(dealership);

        // ensure user enter a correct park spot number
        do{
            try {
                System.out.print("Enter parking spot number between 1 and 5: ");
                String text = scanner.nextLine(); 
                userInput = (Integer.parseInt(text) - 1);
            } catch (NumberFormatException ime) {
                System.out.println("Invalid input - numbers only please");
            }

        }while(userInput < 0 || userInput > 4);

        System.out.println("\nYor are going to buy the following car at parking spot #" + userInput + ": \n" + dealership.getCar(userInput) + "\n\n");

        // sell the car chosen by user
        dealership.sellCar(userInput);
        
        // update inventory
        dealership.removeCar(userInput);     

        // display new inventory
        System.out.println("\nFeel free to browser our new collection of cars as below: \n" + dealership);
        
        scanner.close();
    }
}

package OOP.dealership;

import java.text.DecimalFormat;

public class main {
    public static void main(String[] args) {
        Car[] cars = new Car[] {
            new Car("Nissan", 5000, 2020, "red", new String[] {"tires", "keys"}),
            new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
            new Car("Nissan", 5000, 2017, "yellow", new String[] {"tires", "filter"}),
            new Car("Honda", 7000, 2019, "orange", new String[] {"tires", "filter"}),
            new Car("Mercedes", 12000, 2015, "jet black", new String[] {"tires", "filter", "transmission"})
        };

        cars[3].setColor("black");

        Dealership dealership = new Dealership(cars);
        dealership.displayCarsInfo();

        String carParts = "";
        String[] parts = new String[] {"Keys", "Tires"};
        Car nissan = new Car("Nissan", 36890, 2022, "white", parts);

        System.out.println(nissan);

        Car toyota = new Car("toyota", 36890, 2022, "white", parts);
        Car toyota2 = new Car(toyota);

        System.out.println(toyota);
        toyota.drive();
        toyota2.drive();

        Car audi = new Car(null, 0, 0, null, parts);

        audi.setMake("Audi");
        audi.setPrice(40000.88);
        audi.setYear(2014);
        audi.setColor("white");

        System.out.println("\nBelow is the third car's information: ");
        System.out.println("\tMake: " + audi.getMake());
        System.out.println("\tPrice: " + new DecimalFormat("#.##").format(audi.getPrice()));
        System.out.println("\tYear: " + audi.getYear());
        System.out.println("\tColor: " + audi.getColor());
        
        for(int i = 0; i < audi.getParts().length; i++){
            carParts += audi.getParts()[i];
            if( i < audi.getParts().length - 1) carParts += ", ";
        }
        System.out.println("\tParts: " + carParts.trim());
        audi.drive();
    }
}

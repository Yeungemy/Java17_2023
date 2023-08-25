package OOP.dealership;

import java.text.DecimalFormat;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String carParts = "";
        String[] parts = new String[] {"Keys", "Tires"};
        Car nissan = new Car("Nissan", 36890, 2022, "white", parts);

        nissan.displayCarInfo();

        Car toyota = new Car("toyota", 36890, 2022, "white", parts);
        Car toyota2 = new Car(toyota);

        toyota.displayCarInfo();
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

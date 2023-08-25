package OOP.dealership;

public class main {
    public static void main(String[] args) {
        Car nissan = new Car("Nissan", 36890, 2022, "white");

        nissan.displayCarInfo();

        Car toyota = new Car("toyota", 36890, 2022, "white");
        Car toyota2 = new Car(toyota);

        System.out.println("\nBelow is another car's information: ");
        System.out.println("\tMake: " + toyota.getMake());
        System.out.println("\tPrice: " + toyota.getPrice());
        System.out.println("\tYear: " + toyota.getYear());
        System.out.println("\tColor: " + toyota.getColor());

        Car audi = new Car(null, 0, 0, null);

        audi.setMake("Audi");
        audi.setPrice(40000.88);
        audi.setYear(2014);
        audi.setColor("white");

        System.out.println("\nBelow is the third car's information: ");
        System.out.println("\tMake: " + audi.getMake());
        System.out.println("\tPrice: " + audi.getPrice());
        System.out.println("\tYear: " + audi.getYear());
        System.out.println("\tColor: " + audi.getColor());
    }
}

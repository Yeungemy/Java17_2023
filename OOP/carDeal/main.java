package OOP.carDeal;

public class main {
    public static void main(String[] args) {
        Car nissan = new Car("Nissan", 36890, 2022, "white");

        nissan.displayCarInfo();

        Car toyoto = new Car("Toyoto", 36890, 2022, "white");

        System.out.println("\nBelow is another car's information: ");
        System.out.println("\tMake: " + toyoto.getMake());
        System.out.println("\tPrice: " + toyoto.getPrice());
        System.out.println("\tYear: " + toyoto.getYear());
        System.out.println("\tColor: " + toyoto.getColor());

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

package OOP.carDeal;;

public class main {
    public static void main(String[] args) {
        Car nissan = new Car();
        nissan.make = "Nissan";
        nissan.price = 36890;
        nissan.year = 2022;
        nissan.color = "white";

        System.out.println(nissan.make);
    }
}

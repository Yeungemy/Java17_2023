package OOP.lambda.payment;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(55.99, 33.99, 88.99, 11.49, 55.99, 111.99, 77.99);

        List<Payment> payments = Arrays.asList(
                new Payment(LocalDate.of(2020, 1, 1), 100.00),
                new Payment(LocalDate.of(2020, 2, 15), 200.00),
                new Payment(LocalDate.of(2020, 3, 30), 300.00),
                new Payment(LocalDate.of(2020, 4, 1), 50.00),
                new Payment(LocalDate.of(2020, 5, 15), 75.00),
                new Payment(LocalDate.of(2020, 6, 30), 100.00));

        List<String> books = Arrays.asList(
                "To Kill a Mockingbird",
                "The Great Gatsby",
                "Pride and Prejudice",
                "The Catcher in the Rye",
                "The Alchemist",
                "One Hundred Years of Solitude",
                "Moby-Dick",
                "The Brothers Karamazov",
                "The Lord of the Rings",
                "The Picture of Dorian Gray");

        payments.forEach(p -> {
            System.out.println("Date: " + p.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Amount: " + p.getAmount());
            System.out.println("---");
        });

        System.out.println("\nPrices\n------");
        prices.forEach(System.out::println);
        prices.sort((a, b) -> a.compareTo(b));
        System.out.println("\nLibrary\n--------");
        prices.forEach(System.out::println);

        System.out.println("\nLibrary\n--------");
        books.forEach(System.out::println);
        books.sort((a, b) -> a.compareTo(b));
        System.out.println("\nLibrary\n--------");
        books.forEach(System.out::println);

        /** applied stream */
        prices.stream()
                .filter(price -> price > 50)
                .map(price -> Double.parseDouble(new DecimalFormat("#.##").format(price * .80)))
                .sorted((left, right) -> right.compareTo(right))
                .map(price -> "$" + price)
                .forEach(System.out::println);
    }
}

package smallExcercises;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dealership {
    public static void main(String[] args) {
        double budget = 0.0;
        int creditScore = 0;
        int value = 0;
        int price = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println(" - Welcome to the Java Dealership");
        System.out.println(" - Select option 'a' to buy a car");
        System.out.println(" - Select option 'b' to sell a car");

        System.out.println("\nPlease select an option: ");
        char option = scan.next().charAt(0);

        switch (option) {
            case 'a':
                System.out.println("What is your budget?");

                try {
                    budget = scan.nextDouble();

                    // budget greater than or equal to 10000
                    if (budget >= 10000) {
                        System.out.println("Great! A Nissan Altima is available");

                        System.out.println("\nDo you have insurance? Write 'yes' or 'no'");
                        scan.nextLine();
                        String hasInsurance = scan.nextLine();

                        System.out.println("\nDo you have a license? Write 'yes' or 'no'");
                        String haslicense = scan.nextLine();

                        System.out.println("\nWhat is your credit score?");

                        try {
                            creditScore = scan.nextInt();

                            if (hasInsurance.equals("yes") && haslicense.equals("yes") && creditScore >= 660) {
                                System.out.println("\nSold! Pleasure doing business with you");
                            } else {
                                System.out.println("\nWe're sorry. You are not eligible");
                            }
                        } catch (InputMismatchException a) {
                            System.out.println("\nSorry, I cann't understand!");
                        }
                    } else {
                        System.out.println("\nSorry, we currently don't have cars less than $" + budget + "!");
                    }
                } catch (InputMismatchException a) {
                    System.out.println("Sorry, I cann't understand!");
                }

                break;
            case 'b':
                System.out.println("\nWhat is your car valued at?");
                try {
                    value = scan.nextInt();

                    System.out.println("\nWhat is your selling price?");
                    try {
                        price = scan.nextInt();

                        // value is greater than price and price is less than 30000
                        if (value > price && price < 30000) {
                            System.out.println("\nWe will buy your car. Pleasure doing business with you!");
                        } else {
                            System.out.println("\nSorry, we're not interested.");
                        }
                    } catch (InputMismatchException a) {
                        System.out.println("\nSorry, I cann't understand!");
                    }
                } catch (InputMismatchException a) {
                    System.out.println("\nSorry, I cann't understand!");
                }

                break;
            default:
                System.out.println("\nSorry, I cann't understood!");
                break;
        }
        scan.close();
    }
}

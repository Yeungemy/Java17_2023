package smallProjects;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class GroceryStore {
    public static void main(String[] args) {
        String[] Groceries = { "coffee", "milk", "sugar", "meat", "eggs" };
        double[] prices = { 1.50, 2.00, 3.25, 4.89, 5.36 };
        int[] scores = { 5687, 2589, 3698, 7894, 1599, 4895, 6753 };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Hello, what can I help you to find today?\nCustomer: ");
        String groceryName = (scanner.nextLine()).toLowerCase();
        int aisleNo = findGroceryAisle(groceryName, Groceries);

        if(aisleNo >= 0){
            System.out.println(groceryName + " is Aisle " + aisleNo);
        }else{
            System.out.println("Out of stock!");
        }
        

        System.out.print(
                "By the way, have you participated in the last competition of our store?\nCustomer ('yes or no'): ");
        String answer = (scanner.nextLine()).toLowerCase();

        if (answer.equals("yes")) {
            System.out.print("Please tell me your score.\nCustomer: ");
            int customerScore = scanner.nextInt();

            int maxScore = IntStream.of(scores).max().getAsInt();

            if (customerScore == maxScore) {
                System.out.println(
                        "Congratuation, you are the highest score for that competition. \nPlease go to customer service center to collect your award!!!");
            } else {
                System.out.println("I will give you a box of cookie!");
            }
        }

        System.out.print("What groceries are in your shopping cart?\nCustomer: ");
        String items = scanner.nextLine();
        String[] itemList = items.trim().split(" ");

        System.out.println("Here is your receipt: ");
        for (String item : itemList) {
            int index = findGroceryAisle(item, Groceries);

            if(index >= 0){
                double price = prices[index];

            System.out.println(item + ": $" + price);
            }else{
                System.out.println("Very luck, you got an item free today!");
            }
        }

        scanner.close();
    }

    public static int findGroceryAisle(String groceryName, String[] groceries){
        int index = 0;
        try{
            index = Arrays.asList(groceries).indexOf(groceryName);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }
}

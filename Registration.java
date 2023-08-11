import java.util.Scanner;

public class Registration {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pick up your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Pick up last name");
        String lastName = scanner.nextLine();

        System.out.println("Pick up username: ");
        String username = scanner.nextLine();

        System.out.println("Pick up Age: ");
        int age = scanner.nextInt();

        System.out.println("Enter city where you live: ");
        scanner.nextLine(); //throwaway space after non-string input
        String city = scanner.nextLine();

        System.out.println("Enter your country: ");
        String country = scanner.nextLine();
        scanner.close();

        String result = "Here is the information you entered:\n\tFirst Name: " + firstName + "\n\tLast Name: " + lastName + "\n\tAge: " + age + "\n\tUsername: " + username + "\n\tCity: " + city + "\n\tcountry: " + country; 

        System.out.println(result);
    }
}

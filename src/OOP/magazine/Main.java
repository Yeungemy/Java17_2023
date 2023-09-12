package OOP.magazine;

import java.time.LocalDate;
import java.util.Scanner;

import shared.NumberUtil;
import shared.SharedUtil;

public class Main {
    static SharedUtil sharedUtil = new SharedUtil();
    static NumberUtil numberUtil = new NumberUtil();
    static int currentYear = LocalDate.now().getYear();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = promptForTitle(scanner);
        String publisher = promptForPublisher(scanner);
        int issueNumber = promptForIssueNumber(scanner);
        int publicationYear = promptForPublicationYear(scanner);

        Magazine newMagazine = new Magazine(title, publisher, issueNumber, publicationYear);

        MagazineLibrary library = new MagazineLibrary();
        library.addMagazine(newMagazine);

        System.out.println("Magazine added to the library: " + newMagazine.getTitle());
        scanner.close();
    }

    public static String promptForTitle(Scanner scanner){
        String userInput = "";

        while(true){
            System.out.print("Enter a title of the magazine: ");
            userInput = scanner.nextLine();

            if(!sharedUtil.isNullOrBlank(userInput)){
               return userInput;
            }else{
                System.out.println("Title cannot be null or blank!");
            }
        }
    }

    public static String promptForPublisher(Scanner scanner){
        String userInput = "";

        while(true){
            System.out.print("Enter a publisher of the magazine: ");
            userInput = scanner.nextLine();

            if(!sharedUtil.isNullOrBlank(userInput)){
               return userInput;
            }else{
                System.out.println("Publisher cannot be null or blank!");
            }
        }
    }

    public static int promptForIssueNumber(Scanner scanner){
        int userInput = 0;

        userInput = numberUtil.userInputIntegerNumber(scanner, 0, Integer.MAX_VALUE);

        return userInput;
    }

    public static int promptForPublicationYear(Scanner scanner){
        int userInput = 0;

        userInput = numberUtil.userInputIntegerNumber(scanner, 0, currentYear);
        return userInput;
    }
}

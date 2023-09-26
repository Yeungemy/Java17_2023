package OOP.magazine;

import java.time.LocalDate;
import java.util.Scanner;

import shared.NumberUtil;
import shared.StringUtil;

public class Main {
    static StringUtil sharedUtil = new StringUtil();
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
        return sharedUtil.promptForString(scanner);
    }

    public static String promptForPublisher(Scanner scanner){
        return sharedUtil.promptForString(scanner);
    }

    public static int promptForIssueNumber(Scanner scanner){      
        return numberUtil.userInputIntegerNumber(scanner, 0, Integer.MAX_VALUE);
    }

    public static int promptForPublicationYear(Scanner scanner){
        return numberUtil.userInputIntegerNumber(scanner, 0, currentYear);
    }
}

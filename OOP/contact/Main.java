package OOP.contact;

// import java.util.Arrays;
import java.util.Scanner;

import shared.NumberUtil;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char isContinue = 'y';
        NumberUtil sharedNumberUtil = new NumberUtil();
        int indexOfContact = 0;
        ContactManager contactManager = new ContactManager();
        final int numOfContacts = contactManager.getContacts().length;
        final String dateFormat = "yyyy-mm-dd";
        String separator = "-";

        // print all contacts
        contactManager.displayContacts();

        do {
            // select a contact
            indexOfContact = sharedNumberUtil.userInputIntegerNumber(scanner, 0, numOfContacts + 1);

            // display the contact chosen to be edited
            System.out.println("You are about to edit the following contact: ");
            System.out.println(contactManager.getContacts()[indexOfContact]);

            // edit a contact
            contactManager.editContact(scanner, indexOfContact, dateFormat, separator);

            // prompt for continuing to edit next contact
            System.out.print("\nYou have " + numOfContacts + " contacts. Enter 'y' or 'Y' to continue edit them: ");
            isContinue = scanner.next().charAt(0);
        } while (Character.toLowerCase(isContinue) == 'y');

        // print all contacts after updating
        contactManager.displayContacts();
        scanner.close();
    }
}

package OOP.contact;

// import java.util.Arrays;
import java.util.Scanner;

import shared.NumberUtil;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char isContinue = 'y';
        NumberUtil sharedNumberUtil = new NumberUtil();
        int indexOfContact = 0;
        ContactManager contactManager = new ContactManager();
        final int numOfContacts = contactManager.getContacts().length;
        final String dateFormat = "yyyy-m-dd";

        // print all contacts
        contactManager.displayContacts();

        do{
            // select a contact
            indexOfContact = sharedNumberUtil.userInputIntegerNumber(scanner, 0, numOfContacts + 1);

            // display the contact chosen to be edited
            System.out.println("You are about to edit the following contact: ");
            System.out.println(contactManager.getContacts()[indexOfContact]);

            // edit a contact
            contactManager.editContact(scanner, indexOfContact, dateFormat);

            // prompt for continuing to edit next contact
            System.out.print("\nYou have " + numOfContacts + " contacts. Enter 'y' or 'Y' to continue edit them: ");
            isContinue = scanner.next().charAt(0);
        }while(Character.toLowerCase(isContinue) == 'y');

        // print all contacts after updating
        contactManager.displayContacts();
        

        // Contact[] contacts = new Contact[] {
        //         new Contact("Alice", "123-456-7890", "1990-01-01"),
        //         new Contact("Bob", "234-567-8901", "1992-02-02"),
        //         new Contact("Charlie", "345-678-9012", "1994-03-03"),
        //         new Contact("David", "456-789-0123", "1996-04-04")
        // };

        // // Contact contact1 = new Contact("Alice", "123-456-7890", "1990-01-01", 33);
        // // Contact contact2 = new Contact("Bob", "234-567-8901", "1992-02-02", 31);
        // // Contact contact3 = new Contact("Charlie", "345-678-9012", "1994-03-03", 29);
        // // Contact contact4 = new Contact("David", "456-789-0123", "1996-04-04", 27);

        // // print all contacts
        // Arrays.stream(contacts).forEach(System.out::println);

        // // copy contacts
        // Contact copyContact1 = new Contact(contacts[0]);
        // Contact copyContact2 = new Contact(contacts[2]);

        // // update copied contacts
        // copyContact1.setName("Alice Twin");

        // // update copy contact 1 with new bod
        // copyContact1.setBirthdate("1989-01-01");
        // copyContact2.setName("Charlie Twin");

        // // print copied contact
        // System.out.println(copyContact1);
        // System.out.println(copyContact2);

        // ContactManager contactManager = new ContactManager(contacts);

        // System.out.println(contactManager);

        // // Test the geContactByIndex method
        // Contact retrievedContact = contactManager.geContactByIndex(0);
        // System.out.println(retrievedContact.getName());

        // // Test the setContact method
        // Contact newContact = new Contact("Charlie", "345-678-9012", "1994-03-03");
        // contactManager.setContactByIndex(0, newContact);

        // // Verify that the contact was updated
        // retrievedContact = contactManager.geContactByIndex(0);
        // System.out.println(retrievedContact.getName());

        // close scanner
        scanner.close();
    }
}

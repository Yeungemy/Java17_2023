package OOP.contact;
import java.util.Arrays;
import java.util.Scanner;

import shared.DateUtil;
import shared.PhoneNoUtil;

public class ContactManager {
    private Contact[] contacts;
    DateUtil sharedDateUtil = new DateUtil();
    PhoneNoUtil phoneNoUtil = new PhoneNoUtil();

    public ContactManager(Contact[] contacts){
        Contact[] temp = new Contact[contacts.length];
        temp = Arrays.copyOf(contacts, contacts.length);
        this.contacts = temp;
    }

    public ContactManager(){
        Contact[] temp = new Contact[contactData().length];
        temp = Arrays.copyOf(contactData(), contactData().length);
        this.contacts = temp;
    }

    public String toString(){
        String temp = "";
        for(Contact contact : this.contacts){
            temp += contact + "\n";
        }

        return temp;
    }

    public void displayContacts(){
        System.out.println(
                "******************************************************ALL Contacts******************************************************\n");
        System.out.println(toString());
        System.out.println(
                "***********************************************************************************************************************");
    }

    public Contact geContactByIndex(int index){
        return new Contact(this.contacts[index]);
    }

    public void setContactByIndex(int index, Contact contact){
        this.contacts[index] = new Contact(contact);
    }

    public static Contact[] contactData() {
        return new Contact[] {
                new Contact("John Doe", "555-123-4567", "1985-01-01"),
                new Contact("Jane Smith", "555-987-6543", "1990-02-14"),
                new Contact("Alice Johnson", "555-345-6789", "1975-03-30"),
                new Contact("Bob Brown", "555-567-8910", "2000-12-25"),
                new Contact("Charlie Davis", "555-111-2222", "1983-07-04"),
                new Contact("Diana White", "555-333-4444", "1997-11-18"),
                new Contact("Ethan Green", "555-555-6666", "1988-05-22"),
                new Contact("Fiona Black", "555-777-8888", "2002-10-31")
        };
    }

    public Contact[] getContacts(){
        Contact[] tempCopy = Arrays.copyOf(contactData(), contactData().length);
        return tempCopy;
    }

    public void editContact(Scanner scanner, int index, String dateformat, String separator) {
        System.out.print("\tPlease enter a new name: ");

        // pick up name
        String newName = scanner.next();
        this.contacts[index].setName(newName);

        System.out.print("\tPlease enter a new Phone Number: ");

        // pick up number
        String newPhoneNumber = phoneNoUtil.userInputPhoneNumber(scanner, null);
        this.contacts[index].setPhoneNumber(newPhoneNumber);

        System.out.print("\tPlease enter a new Birthdate - ");

        // pick up birth date
        String newBod = (sharedDateUtil.userInputDate(scanner, dateformat, separator));
        this.contacts[index].setBirthdate(newBod);
    }
}

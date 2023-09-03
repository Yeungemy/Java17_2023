package OOP.contact;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import shared.DateUtil;
import shared.SharedUtil;

public class Contact {
    private String name;
    private String phoneNumber;
    private String birthdate;
    private int age;
    DateUtil shared = new DateUtil();
    SharedUtil sharedUtil = new SharedUtil();
    

    // Create a constructor that initializes the fields of a newly created object.
    public Contact(String name, String phoneNumber, String birthdate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        setBirthdate(birthdate);
    }

    // Create a constructor that initializes a new object using an existing object's fields.
    public Contact(Contact source){
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        setBirthdate(source.birthdate);
    }

    public String toString(){
        return "Personal information of " + this.name + ":\n\tPhone number: " + this.phoneNumber + "\n\tBirthdate: " + this.birthdate + "\n\tAge: " + this.age + "\n";
    }

    public void printContact(){
        System.out.println(toString());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        toAge();
    }

    public int getAge() {
        return this.age;
    }

    private void toAge() {
        LocalDate dob = LocalDate.parse(this.birthdate, DateTimeFormatter.ofPattern("yyy-MM-dd"));
        LocalDate today = LocalDate.now();

        this.age = Period.between(dob, today).getYears();
    }
}

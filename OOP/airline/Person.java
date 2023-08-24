package OOP.airline;

import java.util.Arrays;

public class Person {
    String name;
    String nationality;
    String dataOfBirth;
    String[] passport;
    int seatNumber;

    public Person(String name, String nationality, String dataOfBirth, int seatNumber){
        this.name = name;
        this.nationality = nationality;
        this.dataOfBirth = dataOfBirth;
        this.seatNumber = seatNumber;
        this.passport = new String[] {name, nationality, dataOfBirth};
    }

    public void displayPersonInfo(){
        System.out.println("Below is personal information: " + "\n\tName: " + this.name + "\n\tNationality: " + this.nationality + "\n\tData of Birth: " + this.dataOfBirth + "\n\tPassport: " + Arrays.toString(this.passport) + "\n\tSeat #: " + this.seatNumber);
    }
}

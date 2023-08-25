package OOP.airline;

import java.util.Arrays;

public class Person {
    private String name;
    private String nationality;
    private String dataOfBirth;
    private String[] passport;
    private int seatNumber;

    public Person(String name, String nationality, String dataOfBirth, int seatNumber) {
        this.name = name;
        this.nationality = nationality;
        this.dataOfBirth = dataOfBirth;
        this.seatNumber = seatNumber;
        this.passport = new String[] { name, nationality, dataOfBirth };
    }

    public Person(Person people){
        this.name = people.name;
        this.nationality = people.nationality;
        this.dataOfBirth = people.dataOfBirth;
        this.seatNumber = people.seatNumber;
        this.passport = new String[] { people.name, people.nationality, people.dataOfBirth };
    }

    public void displayPersonInfo() {
        System.out.println("Below is personal information: " + "\n\tName: " + this.name + "\n\tNationality: "
                + this.nationality + "\n\tData of Birth: " + this.dataOfBirth + "\n\tSeat #: " + this.seatNumber + "\n\tPassport: ");
        Arrays.stream(this.passport).forEach(s -> System.out.print(s + ", "));
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDataOfBirth() {
        return this.dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String[] getPassport() {
        return this.passport;
    }

    public void setPassport(String[] passport) {
        this.passport = passport;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}

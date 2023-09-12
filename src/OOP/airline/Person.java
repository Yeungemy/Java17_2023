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
        this.passport = new String[3];
    }

    public Person(Person people) {
        this.name = people.name;
        this.nationality = people.nationality;
        this.dataOfBirth = people.dataOfBirth;
        this.seatNumber = people.seatNumber;
        this.passport = Arrays.copyOf(people.passport, people.passport.length);
    }

    public String toString() {
        return "\npersonal information of " + this.name + ":\n\tNationality: "
                + this.nationality + "\n\tData of Birth: " + this.dataOfBirth + "\n\tSeat #: " + this.seatNumber
                + "\n\tPassport: " + Arrays.toString(this.passport);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty!");
        }else{
            this.name = name;
        }
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        if(nationality == null || nationality.isBlank()){
            throw new IllegalArgumentException("Nationality cannot be null or empty!");
        }else{
            this.nationality = nationality;
        }
    }

    public String getDataOfBirth() {
        return this.dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        if(dataOfBirth == null || dataOfBirth.isBlank()){
            throw new IllegalArgumentException("Date of birth cannot be null or empty!");
        }
        this.dataOfBirth = dataOfBirth;
    }

    public String[] getPassport() {
        return Arrays.copyOf(this.passport, this.passport.length);
    }

    public void setPassport() {
        this.passport =  new String[] { this.name, this.nationality, this.dataOfBirth };
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public boolean applyPassport() {
        return (int) ((Math.random()) * 2) == 1;
    }

    public void chooseSeat() {
        this.seatNumber = (int) (Math.random() * 11 + 1);
    }

    public void displayPassportApplyResult(boolean isSuccessfullyApplied) {
        if (isSuccessfullyApplied)
            System.out.println("Congratulations " + this.name + ". Your passport was﻿ approved!");
        else
            System.out.println("We are sorry " + this.name + ". We cannot process your application!");
    }
}

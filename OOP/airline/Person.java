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
        this.passport = new String[] { this.name, this.nationality, this.dataOfBirth };
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
                + this.nationality + "\n\tData of Birth: " + this.dataOfBirth + "\n\tSeat #: " + this.seatNumber);
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
        return Arrays.copyOf(this.passport, this.passport.length);
    }

    public void setPassport() {
        this.passport = new String[] { this.name, this.nationality, this.dataOfBirth };
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean applyPassport(){
        return (int)((Math.random()) * 2) == 1;
    }

    public void chooseSeat(){
        this.seatNumber = (int)(Math.random() * 11 + 1);
    }

    public void displayPassportApplyResult(boolean isSuccessfullyApplied){
        if(isSuccessfullyApplied) System.out.println("Congratulations " + this.name +". Your passport was﻿ approved!"); 
        else System.out.println("We are sorry " + this.name +". We cannot process your application!");
    }
}

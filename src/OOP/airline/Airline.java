package OOP.airline;

import java.util.Arrays;

public class Airline {
    private Person[] persons;

    // a constructor without any parameters
    public Airline() {
        this.persons = new Person[11];
    }

    public Airline(Person[] persons) {
        this.persons = new Person[persons.length];
        for (int i = 0; i < persons.length; i++) {
            setPersonByIndex(persons[i]);
        }
    }

    public void createReservation(Person person) {
        if (person.applyPassport()) {
            // set passport
            person.setPassport();

            while (this.persons[person.getSeatNumber() - 1] != null) {
                // kind remind the seat is not vacant
                System.out.println(person.getName() + ", seat: " + person.getSeatNumber()
                        + " is already taken. Please choose another seat.\n");

                // choose a new seat
                person.chooseSeat();
            }

            // populate the reservation
            this.persons[person.getSeatNumber() - 1] = new Person(person);

            // issue a message of successful reservation
            System.out.println("Thank you " + person.getName() + " for flying with Java airlines. Your seat number is "
                    + (person.getSeatNumber()) + ".\n");
        } else {
            // remind the passport is not valid
            System.out.println("Sorry " + person.getName() + ". Your passport: "
                    + Arrays.toString(person.getPassport()) + " is not valid.\n");
        }
    }

    public Person getPersonByIndex(int index) {
        return new Person(this.persons[index]);
    }

    public void setPersonByIndex(Person person) {
        int index = person.getSeatNumber() - 1;
        this.persons[index] = new Person(person);
    }
}

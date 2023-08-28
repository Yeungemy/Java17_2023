package OOP.airline;

public class Airline {
    Person[] persons;

    // a constructor without any parameters
    public Airline(){
        this.persons = new Person[11];
    }

    public Airline(Person[] persons){
        this.persons = new Person[persons.length];
        for(int i = 0; i < persons.length; i++){
            setPersonByIndex(persons[i]);
        }
    }

    public Person getPersonByIndex(int index){
        return new Person(this.persons[index]);
    }

    public void setPersonByIndex(Person person){
        int index = person.getSeatNumber() - 1;
        this.persons[index] = new Person(person);
    }
}

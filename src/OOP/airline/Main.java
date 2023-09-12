package OOP.airline;
public class Main {
    
    public static void main(String[] args) {
        Person[] people = new Person[] { 
            new Person("Cleopatra", "Egypt", "69 BC", 1),
            new Person("Alexander the Great", "Macedon", "356 BC", 2),
            new Person("Julius Caesar", "Rome", "100 BC", 3),
            new Person("Hannibal", "Carthage", "247 BC", 4),
            new Person("Confucius", "China", "551 BC", 5),
            new Person("Pericles", "Greece", "429 BC", 6),
            new Person("Spartacus", "Thrace", "111 BC", 7),
            new Person("Marcus Aurelius", "Rome", "121 AD", 8),
            new Person("Leonidas", "Greece", "540 BC", 9),
            new Person("Sun Tzu", "China", "544 BC", 10),
            new Person("Hammurabi", "Babylon", "1750 BC", 10),
        };

        Airline airline = new Airline(); 
        
        // populate the airline
        for(int i = 0; i < people.length; i++){
            /**
             * populate by set method
             * airline.setPersonByIndex(people[i]);
             * System.out.println(airline.getPersonByIndex(i));
             */
            
             // populate by createReservation method
            airline.createReservation(people[i]);
        }

        /**
         * populate by a constructer with a parameter of soure data
         * Airline airline = new Airline(people);
         * System.out.println(airline.getPersonByIndex(1));
         * System.out.println(airline.getPersonByIndex(5));
         * System.out.println(airline.getPersonByIndex(10));
         */
    } 
}

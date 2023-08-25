package OOP.airline;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Person ryan = new Person( "Ryan Slim", "Canadian", "01/01/1978", 5);
        System.out.println(ryan);;
        ryan.displayPassportApplyResult(ryan.applyPassport());

        Person jimmy = new Person(null, null, null, 0);

        jimmy.setName("Jimmy Green");
        jimmy.setDataOfBirth("01/02/1234");
        jimmy.setNationality("Chinese");
        jimmy.setPassport();

        System.out.println("\n");
        System.out.println(jimmy);
        jimmy.displayPassportApplyResult(jimmy.applyPassport());

        System.out.println("\nBelow is a personal information of " + jimmy.getName() + ":");
        System.out.println("\tNationality: " + jimmy.getNationality());
        System.out.println("\tData of Birth: " + jimmy.getDataOfBirth());
        
        System.out.println("\tPassport: " + Arrays.toString(jimmy.getPassport()));
        // Arrays.stream(jimmy.getPassport()).forEach(item -> System.out.print("\t" + item + " "));
        jimmy.displayPassportApplyResult(jimmy.applyPassport());

        Person twin = new Person(jimmy);
        twin.setName("Twin Green");
        twin.setSeatNumber(3);
        twin.setPassport();

        System.out.println("\n");
        System.out.println(twin);
        twin.displayPassportApplyResult(twin.applyPassport());
    }
}

package smallExcercises;

import java.util.Arrays;

public class IntroToArrays {
    public static void main(String[] args) {
        String[] kindoms = {"Mercia", "Wessex", "Northumbria", "East Anglia"};
        String[] students = {"Malfoy", "Crabbe", "Goyle", "Pansy", "Deam", "Jimmy"};
        
        // find student seat
        Arrays.sort(students);

        // print student seats
        System.out.println("Arrange student seats by index: ");
        for(int i = 0; i < students.length; i++){
            System.out.println(students[i] + ", you will take seat " + i);
        }

       boolean hasStudent = Arrays.stream(students).anyMatch("Jimmy"::equals);
       int seatNo = Arrays.asList(students).indexOf("Jimmy");

        // print student seats
        System.out.print("\nJimmy has a seat: " + hasStudent);
        System.out.println(", and his seat No is " + seatNo);
        

        // print an array with lambda
        System.out.println("\nAs below print an array with lambda");
        Arrays.stream(kindoms).forEach(System.out::println);

        // print an array with a loop
        System.out.println("\nAs below print by a loop");
        for(String kindom : kindoms){
            System.out.println(kindom);
        }

        //print an array with index
        System.out.println("\nAs below print an array with index");
        System.out.println(kindoms[0]);
        System.out.println(kindoms[1]);
        System.out.println(kindoms[2]);
        System.out.println(kindoms[3]);
    }
}
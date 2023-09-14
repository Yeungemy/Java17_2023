package OOP.lambda.studentGrades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("src/assets/emails.txt");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        List<String> usernames = Arrays.asList("sparklingunicorn", "galactic_goddess", "neon_ninja", "purplepixiedust");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Student> students = Arrays.asList(
                new Student("Alice", 85.6),
                new Student("Bob", 73.2),
                new Student("Charlie", 64.1),
                new Student("Dave", 92.7),
                new Student("Eve", 77.4),
                new Student("Frank", 59.3),
                new Student("Gina", 91.4),
                new Student("Hannah", 76.8),
                new Student("Igor", 68.9),
                new Student("Jasmine", 82.5));

        students.stream()
                .filter(student -> student.getScore() > 80)
                .forEach(student -> System.out.println(
                        "Congratulations " + student.getName() + " for achieving a score of " + student.getScore()));

        System.out.println("\n**************************************");
        names.stream()
                .map(name -> ("Hello, " + name + "!"))
                .forEach(System.out::println);

        System.out.println("\n**************************************");

        String username = usernames.stream()
        .filter(name -> name.equals("neon_ninja"))
        .findFirst()
        .orElse(null);

        System.out.println("Found you: " + username);

        System.out.println("\n**************************************");

        long numEven = numbers.stream()
        .filter(num -> num % 2 == 0)
        .count();

        System.out.println("There are " + numEven + " even numbers in this list");

        System.out.println("\n**************************************");

        try{
            Files.lines(path)
            .filter(l -> !(l.startsWith("Spam")))
            .sorted((a, b) -> a.compareTo(b))
            .forEach(System.out::println);
        }catch(IOException e){
            System.out.println(e);
        }

        // try{
        //     Files.lines(path)
        //     .filter(l -> ! (l.startsWith("Spam")))
        //     .map(l -> l.split("\\n"))
        //     .sorted((a, b) -> a[0].compareTo(b[0]))
        //     .forEach(a -> System.out.println(a[0]));
        // }catch(IOException e){
        //     System.out.println(e);
        // }
    }
}

package smallProjects;

import java.util.Scanner;

public class TrivalQuiz {
    public static void main(String[] args) {
        final char[] correctAnswers = { 'c', 'a', 'd', 'a', 'b' };
        String answers = "";
        int grade = 4;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which country held the 2016 Summer Olympics?");
        System.out.println("\ta) China\n\tb) Ireland\n\tc) Brazil\n\td) Italy");
        System.out.print("\nAnswer: ");
        answers += (scanner.nextLine().charAt(0));

        System.out.println("\nWhich planet is the hottest?");
        System.out.println("\ta) Venus\n\tb) Saturn\n\tc) Mercury\n\td) Mars");
        System.out.print("\nAnswer: ");
        answers += scanner.nextLine().charAt(0);

        System.out.println("\nWhat is the rarest blood type?");
        System.out.println("\ta) O\n\tb) A\n\tc) B\n\td) AB-Negative");
        System.out.print("\nAnswer: ");
        answers += scanner.nextLine().charAt(0);

        System.out.println("\nWhich one of these characters is friends with Harry Potter?");
        System.out.println("\ta) Ron Weasley\n\tb) Hermione Granger\n\tc) Draco Malfoy");
        System.out.print("\nAnswer: ");
        answers += scanner.nextLine().charAt(0);

        scanner.close();

        System.out.println("\n\n\nGRADE REPORT: ");
        System.out.println("**********************************************************");

        for (int i = 0; i < answers.length(); i++) {
            char answer = answers.charAt(i);

            if (i < answers.length() - 1) {
                if (answer != correctAnswers[i]) {
                    grade--;
                    System.out.println("Your answer is '" + answer + "', but the correct answer is '" + correctAnswers[i] + "'");
                }
            } else {
                if (answer != correctAnswers[i] && answer != correctAnswers[i + 1]) {
                    grade--;
                    System.out.println("Your answer is '" + answer + "', but the correct answer is '" + correctAnswers[i] + "' or '" + correctAnswers[i + 1] + "'");
                }
            }
        }

        System.out.println("\nHere is your score: " + grade * 25 + " out of 100.");

        if (grade >= 3) {
            System.out.println("Wow, you know your stuff!");
        } else if (grade > 1) {
            System.out.println("Not bad!");
        } else {
            System.out.println("better luck next time.");
        }

        System.out.println("**********************************************************\n\n\n");
    }
}

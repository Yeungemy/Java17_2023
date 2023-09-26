package smallProjects;
import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        final int myAge = 400;
        String username = "";
        String city = "";
        int age = 0;
        String languag = "";
        int experience = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Java Chatbot: Hello! What is your name?");
        username = scanner.nextLine();

        System.out.println("\nHi " + username + "! I'm Javabot. \nWhat city are you living now?");
        city = scanner.nextLine();

        System.out.println("\nJava Chatbot: I hear it's beautiful at " + city + ". I'm from a place called Oracle.\nHow old are you?");
        age = scanner.nextInt();

        System.out.println("\nJava Chatbot: So your are " + age + ", cool! I'm " + myAge + " years old.\nThis means I am about " + myAge/age + " times older than you. \nEnough about me. \nWhat's your favoriate programming language? (just don't say Python)");
        scanner.nextLine();
        languag = scanner.nextLine();

        System.out.println("\nJava Chatbot: " + languag + ", fair enough! \nHow many years have you been coding in " + languag + "?");
        experience = scanner.nextInt();

        System.out.println("\nJava Chatbot: " + experience + " years eh? That's great, keep it up!\nNice chatting with you " + username + ". I have to log off now. \nSee ya!");

        scanner.close();
    }
}

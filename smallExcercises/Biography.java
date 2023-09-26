package smallExcercises;
public class Biography {
    public static void main(String[] args) {
        String name = "Same";
        int hours = 2;
        int age = 35;
        String game = "Checkers";
        String country = "England";
        String subject = "Chemistry";
        String sport = "Basketball";
        char grade = 'B';

        String introduction = "My name is " + name + ". I'm " + age + " years old, and I'm from " + country + ".\n";
        String favourite = "My favouriate sport is " + sport + ". I play for " + hours + " hour(s) a day" + ".\n";
        String retirePlan = "When I'm tired, I like to play " + game + ".\n";
        String favouriteSubject = "In school, my favourite subject was " + subject + ", I scored a " + grade + ".\n";

        System.out.println(introduction + favourite + retirePlan + favouriteSubject);   
    }
}

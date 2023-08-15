package smallExcercises;
import java.util.Scanner;

public class HitStay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option = "";

        System.out.println("Would you like to stay or hit?");
        option = scanner.nextLine();

        if(!option.equals("hit") && !option.equals("stay")){
            System.out.println("Invalid entries");
        }else{
            System.out.println("End turn");
        }

        scanner.close();
    }
}

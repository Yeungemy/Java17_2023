package smallProjects;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play 'Rock, Paper, Scissor'?");
        System.out.print("Answer ('Y' or 'y' for 'Yes', 'n' or 'N' for 'NO'): ");
        char choice = (scanner.nextLine()).toLowerCase().charAt(0);
        int userShoot = 0;
        int javabotShoot = (int)(Math.random() * 3) + 1;

        if(choice == 'y'){
            displayMenu();
            System.out.print("\nYour Shoot: ");
            userShoot = scanner.nextInt();

            if(! isLessThanOne(userShoot) && !isGreaterThanThree(userShoot)){
                printReport(userShoot, javabotShoot);
            }else{
                System.out.println("Sorry, your shoot number is outside the valid range!");
            }
            
        }else{
            System.out.println("\n\nSee you next time!\n");
        }

        scanner.close();
    }

    public static boolean isLessThanOne(int userShoot){
        return userShoot < 1;
    }

    public static boolean isGreaterThanThree(int userShoot){
        return userShoot > 3;
    }   


    public static void displayMenu(){
        System.out.print("\nHere is the menu of the game: \n");
        System.out.println("\tShoot number 1 for Rock;");
        System.out.println("\tShoot number 2 for Paper;");
        System.out.println("\tShoot number 3 for Scissors.");
    }

    public static void displayUserShoot(int userShoot){
        System.out.println("You shoot number is " + userShoot + ".");
    }

    public static void displayJavabotShoot(int javabotShoot){
        System.out.println("Javabot shoot number is " + javabotShoot + ".");
    }

    public static boolean isUserWon(int userShoot, int javabotShoot){
        boolean isWon = false;

        if(userShoot == 1 && javabotShoot == 3){
            isWon = true;
        }else if(userShoot == 3 && javabotShoot == 1){
            isWon = false;
        }else if(userShoot > javabotShoot){
            isWon = true;
        }

        return isWon;
    }

    public static void printReport(int userShoot, int javabotShoot){
        System.out.println("\n\n\nHere is the game Report: ");
        System.out.println("******************************************************************");
        displayUserShoot(userShoot);
        displayJavabotShoot(javabotShoot);

        if(isUserWon(userShoot, javabotShoot)){
            System.out.println("\nCongratulation, you won the game!");
        }else{
            System.out.println("\nBetter luck next time!");
        }
        System.out.println("******************************************************************");
    }
}

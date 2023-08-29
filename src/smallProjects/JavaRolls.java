package smallProjects;

import java.util.Scanner;

public class JavaRolls {
    public static void main(String[] args) {
        int min = 1;
        int max = 6;
        int points = 0;
        int minPointsToWin = 3;
        int zeroPointNumber = 4;
        int pointDeductNumber = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Let's play Rolling Java. Type anything to start: ");
        scanner.nextLine();
        displayRules();
        scanner.nextLine();
        System.out.println("\n");
        
        points = play(min, max, zeroPointNumber, pointDeductNumber);

        displayReport(points, minPointsToWin);

        scanner.close();
    }

    public static void displayRules(){
        System.out.println("\n\nGreat, here are the rules:\n");
        System.out.println("  >> - If you roll a 6, the game stops.");
        System.out.println("  >> - If you roll a 4, nothing happens.");
        System.out.println("  >> - If you roll a 0, you lose 1 point.");
        System.out.println("  >> - Otherwise, you get 1 point.");
        System.out.print("  >> - You must collect at least 3 points to win. Enter anything to roll:");
    }

    public static int rollDice(int min, int max){
        return (int)(Math.random() * max + min);
    }

    public static int play(int min, int max, int zeroPointNumber, int pointDeductNumber){
        int points = 0;

        while(true){
            int dice = rollDice(min, max);

            if(dice == max){
                System.out.println("You rolled number " + dice + ". End of the game.");
                break;
            }else if(dice == zeroPointNumber){
                System.out.println("You rolled a number " + dice + ". Zero points. Keep rolling.");
                continue;
            }else if(dice == pointDeductNumber){
                System.out.println("You rolled a number " + dice + ". One point has been deducted and keep rolling.");
                points--;
                continue;
            }

            System.out.println("You rolled a number " + dice + ". One point has been granted and keep rolling.");
            points++;
        }

        return points;
    }

    public static void displayReport(int points, int minPoints){
        System.out.println("\n\n\nHere is the Java Roll Report: ");
        System.out.println("******************************************************************");
        System.out.println("Your currently have " + points + " points.");
        if(points >= minPoints){
            System.out.println("Congratulation, you won!");
        }else{
            System.out.println("Better luck next time!");
        }
        System.out.println("******************************************************************");
    }
}

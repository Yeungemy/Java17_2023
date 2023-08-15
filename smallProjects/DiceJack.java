package smallProjects;

public class DiceJack {
    public static void main(String[] args) {
        int javaDices = 0;
        int playerDices = 0;
        int minDice = 1;
        int maxDice = 13;

        playerDices += playThreeDices(minDice, maxDice);
        javaDices += playThreeDices(minDice, maxDice);
        printReport(javaDices, playerDices);
    }

    public static int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int playThreeDices(int minDice, int maxDice){
        int points = 0;
        points += getRandomInt(minDice, maxDice);
        points += getRandomInt(minDice, maxDice);
        points += getRandomInt(minDice, maxDice);

        return points;
    }

    public static void displayPlayerPoints(int playerDices){
        System.out.println("Your points are " + playerDices + ".");
    }

    public static void displayJavabotPoints(int javaDices){
        System.out.println("The Javabot's points are " + javaDices + ".");
    }

    public static void printReport(int javaDices, int playerDices){
        System.out.println("\n\n\nHere is the Java Jack Report: ");
        System.out.println("******************************************************************");

        if (playerDices <= 21) {
            displayJavabotPoints(javaDices);
            displayPlayerPoints(playerDices);

            if(javaDices > 21){
                System.out.println("\nCongratulation, you won since Javabot was busted!");
            }
            else if (playerDices > javaDices) {
                 System.out.println("\nCongratulation, you won since Javabot has less points than yours!");
            }
            else if(playerDices == javaDices){
                System.out.println("This a tie game!");
            }
            else{
                System.out.println("\nBetter luck next time!");
            }
        } else {
            displayPlayerPoints(playerDices);
            System.out.println("Busted! Better luck next time");
        }

        System.out.println("******************************************************************\n");
    }
}

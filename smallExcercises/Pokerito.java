package smallExcercises;

import java.util.Scanner;

public class Pokerito {
    public static void main(String[] args) {
        int min = 1;
        int max = 13;
        int javabotCardNo = 0;
        int playerCardNo = 0;
        String javabotCard = "";
        String playerCard = "";
        int numberOfRiverCards = 5;
        int riverCards[] = { 0, 0, 0, 0, 0 };

        Scanner scanner = new Scanner(System.in);

        // prompt to start the game
        System.out.print("Let's play Pokerito. Type anything when you're ready: ");
        scanner.nextLine();

        // display game rules
        displayRules();
        scanner.nextLine();

        // deliver card to player
        System.out.println("Here is your card: ");
        playerCardNo = randomNumber(min, max);
        playerCard = randomCard(playerCardNo);
        displayCard(playerCard);

        // deliver card to Javabot
        System.out.println("Here is Javabot's card: ");
        javabotCardNo = randomNumber(min, max);
        javabotCard = randomCard(javabotCardNo);
        displayCard(javabotCard);

        // prompt to continue
        System.out.print("Now, the dealer will draw " + numberOfRiverCards + " cards. Press enter to continue: ");
        scanner.nextLine();

        // deliver five card to the river
        riverCards = deliverCardsToRiver(numberOfRiverCards, min, max);

        // display the match report
        displayReport(playerCardNo, javabotCardNo, riverCards);

        scanner.close();
    }

    public static void clearScreen() {
        // for(int clear = 0; clear < 100; clear++) {
        // System.out.println() ;
        // }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayRules() {
        clearScreen();
        System.out.print("\nIt's like Poker, but a lot simpler. Here are some rules as below:\n" + //
                "  >> - There are two players, you and the computer.\n" + //
                "  >> - The dealer will give each player one card.\n" + //
                "  >> - Then, the dealer will draw five cards (the river)\n" + //
                "  >> - The player with the most river matches wins!\n" + //
                "  >> - If the matches are equal, everyone's a winner!\n" + //
                "\nReady? Type anything if you are: ");
    }

    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    public static void displayCard(String card) {
        System.out.println(card);
    }

    public static int[] deliverCardsToRiver(int numberOfCard, int min, int max) {
        String riverCard = "";
        int riverCards[] = { 0, 0, 0, 0, 0 };

        System.out.println("Here are cards in the river: ");
        for (int i = 0; i < numberOfCard; i++) {
            riverCards[i] = randomNumber(min, max);
            riverCard = randomCard(riverCards[i]);

            System.out.println("Card " + (i + 1) + ": ");
            System.out.println(riverCard);
        }

        return riverCards;
    }

    public static int countMatches(int cardNo, int[] riverCards) {
        int matches = 0;

        for (int x : riverCards) {
            if (x == cardNo) {
                matches++;
            }
        }

        return matches;
    }

    public static void displayReport(int playerCardNo, int javabotCardNo, int[] riverCards) {
        int playerMatches = countMatches(playerCardNo, riverCards);
        int javabotMatches = countMatches(javabotCardNo, riverCards);

        System.out.println("\n\n\nHere is the game Report: ");
        System.out.println("******************************************************************");

        // print matched results
        System.out.println("Your number of matches: " + playerMatches + ".");
        System.out.println("Javabot's number of matches: " + javabotMatches + ".");

        if (playerMatches > javabotMatches) {
            System.out.println("\nCongratulation, you won the game!");
        } else if (playerMatches == javabotMatches) {
            System.out.println("\nIt is a tie!");
        } else {
            System.out.println("\nBetter luck next time!");
        }

        System.out.println("******************************************************************");
    }

    public static String randomCard(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";
            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";
            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";
            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";

            default:
                return "Invalid Card Number";
        }
    }
}

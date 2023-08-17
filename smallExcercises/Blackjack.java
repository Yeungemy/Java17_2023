package smallExcercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int min = 1;
        int max = 13;
        int playerCardsCounter = 2;
        int javabotCardsCounter = 2;
        ArrayList<Integer> playerCardNumbers = new ArrayList<Integer>();
        ArrayList<String> playerCards = new ArrayList<String>();
        ArrayList<Integer> javabotCardNumbers = new ArrayList<Integer>();
        ArrayList<String> javabotCards = new ArrayList<String>();

        System.out.print("What is your name: ");
        String player = scan.nextLine();

        System.out.println("\nWelcome to Java Casino, " + player + "!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see...");
        System.out.print("\n...Ready? Press anything to begin! ");

        // promp for the user to press enter.
        scan.nextLine();

        // clear screen
        clearScreen();

        // Get two random cards for the player
        playerCardNumbers.addAll(drawTwoCards(min, max));
        playerCards.addAll(cardStrings(playerCardNumbers));

        // print two cards of the player
        printCards(playerCards, true);
        int playerHandValue = handValue(playerCardNumbers);

        // Get two random cards for the dealer.
        javabotCardNumbers.addAll(drawTwoCards(min, max));
        javabotCards.addAll(cardStrings(javabotCardNumbers));

        int javabotHandValue = handValue(javabotCardNumbers);

        // Print the dealer cards
        printCards(javabotCards, false);

        // Issue an alert that the dealer's total is hidden
        System.out.println("The dealer's total is hidden!");

        // Keep asking the player to hit or stay (while loop).
        boolean playerContinueHitting = playerHandValue <= 21;
        boolean javabotContinueHitting = playerHandValue <= 21 && playerHandValue < 18;
        int newCardNo = 0;
        String newCard = "";

        while (playerContinueHitting || javabotContinueHitting) {
            if (playerContinueHitting) {
                // Print the sum of your hand value.
                printHandValue(playerHandValue);
                if (hitOrStay().toLowerCase().equals("hit")) {
                    // draw a new card.
                    newCardNo = drawRandomCard(min, max);
                    newCard = cardString(newCardNo);

                    playerCardNumbers.add(newCardNo);
                    playerCards.add(newCard);
                    playerCardsCounter++;

                    // calculate their new total.
                    playerHandValue += newCardNo;

                    // print: (new line) You get a (new line) <show new card>.
                    System.out.println("Your number " + playerCardsCounter + " card: /n" + newCard);
                    playerContinueHitting = playerHandValue <= 21;
                } else {
                    playerContinueHitting = false;
                }
            }

            // Javabot draw cards
            javabotContinueHitting = playerHandValue <= 21 && javabotHandValue < 18;
            if (javabotContinueHitting) {
                // draw a new card.
                newCardNo = drawRandomCard(min, max);
                newCard = cardString(newCardNo);

                javabotCardNumbers.add(newCardNo);
                javabotCards.add(newCard);
                javabotHandValue += newCardNo;
                javabotCardsCounter++;

                // – print: (new line) You get a (new line) <show new card>.
                System.out.println("Javabot number " + javabotCardsCounter + " card: /n" + newCard);
            }
        }

        // print report
        displayReport(playerHandValue, javabotHandValue, playerCards, javabotCards);

        scan.close();
    }

    public static void clearScreen() {
        // for(int clear = 0; clear < 100; clear++) {
        // System.out.println() ;
        // }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * a function to get a random number between 1 and 13
     * Function name – drawRandomCard
     */
    public static int drawRandomCard(int min, int max) {
        return (int) (Math.random() * max + min);
    }

    public static ArrayList<Integer> drawTwoCards(int min, int max) {
        ArrayList<Integer> cards = new ArrayList();

        cards.add(drawRandomCard(min, max));
        cards.add(drawRandomCard(min, max));

        return cards;
    }

    public static ArrayList<String> cardStrings(ArrayList<Integer> playerCardNumbers) {
        ArrayList<String> cards = new ArrayList<String>();

        cards.add(cardString(playerCardNumbers.get(0)));
        cards.add(cardString(playerCardNumbers.get(1)));

        return cards;
    }

    public static void printCards(ArrayList<String> playerCards, boolean fullyDisclosure) {
        for (int i = 0; i < playerCards.size(); i++) {
            if (i == 0) {
                if (!fullyDisclosure) {
                    System.out.println("Javabot has the first card facing down\n" + faceDown());
                } else {
                    System.out.println("\nYou get a " + playerCards.get(i));
                }
            } else {
                System.out.println("and a\n" + playerCards.get(i));
            }
        }
    }

    public static int handValue(ArrayList<Integer> playerCardNumbers) {
        int handValue = 0;
        for (int i : playerCardNumbers) {
            handValue += i;
        }

        return handValue;
    }

    public static void printHandValue(int handValue) {
        System.out.println("\nyour hand value now is: " + handValue + ".\n");
    }

    /**
     * Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * 
     * @return (String)
     */
    public static String hitOrStay() {
        String userOPtion = "";

        while (!userOPtion.equals("hit") && !userOPtion.equals("stay")) {
            System.out.print("Please write 'hit' or 'stay': ");
            userOPtion = scan.nextLine();
        }

        return userOPtion;
    }

    public static void displayReport(int playerHandValue, int javabotHandValue, ArrayList<String> playerCards,
            ArrayList<String> javabotCards) {
        System.out.println("\n\n\nHere is the game Report: ");
        System.out.println("******************************************************************");

        // print matched results
        printCards(playerCards, true);
        System.out.println("\nYour hand value: " + playerHandValue + ".\n");

        if (playerHandValue > 21) {
            System.out.println("You are busted. Better luck next time!");
        } else {
            printCards(javabotCards, true);
            System.out.println("Javabot's hand value: " + javabotHandValue + ".\n");

            if (javabotHandValue > 21 || playerHandValue > javabotHandValue) {
                if(javabotHandValue > 21) System.out.print("Javabot was busted! ");
                System.out.println("Congratulation, you won the game!");
            } else if (playerHandValue == javabotHandValue) {
                System.out.println("It is a tie!");
            } else {
                System.out.println("Better luck next time!");
            }
        }

        System.out.println("******************************************************************");
    }

    /**
     * a function that returns a String drawing of the card.
     * Function name – cardString
     * 
     * @param cardNumber (int)
     * @return (String)
     */
    public static String cardString(int cardNumber) {
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

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }
}
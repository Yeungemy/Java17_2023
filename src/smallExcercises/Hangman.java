package smallExcercises;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "_____\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "_____\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "_____\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " _____\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " _____\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " _____\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " _____\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {
        int incorrectCounter = 0;
        Scanner scanner = new Scanner(System.in);

        // prompt to start the game
        System.out.print("Let's play Hangman. Type anything when you're ready: ");
        scanner.nextLine();

        String word = getWord(words);
        String dashLines = makeDashLines(word);

        System.out.println("Great! Here is the puzzle as below: ");
        makePuzzle(dashLines);

        System.out.println("Now, start your guess!");
        do {
            // player make a guess
            System.out.print("What letter would you like to put in? ");
            char singleLetter = Character.toLowerCase(scanner.nextLine().charAt(0));
            ArrayList<Integer> indexList = findLetterIndex(singleLetter, word);

            if (indexList.size() == 0) {
                drawGallows(gallows, incorrectCounter);
                incorrectCounter++;
            } else {
                char[] dashLinesChar = dashLines.toCharArray();
                // update the puzzle
                for(int i : indexList){
                    dashLinesChar[i] = singleLetter;
                }

                dashLines = String.valueOf(dashLinesChar);

                // display a new puzzle
                printPuzzle(dashLines);
            }
        } while ((incorrectCounter < gallows.length && dashLines.contains("-")));

        System.out.println("******************************************************************");
        if (incorrectCounter < gallows.length && !(dashLines.contains("-"))) {
            System.out.println("\nCongratulation, you won that game!\n");
        } else {
            System.out.println("The word is " + word);
            System.out.println("\nBetter lunck next time!\n");
        }
        System.out.println("******************************************************************");

        scanner.close();
    }

    public static void clearScreen() {
        // for(int clear = 0; clear < 100; clear++) {
        // System.out.println() ;
        // }

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // get a word from the collections
    public static String getWord(String[] words) {
        int indexOfWord = (int) (Math.random() * words.length);

        return words[indexOfWord];
    }

    // get dash lines by word
    public static String makeDashLines(String word) {
        String dashLine = "";
        for (int i = 0; i < word.length(); i++) {
            dashLine += "-";
        }

        return dashLine;
    }

    // make puzzle by word
    public static void makePuzzle(String dashLines) {
        System.out.println("This is a word of an animal with " + dashLines.length() + " letters");
        System.out.println("\n\t\t" + dashLines);
    }

    // print gallows
    public static void drawGallows(String[] gallows, int incorrectCounter) {
        clearScreen();
        System.out.println(gallows[incorrectCounter]);
    }

    // find index
    public static ArrayList<Integer> findLetterIndex(char letter, String word) {
        ArrayList<Integer> indexList = new ArrayList<Integer>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                indexList.add(i);
            }
        }

        return indexList;
    }

    public static void printPuzzle(String dashLines) {
        clearScreen();
        System.out.println(dashLines);
    }
}

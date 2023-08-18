package smallProjects;

import java.util.Scanner;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        final char spaceHolder = '-';
        char playerTwoBoardMarker = ' ';
        final char[] boardMarkers = { 'X', 'O' };
        int min = 0;
        int max = 2;
        int turnCounter = 0;
        boolean hasWinner = false;
        char winnerMarker = ' ';

        System.out.println("\nLet's play tic tac toe");

        // Task 1: Create an array with three rows of '_' characters.
        char[][] board = {
                { '-', '-', '-' },
                { '-', '-', '-' },
                { '-', '-', '-' }
        };

        // Task 2: Call the function printBoard();
        printBoard(board);

        // promp for board marker and determine other player's marker
        char playerOneBoardMarker = chooseBoardMarker();
        playerTwoBoardMarker = getPlayerTwoBoardMarker(boardMarkers, playerOneBoardMarker);

        int playerOneDiceRoll = (int) (Math.random() * 2);
        
        while (!hasWinner) {
            winnerMarker = checkWin(board, boardMarkers);
            hasWinner = (winnerMarker != ' ');

            // check winner
            if (hasWinner) {
                displayReport(winnerMarker, board);
            } else {
                if (turnCounter++ % 2 == playerOneDiceRoll) {
                    int[] spot = new int[2];

                    System.out.println("Currently it is player " + playerOneBoardMarker + "'s turn!");

                    // player one place his marker on the board
                    spot = askUser(board, min, max, spaceHolder);
                    placeMarker(playerOneBoardMarker, board, spot);

                    printBoard(board);
                } else {
                    int[] spot = new int[2];
                    // player two place his marker on the board
                    System.out.println("Currently it is player " + playerTwoBoardMarker + "'s turn!");
                    spot = askUser(board, min, max, spaceHolder);
                    placeMarker(playerTwoBoardMarker, board, spot);
                    printBoard(board);
                }
            }
        }

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
     * Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * 
     * @param board (char[][])
     * 
     *              Inside the function:
     *              1. print a new line.
     *              2. print the board.
     *              • separate each row by two lines.
     *              • each row precedes a tab of space
     *              • each character in the grid has one space from the other
     *              character
     */
    public static void printBoard(char[][] board) {
        clearScreen();
        System.out.println("\n");
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }

            System.out.println("\n\n");
        }
    }

    public static char chooseBoardMarker() {
        char playerBoardMarker = ' ';

        do {
            System.out.print("Please choose board marker ('X' or 'O'): ");
            playerBoardMarker = Character.toUpperCase(scan.nextLine().charAt(0));
        } while (playerBoardMarker != 'X' && playerBoardMarker != 'O');

        return  playerBoardMarker;
    }

    public static char getPlayerTwoBoardMarker(char[] boardMarkers, char marker) {
        char otherMarker = ' ';

        for(char boardMarker : boardMarkers){
            if(boardMarker != marker){
                otherMarker = boardMarker;
            }
        }

        return otherMarker;
    }

    public static int inputInteger(int min, int max) {
        int userInput = -1;

        do {
            System.out.print("Please enter a integer between 0 and 2 inclusive: ");
            userInput = scan.nextInt();
        } while (userInput < min || userInput > max);

        return userInput;
    }

    /**
     * Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * 
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     *         Inside the function
     *         1. Asks the user: - pick a row and column number:
     *         2. Check if the spot is taken. If so, let the user choose again.
     *         3. Return the row and column in an int[] array.
     * 
     */
    public static int[] askUser(char[][] board, int min, int max, char placeholder) {
        int[] spot = new int[2];

        do {
            System.out.print("Row Index - ");
            spot[0] = inputInteger(min, max);

            System.out.print("Column Index - ");
            spot[1] = inputInteger(min, max);
        } while (board[spot[0]][spot[1]] != placeholder);
        return spot;
    }

    public static char[][] placeMarker(char marker, char[][] board, int[] spot) {
        board[spot[0]][spot[1]] = marker;
        return board;
    }

    /**
     * Task 6 - Write a function that determines the winner
     * Function name - checkWin
     * 
     * @param board   (char[][])
     * @param markers (char[])
     * @return char markerOfWinner
     * 
     *         Inside the function:
     *         1. Make a count variable that starts at 0.
     *         2. Check every row for a straight X or straight O (Task 7).
     *         3. Check every column for a straight X or straight O (Task 8).
     *         4. Check the left diagonal for a straight X or straight O (Task 9).
     *         5. Check the right diagonal for a straight X or straight O (Task 10).
     */
    public static char checkWin(char[][] board, char[] markers) {
        char markerOfWinner = ' ';

        // Check every row for marker
        for (char marker : markers) {
            if ((board[0][0] == marker && board[0][1] == marker && board[0][2] == marker) ||
                    (board[1][0] == marker && board[1][1] == marker && board[1][2] == marker) ||
                    (board[2][0] == marker && board[2][1] == marker && board[2][1] == marker) ||

                    (board[0][0] == marker && board[1][0] == marker && board[2][0] == marker) ||
                    (board[0][1] == marker && board[1][1] == marker && board[2][1] == marker) ||
                    (board[0][2] == marker && board[1][2] == marker && board[2][2] == marker) ||

                    (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) ||
                    (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker)) {
                markerOfWinner = marker;
            }
        }
        return markerOfWinner;
    }

    public static void displayReport(char marker, char[][] board) {
        printBoard(board);

        System.out.println("\n\n\nHere is the game Report: ");
        System.out.println("******************************************************************");
        System.out.println("\nCongratulation, Player with marker '" + marker + "' won that game!\n");
        System.out.println("******************************************************************");
    }
}
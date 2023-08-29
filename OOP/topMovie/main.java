package OOP.topMovie;

import java.text.DecimalFormat;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int movieId = 100;
        double newRating = 11.0;
        Scanner scanner = new Scanner(System.in);
        String isContinue = "continue";

        Movie[] movies = new Movie[] {
                new Movie("The Shawshank Redemption", "BlueRay", 9.2),
                new Movie("The Godfather", "BlueRay", 9.1),
                new Movie("The Godfather: Part II", "DVD", 9.0),
                new Movie("The Dark Knight", "BlueRay", 9.0),
                new Movie("Schindler's List", "DVD", 8.9),
                new Movie("The Lord of the Rings: The Return of the King", "BlueRay", 8.9),
                new Movie("Pulp Fiction", "DVD", 8.8),
                new Movie("The Lord of the Rings: TThe Lord of the Rings: The Return of the King", "DVD", 8.8),
                new Movie("Pulp The Good, the Bad and the Ugly", "DVD", 8.8),
                new Movie("The Lord of the Rings: The Fellowship of the Ring", "DVD", 8.8)
        };

        Store store = new Store();

        // populate movies to the store
        for (int i = 0; i < movies.length; i++) {
            store.setMovieByIndex(i, movies[i]);
        }

        // print store movie inventory
        store.printStore();

        do {
            while (movieId < 0 || movieId > 9) {
                try {
                    System.out.print("Please choose a movie ID number from 1 to 10: ");
                    String userInput = scanner.next();
                    movieId = Integer.parseInt(userInput) - 1;

                    if(movieId < 0 || movieId > 9){
                        System.out.println("The movie ID is outside of valid range!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number and please try again!");
                }
            }

            // Grab a movie from the store based on the user input
            Movie selectedMovie = store.getMovieByIndex(movieId);
            System.out.println("Below is the movie you have chosen: \n'" + selectedMovie + "'.");

            while (newRating < 0 || newRating > 10) {
                try {
                    // extract user new rating
                    System.out.print("Set a new rating for '" + selectedMovie.getName() + "' between 0 and 10: ");
                    String userInput = scanner.next();
                    newRating = Double.parseDouble(userInput);

                    // keep rating with only one decimal
                    DecimalFormat numberFormat = new DecimalFormat("#.0");
                    newRating = Double.parseDouble(numberFormat.format(newRating));

                    if(newRating < 0 || newRating > 10){
                        System.out.println("The new rating is outside of valid range!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number and please try again!");
                }
            }

            // update with new rating
            selectedMovie.setrating(newRating);

            // update store with new rating for that movie
            store.setMovieByIndex(movieId, selectedMovie);

            System.out.print("To edit another rating, type: 'continue': ");
            isContinue = scanner.next();
        } while (isContinue.trim().toLowerCase().equals("continue"));

        // print store moive info with new ratings
        store.printStore();

        scanner.close();
    }
}

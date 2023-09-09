package OOP.topMovie;

import java.util.Scanner;

import shared.NumberUtil;

public class main {
    public static void main(String[] args) {
        int movieId = 100;
        double newRating = 11.0;
        Scanner scanner = new Scanner(System.in);
        char isContinue = 'y';
        NumberUtil shared = new NumberUtil();

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
        store.addMovies(movies);

        // print store movie inventory
        store.printStore();

        do {
            // prompt for a movie to be rated
            movieId = shared.userInputIntegerNumber(scanner, 0, 9);

            // Grab a movie from the store based on the user input
            Movie selectedMovie = store.getMovie(movieId);
            System.out.println("Below is the movie you have chosen: \n'" + selectedMovie + "'.");

            // prompt for a new rating of the chosen moive
            newRating = shared.userInputDoubleValue(scanner, 0, 10, 1);

            // update with new rating
            selectedMovie.setRating(newRating);

            // update store with new rating for that movie
            store.setMovie(movieId, selectedMovie);

            // prompt user for continue to edit rating of other moives
            System.out.print("To edit another rating, type 'Y' or 'y' for yes to continue: ");
            isContinue = scanner.next().charAt(0);
        } while (Character.toUpperCase(isContinue) == 'Y');

        // print store moive info with new ratings
        store.printStore();

        store.removeMovies();

        store.printStore();

        scanner.close();
    }
}

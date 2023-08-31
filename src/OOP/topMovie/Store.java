package OOP.topMovie;

public class Store {
    private Movie[] movies;

    public Store() {
        this.movies = new Movie[10];
    }

    public String toString() {
        String movieStr = "";
        for (Movie movie : this.movies) {
            movieStr += "\t" + movie + "\n";
        }
        return movieStr;
    }

    public void printStore() {
        System.out.println(
                "******************************************************MOVIE STORE******************************************************\n");
        System.out.println(toString());
        System.out.println(
                "***********************************************************************************************************************");
    }

    public Movie getMovieByIndex(int index) {
        return this.movies[index];
    }

    public void setMovieByIndex(int index, Movie movie) {
        this.movies[index] = new Movie(movie);
    }

    public void setMovies(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
           setMovieByIndex(i, movies[i]);
        }
    }
}
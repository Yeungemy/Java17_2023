package OOP.topMovie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {
    private List<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>(){};
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

    /** fetch movie by index */
    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    /** update movies */
    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie)); 
    }

    /** insert moive */
    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
    }

    /** insert movies in batch */
    public void addMovies(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
           addMovie(movies[i]);
        }
    }

    /** update movies in batch  */
    public void setMovies(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
           setMovie(i, movies[i]);
        }
    }

    /** remove a movie */
    public void removeMovie(int index){
        this.movies.remove(index);
    }

    /** remove all movies */
    public void removeMovies(){
        // System.out.println("Currently have " + this.movies.size() + " movies in our store.");
        if(this.movies.size() > 0){
            removeMovie(0);
            removeMovies();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Store)) {
            return false;
        }
        Store store = (Store) o;
        return Objects.equals(movies, store.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movies);
    }    
}

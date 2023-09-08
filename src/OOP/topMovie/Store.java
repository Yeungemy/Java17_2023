package OOP.topMovie;

import java.util.ArrayList;
import java.util.List;

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

    public Movie getMovie(int index) {
        return this.movies.get(index);
    }

    public void setMovie(int index, Movie movie) {
        try{
            if( index >= 0 || index < this.movies.size()){
                this.movies.set(index, movie);
            }   
        }catch(IndexOutOfBoundsException e){

        }  
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }

    public void addMovies(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
           addMovie(movies[i]);
        }
    }

    public void setMovies(Movie[] movies){
        for (int i = 0; i < movies.length; i++) {
           setMovie(i, movies[i]);
        }
    }

    public void removeMovie(int index){
        this.movies.remove(index);
    }
}

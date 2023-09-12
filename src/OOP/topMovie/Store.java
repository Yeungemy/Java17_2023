package OOP.topMovie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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

    /**
     * Load movies from a file
     * @param {String} filePath - the path of a file
     * @param {String} seporator - the seporator of each field
     * @throws FileNotFoundException
     */
    public void loadMovies(String filePath, String seporator) throws FileNotFoundException{
        if(filePath == null || filePath.isBlank()){
            throw new IllegalArgumentException("File path cannot be null or blank!");
        }

        if(seporator == null || seporator.isBlank()){
            throw new IllegalArgumentException("Seporator path cannot be null or blank!");
        }

        FileInputStream fis = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fis);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            String[] data = line.split(seporator);

            addMovie(new Movie(data[0], data[1], Double.parseDouble(data[2])));
        }

        scanner.close();
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

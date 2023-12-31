package OOP.topMovie;
import java.util.Objects;

public class Movie {
    private String name;
    private String format;
    private double rating;

    public Movie() {}

    public Movie(String name, String format, double rating) {
        this.name = name;
        this.format = format;
        this.rating = rating;
    }

    public Movie(Movie movie){
        this.name = movie.name;
        this.format = movie.format;
        this.rating = movie.rating;
    }

    public String toString(){
        return this.rating + "\t" + this.format + "\t\t" + this.name + "";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if( name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank!");
        }
        
        this.name = name;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        if( format == null || format.isBlank()){
            throw new IllegalArgumentException("Format cannot be null or blank!");
        }
        
        this.format = format;
    }

    public double getRating() {
        return this.rating;
    }

    /**
     * Set rating of a movie
     * @param {double} rating - the rating is less than 0 or greater than 10
     */
    public void setRating(double rating) {
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("The rating should not be less than 0 or greater than 10!");
        }
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Movie)) {
            return false;
        }
        
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) && Objects.equals(format, movie.format) && rating == movie.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, format, rating);
    }    
}

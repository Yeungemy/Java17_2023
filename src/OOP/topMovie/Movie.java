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
        this.name = name;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
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

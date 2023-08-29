package OOP.topMovie;

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

    public double getrating() {
        return this.rating;
    }

    public void setrating(double rating) {
        this.rating = rating;
    }
}

package OOP.lambda.book;
import java.util.Objects;

public class Book {

    private String title;
    private String genre;
    private Integer year;
    private Double price;

    public Book(String title, String genre, int year, double price) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }

    public Book(Book book){
        setTitle(book.title);
        setGenre(book.genre);
        setPrice(book.price);
        setYear(book.year);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String toString() {
        return this.genre + "  " + this.year + "  $" + this.price + "  " + this.title;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(genre, book.genre) && Objects.equals(year, book.year) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, year, price);
    }
    
}
    
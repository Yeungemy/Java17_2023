package OOP.bookStore;

import java.text.DecimalFormat;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private double rating;
    private double price;

    /** creat a constructor that initializes the fields of a newly created object  
     * @param {String} title - the book title
     * @param {String} author - the author of the book
     * @param {double} rating - the rating of the book
     * @param {double} price - the price of the book
     */
    public Book(String title, String author, double rating, double price){
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.price = price;
    }

    /** create a constructor that initializes a new object using an existing object's fields 
     * @param {Book} source - an existing book object
     */
    public Book(Book source){
        this.title = source.title;
        this.author = source.author;
        this.rating = source.rating;
        this.price = source.price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "'" + this.title + "' written by " + this.author + " is rated " + new DecimalFormat("#.##").format(this.rating) + " and sold for $" + new DecimalFormat("#.##").format(this.price); 
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && rating == book.rating && price == book.price;
    }
}

package OOP.lambda.book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookStore {
    private static final int TOP_PRICE_BOOKS = 3;
    private List<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }

    public void addBooks(List<Book> books) {
        books.forEach(book -> addBook(book));
    }

    public Book getBooks(int index) {
        if (index < 0 || index >= this.books.size()) {
            throw new IllegalArgumentException(
                    "Index should be greater than or equal 0 and less than " + this.books.size() + ".");
        }

        return new Book(this.books.get(index));
    }

    public void setBooks(Book book, int index) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }

        if (index < 0 || index >= this.books.size()) {
            throw new IllegalArgumentException(
                    "Index should be greater than or equal 0 and less than " + this.books.size() + ".");
        }

        this.books.set(index, new Book(book));
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        this.books.add(new Book(book));
    }

    public List<Book> filterByGenre(String genre) {
        return this.books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Book> sortByReleaseYear() {
        return this.books.stream()
                .sorted((a, b) -> a.getYear().compareTo(b.getYear()))
                .collect(Collectors.toList());
    }

    public List<Book> getTopPriceBooks(double price) {
        return this.books.stream()
                .filter(book -> book.getPrice() > price)
                .sorted((a, b) -> b.getPrice().compareTo(a.getPrice()))
                .limit(TOP_PRICE_BOOKS)
                .collect(Collectors.toList());
    }
}

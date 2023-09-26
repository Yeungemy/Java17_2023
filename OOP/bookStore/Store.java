package OOP.bookStore;
import java.util.ArrayList;

public class Store {
    private ArrayList<Book> books;

    /** create a constructor for the Store class that initializes an empty ArrayList of Book objects */
    public Store(){
        this.books = new ArrayList<Book>();
    }

    /** Create a getBook method that takes an index as a parameter 
     * @param {int} index - an index as a parameter
     * @return returns a deep copy of the Book object at that index
     */
    public Book getBook(int index){
        return new Book(this.books.get(index));
    }

    /** Create a setBook method that takes a Book object and an index as parameters and sets the Book object at the specified index to a deep copy of the given object  
     * @param {int} index - an index as a parameter
     * @param {Book} book - the Book object
     */
    public void setBook(int index, Book book){
        this.books.set(index, new Book(book));
    }

    public void addBook(Book book){
        this.books.add(new Book(book));
    }

    public boolean contains(Book book){
        return this.books.contains(book);
    }

    public void sellBook(String title){
        for(int i = 0; i < this.books.size(); i++){
            if(this.books.get(i).getTitle().equals(title)){
                this.books.remove(i);
            }
        }
    }   
}

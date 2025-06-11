/**
 * The Book class represents a book in the library.
 * It extends LibraryItem and adds the number of pages.
 */
public class Book extends LibraryItem{
    private int pages;

    /**
     * Constructs a Book with the given details.
     *
     * @param title         The title of the book.
     * @param author        The author of the book.
     * @param description   A brief description of the book.
     * @param yearPublish   Year the book was published.
     * @param genre         The genre of the book.
     * @param price         The price of the book.
     * @param pages         Number of pages in the book.
     */
    public Book(String title, String author, String description, int yearPublish, String genre, double price, int pages){
    super(title,author,description, yearPublish, genre, price);
    this.pages = pages;
    }

     /**
     * Displays information about the book, including number of pages.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Pages: " + pages);
    }
}
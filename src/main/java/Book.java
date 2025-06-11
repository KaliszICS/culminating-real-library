/**
 * The Book class represents a book in the library.
 * It extends LibraryItem and adds the number of pages.
 */
public class Book extends LibraryItem{
    private int bookPages;
    private String ISBN;

<<<<<<< HEAD
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
=======
    public Book (String title, String author, String description, int yearPublish, String genre, double price, int bookPages, String ISBN){
        super(title, author, description, yearPublish, genre, price);
        this.bookPages = bookPages;
        this.ISBN = ISBN;
    }

    public int getBookPages(){
        return this.bookPages;
    }

    public String getISBN(){
        return this.ISBN;
>>>>>>> 1dea00b (WIP #3)
    }

     /**
     * Displays information about the book, including number of pages.
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Book book = (Book)obj;
        if(book.getTitle().equals(this.getTitle()) && book.getAuthor().equals(this.getAuthor()) && book.getDescription().equals(this.description) && book.getYearPublish() == this.getYearPublish() && book.getGenre().equals(this.genre) && book.getPrice() == this.price && book.getBookPages() == this.bookPages && book.getISBN() == this.ISBN){
            return true;
        }
        return false;
    }
}
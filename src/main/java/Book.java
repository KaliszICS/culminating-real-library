/**
 * The Book class represents a book in the library.
 * It extends LibraryItem and adds the number of pages.
 */
public class Book extends LibraryItem{
    private int bookPages;
    private String ISBN;

    /**
     * Constructs a Book with the given details.
     *
     * @param title         A String representing the title of the book.
     * @param author        A String representing the author of the book.
     * @param description   A String representing a brief description of the book.
     * @param yearPublish   A integer representing the year the book was published.
     * @param genre         A String representing the genre of the book.
     * @param price         A integer representing the price of the book.
     * @param pages         A integer representing the number of pages in the book.
     * @param ISBN          A String representing the International Standard Book Number (ISBN) of the book.
     */

    public Book(String title, String author, String description, int yearPublish, String genre, double price, int pages, String ISBN){
    super(title,author,description, yearPublish, genre, price);
    this.bookPages = pages;
    this.ISBN = ISBN;
    }

    /**
     * Gets the ISBN of the book
     * @return a String that represents the ISBN of the book
     */
    public String getISBN(){
        return this.ISBN;
    }

    /**
     * Gets the number of pages in the book
     * @return an integer that represents the number of pages in the book
     */
    public int getBookPages(){
        return this.bookPages;
    }

     /**
     * Checks to see if the book is equal to the other object
     * @param obj the object being compared
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Book book = (Book)obj;
        if(book.getTitle().toLowerCase().equals(this.getTitle().toLowerCase()) && book.getAuthor().toLowerCase().equals(this.getAuthor().toLowerCase()) && book.getDescription().toLowerCase().equals(this.description.toLowerCase()) && book.getYearPublish() == this.getYearPublish() && book.getGenre().toLowerCase().equals(this.genre.toLowerCase()) && book.getPrice() == this.price && book.getBookPages() == this.bookPages && book.getISBN().toLowerCase().equals(this.ISBN.toLowerCase())){
            return true;
        }
        return false;
    }
}
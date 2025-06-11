<<<<<<< HEAD
/**
 * LibraryItem class represents a general item in a library, such as a book, DVD, or magazine.
 * It stores common attributes like title, author, description, year published, genre, and price.
 */

class LibraryItem {
=======
abstract class LibraryItem {
    /*
     * 
     */
>>>>>>> 1dea00b (WIP #3)
    protected String title;
    protected String author;
    protected String description;
    protected int yearPublish;
    protected String genre;
    protected double price; 

     /**
     * Constructs a LibraryItem with all the common fields.
     *
     * @param title         The title of the item.
     * @param author        The author or creator.
     * @param description   A brief description.
     * @param yearPublish   Year the item was published.
     * @param genre         Genre or category.
     * @param price         The item's price.
     */
    
    public LibraryItem (String title, String author, String description, int yearPublish, String genre, double price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.yearPublish = yearPublish;
        this.genre = genre;
        this.price = price;
    }
<<<<<<< HEAD
/*
 * Displays the information of the library item.
 * This includes the title, author, description, year published, genre, and price.
 * This method is intended to be overridden by subclasses for specific item types.
 */
    public void displayInfo (){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("Year published: " + yearPublish);
        System.out.println("Genre: " + genre);
        System.out.println("Price: $" + price);

=======

    public String getTitle(){
        return this.title;
>>>>>>> 1dea00b (WIP #3)
    }

    public String getAuthor(){
        return this.author;
    }

    public String getDescription(){
        return this.description;
    }

    public int getYearPublish(){
       return this.yearPublish;
    }

    public String getGenre(){
        return this.genre;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public String toString(){
        return this.title + " by " + this.author + " published in " + this.yearPublish;
    }
}
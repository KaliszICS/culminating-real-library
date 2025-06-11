/**
 * LibraryItem class represents a general item in a library, such as a book, DVD, or magazine.
 * It stores common attributes like title, author, description, year published, genre, and price.
 */

class LibraryItem {
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

    }

}
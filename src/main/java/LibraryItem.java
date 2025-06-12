/**
 * LibraryItem class is a blueprint used to create a general item in a library, such as a book, DVD, or magazine.
 * It stores common attributes like title, author, description, year published, genre, and price.
 */

 abstract class LibraryItem {
    protected String title;
    protected String author;
    protected String description;
    protected int yearPublish;
    protected String genre;
    protected double price; 

     /**
     * Constructs a LibraryItem with all the common fields.
     *
     * @param title         A String representing the title of the item.
     * @param author        A String representing the author or creator.
     * @param description   A String representing a brief description.
     * @param yearPublish   An integer representing the year the item was published.
     * @param genre         A String representing genre or category of the library item.
     * @param price         A double representing the item's price, which will be the fine cost if the item is overdue.
     */
    
    public LibraryItem (String title, String author, String description, int yearPublish, String genre, double price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.yearPublish = yearPublish;
        this.genre = genre;
        this.price = price;
    }

    /**
     * Gets the title of the library item
     * @return a String that represents the title of the library item
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Gets the author of the author of the library item
     * @return a String that represents the author of the library item
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     * Gets the description of the library item
     * @return a String that represents the description of the library item
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gets the year the library item was published
     * @return an integer that represents the year the library item was published
     */
    public int getYearPublish(){
       return this.yearPublish;
    }

    /**
     * Gets the genre of the library item
     * @return a String that represents the genre of the library item
     */
    public String getGenre(){
        return this.genre;
    }

    /**
     * Gets the price of the library item
     * @return a double that represents the price of the library item
     */
    public double getPrice(){
        return this.price;
    }

    /** 
     * Writes a String representation of the library item
     * @return a String that is in the format: "title" by "author" published in "yearPublish"
     */
    @Override
    public String toString(){
        return this.title + " by " + this.author + " published in " + this.yearPublish;
    }
}

}
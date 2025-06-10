class LibraryItem {
    /*
     * 
     */
    protected String title;
    protected String auothor;
    protected String description;
    protected int yearPublish;
    protected String genre;
    protected double price; 

    public LibraryItem (String title, String author, String description, int yearPublish, String genre, double price) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.yearPublish = yearPublish;
        this.genre = genre;
        this.price = price;
    }

    public displayInfo {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("Year published: " + yearPublish);
        System.out.println("Genre: " + genre);
        System.out.println("Price: $" + price);

    }

}
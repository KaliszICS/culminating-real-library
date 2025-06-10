public class Book extends LibraryItem{
    private int pages;

    public Book (String title, String author, String description, int yearPublish, String genre, double price){
    super(title,author,description, yearPublish, genre, price);
    this.pages = pages;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Pages: " + pages);
    }
}
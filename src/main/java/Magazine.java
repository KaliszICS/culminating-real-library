/**
 * The Magazine class represents a magazine in the library.
 * It extends LibraryItem and adds the number of pages specific to the magazine.
 */
public class Magazine extends LibraryItem{
    private int magazinePages;

    /**
     * Constructs a Magazine with the given details.
     *
     * @param title           The title of the magazine.
     * @param author          The author/editor of the magazine.
     * @param description     A brief description of the magazine.
     * @param yearPublish     Year the magazine was published.
     * @param genre           The genre of the magazine.
     * @param price           The price of the magazine.
     * @param magazinePages   Number of pages in the magazine.
     */
    public Magazine (String title, String author, String description, int yearPublish, String genre, double price, int magazinePages){
    super(title,author,description, yearPublish, genre, price);
    this.magazinePages = magazinePages;
    }

    /**
     * Displays information about the magazine, including the number of pages.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Pages: " + magazinePages);
    }
}
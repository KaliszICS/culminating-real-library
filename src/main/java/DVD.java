/**
 * The DVD class represents a DVD in the library.
 * It extends LibraryItem and adds the length (duration) of the DVD.
 */
public class DVD extends LibraryItem{
    private int length;

    /**
     * Constructs a DVD with the given details.
     *
     * @param title         The title of the DVD.
     * @param author        The creator/director of the DVD.
     * @param description   A brief description of the DVD.
     * @param yearPublish   Year the DVD was published.
     * @param genre         The genre of the DVD.
     * @param price         The price of the DVD.
     * @param length        The length (duration) of the DVD in minutes.
     */
    public DVD (String title, String author, String description, int yearPublish, String genre, double price, int length) {
    super (title, author, description, yearPublish, genre, price);
    this.length = length;
    }

    /**
     * Displays information about the DVD, including the duration.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Duration: " + length);
    }
}
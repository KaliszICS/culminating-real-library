import java.util.*;

public class Shelf{
    private String shelfType;
    private int maxCapacity;
    private int itemsStored;
    private ArrayList<LibraryItem> Items;

    /*
     * @param shelfType - types of shelves in the library
     * @param maxCapacity - the number of maximum books a shelf can hold
     * @param itemsStored - Number of items stored in a shelf
     */
    public Shelf(String shelfType, int maxCapacity, int itemsStored) {
        this.shelfType = shelfType;
        this.maxCapacity = maxCapacity;
        this.itemsStored = 0;
        this.Items = new ArrayList<>();
    }

    /*
     * @return - returns the type of shelf used on to store items
     */
    public String getShelfType() {
        return shelfType;
    }

    /*
     * @return - returns the maximum number of books a shelf can hold
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /*
     * @return - returns sorted items
     */
    public int getItemsSorted() {
        return itemsStored;
    }

    /*
     * @return returns Items that are stored in an ArrayList
     */
    public ArrayList<LibraryItem> getItems() {
        return Items;
    }

    /*
     * Checks if number of items are less that what the shelf can hold and adds new items
     * @param newItem
     * @return Lets librarian know if items have been added to shelves
     */

    public String addItem(LibraryItem newItem) {
        if (Items.size() < maxCapacity) {
            Items.add(newItem);
            itemsStored++;
            return "Added Item";
        }
        return "Shelf is full";
    }

    /*
     * Removes item from shelf
     * @param item
     * @return Lets librarian know if an Item is removed from a Shelf
     */

    public String removeItem(LibraryItem item) {
        if (Items.remove(item)) {
            itemsStored--;
            return "Removed item";
        }
        return "Item not found";
    }

    /* 
     * Organizes shelf by sorting by Title, Authors (first letter of Title and Authors), and Genre
     */
    
    public void organizeByTitle() {
        Items.sort((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
    }

    public void organizeByAuthors() {
        Items.sort((a, b) -> a.getAuthor().compareToIgnoreCase(b.getAuthor()));
    }

    public void organizeByGenre() {
        Items.sort((a, b) -> a.getGenre().compareToIgnoreCase(b.getGenre()));
    }
}
import java.util.*;

/** 
 * The Shelf class represents a shelf in the library that holds library items.
 */
public class Shelf{
    private String shelfType;
    private int maxCapacity;
    private int itemsStored;
    private LibraryItem[] items;

    /**
     * Constructs a Shelf object with number of items stored currently in the shelf and the following details:
     * @param shelfType  a String that represents types of shelves in the library
     * @param maxCapacity a integer that represents the number of maximum books a shelf can hold
     * @param items an array of LibraryItem objects that represents the items stored in the shelf
     */
    public Shelf(String shelfType, int maxCapacity, LibraryItem[] items) {
        this.shelfType = shelfType;
        this.maxCapacity = maxCapacity;

        if (items != null && items.length <= this.maxCapacity){
            this.items = items;
            this.itemsStored = this.items.length;
        }
        else{
            this.items = new LibraryItem[0];
            this.itemsStored = 0;
        }
    }

    /**
     * Constructs a shelf object with no items stored currently in the shelf and the following details:
     * @param shelfType a String that represents types of shelves in the library
     * @param maxCapacity a integer that represents the number of maximum books a shelf can hold
     */
    public Shelf(String shelfType, int maxCapacity){
        this.shelfType = shelfType;
        this.maxCapacity = maxCapacity;
        this.items = new LibraryItem[0];
        this.itemsStored = 0;
    }

    /**
     * Gets the type of shelf used to store the library items
     * @return a String that represents the type of shelf used on to store library items
     */
    public String getShelfType() {
        return this.shelfType;
    }

    /**
     * Gets the maximum capacity amount of library items a shelf can hold
     * @return -an integer that represents the maximum capacity amount of library items a shelf can hold
     */
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    /**
     * Gets the number of library items stored in the shelf
     * @return an integer that represents the number of items stored in the shelf
     */
    public int getItemsStored() {
        return this.itemsStored;
    }

    /**
     * Gets the items stored in the shelf
     * @return returns Items that are stored in an ArrayList
     */
    public LibraryItem[] getItems() {
        return this.items;
    }

    /**
     * Looks for a library item within the shelf
     * @param item a Library item object that represents the item to find
     * @return the index at which the library item was found in the shelf
     */
    public int findItem(LibraryItem item){
        if (item == null){
            return -1;
        }

        for (int i = 0; i < items.length; i++){
            if (items[i].equals(item)){
               return i;
            }
        }
        return -1;
    }

    /**
     * Checks if the shelf is at max capacity yet, if not it will add the given item into the shelf
     * @param newItem a LibraryItem object that represents the item to be added to the shelf
     * @return a boolean the represents if the library item has been successfully added or not
     */
    public boolean addItem(LibraryItem newItem){
        if (newItem == null){
            return false;
        }
        if (this.itemsStored < maxCapacity) {
            LibraryItem[] newItems = new LibraryItem[items.length + 1];
            for (int i = 0; i < items.length; i++){
                newItems[i] = items[i];
            }
            newItems[items.length] = newItem;
            this.items = newItems;
            itemsStored++;
            return true;
        }
        return false;
    }

    /**
     * Removes a Library item from shelf
     * @param item a LibraryItem object that represents the item to be removed from the shelf
     * @return Lets librarian know if an Item is removed from a Shelf
     */

    public boolean removeItem(LibraryItem item) {
        if (item == null){
            return false;
        }

        LibraryItem[] newItems = new LibraryItem[items.length - 1];
        int indexOfItem = findItem(item);
        int currentIndex = 0;
        if (indexOfItem != -1){
            for (int i = 0; i < items.length; i++){
                if (i != indexOfItem){
                    newItems[currentIndex++] = items[i];
                }
            }
        items = newItems;
        itemsStored--;
        return true;
        }
    return false;
    }

    /**
     * Organizes library items on shelf by sorting by Title alphabetically
     */
    public void organizeByTitle() {
        for (int i = 0; i < items.length - 1; i++){
            int smallestIndex = i;
            for (int j = i + 1; j < items.length; j++){
                if (items[j].getTitle().toLowerCase().compareTo(items[smallestIndex].getTitle().toLowerCase()) < 0){
                    smallestIndex = j;
                }
            }
            LibraryItem temp = items[smallestIndex];
            items[smallestIndex] = items[i];
            items[i] = temp;
        }
    }

    /**
     * Organizes library items on shelf by sorting by Author alphabetically
     */
    public void organizeByAuthors() {
      for (int i = 0; i < items.length - 1; i++){
            int smallestIndex = i;
            for (int j = i + 1; j < items.length; j++){
                if (items[j].getAuthor().toLowerCase().compareTo(items[smallestIndex].getAuthor().toLowerCase()) < 0){
                    smallestIndex = j;
                }
            }
            LibraryItem temp = items[smallestIndex];
            items[smallestIndex] = items[i];
            items[i] = temp;
        }
    }

    /**
     * Organizes library items on shelf by sorting by Genre alphabetically
     */
    public void organizeByGenre() {
          for (int i = 0; i < items.length - 1; i++){
            int smallestIndex = i;
            for (int j = i + 1; j < items.length; j++){
                if (items[j].getGenre().toLowerCase().compareTo(items[smallestIndex].getGenre().toLowerCase()) < 0){
                    smallestIndex = j;
                }
            }
            LibraryItem temp = items[smallestIndex];
            items[smallestIndex] = items[i];
            items[i] = temp;
        }
    }
}
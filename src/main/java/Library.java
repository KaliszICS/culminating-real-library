import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 *  The Library class represents a library that contains shelves with items on them.
 */
public class Library{
    private Shelf[] shelves;

    /**
     * Constructs a Library that has shelves
     * @param shelves an array of shelf that stores mulitple shelves
     */
    public Library(Shelf[] shelves){
        this.shelves = shelves;
    }

    /**
     * Constructs a Library with no shelves
     */
    public Library(){
        this.shelves = new Shelf[0];
    }

    /**
     * Gets the shelves that are in the library
     * @return An array of shelves that are in the library
     */
    public Shelf[] getShelves(){
        return this.shelves;
    }

    /**
     * Checks to see if the Desired item is on a shelf that is in the library
     * @param item a Library item object that represents an item to be found
     * @return an integer that represents the index of the shelf where the item was found at
     */
    public int findItem(LibraryItem item) {
        if (item == null){
            return -1;
        }
        for (int i = 0; i < shelves.length; i++){
            if (shelves[i].findItem(item) != -1){
               return i;
            }
        }
        return -1;
    }

    /*
     * Saves the items that were in library
     */
    public void saveLibraryFile() {
      BufferedWriter writer = null;
      try{
        writer = new BufferedWriter(new FileWriter("savedLibrary.txt"));
        for (int i = 0; i < shelves.length; i++){
            Shelf shelf = shelves[i];
            LibraryItem[] items = shelf.getItems();
            for(int j = 0; j < items.length; j++){
                writer.write(items[j].toString());
                writer.newLine();
            }
            writer.write("Saved Date: " + LocalDate.now() + "\n");
        }
      }
      catch (IOException e){
        System.out.println(e);
      }
      finally{
        try{
            if (writer != null){
                writer.close();
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
      }
    }

    /*
     * Loads the save files of the items that were in the library
     */
    public void loadLibraryFile() {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("savedLibrary.txt"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
        finally{
        try{
            if (reader != null){
                reader.close();
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
      }
    }
    

    /**
     * Adds a new shelf to the library
     * @param newShelf a Shelf object that represents a new shelf to be added into the library
     */
    public void addShelf(Shelf newShelf) {
        if (newShelf != null){
            Shelf[] newShelves = new Shelf[shelves.length + 1];
            for (int i = 0; i < shelves.length; i++){
                newShelves[i] = shelves[i];
            }
            newShelves[shelves.length] = newShelf;
            shelves = newShelves;
        }
    }

    /**
     * Organizes the shelves in the library by what type of shelf they are alphabetically
     */
    public void organizeLibraryShelves() {
        for (int i = 0; i < shelves.length - 1; i++){
            int smallestIndex = i;
            for (int j = i + 1; j < shelves.length; j++){
                if(shelves[j].getShelfType().toLowerCase().compareTo(shelves[smallestIndex].getShelfType().toLowerCase()) < 0){
                    smallestIndex = j;
                }
            }
            Shelf temp = shelves[smallestIndex];
            shelves[smallestIndex] = shelves[i];
            shelves[i] = temp;
        }
    }

    /**
     * Calculates the total amount of items that are currently in the library shelves
     * @return an integer representing the total number of items on all the shelves in the library
     */
    public int totalAvailableItems() {
        int totalItems = 0;
        for (int i = 0; i < shelves.length; i++){
             totalItems += shelves[i].getItemsStored();
        }
        return totalItems;
    }

    /**
     * Checkout a library item for a library member
     * @param item a Library item that represents the item that the person wants to checkout from the library
     * @return a boolean that tells you if the checkout of the library item was succesful
     */
    public boolean checkOutItem(LibraryItem item) {
        int indexOfItem = findItem(item);
        if (indexOfItem != -1){
            boolean removed = shelves[indexOfItem].removeItem(item);
            return removed;
        }
        return false;
    }

    /**
     * Adding an item back into the library after a library member has returned the item
     * If all shelves are full, the item cannot be added into the library
     * @param item a Library item object that represents the item that is being returned back to the library
     * @return a boolean that tells you if returning the item was successful or not
     */
    public boolean checkInItem(LibraryItem item){
        for (int i = 0; i < shelves.length; i++){
            if (shelves[i].addItem(item)){
                return true;
            }
        }
        return false;
    }
}
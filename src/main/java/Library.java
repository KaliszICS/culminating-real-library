import java.io.*;
import java.util.*;
public class Library{

    private ArrayList<Shelf> shelves;

    // No @param
    public Library(){
        this.shelves = new ArrayList<>();
    }

    /*
     * Finds Desired item on the shelf
     * @param item
     * @return - at which type of shelf an item is stored in, unless the item is not found
     */

    public String findItem(LibraryItem item) {
        for (Shelf shelf : shelves) {
            if (shelf.borrowItems().contains(item)) {
                return "Found in: " + shelf.getShelfType();
            }
        }
        return "Item not found";
    }

    /*
     * @param
     * Filewrite is used to save process on a text file
     * try-catch method used, so it catches a fail in saving file
     */

    public void saveLibraryFile() {
        try (FileWriter newFile = new FileWriter("saved_data.txt")) {
            for (Shelf shelf : shelves) {
                newFile.write("shelf category: " + shelf.getShelfType() + "| Max capacity: " + shelf.getMaxCapacity() + "\n");
                for (LibraryItem item : shelf.getItems()) {
                    newFile.write("items: " + item.toString() + "\n");
                }
            }
            System.out.println("Data sucessfully saved to 'saved_data.txt");
            System.out.prinlnt("Saved on: " + java.time.LocalDateTime.now());
        } catch (IOException e) {
            System.out.println("Failed to save data, " + e.getMessage());
        }
    }

    /*
     * 
     */

    public void loadLibraryFile() {
        try (BufferedReader FileReader = new BufferedReader(new FileReader("saved_data.txt"))) {
            String line;
            shelves.clear();
            while (line 
        }
    }

    public void addShelf(Shelf newShelf) {
        shelves.add(newShelf);
    }

    public void organizeLibraryShelves() {
        for (Shelf shelf : shelves) {
            shelf.organizeByTitle();
            shelf.organizeByAuthors();
            shelf.organizeByGenre();
        }
    }

    /*
     * Checks for total items for user to read/borrow
     * @param - param inside the class for total = 0
     * @return - returns number of items available to read
     */

    public int totalAvailableItems() {
        int total = 0;
        for (Shelf shelf : shelves)  {
            total += shelf.getItems().size();
        }
        return total;
    }

    public String checkOutItem() {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Title of item to be checked out: ");
        String title = newScanner.nextLine();
        
        for(Shelf shelf : shelves) {
            for(LibraryItem item : shelf.getItems()) {
                if (item.getTitle().equals(title)) {
                    shelf.getItems().remove(item);
                    shelf.setItemsStored(shelf.getItemsSorted() - 1);
                    return "Checked out: " + item.getTitle();
                }
            }
        }
        return "Item not found.";

    }

    public String checkInItem() {

    }

}
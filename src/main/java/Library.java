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
     * 
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
            
        }
    }

    public void addShelf(Shelf newShelf) {
        shelves.add(newShelf);
    }

    public void organizeLibraryShelves() {

    }

    public int totalAvailableItems() {

    }

    public String checkOutItem() {

    }

    public String checkInItem() {

    }

}
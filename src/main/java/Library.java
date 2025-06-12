import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 *  The Library class represents a library that contains shelves with items on them.
 */
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
     * @param - no param
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
            System.out.println("Data sucessfully saved to 'saved_data.txt'.");
            System.out.prinlnt("Saved on: " + java.time.LocalDateTime.now());
        } catch (IOException e) {
            System.out.println("Failed to save data, " + e.getMessage());
        }
    }

    /*
     * @param - no param
     * Loads the user's data stored in a file
     * reads through file using BufferedReader then loads left data
     * reads shelf category first, then reads items
     * Library will be loaded successfully
     */

    public void loadLibraryFile() {
        try (BufferedReader FileReader = new BufferedReader(new FileReader("saved_data.txt"))) {
            String line;
            shelves.clear();
            while (line = FileReader.readLine() != null) {
                if (line.startsWith("shelf category: ")) {
                    String[] FileParts = line.substring(6).split(", ");
                    int maxCap = Integer.parseInt(FileParts[1].trim());
                    currentShelf = new Shelf(shelfType, maxCap);
                    shelves.add(currentShelf);
                }
                else if (line.startsWith("items: " && currentShelf != null)) {
                    String itemData = line.substring(5).trim();
                    String[] segments = itemData.split(" by ");
                    String title = segments[0].trim();
                    String[] authorGenre = segments[1].split(" | (Genre: ");
                    String author = authorGenre[0].trim();
                    String Genre = authorGenre[1].replace(")", "").trim();

                    LibraryItem item = new LibraryItem(title, author, genre);
                    currentShelf.addItem(item);
                    

                }
            }
            System.out.println("Library loaded successfully");
        } catch (IOException e) {
            System.out.println("Library failed to load: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error reading data: " + e.getMessage());
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

    /*
     * no @param
     * New Scanner Scans for Item's title
     * Checks out item for one particular user 
     * which means the user can't see their book until it's checked in
     */

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

    /*
     * No param
     * checks in item
     * scans shelf to see if the item is missing
     * if the shelves are full item will not be checked in
     */

    public String checkInItem() {
        Scanner newScn = new Scanner(System.in);
        System.out.println("Title of item to be checked in: ");
        String title = newScn.nextLine();

        LibraryItem newItem = new LibraryItem(title);

        for(Shelf shelf : shelves) {
            if (shelf.getItemsSorted() < shelf.getMaxCapacity()) {
                shelf.getItems().add(newItem);
                shelf.setItemsStored(shelf.getItemsSorted() + 1);
                return "Item checked into: " + shelf.getShelfType();
            }
        }
        return "No available space on shelves.";
    }

}
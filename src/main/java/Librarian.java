import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Creates a librarian object
 */
class Librarian extends Person{
    private String librarianID;
    private Library assignLibrary;
    private Loan[] loan;

    /**
     * Constructs a libriran 
     * @param name a String that represents the librarian's name
     * @param age a integer that represents the librarian's age
     * @param phoneNumber a String that represents the librarian's phone number
     * @param email a String that represents the librarian's email
     * @param librarianID a String that represents the librarian's ID
     */
    Librarian(String name, int age, String phoneNumber, String email, String librarianID){
        super(name, age, phoneNumber, email);
        this.librarianID = librarianID;
    }

    /**
     * Gets the librarian's identification card
     * @return a String that represents the Librarian identification card
     */
    public String getLibrarianID(){
        return this.librarianID;
    }

    /**
     * Librarian gives the item if found on a library shelf to a member
     * @param loan a Loan Object that represents the current library item on loan
     * @param item a LibraryItem object that represents the item the librarian will give to a member
     * @return a boolean that represents if an item was succesfully given
     */
    public boolean giveItem(Loan loan, LibraryItem item){
     if (loan.getLibraryItem().equals(item) && assignLibrary.findItem(item)){
        //saves loan to the loan list
        Loan[] newLoans = new Loan[this.loan.length + 1];
        for (int i = 0; i < this.loan.length; i++){
            newLoans[i] = this.loan[i];
        }
        newLoans[this.loan.length] = loan;
        this.loan = newLoans;

        //Checks if item exists on shelf
        Shelf[] shelves = assignLibrary.getShelves();
        boolean found = false;
        int shelfIndex = -1;
        for (int i = 0; i < shelves.length; i++){
            Shelf shelf = shelves[i];
            LibraryItem[] items = shelf.getItems();

            for (int j = 0; j < items.length; j++){
                if (items[j].equals(item)){
                    found = true;
                    j = items.length;
                    shelfIndex = i;
                }
            }

            if (shelfIndex != -1){
                shelf.removeItem(loan, item);
                i = shelves.length;
                return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Returns the library item given back to a library shelf
     * @param loan a Loan objects that represents a loan that is tied with the library item
     * @param item a Library item that represents a item
     * @return a boolean whenever if returning the item back to a library shelf was successful or not
     */
    public boolean returnItem(Loan loan, LibraryItem item){
        //Checks if the loan exists in the list and if it does removes the loan from the list 
        int itemIndex = -1;
        for (int i = 0; i < this.loan.length; i++){
            if (this.loan[i].equals(loan)){
                itemIndex = i;
                i = this.loan.length;
            }
        }
        int currentIndex = 0;
        if (itemIndex != -1){
            Loan[] newLoans = new Loan[this.loan.length - 1];
            for (int i = 0; i < this.loan.length; i++){
                if (i != itemIndex){
                   newLoans[currentIndex++] = this.loan[i];
                }
            }
            this.loan = newLoans;
            Shelf[] shelves = assignLibrary.getShelves();
            for (int i = 0; i < shelves.length; i++){
                if (shelves[i].addItem(item) != false){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    /**
     * Saves the loans of the current library items are out
     */
    public void saveLoans(){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter("loan.txt"));
            for (int i = 0; i < loan.length; i++){
                writer.write(loan[i].toString());
                writer.newLine();
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

    /**
     * Load the loans that show the current Library items are out
     */
    public void loadLoans(){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader("loan.txt"));
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
}
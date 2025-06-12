import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * The Librarian class that represents a librarian in a library system.
 * The Librarian class extends the Person class.
 */
class Librarian extends Person{
    private String librarianID;
    private Library assignLibrary;
    private Loan[] loan;

    /**
     * Constructs a libriran with the following details:
     * @param name a String that represents the librarian's name
     * @param age a integer that represents the librarian's age
     * @param phoneNumber a String that represents the librarian's phone number
     * @param email a String that represents the librarian's email
     * @param librarianID a String that represents the librarian's ID
     * @param assignLibarary a Libary object that represents the library the librarian is working for
     */
    Librarian(String name, int age, String phoneNumber, String email, String librarianID, Library assignLibrary, Loan[] loan){
        super(name, age, phoneNumber, email);
        this.librarianID = librarianID;
        this.assignLibrary = assignLibrary;
        this.loan = loan;
    }

    /**
     * Constructs a libriran that has no loans out and with the following details:
     * @param name a String that represents the librarian's name
     * @param age a integer that represents the librarian's age
     * @param phoneNumber a String that represents the librarian's phone number
     * @param email a String that represents the librarian's email
     * @param librarianID a String that represents the librarian's ID
     * @param assignLibrary a Libary object that represents the library the librarian is working for
     */
    Librarian(String name, int age, String phoneNumber, String email, String librarianID, Library assignLibrary){
        super(name, age, phoneNumber, email);
        this.librarianID = librarianID;
        this.assignLibrary = assignLibrary;
        this.loan = new Loan[0];
    }
    /**
     * Gets the librarian's identification card
     * @return a String that represents the Librarian identification card
     */
    public String getLibrarianID(){
        return this.librarianID;
    }

    /**
     * Gets the libary at which the librarian is assigned at
     * @return a Library object represents the libary at which the librarian is assigned at
     */
    public Library getAssignLibrary(){
        return this.assignLibrary;
    }
    
    /**
     * Gets the list of loans
     * @return an array of loans representing loans of various library members
     */
    public Loan[] getLoan(){
        return this.loan;
    }
    /**
     * Librarian gives the item if found on a library shelf to a member
     * @param loan a Loan Object that represents the current library item on loan
     * @param item a LibraryItem object that represents the item the librarian will give to a member
     * @return a boolean that represents if an item was succesfully given
     */
    public boolean giveItem(Loan loan, LibraryItem item){
    if (loan != null && item != null && assignLibrary.checkOutItem(item) && loan.getLibraryItem().equals(item)){
        //saves loan to the loan list
        Loan[] newLoans = new Loan[this.loan.length + 1];
        for (int i = 0; i < this.loan.length; i++){
            newLoans[i] = this.loan[i];
        }
        newLoans[this.loan.length] = loan;
        this.loan = newLoans;
        return true;
        }
        return false;
    }

    /**
     * Returns the library item given back to a library shelf
     * @param loaned a Loan objects that represents a loan that is tied with the library item
     * @param item a Library item that represents a item
     * @return a boolean whenever if returning the item back to a library shelf was successful or not
     */
    public boolean returnItem(Loan loaned, LibraryItem item){
        //Checks if the loan exists in the list and if it does removes the loan from the list 
        if (loaned != null && item != null && loaned.getLibraryItem().equals(item)){
            int itemIndex = -1;
            for (int i = 0; i < this.loan.length; i++){
                if (this.loan[i] != null && this.loan[i].equals(loaned)){
                    itemIndex = i;
                    i = this.loan.length;
                }
            }
       
        //Updates the loans if the loan existed in the list
            int currentIndex = 0;
            if (itemIndex != -1){
                Loan[] newLoans = new Loan[this.loan.length - 1];
                for (int i = 0; i < this.loan.length; i++){
                    if (i != itemIndex){
                    newLoans[currentIndex++] = this.loan[i];
                    }
                }
            this.loan = newLoans;
            boolean returned = assignLibrary.checkInItem(item);
            return returned;
            }
        }
        return false;
    }
    
    /**
     * Saves the loans of the current library items are out
     */
    public void saveLoans(){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter("savedLoan.txt"));
            for (int i = 0; i < loan.length; i++){
                writer.write(loan[i].toString());
                writer.newLine();
            }
            writer.write("Saved Date: " + LocalDate.now() + "\n");
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
            reader = new BufferedReader(new FileReader("savedLoan.txt"));
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
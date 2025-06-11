import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Creates a librarian
 */
class Librarian extends Person{
    private String librarianID;
    private Library assignLibrary;
    private Loan[] loan;

    /**
     * 
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
     * 
     * @return
     */
    public String getLibrarianID(){
        return this.librarianID;
    }

    public String giveItem(Loan loan, LibraryItem item){
     
        // Loan assignLoan = new Loan(member, LocalDate.now(), item);
          if (Library.findItem(item)){
           return "Item has been found";
        }
        else {
            return item.toString() + " is not currently available at this library";
        }
    }

    public String returnItem(Loan loan, LibraryItem item){
        
    }

    /**
     * 
     */
    public void saveLoans(){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter("loan.txt"));
            for (int i = 0; i < loan.length; i++){
                writer.write(loan[i].toString());
                writer.write("\n");
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
     * 
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
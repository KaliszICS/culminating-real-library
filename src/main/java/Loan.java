import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 */
class Loan{
    private Member member;
    private LibraryItem item;
    private LocalDate borrowedDate;

    /**
     * 
     * @param member a member that represents a library
     * @param borrowedDate the date when the library item was borrowed in the format: dd MMMM yyyy
     * @param item a LibraryItem that represents an item that is borrowed from the library
     */
    public Loan(Member member, LocalDate borrowedDate, LibraryItem item){
        this.member = member;
        this.borrowedDate = borrowedDate;
        this.item = item;
    }

    /**
     * 
     * @return returns the member that has the item on loaned
     */
    public Member getMember(){
        return this.member;
    }

    /**
     * 
     * @return a String that represents the date formated: dd MM yyyy, when the item was borrowed
     */
    public String getBorrowedDate(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String borrowDate = this.borrowedDate.format(dateFormat);
        return borrowDate;
    }

    /**
     * 
     * @return a LibraryItem that represents the item loaned from the library
     */
    public LibraryItem getLibraryItem(){
        return this.item;
    }

    /**
     * Assigns the due date of the Library item depending on what it is such as
     * a book has a 21 days borrowed limit, a magazine has a 7 days borrowed limit, and a DVD has a 14 days borrowed limit
     * @return a String that represents the due date of the given Library Item
     */
    public String dueDate(){
        LocalDate date = this.borrowedDate;
        if (item instanceof Book){
            date = date.plusDays(21);
        }
        else if (item instanceof Magazine){
            date = date.plusDays(7);
        }
        else{
            date = date.plusDays(14);
        }

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String returnDate = date.format(dateFormat);
        return returnDate;
    }

    /**
     * Determines the date of when the library member returns their library item back to the library
     * @return a String that represents today's date when the item was returned in the format: dd MMMM yyyy
     */
    public String returnDate(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String currentDate = date.format(dateFormat);
        return currentDate;
    }

    /**
     * Checks if the book returned is overdue or not
     * @return a boolean that represents if the item returned is overdue
     */
    public boolean OverDue(){
        String date = returnDate();
        int comparison = date.compareTo(getBorrowedDate());
        
        if (comparison >= 0){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Allows the member to pay off their library fine if they have enough money
     * @return a String that tells the user if their fine has been paid off or not
     */
    public String payFine(){
        double fine = item.getPrice();
        if (member.getCash() >= fine){
            fine = member.getCash() - fine;
            return "You have paid off your fine.";
        }
        else{
            double cashNeeded = fine - member.getCash();
            return "You are $" + cashNeeded + " short to paying off the fine.";
        }
    }
}
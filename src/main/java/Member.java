/**
 * Creates a Library member objet
 */
class Member extends Person{
    private String libraryCard;
    private LibraryItem[] borrowedItems;
    private double cash;

    /**
     * Constructs a library member
     * @param name a String that represents the member's name
     * @param age an integer that represents the member's age
     * @param phoneNumber a String that represents the member's phone number
     * @param email a String that represents the member's email
     * @param libraryCard a String that represents the member's library card
     * @param cash a double that represents the amount of cash that the member is carrying on them
     */
    public Member(String name, int age, String phoneNumber, String email, String libraryCard, double cash, LibraryItem[] borrowedItems){
        super(name, age, phoneNumber, email);
        this.libraryCard = libraryCard;
        this.cash = cash;
        this.borrowedItems = borrowedItems;
    }

    /**
     * Constructs a library member that by default has no money
     * The default cash for the member is 0 as they are not carrying any money on them
     * @param name a String that represents the member's name
     * @param age an integer that represents the member's age in years
     * @param phoneNumber a String that represents the member's phone mumber
     * @param email a String that represents the member's email
     * @param libraryCard a String that represents the member's library card
     */
     public Member(String name, int age, String phoneNumber, String email, String libraryCard, LibraryItem[] borrowedItems){
        super(name, age, phoneNumber, email);
        this.libraryCard = libraryCard;
        this.cash = 0;
        this.borrowedItems = borrowedItems;
    }

    /**
     * Gets the library member's library card
     * @return a String that represents the library Card
     */
    public String getLibraryCard(){
        return this.libraryCard;
    }

    /**
     * Gets the amount of money that the library member has
     * @return a double that represents how much money the member in dollars and cents
     */
    public double getCash(){
        return this.cash;
    }

    /**
     * Finds out how many items the library member currently loaned to them
     * @return an integer that represents the amount of items currently loaned
     */
    public int numOfItemsBorrowed(){
        return borrowedItems.length;
    }

    /**
     * Checks the due date of the library item if the loan corresponds to the member's library card and item
     * @param loan the loan that corresponds with the library item
     * @param item a LibraryItem that represents the library item on loan
     * @return a String that tells you when your library item is due
     */
    public String checkLoan(Loan loan, LibraryItem item){
        int index = -1;
        for (int i = 0; i < borrowedItems.length; i++){
            if (borrowedItems[i].equals(item)){
                index  = i;
                i = borrowedItems.length;
            }
        }
       

        if (index != -1 && loan.getMember().getLibraryCard().equals(getLibraryCard()) && loan.getLibraryItem().equals(item)){
            return "This item is due by " + loan.dueDate() + ", please make sure to return it by then otherwise penalty charges will be applied."; 
        }
        else{
            return "Either this item is not associated to your account or your loan does not match your current library item";
        }
    }

    /**
     * Allows the member to borrow an item from the library
     * @param Librarian a Librarian object that represents a librarian who works at the library
     * @param item a Libraryitem that represents an item that the member wants to borrow
     * @return a String value if the library item was successfully added to their acccount
     */
    public String borrowItem(Librarian Librarian, Loan loan, LibraryItem item){
        if (loan.getMember().getLibraryCard().equals(getLibraryCard()) && loan.getLibraryItem().equals(item)){
            if (Librarian.giveItem(loan, item) == true){
                LibraryItem[] newBorrowedList = new LibraryItem[borrowedItems.length + 1];
                for (int i = 0; i < borrowedItems.length; i++){
                    newBorrowedList[i] = borrowedItems[i];
                }
                newBorrowedList[borrowedItems.length] = item;
                return item.toString() + "was successfully added to your account";
            }
            else {
            return item.toString() + "is not currently available at this library";
            }
        }
        return "Either your loan is no associated to you or the loan provided did not match the library item being borrowed";
    }

    /**
     * Returns the library item that a member has on their account back to the library and removes the item off their account
     * @param Librarian a Librarian object that represents the librarian that works at the library
     * @param loan a Loan object that represents the loan that is associated with the library item and library card
     * @param item a LibraryItem object that represents the item being returned
     * @return a String that will tell the member what the outcome was of trying to return the item
     */
    public String returnItem(Librarian Librarian, Loan loan, LibraryItem item){
        if (loan.getMember().getLibraryCard().equals(getLibraryCard()) && loan.getLibraryItem().equals(item)){
            if(Librarian.returnItem(loan, item) == true){
                int index = -1;
                for (int i = 0; i < borrowedItems.length; i++){
                    if (borrowedItems[i].equals(item)){
                        index = i;
                        i = borrowedItems.length;
                    }
                }
                if (index == -1){
                    return "Library item was not found in your account";
                }   

                LibraryItem[] newBorrowedList = new LibraryItem[borrowedItems.length - 1];
                int currentIndex = 0;
                for (int i = 0; i < borrowedItems.length; i++){
                    if (index != i){
                        newBorrowedList[currentIndex++] = borrowedItems[i];
                    }
                }
                borrowedItems = newBorrowedList;

                //check for fine
                if(loan.OverDue()){
                    loan.payFine();
                }
                else{
                    return "Your library item has been succesfully return, no fine has been imposed.";
                }
            }
            return "Your loan was not found in the list of loans provided to the Librarian, therefore cannot return this library item";
        }
        return "Item cannot be returned because the loan doesn't match the item currently being retured.";
    }
}
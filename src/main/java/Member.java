/**
 * Creates a Library member 
 */
class Member extends Person{
    private String libraryCard;
    private LibraryItems[] borrowedItems;
    private double cash;

    /**
     * Creates a library member that
     * @param name a String that represents the member's name
     * @param age an integer that represents the member's age
     * @param phoneNumber a String that represents the member's phone number
     * @param email a String that represents the member's email
     * @param libraryCard a String that represents the member's library card
     * @param cash a double that represents the amount of cash that the member is carrying on them
     */
    public Member(String name, int age, String phoneNumber, String email, String libraryCard, double cash){
        super(name, age, phoneNumber, email);
        this.libraryCard = libraryCard;
        this.cash = cash;
    }


    /**
     * Creates a library member that
     * The default cash for the member is 0 as they are not carrying any money on them
     * @param name a String that represents the member's name
     * @param age an integer that represents the member's age in years
     * @param phoneNumber a String that represents the member's phone mumber
     * @param email a String that represents the member's email
     * @param libraryCard a String that represents the member's library card
     */
     public Member(String name, int age, String phoneNumber, String email, String libraryCard){
        super(name, age, phoneNumber, email);
        this.libraryCard = libraryCard;
        this.cash = 0;
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
     * 
     * @param loan
     * @param item
     * @return
     */
    public String checkLoan(Loan loan, LibraryItem item){

    }

    /**
     * 
     * @param Librarian
     * @param loan
     * @param item
     * @return
     */
    public String borrowItem(Librarian Librarian, LibraryItem item){
        if (Librarian.giveItem(item).equals("Item has been found")){
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

    /**
     * 
     * @param Librarian
     * @param loan
     * @param item
     * @return
     */
    public String returnItem(Librarian Librarian, Loan loan, LibraryItem item){
        Librarian.returnItem(item);
        int index = -1;
        for (int i = 0; i < borrowedItems.length; i++){
            if (borrowedItems[i].equals(item) && borrowedItems[i].getTitle().equals(item.getTitle()) && borrowedItems[i].getAuthor().equals(item.getAuthor()) && borrowedItems[i].getDescription().equals(item.getDescription()) && borrowedItems[i].getYearPublish() == item.getYearPublish() && borrowedItems[i].getGenre().equals(item.getGenre()) && borrowedItems[i].getPrice() == item.getPrice()){
                    index = i;
                    i = borrowedItems.length;
            }
        }

        LibraryItem[] newBorrowedList = new LibraryItem[borrowedItems.length - 1];
        int currentIndex = 0;
        for (int i = 0; i < borrowedItems.length; i++){
            if (index != i){
                newBorrowedList[currentIndex++] = borrowedItems[i];
            }
        }
        borrowedItems = newBorrowedList;
        return item.toString() + " was successfully returned.";
    }
}
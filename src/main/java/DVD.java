public class DVD extends LibraryItem{
    private int length;

    public DVD (String title, String author, String description, int yearPublish, String genre, double price){
    super(title,author,description, yearPublish, genre, price);
    this.length = length;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Duration: " + length);
    }
}
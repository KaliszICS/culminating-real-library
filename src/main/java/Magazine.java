public class Magazine extends LibraryItem{
    private int magazinePages;

    public Magazine (String title, String author, String description, int yearPublish, String genre, double price){
    super(title,author,description, yearPublish, genre, price);
    this.magazinePages = magazinePages;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Pages: " + magazinePages);
    }
}
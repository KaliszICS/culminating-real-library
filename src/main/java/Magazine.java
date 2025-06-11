/**
 * The Magazine class represents a magazine in the library.
 * It extends LibraryItem and adds the number of pages specific to the magazine.
 */
public class Magazine extends LibraryItem{
    private int magazinePages;
    private int ISSN;

<<<<<<< HEAD
    /**
     * Constructs a Magazine with the given details.
     *
     * @param title           The title of the magazine.
     * @param author          The author/editor of the magazine.
     * @param description     A brief description of the magazine.
     * @param yearPublish     Year the magazine was published.
     * @param genre           The genre of the magazine.
     * @param price           The price of the magazine.
     * @param magazinePages   Number of pages in the magazine.
     */
    public Magazine (String title, String author, String description, int yearPublish, String genre, double price, int magazinePages){
    super(title,author,description, yearPublish, genre, price);
    this.magazinePages = magazinePages;
=======
    public Magazine (String title, String author, String description, int yearPublish, String genre, double price, int magazinePages, int ISSN){
        super(title,author,description, yearPublish, genre, price);
        this.magazinePages = magazinePages;
        this.ISSN = ISSN;
    }

    public int getMagazinePages(){
        return this.magazinePages;
    }

    public int getISSN(){
        return this.ISSN;
>>>>>>> 1dea00b (WIP #3)
    }

    /**
     * Displays information about the magazine, including the number of pages.
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Magazine magazine = (Magazine)obj;
        if(magazine.getTitle().equals(this.getTitle()) && magazine.getAuthor().equals(this.getAuthor()) && magazine.getDescription().equals(this.description) && magazine.getYearPublish() == this.getYearPublish() && magazine.getGenre().equals(this.genre) && magazine.getPrice() == this.price && magazine.getMagazinePages() == this.magazinePages && magazine.getISSN() == this.ISSN){
            return true;
        }
        return false;
    }
}
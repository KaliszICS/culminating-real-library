/**
 * The Magazine class represents a magazine in the library.
 * It extends LibraryItem and adds the number of pages specific to the magazine.
 */
public class Magazine extends LibraryItem{
    private int magazinePages;
    private int ISSN;

    /**
     * Constructs a Magazine with the given details.
     * @param title a String that represents the title of the magazine
     * @param author a String that represents the author of the magazine
     * @param description a String that represents the description of the magazine
     * @param yearPublish a integer that represents the year the magazine was published
     * @param genre a String that represents the genre of the magazine
     * @param price a double that represents the price of the magazine
     * @param magazinePages a integer that represents the number of pages in the magazine
     * @param ISSN an integer that represents the International Standard Serial Number (ISSN) of the magazine
     */
    public Magazine (String title, String author, String description, int yearPublish, String genre, double price, int magazinePages, int ISSN){
        super(title,author,description, yearPublish, genre, price);
        this.magazinePages = magazinePages;
        this.ISSN = ISSN;
    }

    /**
     * Gets the number of pages in the magazine
     * @return a integer that represents the number of pages in the magazine
     */
    public int getMagazinePages(){
        return this.magazinePages;
    }

    /**
     * Gets the ISSN of the magazine
     * @return a integer that represents the ISSN of the magazine
     */
    public int getISSN(){
        return this.ISSN;
    }

    /**
     * Checks to see if the magazine is equal to another object
     * @param obj the object being compared
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Magazine magazine = (Magazine)obj;
        if(magazine.getTitle().toLowerCase().equals(this.getTitle().toLowerCase()) && magazine.getAuthor().toLowerCase().equals(this.getAuthor().toLowerCase()) && magazine.getDescription().toLowerCase().equals(this.description.toLowerCase()) && magazine.getYearPublish() == this.getYearPublish() && magazine.getGenre().toLowerCase().equals(this.genre.toLowerCase()) && magazine.getPrice() == this.price && magazine.getMagazinePages() == this.magazinePages && magazine.getISSN() == this.ISSN){
            return true;
        }
        return false;
    }
}
/**
 * The DVD class represents a DVD in the library.
 * It extends LibraryItem and adds the length (duration) of the DVD.
 */
public class DVD extends LibraryItem{
    private int length;
    private String dvdID;

    /**
     * Constructs a DVD with the given details.
     * @param title a String that represents the title of the DVD
     * @param author a Stirng that represents the author of the DVD
     * @param description a String that represents the description of the DVD
     * @param yearPublish a integer that represents the year the DVD was published
     * @param genre a String that represents the genre of the DVD
     * @param price a double that represents the price of the DVD
     * @param length a integer that represents the length of the DVD in minutes
     * @param dvdID a String that represents the DVD unique identification
     */
    public DVD (String title, String author, String description, int yearPublish, String genre, double price, int length, String dvdID){
        super(title,author,description, yearPublish, genre, price);
        this.length = length;
        this.dvdID = dvdID;
    }

    /**
     * Gets the duration of the DVD in minutes
     * @return an integer that represents the duration of the DVD in minutes
     */
    public int getLength(){
        return this.length;
    }

    /**
     * Gets the DVD identification
     * @return a String that represents the DVD identification
     */
    public String getDVDid(){
        return this.dvdID;
    }

    /**
     * Checks to see if the DVD is equal to the other object
     * @param obj the object being compared
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        DVD dvd = (DVD)obj;
        if(dvd.getTitle().toLowerCase().equals(this.getTitle().toLowerCase()) && dvd.getAuthor().toLowerCase().equals(this.getAuthor().toLowerCase()) && dvd.getDescription().toLowerCase().equals(this.description.toLowerCase()) && dvd.getYearPublish() == this.getYearPublish() && dvd.getGenre().toLowerCase().equals(this.genre.toLowerCase()) && dvd.getPrice() == this.price && dvd.getLength() == this.length && dvd.getDVDid().toLowerCase().equals(this.dvdID.toLowerCase())){
            return true;
        }
        return false;
    }
}
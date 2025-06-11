/**
 * The DVD class represents a DVD in the library.
 * It extends LibraryItem and adds the length (duration) of the DVD.
 */
public class DVD extends LibraryItem{
    private int length;
    private String dvdID;

<<<<<<< HEAD
    /**
     * Constructs a DVD with the given details.
     *
     * @param title         The title of the DVD.
     * @param author        The creator/director of the DVD.
     * @param description   A brief description of the DVD.
     * @param yearPublish   Year the DVD was published.
     * @param genre         The genre of the DVD.
     * @param price         The price of the DVD.
     * @param length        The length (duration) of the DVD in minutes.
     */
    public DVD (String title, String author, String description, int yearPublish, String genre, double price, int length) {
    super (title, author, description, yearPublish, genre, price);
    this.length = length;
=======
    public DVD (String title, String author, String description, int yearPublish, String genre, double price, int length, String dvdID){
        super(title,author,description, yearPublish, genre, price);
        this.length = length;
        this.dvdID = dvdID;
    }

    public int getLength(){
        return this.length;
    }

    public String getDVDid(){
        return this.dvdID;
>>>>>>> 1dea00b (WIP #3)
    }

    /**
     * Displays information about the DVD, including the duration.
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        DVD dvd = (DVD)obj;
        if(dvd.getTitle().equals(this.getTitle()) && dvd.getAuthor().equals(this.getAuthor()) && dvd.getDescription().equals(this.description) && dvd.getYearPublish() == this.getYearPublish() && dvd.getGenre().equals(this.genre) && dvd.getPrice() == this.price && dvd.getLength() == this.length && dvd.getDVDid().equals(this.dvdID)){
            return true;
        }
        return false;
    }
}
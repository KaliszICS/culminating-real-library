/**
 * A blueprint for a person that is used to either create a Librarian or Member
 */
abstract class Person{
    private String name;
    private int age;
    private String phoneNumber;
    private String email;

    /**
     * Constructs a person with a name, age, phone number, and email
     * @param name a String that represents the person's first and last name
     * @param age an integer that represents the person's age in years
     * @param phoneNumber a String that represents
     * @param email a String that represents the person's email
     */
    public Person(String name, int age, String phoneNumber, String email){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    /**
     * Gets the person's name
     * @return a String that represents the person's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the person's age
     * @return an integer that represents the person's age
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Gets the person's phone number
     * @return a String that represents the person's phone number
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     * Gets the person's email
     * @return a String that represents the person's email
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Sets a String value to phone number
     * @param newPhoneNumber a String that represents a new phone number
     */
    public void setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
    }

    /**
     * Sets a String value to email
     * @param newEmail a String that represents a new email
     */
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
}
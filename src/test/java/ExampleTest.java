import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.beans.Transient;
import java.io.*;

public class ExampleTest {

   @Test
   public void testLibraryItems(){
      DVD item1 = new DVD("Blue days", "Human a", "The sky is blue.", 2000, "horror", 19.00, 60, "AGGAS2GDX");
      assertEquals("Blue days",item1.getTitle());
      assertEquals("Human a",item1.getAuthor());
      assertEquals("The sky is blue.",item1.getDescription());
      assertEquals(2000,item1.getYearPublish());
      assertEquals("horror",item1.getGenre());
      assertEquals(19.00,item1.getPrice());
      assertEquals(60,item1.getLength());
      assertEquals("AGGAS2GDX", item1.getDVDid());

      Magazine item2 = new Magazine("Top 10 Potatoes", "Potato", "Its just a potato", 1983, "Classic", 2.00, 20, 1244232);
      assertEquals("Top 10 Potatoes",item2.getTitle());
      assertEquals("Potato",item2.getAuthor());
      assertEquals("Its just a potato",item2.getDescription());
      assertEquals(1983,item2.getYearPublish());
      assertEquals("Classic",item2.getGenre());
      assertEquals(2.00,item2.getPrice());
      assertEquals(20,item2.getMagazinePages());
      assertEquals(1244232, item2.getISSN());

      Book item3 = new Book("Need Sleep", "Anzg Aka", "Can I sleep now?", 2007, "Self-help", 100.00, 512, "1GAS312F");
      assertEquals("Need Sleep",item3.getTitle());
      assertEquals("Anzg Aka",item3.getAuthor());
      assertEquals("Can I sleep now?",item3.getDescription());
      assertEquals(2007,item3.getYearPublish());
      assertEquals("Self-help",item3.getGenre());
      assertEquals(100.00,item3.getPrice());
      assertEquals(512,item3.getBookPages());
      assertEquals("1GAS312F", item3.getISBN());
   }

   @Test
   public void testShelf(){
      DVD item1 = new DVD("Blue days", "Human a", "The sky is blue.", 2000, "horror", 19.00, 60, "AGGAS2GDX");
      Magazine item2 = new Magazine("Top 10 Potatoes", "Potato", "Its just a potato", 1983, "classic", 2.00, 20, 1244232);
      Book item3 = new Book("Need Sleep", "Anzg Aka", "Can I sleep now?", 2007, "Self-help", 100.00, 512, "1GAS312F");
      LibraryItem[] storedItems = {item1, item2};

      Shelf shelf1 = new Shelf("Cantilever-style", 1, storedItems);
      assertEquals("Cantilever-style", shelf1.getShelfType());
      assertEquals(1, shelf1.getMaxCapacity());
      assertEquals(0, shelf1.getItemsStored());
      assertEquals(true, shelf1.addItem(item3));
      assertEquals(false, shelf1.removeItem(item1));
      assertEquals(true, shelf1.removeItem(item3));

      Shelf shelf2 = new Shelf("Cantilever-style", 10, storedItems);
      assertEquals(2, shelf2.getItemsStored());
      assertEquals(1, shelf2.findItem(item2));
      assertEquals(-1, shelf2.findItem(item3));
      assertEquals(true, shelf2.addItem(item3));
      assertEquals(3, shelf2.getItemsStored());
      assertEquals(false, shelf2.addItem(null));
      shelf2.organizeByTitle();
      assertEquals(item1, shelf2.getItems()[0]);
      shelf2.organizeByAuthors();
      assertEquals(item3, shelf2.getItems()[0]);
      shelf2.organizeByGenre();
      assertEquals(item2, shelf2.getItems()[0]);
   }

   @Test
   public void testLibrary(){
      DVD item1 = new DVD("Blue days", "Human a", "The sky is blue.", 2000, "horror", 19.00, 60, "AGGAS2GDX");
      Magazine item2 = new Magazine("Top 10 Potatoes", "Potato", "Its just a potato", 1983, "classic", 2.00, 20, 1244232);
      Book item3 = new Book("Need Sleep", "Anzg Aka", "Can I sleep now?", 2007, "Self-help", 100.00, 512, "1GAS312F");
      Book item4 = new Book("Need Sleep pls", "Anzg Aka", "Can I sleep now?", 2007, "Self-help", 100.00, 512, "1GAS312F");
      LibraryItem[] storedItems1 = {item1, item2};
      LibraryItem[] storedItems2 = {item3};

      Shelf shelf1 = new Shelf("Single-style", 3, storedItems1);
      Shelf shelf2 = new Shelf("dantilever-style", 4, storedItems2);
      Shelf[] shelves1 = {shelf1, shelf2};

      Library library1 = new Library();
      assertEquals(0, library1.getShelves().length);
      library1.addShelf(shelf1);
      assertEquals(1, library1.getShelves().length);

      Library library2 = new Library(shelves1);
      assertEquals(2, library2.getShelves().length);
      assertEquals(1, library2.findItem(item3));
      assertEquals(-1, library2.findItem(item4));
      library2.saveLibraryFile();
      library1.saveLibraryFile();
      library2.organizeLibraryShelves();
      assertEquals(shelf2, library2.getShelves()[0]);
      assertEquals(3, library2.totalAvailableItems());
      assertEquals(true, library2.checkInItem(item4));
      assertEquals(true, library2.checkOutItem(item1));
      assertEquals(false, library2.checkOutItem(item1));
   }

   // @Test
   // public void testCreationPeople(){

   // }
   // @Test
   // public void testCreationPeople(){

   // }
   // @Test
   // public void testOutput()
   // {
   //   PrintStream originalOut = System.out;
   //   ByteArrayOutputStream bos = new ByteArrayOutputStream();
   //   System.setOut(new PrintStream(bos));

   //   // action
   //   PracticeProblem.q1();

   //   // assertion
   //   assertEquals("There once was a man from St. Ives.\n", bos.toString());

   //   // undo the binding in System
   //   System.setOut(originalOut);
   // }

   // @Test
   // public void testInputandOutput()
   // {
   //    String data = "Users Input";
   //    System.setIn(new ByteArrayInputStream(data.getBytes()));
      
   //    PrintStream originalOut = System.out;
   //    ByteArrayOutputStream bos = new ByteArrayOutputStream();
   //    System.setOut(new PrintStream(bos));

   //    // action
   //    PracticeProblem.q1();

   //    // assertion
   //    assertEquals("There once was a man from St. Ives.\n", bos.toString());

   //    // undo the binding in System
   //    System.setOut(originalOut);
   // }

   // @Test
   // public void testQ3()
   // {
   //   int num = 5;
   //    assertEquals(5, num);
   // }
}

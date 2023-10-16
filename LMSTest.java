import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LMSTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook(new Book("1", "Harry Potter and the Philosopher's Stone", "J. K. Rowling"));
        library.addBook(new Book("2", "Rich Dad Poor Dad", "Robert Kiyosaki"));
    }





    @Test
    public void testRemoveBookByBarcode() {
        assertTrue(library.removeBookByBarcode("1"));
        assertNull(library.findBookByTitle("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void testRemoveBookByTitle() {
        assertTrue(library.removeBookByTitle("Rich Dad Poor Dad"));
        assertNull(library.findBookByTitle("Rich Dad Poor Dad"));
    }

    @Test
    public void testCheckOutBook() {
        library.checkOutBook("Rich Dad Poor Dad");
        assertFalse(library.findBookByTitle("Rich Dad Poor Dad").isAvailable());

    }

    @Test
    public void testCheckInBook() {
        Book book = library.findBookByTitle("Harry Potter and the Philosopher's Stone");
        assertNotNull(book);
        library.checkOutBook("Harry Potter and the Philosopher's Stone");
        library.checkInBook("Harry Potter and the Philosopher's Stone");
        assertTrue(book.isAvailable());
    }

}

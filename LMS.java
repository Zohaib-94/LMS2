import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LMS {
    public static void main(String[] args) {
        Library library = new Library();


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ahmadzai\\IdeaProjects\\BookStore1\\src\\library_books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();


                    Book book = new Book(id, title, author);
                    library.addBook(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Books in the Library:");
        library.listAllBooks();


        String bookIdToRemove = "1";
        library.removeBookById(bookIdToRemove);


        System.out.println("\nOnce book has been removed with ID " + bookIdToRemove + ":");
        library.listAllBooks();
    }
}

import java.util.List;
import java.util.ArrayList;


public class Library {
    private List<Book> books;


    public Library() {
        books = new ArrayList<>();
    }


    public void addBook(Book book) {
        books.add(book);
    }


    public void removeBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                books.remove(book);
                return;
            }
        }
    }


    public void listAllBooks() {
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Available: " + book.isAvailable());
        }
    }


}
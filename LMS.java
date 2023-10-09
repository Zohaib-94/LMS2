import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class LMS {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please enter the file name inorder to load the books: ");
        String fileName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Ahmadzai\\IdeaProjects\\BookStore1\\src\\library_books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String barcode = parts[0].trim();
                    String title = parts[1].trim();
                    String author = parts[2].trim();

                    Book book = new Book(barcode, title, author);
                    library.addBook(book);
                }
            }
            System.out.println("Books which loaded from the file.");
        } catch (IOException e) {
            System.err.println("Error reading this file: " + e.getMessage());
        }

        while (true) {
            System.out.println("\nLMS Menu:");
            System.out.println("1. List the Library contents");
            System.out.println("2. Remove a Book by the Barcode");
            System.out.println("3. Remove a Book by the Title");
            System.out.println("4. Check Out a Book");
            System.out.println("5. Check In a Book");
            System.out.println("6. Exit");
            System.out.print("Please enter your next choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Printing the library status :");
                    library.printLibrary();
                    break;
                case 2:
                    System.out.print("Enter the barcode to remove: ");
                    String barcodeToRemove = scanner.nextLine();
                    if (library.removeBookByBarcode(barcodeToRemove)) {
                        System.out.println("Book with barcode " + barcodeToRemove + " removed.");
                    } else {
                        System.out.println("Book with barcode " + barcodeToRemove + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    if (library.removeBookByTitle(titleToRemove)) {
                        System.out.println("Book with title \"" + titleToRemove + "\" removed.");
                    } else {
                        System.out.println("Book with title \"" + titleToRemove + "\" not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the title to check out: ");
                    String titleToCheckOut = scanner.nextLine();
                    library.checkOutBook(titleToCheckOut);
                    System.out.println("Book with title \"" + titleToCheckOut + "\" checked out.");
                    break;
                case 5:
                    System.out.print("Enter the title to check in: ");
                    String titleToCheckIn = scanner.nextLine();
                    library.checkInBook(titleToCheckIn);
                    System.out.println("Book with title \"" + titleToCheckIn + "\" checked in.");
                    break;
                case 6:
                    System.out.println("Leaving LMS. Bye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Incorrect choice. Please enter the right option.");
                    break;
            }
            System.out.println("\nLibrary Status:");
            library.printLibrary();
        }
    }
}

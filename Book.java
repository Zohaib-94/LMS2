// Zohaib Ahmadzai
// CEN-3024C
// 10/08/2023

// Created book class with Barcode, Title and Author
public class Book {
    private String barcode;
    private String title;
    private String author;
    private boolean available;

    public Book(String barcode, String title, String author) {
        this.barcode = barcode;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Barcode: " + barcode + " | Title: " + title + " | Author: " + author + " | Available: " + available;
    }
}

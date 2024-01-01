import java.util.HashMap;
import java.util.Map;

public class BookLibrary {

    private static BookLibrary instance;  // Singleton instance
    private final Map<Book, Integer> bookInventory;

    // Private constructor to prevent instantiation
    private BookLibrary() {
        this.bookInventory = new HashMap<>();
    }

    // Method to get the singleton instance
    public static BookLibrary getInstance() {
        if (instance == null) {
            instance = new BookLibrary();
        }
        return instance;
    }

    // Registering a new book in the library
    public void registerBook(Book book, int quantity) {
        int currentQuantity = bookInventory.getOrDefault(book, 0);
        bookInventory.put(book, currentQuantity + quantity);
        System.out.println("Registered " + quantity + " copies of '" + book.getName() + "' in the library.");
    }

    // Retrieving a book from the library (borrowing)
    public void borrowBook(Book book){
        Book matchingBook = findMatchingBook(book);

        if (matchingBook != null) {
            int currentQuantity = bookInventory.get(matchingBook);
            if (currentQuantity == 1){
                bookInventory.remove(matchingBook);
            }
            else bookInventory.put(matchingBook, currentQuantity - 1);
            System.out.println("Borrowed '" + matchingBook.getName() + "' from the library.");
            System.out.println("Thank you for borrowing a book!");
        } else {
            System.out.println("'" + book.getName() + "' is currently not available in the library.");
        }
    }

    // Helper method to find a matching book based on name and author
    private Book findMatchingBook(Book bookToFind) {
        for (Book book : bookInventory.keySet()) {
            if (book.getName().equals(bookToFind.getName()) && book.getAuthor().equals(bookToFind.getAuthor())) {
                return book;
            }
        }
        return null;
    }


    // Returning a book to the library
    public void returnBook(Book book) {

        Book matchingBook = findMatchingBook(book);
        if (matchingBook == null) matchingBook = book;

        int currentQuantity = bookInventory.getOrDefault(matchingBook, 0);
        bookInventory.put(matchingBook, currentQuantity + 1);
        System.out.println("Returned '" + book.getName() + "' to the library.");
    }

    public void displayInventory() {
        String bold = "\u001B[1m";
        String italic = "\u001B[3m";
        String resetFormat = "\u001B[0m";

        System.out.println("Current Library Inventory:");

        bookInventory.forEach((book, quantity) -> {
            String formattedTitle = italic + bold + book.getName() + resetFormat;
            String formattedAuthor = bold + book.getAuthor() + resetFormat;

            System.out.println("'" + formattedTitle + "' by " + formattedAuthor +
                    " - Available Copies: " + quantity);
        });
    }
}

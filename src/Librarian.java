import java.util.InputMismatchException;
import java.util.Scanner;

public class Librarian {

    private static final BookLibrary library = BookLibrary.getInstance();
    private static final Scanner scanner = new Scanner(System.in);
    //Method to create few books and registers them to library inventory.
    public void createAndFillLibrary() {
        Book book1 = new Book("The Great Gatsby", 25.0, "F. Scott Fitzgerald", 1925, "9780743273565");
        Book.SignedBook book2 = new Book.SignedBook("To Kill a Mockingbird", 30.0, "Harper Lee", 1960, "0446310786");
        Book.VintageBook book3 = new Book.VintageBook("1984", 20.0, "George Orwell", 1949, "9780451524935",50);

        library.registerBook(book1, 5);
        library.registerBook(book2, 3);
        library.registerBook(book3, 1);

        System.out.println("Library has been created and filled with books.");
    }
    // Starting the interaction with user
    public void startInteraction(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrarian Menu:");
            System.out.println("1. List Books in the Library");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());


                switch (choice) {
                    case 1:
                        library.displayInventory();
                        break;
                    case 2:
                        borrowBook();
                        break;
                    case 3:
                        returnBook();
                        break;
                    case 4:
                        System.out.println("Exiting Librarian. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");

                }
            }
            catch (NumberFormatException  e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    // Retrieving a book from the library (borrowing)
    private void borrowBook() {
        System.out.print("Enter the name of the book you want to borrow: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        Book bookToBorrow = new Book(bookName, 0, author, 0, "0");
        library.borrowBook(bookToBorrow);

    }
    // Returning a book to the library
    private void returnBook() {
        System.out.print("Enter the name of the book you are returning: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        Book bookToReturn = new Book(bookName, 0, author, 0, "0");
        library.returnBook(bookToReturn);
        System.out.println("Thank you for returning the book!");
    }
}

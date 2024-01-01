## There are 3 Main classes


- Book
- BookLibrary
- Librarian

## Book Class


The Book class represents a basic book entity with 
essential attributes such as name, value, author, publication year, and 
ISBN (International Standard Book Number). It includes a constructor to 
initialize these attributes and getter methods to retrieve the values.

It contains this fields

- **name** (String): The name/title of the book.
- **value** (double): The monetary value of the book.
- **author** (String): The author of the book.
- **publicationYear** (int): The year the book was published.
- **isbn** (String): The ISBN (International Standard Book Number) of the book.

For all the fields there is also a getter method

- getName() - Returns the name of the book.
- getValue() - Returns the monetary value of the book.
- getAuthor() - Returns the author of the book.
- getPublicationYear() - Returns the publication year of the book.
- getIsbn() - Returns the ISBN of the book

There are also 2 subclasses

- SignedBook - Extends Book class. Represents a signed version of a book with double value.
- VintageBook - Also extends Book class. Represents a vintage version of a book with value based on age.

## BookLibrary Class

The BookLibrary class represents a simple library system for managing book inventory. 
It follows the Singleton pattern, ensuring that only one instance of the library exists. 
The library maintains a collection of books and their quantities. Users can register 
new books, borrow books, return books, and display the current inventory.

There are 2 fields

- instance - Singleton instance of the BookLibrary class
- bookInventory - Represents the inventory of books in the library, where Book object is a key and value is the quantity available

There are 6 methods

- getInstance() - Returns the singleton instance of BookLibrary class.
- registerBook(Book book, int quantity) - Registers new book in teh library with specified quantity.
- borrowBook(Book book) - Borrows a book from the library.
- returnBook(Book book) - Returns a book to the library.
- displayInventory() - Display the current inventory of books in formatted manner.
- findMachingBook(Book bookToFind) - Private helper method to find a matching book based on name and author.

## Librarian Class

The Librarian class is responsible for interacting with the BookLibrary system. 
It provides methods for creating and filling the library with initial books, as 
well as handling user interactions through a console-based menu.

It has 2 fields

- library - Singleton instance of the BookLibrary class to manage the book inventory
- scanner - Scanner object for user input

There are 4 methods

- createAndFillLibrary() - Creates and fills the library with initial books during the initialization of the Librarian object
- startInteraction() - Initiates the Librarian menu for user interactions, including options to list books, borrow a book, return a book, or exit the program.
- borrowBook() - Collects user input for borrowing a book and invokes the borrowBook method of the BookLibrary class.
- returnBook() - Collects user input for returning a book and invokes the returnBook method of the BookLibrary class.
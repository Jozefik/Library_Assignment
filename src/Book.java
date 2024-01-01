public class Book {
    private final String name;
    private final double value;
    private final String author;
    private final int publicationYear;
    private final String isbn;

    public Book(String name, double value, String author, int publicationYear, String isbn) {
        this.name = name;
        this.value = value;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }


    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public static class SignedBook extends Book{
        public SignedBook(String name, double value, String author, int publicationYear, String isbn) {
            super(name, 2 * value, author, publicationYear, isbn);
        }
    }

    public static class VintageBook extends Book{

        public VintageBook(String name, double value, String author, int publicationYear, String isbn, int age) {
            super(name, calculateVintageValue(value,age), author, publicationYear, isbn);

        }
        public static double calculateVintageValue(double originalValue, int age) {
            // Adjust value based on age, for example, decrease by 10% for each decade
            return originalValue * Math.pow(0.9, age / 10.0);
        }

    }
}

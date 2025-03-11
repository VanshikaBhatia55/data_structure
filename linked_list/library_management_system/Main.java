package data_structure.linked_list.library_management_system;

public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books
        library.addBookAtBeginning(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101));
        library.addBookAtEnd(new Book("1984", "George Orwell", "Dystopian", 102));
        library.addBookAtPosition(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 103), 2);

        // Display all books in forward order
        System.out.println("Books in forward order:");
        library.displayBooksForward();

        // Display all books in reverse order
        System.out.println("\nBooks in reverse order:");
        library.displayBooksReverse();

        // Search for a book by title
        System.out.println("\nSearching for book with title '1984':");
        library.searchByTitle("1984");

        // Search for a book by author
        System.out.println("\nSearching for books by author 'Harper Lee':");
        library.searchByAuthor("Harper Lee");

        // Update availability of a book
        System.out.println("\nUpdating availability of Book ID 101 to Not Available:");
        library.updateAvailability(101, false);
        library.displayBooksForward();

        // Remove a book by ID
        System.out.println("\nRemoving Book ID 102:");
        library.removeBookById(102);
        library.displayBooksForward();

        // Count total number of books
        System.out.println("\nTotal number of books in the library: " + library.countBooks());
    }
}

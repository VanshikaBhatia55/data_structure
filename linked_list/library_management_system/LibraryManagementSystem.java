package data_structure.linked_list.library_management_system;

public class LibraryManagementSystem {
    private Book head;
    private Book tail;

    // Check if the library is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add a book at the beginning of the list
    public void addBookAtBeginning(Book book) {
        if (isEmpty()) {
            head = book;
            tail = book;
        } else {
            book.next = head;
            head.prev = book;
            head = book;
        }
    }

    // Add a book at the end of the list
    public void addBookAtEnd(Book book) {
        if (isEmpty()) {
            head = book;
            tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
    }

    // Add a book at a specific position
    public void addBookAtPosition(Book book, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addBookAtBeginning(book);
        } else {
            Book temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
                if (temp == null) {
                    System.out.println("Position out of range.");
                    return;
                }
            }
            book.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = book;
            }
            temp.next = book;
            book.prev = temp;
            if (book.next == null) {
                tail = book;
            }
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next;
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            } else {
                tail = temp.prev;
            }
            System.out.println("Book with ID " + bookId + " removed.");
        }
    }

    // Search for a book by Book Title
    public void searchByTitle(String title) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    // Search for a book by Author
    public void searchByAuthor(String author) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book found: " + temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Book by author '" + author + "' not found.");
        }
    }

    // Update a book's availability status
    public void updateAvailability(int bookId, boolean isAvailable) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID " + bookId + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}


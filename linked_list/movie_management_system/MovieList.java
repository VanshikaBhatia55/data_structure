package data_structure.linked_list.movie_management_system;

public class MovieList {
    private MovieNode head;
    private MovieNode tail;

    public MovieList() {
        this.head = null;
        this.tail = null;
    }

    // Method to add a movie to the end of the list
    public void addMovie(String movieTitle, String director, int yearOfRelease, float rating, int index) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);

        // If the list is empty, add the movie as the first node
        if (head == null) {
            if (index == 0) {
                head = newNode;
                tail = newNode;
            } else {
                throw new IndexOutOfBoundsException("Index is out of bounds. List is empty.");
            }
            return;
        }

        // If index is 0, add at the beginning
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }

        // Traverse to the node at the specified index
        MovieNode current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        // If the index is out of bounds, throw an exception
        if (current == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        // Insert the new node
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            // If inserting at the end, update the tail
            tail = newNode;
        }
        current.next = newNode;
    }
    // Method to remove a movie by its title
    public void removeMovie(String movieTitle) {
        MovieNode current = head;
        while (current != null) {
            if (current.movieTitle.equals(movieTitle)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + movieTitle);
    }

    // Method to display all movies in the list
    public void displayMovies() {
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.movieTitle + ", Director: " + current.director +
                    ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }
    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.movieTitle + ", Director: " + current.director +
                    ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Method to search for a movie by its title
    public MovieNode searchMovie(String titleOrDirector) {
        MovieNode current = head;
        while (current != null) {
            if (current.movieTitle.equals(titleOrDirector)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateRating(String title, float newRating){
        MovieNode current =head;
        while(!current.movieTitle.equals(title)){
            current=current.next;
        }
        current.rating=newRating;
    }
}
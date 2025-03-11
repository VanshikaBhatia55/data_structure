package data_structure.linked_list.movie_management_system;

public class Main {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();

        // Adding movies
        movieList.addMovie("Inception", "Christopher Nolan", 2010, 8.8f, 0); // Add at index 0
        movieList.addMovie("The Dark Knight", "Christopher Nolan", 2008, 9.0f, 1); // Add at index 1
        movieList.addMovie("Interstellar", "Christopher Nolan", 2014, 8.6f, 1); // Add at index 1

        // Displaying movies
        movieList.displayMovies();

        movieList.removeMovie("Inception");

        movieList.displayReverse();

        movieList.addMovie("Justice league","Jack Snider" , 2019, 7.5f , 2);

        movieList.searchMovie("Jack Snider");
        movieList.searchMovie("Justice league");

        movieList.updateRating("Interstellar" , 9.8f);

        movieList.displayMovies();

    }
}
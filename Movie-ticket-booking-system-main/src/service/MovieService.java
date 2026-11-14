package service;

import model.Movie;
import util.Utility;

import java.util.ArrayList;

/**
 * MovieService handles all operations related to movies,
 * including initialization of sample movies, displaying movie list,
 * searching movies by name, checking seat availability, and fetching movie details.
 */
public class MovieService {
    // Collection to store movies in memory
    private ArrayList<Movie> movies;

    /**
     * Constructor initializes the movie catalog with at least 5 sample movies.
     */
    public MovieService() {
        movies = new ArrayList<>();
        loadSampleMovies();
    }

    /**
     * Adds initial sample movies to the system catalog at startup.
     */
    private void loadSampleMovies() {
        movies.add(new Movie(101, "Inception", "Sci-Fi", "2h 28m", 12.50, 50));
        movies.add(new Movie(102, "Avatar: Way of Water", "Sci-Fi", "3h 12m", 15.00, 45));
        movies.add(new Movie(103, "The Dark Knight", "Action", "2h 32m", 11.00, 60));
        movies.add(new Movie(104, "Interstellar", "Sci-Fi", "2h 49m", 13.00, 40));
        movies.add(new Movie(105, "Avengers: Endgame", "Action", "3h 02m", 14.50, 35));
    }

    /**
     * Adds a new movie to the catalog.
     * @param movie Movie object to add
     */
    public void addMovie(Movie movie) {
        movies.add(movie);
        Utility.printSuccess("Movie '" + movie.getMovieName() + "' added successfully!");
    }

    /**
     * Displays all available movies in a formatted table.
     */
    public void displayAllMovies() {
        Utility.printHeader("Available Movies Catalog");
        if (movies.isEmpty()) {
            Utility.printInfo("No movies available currently.");
            return;
        }

        System.out.printf("%-6s | %-25s | %-12s | %-10s | %-10s | %-15s%n",
                "ID", "Movie Name", "Genre", "Duration", "Price ($)", "Available Seats");
        System.out.println("------------------------------------------------------------------------------------------");
        for (Movie movie : movies) {
            System.out.printf("%-6d | %-25s | %-12s | %-10s | $%-9.2f | %-15d%n",
                    movie.getMovieId(),
                    movie.getMovieName(),
                    movie.getGenre(),
                    movie.getDuration(),
                    movie.getTicketPrice(),
                    movie.getAvailableSeats());
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }

    /**
     * Searches movies by name or keyword (case-insensitive).
     * @param keyword Search string
     */
    public void searchMoviesByName(String keyword) {
        Utility.printHeader("Search Results for: '" + keyword + "'");
        ArrayList<Movie> foundMovies = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getMovieName().toLowerCase().contains(keyword.toLowerCase())) {
                foundMovies.add(movie);
            }
        }

        if (foundMovies.isEmpty()) {
            Utility.printInfo("No movies found matching '" + keyword + "'.");
        } else {
            System.out.printf("%-6s | %-25s | %-12s | %-10s | %-10s | %-15s%n",
                    "ID", "Movie Name", "Genre", "Duration", "Price ($)", "Available Seats");
            System.out.println("------------------------------------------------------------------------------------------");
            for (Movie movie : foundMovies) {
                System.out.printf("%-6d | %-25s | %-12s | %-10s | $%-9.2f | %-15d%n",
                        movie.getMovieId(),
                        movie.getMovieName(),
                        movie.getGenre(),
                        movie.getDuration(),
                        movie.getTicketPrice(),
                        movie.getAvailableSeats());
            }
            System.out.println("------------------------------------------------------------------------------------------");
        }
    }

    /**
     * Finds a movie by its unique Movie ID.
     * @param movieId Movie ID to search
     * @return Movie object if found, null otherwise
     */
    public Movie findMovieById(int movieId) {
        for (Movie movie : movies) {
            if (movie.getMovieId() == movieId) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Checks and prints seat availability for a specific movie ID.
     * @param movieId Movie ID to check
     */
    public void checkSeatAvailability(int movieId) {
        Movie movie = findMovieById(movieId);
        if (movie != null) {
            Utility.printHeader("Seat Availability Check");
            System.out.println("Movie Name     : " + movie.getMovieName());
            System.out.println("Ticket Price   : $" + String.format("%.2f", movie.getTicketPrice()));
            System.out.println("Available Seats: " + movie.getAvailableSeats());
            if (movie.getAvailableSeats() > 0) {
                Utility.printSuccess("Seats are available for booking!");
            } else {
                Utility.printError("Sorry, this movie show is SOLD OUT!");
            }
        } else {
            Utility.printError("Movie ID " + movieId + " not found!");
        }
    }

    /**
     * Returns list of all movies.
     * @return ArrayList of Movie
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
}

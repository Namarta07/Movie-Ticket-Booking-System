package model;

/**
 * Movie class represents a movie entity in the system.
 * It contains details such as movie ID, name, genre, duration, price, and available seats.
 * Demonstrates Encapsulation by keeping attributes private and exposing getters/setters.
 */
public class Movie {
    // Private attributes (Encapsulation)
    private int movieId;
    private String movieName;
    private String genre;
    private String duration;
    private double ticketPrice;
    private int availableSeats;

    // Default Constructor
    public Movie() {
    }

    // Parameterized Constructor
    public Movie(int movieId, String movieName, String genre, String duration, double ticketPrice, int availableSeats) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    // Getter and Setter methods
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * Deducts available seats when a booking is made.
     * @param count Number of seats to book.
     * @return true if successful, false if insufficient seats.
     */
    public boolean bookSeats(int count) {
        if (count > 0 && count <= this.availableSeats) {
            this.availableSeats -= count;
            return true;
        }
        return false;
    }

    /**
     * Restores available seats when a booking is cancelled.
     * @param count Number of seats to restore.
     */
    public void cancelSeats(int count) {
        if (count > 0) {
            this.availableSeats += count;
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Name: %-22s | Genre: %-12s | Duration: %-8s | Price: $%-7.2f | Seats Left: %d",
                movieId, movieName, genre, duration, ticketPrice, availableSeats);
    }
}

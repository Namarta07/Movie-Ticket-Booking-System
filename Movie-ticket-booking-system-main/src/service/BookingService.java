package service;

import model.Booking;
import model.Movie;
import util.Utility;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * BookingService handles all ticket booking operations,
 * including creating bookings, cancelling bookings, listing bookings,
 * generating unique booking IDs, and generating receipts.
 */
public class BookingService {
    // Collection to store active bookings
    private ArrayList<Booking> bookings;
    
    // Auto-increment counter for generating unique Booking IDs
    private static int bookingCounter = 1000;

    /**
     * Constructor initializes the bookings list.
     */
    public BookingService() {
        bookings = new ArrayList<>();
    }

    /**
     * Generates a unique Booking ID (e.g., BK1001, BK1002).
     * @return Formatted unique Booking ID string
     */
    private String generateBookingId() {
        bookingCounter++;
        return "BK" + bookingCounter;
    }

    /**
     * Interactive ticket booking process.
     * @param movieService MovieService instance to check and update movies
     * @param scanner Scanner instance for reading input
     */
    public void bookTicket(MovieService movieService, Scanner scanner) {
        Utility.printHeader("Book Movie Tickets");
        
        // Display list of movies first
        movieService.displayAllMovies();

        // Step 1: Input Movie ID
        int movieId = Utility.readInt(scanner, "Enter Movie ID to book tickets: ");
        Movie movie = movieService.findMovieById(movieId);

        if (movie == null) {
            Utility.printError("Invalid Movie ID! Booking process cancelled.");
            return;
        }

        // Step 2: Check available seats
        if (movie.getAvailableSeats() <= 0) {
            Utility.printError("Sorry, '" + movie.getMovieName() + "' is SOLD OUT!");
            return;
        }

        System.out.println("Selected Movie  : " + movie.getMovieName());
        System.out.println("Available Seats : " + movie.getAvailableSeats());
        System.out.printf("Ticket Price    : $%.2f%n", movie.getTicketPrice());

        // Step 3: Input Number of Tickets
        int tickets = Utility.readIntInRange(scanner, 
                "Enter number of tickets to book (1 to " + movie.getAvailableSeats() + "): ", 
                1, movie.getAvailableSeats());

        // Double check seat availability (Prevent overbooking)
        if (!movie.bookSeats(tickets)) {
            Utility.printError("Booking failed! Not enough seats available.");
            return;
        }

        // Step 4: Input Customer Name
        String customerName = Utility.readNonEmptyString(scanner, "Enter Customer Name: ");

        // Step 5: Calculate Total Price
        double totalAmount = tickets * movie.getTicketPrice();

        // Step 6: Create Booking Record
        String bookingId = generateBookingId();
        Booking newBooking = new Booking(bookingId, movie.getMovieId(), customerName, movie.getMovieName(), tickets, totalAmount);
        bookings.add(newBooking);

        Utility.printSuccess("Ticket booked successfully!");
        System.out.println("Your Booking ID is: " + bookingId);
        
        // Display receipt immediately
        newBooking.displayReceipt();
    }

    /**
     * Cancels an existing booking by Booking ID and restores movie seats.
     * @param movieService MovieService instance to update seat counts
     * @param bookingId Unique Booking ID to cancel
     */
    public void cancelBooking(MovieService movieService, String bookingId) {
        Utility.printHeader("Cancel Booking");
        
        Booking targetBooking = findBookingById(bookingId);

        if (targetBooking == null) {
            Utility.printError("No booking found with ID '" + bookingId + "'.");
            return;
        }

        // Find corresponding movie and restore seats
        Movie movie = movieService.findMovieById(targetBooking.getMovieId());
        if (movie != null) {
            movie.cancelSeats(targetBooking.getNumberOfTickets());
        }

        // Remove from bookings list
        bookings.remove(targetBooking);

        Utility.printSuccess("Booking ID '" + bookingId + "' has been successfully cancelled!");
        Utility.printInfo(targetBooking.getNumberOfTickets() + " seat(s) restored for movie: " + targetBooking.getMovieName());
    }

    /**
     * Displays all active bookings in the system.
     */
    public void viewAllBookings() {
        Utility.printHeader("All Confirmed Bookings");

        if (bookings.isEmpty()) {
            Utility.printInfo("No active bookings found in the system.");
            return;
        }

        System.out.printf("%-10s | %-18s | %-22s | %-8s | %-10s | %-20s%n",
                "Booking ID", "Customer Name", "Movie Name", "Tickets", "Total ($)", "Booking Time");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Booking b : bookings) {
            System.out.printf("%-10s | %-18s | %-22s | %-8d | $%-9.2f | %-20s%n",
                    b.getBookingId(),
                    b.getCustomerName(),
                    b.getMovieName(),
                    b.getNumberOfTickets(),
                    b.getTotalAmount(),
                    b.getBookingTime());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    /**
     * Generates and prints ticket receipt for a specific Booking ID.
     * @param bookingId Booking ID to fetch receipt for
     */
    public void generateReceipt(String bookingId) {
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            booking.displayReceipt();
        } else {
            Utility.printError("No booking record found for Booking ID: " + bookingId);
        }
    }

    /**
     * Helper method to search booking by ID (case-insensitive).
     * @param bookingId Booking ID
     * @return Booking object if found, null otherwise
     */
    public Booking findBookingById(String bookingId) {
        for (Booking b : bookings) {
            if (b.getBookingId().equalsIgnoreCase(bookingId.trim())) {
                return b;
            }
        }
        return null;
    }
}

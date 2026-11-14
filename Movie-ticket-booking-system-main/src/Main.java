import service.BookingService;
import service.MovieService;
import util.Utility;

import java.util.Scanner;

/**
 * Main application class.
 * Entry point for the Console-Based Movie Ticket Booking System.
 * Handles the menu interface, user inputs, and routes actions to appropriate service classes.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize Scanner for reading keyboard input
        Scanner scanner = new Scanner(System.in);

        // Initialize Services
        MovieService movieService = new MovieService();
        BookingService bookingService = new BookingService();

        boolean running = true;

        // Welcome Banner
        System.out.println("==========================================================================================");
        System.out.println("            WELCOME TO CINESTAR CONSOLE MOVIE TICKET BOOKING SYSTEM                      ");
        System.out.println("==========================================================================================");

        // Main Program Loop
        while (running) {
            displayMenu();
            int choice = Utility.readInt(scanner, "Enter your choice (1-8): ");

            switch (choice) {
                case 1:
                    // Display all available movies
                    movieService.displayAllMovies();
                    break;

                case 2:
                    // Book movie tickets
                    bookingService.bookTicket(movieService, scanner);
                    break;

                case 3:
                    // View all confirmed bookings
                    bookingService.viewAllBookings();
                    break;

                case 4:
                    // Cancel a booking
                    String cancelId = Utility.readNonEmptyString(scanner, "Enter Booking ID to cancel (e.g. BK1001): ");
                    bookingService.cancelBooking(movieService, cancelId);
                    break;

                case 5:
                    // Search movies by name
                    String searchName = Utility.readNonEmptyString(scanner, "Enter movie name or keyword to search: ");
                    movieService.searchMoviesByName(searchName);
                    break;

                case 6:
                    // Check seat availability for a movie
                    movieService.displayAllMovies();
                    int checkId = Utility.readInt(scanner, "Enter Movie ID to check seat availability: ");
                    movieService.checkSeatAvailability(checkId);
                    break;

                case 7:
                    // Generate booking receipt
                    String receiptId = Utility.readNonEmptyString(scanner, "Enter Booking ID to generate receipt: ");
                    bookingService.generateReceipt(receiptId);
                    break;

                case 8:
                    // Exit application
                    running = false;
                    Utility.printHeader("Thank You!");
                    System.out.println("Thank you for using CineStar Movie Ticket Booking System. Goodbye!");
                    break;

                default:
                    Utility.printError("Invalid choice! Please select an option between 1 and 8.");
                    break;
            }

            // Small pause separator between menu interactions
            if (running) {
                System.out.println("\nPress Enter to return to Main Menu...");
                scanner.nextLine();
            }
        }

        // Close scanner resource
        scanner.close();
    }

    /**
     * Displays the primary menu options.
     */
    private static void displayMenu() {
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("                                     MAIN MENU                                            ");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("  1. Display Available Movies");
        System.out.println("  2. Book Movie Tickets");
        System.out.println("  3. View All Bookings");
        System.out.println("  4. Cancel a Booking");
        System.out.println("  5. Search Movies by Name");
        System.out.println("  6. Check Seat Availability");
        System.out.println("  7. Generate Booking Receipt");
        System.out.println("  8. Exit Application");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}

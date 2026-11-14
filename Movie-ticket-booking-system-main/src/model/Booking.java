package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Booking class represents a confirmed ticket booking record.
 * Stores customer details, movie information, ticket count, total amount, and booking timestamp.
 */
public class Booking {
    // Private attributes (Encapsulation)
    private String bookingId;
    private int movieId;
    private String customerName;
    private String movieName;
    private int numberOfTickets;
    private double totalAmount;
    private String bookingTime;

    // Parameterized Constructor
    public Booking(String bookingId, int movieId, String customerName, String movieName, int numberOfTickets, double totalAmount) {
        this.bookingId = bookingId;
        this.movieId = movieId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.totalAmount = totalAmount;
        
        // Format current timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.bookingTime = LocalDateTime.now().format(formatter);
    }

    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    /**
     * Prints a nicely formatted receipt for the booking.
     */
    public void displayReceipt() {
        System.out.println("=================================================");
        System.out.println("            CINESTAR TICKET RECEIPT             ");
        System.out.println("=================================================");
        System.out.printf(" Booking ID     : %s%n", bookingId);
        System.out.printf(" Date & Time    : %s%n", bookingTime);
        System.out.printf(" Customer Name  : %s%n", customerName);
        System.out.printf(" Movie Name     : %s%n", movieName);
        System.out.printf(" Tickets Booked : %d%n", numberOfTickets);
        System.out.printf(" Total Paid     : $%.2f%n", totalAmount);
        System.out.println("-------------------------------------------------");
        System.out.println("    Thank you for booking with CineStar!        ");
        System.out.println("=================================================");
    }

    @Override
    public String toString() {
        return String.format("Booking ID: %-8s | Customer: %-15s | Movie: %-20s | Tickets: %-2d | Total: $%.2f",
                bookingId, customerName, movieName, numberOfTickets, totalAmount);
    }
}

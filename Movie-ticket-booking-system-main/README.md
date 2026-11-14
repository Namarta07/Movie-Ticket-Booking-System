# 🎬 Movie Ticket Booking System (Java Console Application)

A complete, beginner-friendly, console-based **Movie Ticket Booking System** written in **Core Java**. This project demonstrates core Object-Oriented Programming (OOP) principles, the Java Collections Framework (`ArrayList`), input validation, and clean package modularity without requiring any external databases or frameworks.

---

## 📌 Project Features

- 🎟️ **Display Available Movies**: View pre-loaded movies with ID, genre, duration, price, and available seats.
- 🍿 **Book Movie Tickets**: Interactive ticket booking with seat availability checks, automatic total price calculation, and instant seat deduction.
- 📋 **View Confirmed Bookings**: Inspect all active reservations with unique Booking IDs and timestamps.
- ❌ **Cancel Bookings**: Cancel reservations using Booking ID with automatic seat restoration.
- 🔍 **Search Movies by Name**: Search catalog by full or partial movie names (case-insensitive).
- 💺 **Check Seat Availability**: Quick status lookup for any movie show.
- 📄 **Generate Booking Receipt**: Print formatted itemized receipts for any booking.
- 🛡️ **Robust Error & Input Handling**: Handles non-integer inputs, out-of-range choices, and sold-out conditions gracefully.

---

## 🧠 OOP & Core Java Concepts Used

| Concept | Description in Project |
| :--- | :--- |
| **Classes & Objects** | Created modular entities such as `Movie`, `Booking`, `MovieService`, `BookingService`, and `Utility`. |
| **Encapsulation** | Private attributes with public getters and setters in model classes. |
| **Constructors** | Default and parameterized constructors for object initialization. |
| **Collections Framework** | `ArrayList<Movie>` and `ArrayList<Booking>` for dynamic in-memory data management. |
| **Control Flow** | `switch-case` statements for menu navigation and `while` loops for continuous execution. |
| **Input Validation** | Exception handling (`try-catch`) for parsing numeric inputs safely with Scanner. |
| **Modular Packages** | Code organized logically into `model`, `service`, `util`, and main execution layers. |

---

## 📂 Folder & Package Structure

```text
MOVIE TICKET BOOKING PROJECT/
├── bin/                       # Compiled .class files directory (generated)
├── src/                       # Java source code
│   ├── Main.java              # Entry point & interactive console menu
│   ├── model/                 # Data model classes
│   │   ├── Movie.java         # Movie entity details & seat operations
│   │   └── Booking.java       # Ticket reservation record & receipt formatter
│   ├── service/               # Core business logic layer
│   │   ├── MovieService.java  # Catalog operations, search, seat checks
│   │   └── BookingService.java# Booking creation, cancellation, receipt rendering
│   └── util/                  # Helper utilities
│       └── Utility.java       # Input validation & UI formatting helpers
└── README.md                  # Project documentation & execution guide
```

---

## 🚀 How to Run the Application

### Prerequisites
- **Java Development Kit (JDK 8 or higher)** installed on your machine.

### Step 1: Open Terminal / Command Prompt
Navigate to the project root directory:
```bash
cd "d:/MOVIE TICKET BOOKING PROJECT"
```

### Step 2: Compile the Java Files
Compile all Java source files into the `bin` directory:
```bash
javac -d bin src/Main.java src/model/*.java src/service/*.java src/util/*.java
```

### Step 3: Run the Application
Execute the compiled `Main` class:
```bash
java -cp bin Main
```

---

## 🖥️ Sample Console Outputs

### 1. Main Menu
```text
==========================================================================================
            WELCOME TO CINESTAR CONSOLE MOVIE TICKET BOOKING SYSTEM                      
==========================================================================================

------------------------------------------------------------------------------------------
                                     MAIN MENU                                            
------------------------------------------------------------------------------------------
  1. Display Available Movies
  2. Book Movie Tickets
  3. View All Bookings
  4. Cancel a Booking
  5. Search Movies by Name
  6. Check Seat Availability
  7. Generate Booking Receipt
  8. Exit Application
------------------------------------------------------------------------------------------
Enter your choice (1-8): 
```

---

### 2. Available Movies Catalog
```text
==========================================================================================
  AVAILABLE MOVIES CATALOG
==========================================================================================
ID     | Movie Name                | Genre        | Duration   | Price ($)  | Available Seats
------------------------------------------------------------------------------------------
101    | Inception                 | Sci-Fi       | 2h 28m     | $12.50     | 50             
102    | Avatar: Way of Water      | Sci-Fi       | 3h 12m     | $15.00     | 45             
103    | The Dark Knight           | Action       | 2h 32m     | $11.00     | 60             
104    | Interstellar              | Sci-Fi       | 2h 49m     | $13.00     | 40             
105    | Avengers: Endgame         | Action       | 3h 02m     | $14.50     | 35             
------------------------------------------------------------------------------------------
```

---

### 3. Booking a Ticket & Instant Receipt
```text
==========================================================================================
  BOOK MOVIE TICKETS
==========================================================================================
Enter Movie ID to book tickets: 101
Selected Movie  : Inception
Available Seats : 50
Ticket Price    : $12.50
Enter number of tickets to book (1 to 50): 3
Enter Customer Name: Alice Johnson
[SUCCESS] Ticket booked successfully!
Your Booking ID is: BK1001

=================================================
            CINESTAR TICKET RECEIPT             
=================================================
 Booking ID     : BK1001
 Date & Time    : 2026-08-01 09:53:00
 Customer Name  : Alice Johnson
 Movie Name     : Inception
 Tickets Booked : 3
 Total Paid     : $37.50
-------------------------------------------------
    Thank you for booking with CineStar!        
=================================================
```

---

### 4. Viewing All Confirmed Bookings
```text
==========================================================================================
  ALL CONFIRMED BOOKINGS
==========================================================================================
Booking ID | Customer Name      | Movie Name             | Tickets  | Total ($)  | Booking Time        
-----------------------------------------------------------------------------------------
BK1001     | Alice Johnson      | Inception              | 3        | $37.50     | 2026-08-01 09:53:00 
-----------------------------------------------------------------------------------------
```

---

### 5. Cancelling a Booking & Restoring Seats
```text
==========================================================================================
  CANCEL BOOKING
==========================================================================================
Enter Booking ID to cancel (e.g. BK1001): BK1001
[SUCCESS] Booking ID 'BK1001' has been successfully cancelled!
[INFO] 3 seat(s) restored for movie: Inception
```

---

## 🛠️ Extensibility & Future Enhancements
- Add persistent storage using JSON/CSV files or JDBC MySQL Database.
- Add user roles (Admin vs Customer) with movie management features for Admins.
- Add dynamic seat grid selection (e.g., Row A1-A10).

---

## 📄 License
This project is open-source and available under the **MIT License**. Suitable for learning and uploading as a beginner Java portfolio project on GitHub.

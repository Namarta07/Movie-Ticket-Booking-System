package util;

import java.util.Scanner;

/**
 * Utility class containing helper methods for input validation,
 * error handling, and visual formatting of console menus.
 */
public class Utility {

    /**
     * Reads a valid integer from user input with error handling.
     * @param scanner Scanner instance
     * @param prompt Prompt message to display
     * @return Valid integer input
     */
    public static int readInt(Scanner scanner, String prompt) {
        int number = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                number = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                printError("Invalid input! Please enter a valid number.");
            }
        }
        return number;
    }

    /**
     * Reads an integer within a specific range (min to max).
     * @param scanner Scanner instance
     * @param prompt Prompt message
     * @param min Minimum acceptable value
     * @param max Maximum acceptable value
     * @return Valid integer within range
     */
    public static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        int number;
        while (true) {
            number = readInt(scanner, prompt);
            if (number >= min && number <= max) {
                return number;
            } else {
                printError("Input out of range! Please enter a number between " + min + " and " + max + ".");
            }
        }
    }

    /**
     * Reads a non-empty string input from user.
     * @param scanner Scanner instance
     * @param prompt Prompt message
     * @return Non-empty trimmed String
     */
    public static String readNonEmptyString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                printError("Input cannot be empty! Please try again.");
            }
        }
    }

    /**
     * Displays a formatted section header.
     * @param title Title text to display inside the header
     */
    public static void printHeader(String title) {
        System.out.println();
        System.out.println("==========================================================================================");
        System.out.println("  " + title.toUpperCase());
        System.out.println("==========================================================================================");
    }

    /**
     * Prints a success message.
     * @param message Text to display
     */
    public static void printSuccess(String message) {
        System.out.println("[SUCCESS] " + message);
    }

    /**
     * Prints an error message.
     * @param message Text to display
     */
    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    /**
     * Prints an info message.
     * @param message Text to display
     */
    public static void printInfo(String message) {
        System.out.println("[INFO] " + message);
    }
}

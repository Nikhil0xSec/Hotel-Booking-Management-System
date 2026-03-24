/**
 * ============================================================
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class demonstrates how
 * user input is validated before booking.
 *
 * The system:
 * - Accepts user input
 * - Validates centrally
 * - Handles errors gracefully
 *
 * Author Nikhil0xSec
 * @version 9.0
 */

import java.util.Scanner;

public class ErrorHandlingValidation {

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();

        try {

            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            validator.validate(guestName, roomType, inventory);

            System.out.println("Booking successful for " + guestName);

        } catch (InvalidBookingException e) {

            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}
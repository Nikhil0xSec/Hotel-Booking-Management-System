/**
 * ============================================================
 * CLASS - InvalidBookingException
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This custom exception represents
 * invalid booking scenarios in the system.
 *
 * Using a domain-specific exception
 * makes error handling clearer and safer.
 *
 * Author Nikhil0xSec
 * @version 9.0
 */
public class InvalidBookingException extends Exception {

    /**
     * Creates exception with message.
     *
     * @param message error description
     */
    public InvalidBookingException(String message) {
        super(message);
    }
}
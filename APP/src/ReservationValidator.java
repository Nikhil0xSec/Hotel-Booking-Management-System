/**
 * ============================================================
 * CLASS - ReservationValidator
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class validates booking
 * requests before processing.
 *
 * Validation rules are centralized
 * to avoid duplication.
 *
 * Author Nikhil0xSec
 * @version 9.0
 */
public class ReservationValidator {

    /**
     * Validates booking input.
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        if (!inventory.getRoomAvailability().containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        if (inventory.getRoomAvailability().get(roomType) <= 0) {
            throw new InvalidBookingException("Selected room is not available.");
        }
    }
}
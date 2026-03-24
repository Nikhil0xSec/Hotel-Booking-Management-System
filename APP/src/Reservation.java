
/**
 * ===================================================
 * CLASS - Reservation
 * ===================================================
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class represents a booking request made by a guest.
 *
 * At this stage, a reservation only captures intent,
 * not confirmation or room allocation.
 *
 * @version 8.0
 */
public class Reservation {

    // Name of the guest making the booking
    private String guestName;

    // Requested room type
    private String roomType;

    // Constructor
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    // Getter for guest name
    public String getGuestName() {
        return guestName;
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }
}
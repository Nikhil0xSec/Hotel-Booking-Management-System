/**
 * ============================================================
 * CLASS - BookingHistory
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class maintains a record of
 * confirmed reservations.
 *
 * It provides ordered storage for
 * historical and reporting purposes.
 *
 * Author Nikhil0xSec
 * @version 8.0
 */

import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    /**
     * List storing confirmed reservations.
     */
    private List<Reservation> confirmedReservations;

    /**
     * Initializes empty booking history.
     */
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /**
     * Adds confirmed reservation.
     */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /**
     * Returns confirmed reservations.
     */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}
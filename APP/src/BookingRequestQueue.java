/**
 * ===================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ===================================================
 *
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This class demonstrates how booking requests are
 * accepted and queued in a fair and predictable order.
 *
 * No room allocation or inventory update is performed here.
 *
 * @author Nikhil0xSec
 * @version 5.0
 */

public class BookingRequestQueue {

    public static void main(String[] args) {

        // Display header
        System.out.println("Booking Request Queue");

        // Initialize queue
        RequestQueue bookingQueue = new RequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vannathi", "Suite");

        // Add to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Process requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation r = bookingQueue.getNextRequest();
            System.out.println("Processing booking for Guest: "
                    + r.getGuestName()
                    + ", Room Type: "
                    + r.getRoomType());
        }
    }
}
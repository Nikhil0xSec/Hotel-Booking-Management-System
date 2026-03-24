/**
 * ============================================================
 * CLASS - ConcurrentBookingProcessor
 * ============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class represents a booking processor
 * executed by multiple threads.
 *
 * Shared resources such as booking queue
 * and inventory are accessed safely.
 *
 * Author Nikhil0xSec
 * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {

    /**
     * Shared booking queue.
     */
    private BookingRequestQueue bookingQueue;

    /**
     * Shared inventory.
     */
    private RoomInventory inventory;

    /**
     * Shared allocation service.
     */
    private RoomAllocationService allocationService;

    /**
     * Constructor.
     */
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    /**
     * Thread execution logic.
     */
    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            synchronized (bookingQueue) {

                if (bookingQueue.isEmpty()) {
                    break;
                }

                reservation = bookingQueue.dequeue();
            }

            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}
/**
 * ============================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * Author Nikhil0xSec
 * @version 10.0
 */
public class BookingCancellation {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService service = new CancellationService();

        inventory.updateAvailability("Single Room", 4);

        service.registerBooking("Single-1", "Single");

        service.cancelBooking("Single-1", inventory);

        service.showRollbackHistory();

        System.out.println();
        System.out.println("Updated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single Room"));
    }
}
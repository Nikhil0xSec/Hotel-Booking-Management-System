/**
 * ============================================================
 * CLASS - CancellationService
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class handles booking cancellations.
 *
 * It ensures:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 *
 * A stack models rollback behavior.
 *
 * Author Nikhil0xSec
 * @version 10.0
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {

    /**
     * Stores recently released room IDs.
     */
    private Stack<String> releasedRoomIds;

    /**
     * Maps reservation ID to room type.
     */
    private Map<String, String> reservationRoomTypeMap;

    /**
     * Initializes structures.
     */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers confirmed booking.
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels booking safely.
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        releasedRoomIds.push(reservationId);

        int current = inventory.getRoomAvailability().get(roomType + " Room");
        inventory.updateAvailability(roomType + " Room", current + 1);

        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /**
     * Displays rollback history.
     */
    public void showRollbackHistory() {

        System.out.println();
        System.out.println("Rollback History (Most Recent First):");

        while (!releasedRoomIds.isEmpty()) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.pop());
        }
    }
}
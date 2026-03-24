/**
 * ============================================================
 * MAIN CLASS - RoomAllocation
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 *
 *  Author Nikhil0xSec
 * @version 6.0
 */
public class RoomAllocation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService service = new RoomAllocationService();

        Reservation r1 = new Reservation("Abhi", "Single Room");
        Reservation r2 = new Reservation("Subha", "Single Room");
        Reservation r3 = new Reservation("Vannathi", "Suite Room");

        System.out.println("Room Allocation Processing");

        service.allocateRoom(r1, inventory);
        service.allocateRoom(r2, inventory);
        service.allocateRoom(r3, inventory);
    }
}


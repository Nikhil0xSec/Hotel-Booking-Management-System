/**
 * ============================================================
 * MAIN CLASS - UseCase11ConcurrentBookingSimulation
 * ============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class simulates multiple users
 * attempting booking simultaneously.
 *
 * Synchronization prevents conflicts.
 *
 * Author Nikhil0xSec
 * @version 11.0
 */
public class ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.enqueue(new Reservation("Abhi", "Single Room"));
        bookingQueue.enqueue(new Reservation("Vannathi", "Double Room"));
        bookingQueue.enqueue(new Reservation("Kural", "Suite Room"));
        bookingQueue.enqueue(new Reservation("Subha", "Single Room"));

        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService));

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue, inventory, allocationService));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        System.out.println();
        System.out.println("Remaining Inventory:");
        System.out.println("Single: " +
                inventory.getRoomAvailability().get("Single Room"));
        System.out.println("Double: " +
                inventory.getRoomAvailability().get("Double Room"));
        System.out.println("Suite: " +
                inventory.getRoomAvailability().get("Suite Room"));
    }
}
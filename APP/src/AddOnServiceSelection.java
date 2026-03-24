/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * Author Nikhil0xSec
 * @version 7.0
 */

public class AddOnServiceSelection {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1000);

        String reservationId = "Single-1";

        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);

        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " +
                manager.calculateTotalServiceCost(reservationId));
    }
}
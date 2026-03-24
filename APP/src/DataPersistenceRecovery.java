/**
 * ============================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ============================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class demonstrates how system
 * state is restored after restart.
 *
 * Inventory is loaded before operations.
 *
 * Author Nikhil0xSec
 * @version 12.0
 */
public class DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();

        String filePath = "inventory.txt";

        persistence.loadInventory(inventory, filePath);

        System.out.println();
        System.out.println("Current Inventory:");
        System.out.println("Single: "
                + inventory.getRoomAvailability().get("Single Room"));
        System.out.println("Double: "
                + inventory.getRoomAvailability().get("Double Room"));
        System.out.println("Suite: "
                + inventory.getRoomAvailability().get("Suite Room"));

        persistence.saveInventory(inventory, filePath);
    }
}
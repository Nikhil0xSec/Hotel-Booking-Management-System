/**
 * ============================================================
 * CLASS - FilePersistenceService
 * ============================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class persists critical system state
 * to a plain text file.
 *
 * It supports:
 * - Saving inventory state
 * - Restoring inventory at startup
 *
 * Author Nikhil0xSec
 * @version 12.0
 */

import java.io.*;
import java.util.Map;

public class FilePersistenceService {

    /**
     * Saves inventory to file.
     */
    public void saveInventory(RoomInventory inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry :
                    inventory.getRoomAvailability().entrySet()) {

                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Failed to save inventory.");
        }
    }

    /**
     * Loads inventory from file.
     */
    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                if (parts.length == 2) {
                    inventory.updateAvailability(
                            parts[0],
                            Integer.parseInt(parts[1])
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Failed to load inventory.");
        }
    }
}
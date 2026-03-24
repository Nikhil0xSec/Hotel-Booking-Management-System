/**
 * ============================================================
 * CLASS - AddOnServiceManager
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class manages optional services
 * associated with confirmed reservations.
 *
 * It supports attaching multiple services
 * to a single reservation.
 *
 * Author Nikhil0xSec
 * @version 7.0
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AddOnServiceManager {

    /**
     * Maps reservation ID to selected services.
     *
     * Key   -> Reservation ID
     * Value -> List of selected services
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /**
     * Initializes service manager.
     */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Adds service to reservation.
     */
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);
    }

    /**
     * Calculates total service cost.
     */
    public double calculateTotalServiceCost(String reservationId) {

        double total = 0;

        if (servicesByReservation.containsKey(reservationId)) {
            for (AddOnService service : servicesByReservation.get(reservationId)) {
                total += service.getCost();
            }
        }

        return total;
    }
}
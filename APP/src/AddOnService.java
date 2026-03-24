/**
 * ============================================================
 * CLASS - Service
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class represents an optional service
 * that can be added to a confirmed reservation.
 *
 * Examples:
 * - Breakfast
 * - Spa
 * - Airport Pickup
 *
 * Author Nikhil0xSec
 * @version 7.0
 */
public class AddOnService {

    /**
     * Name of the service.
     */
    private String serviceName;

    /**
     * Cost of the service.
     */
    private double cost;

    /**
     * Creates a new add-on service.
     */
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    /**
     * Returns service name.
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Returns service cost.
     */
    public double getCost() {
        return cost;
    }
}
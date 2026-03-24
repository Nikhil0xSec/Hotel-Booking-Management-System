/**
 * ============================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class demonstrates how
 * confirmed bookings are stored
 * and reported.
 *
 * The system maintains ordered
 * audit trail of reservations.
 *
 * Author Nikhil0xSec
 * @version 8.0
 */
public class BookingHistoryReport {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("Abhi", "Single Room"));
        history.addReservation(new Reservation("Subha", "Double Room"));
        history.addReservation(new Reservation("Vannathi", "Suite Room"));

        BookingReportService reportService = new BookingReportService();

        System.out.println("Booking History and Reporting");
        System.out.println();

        reportService.generateReport(history);
    }
}
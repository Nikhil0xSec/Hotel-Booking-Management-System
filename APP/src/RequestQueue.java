import java.util.LinkedList;
import java.util.Queue;
public class RequestQueue {



    // Queue that stores booking requests
    private Queue<Reservation> requestQueue;

    // Initialize empty queue
    public RequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Get next request (FIFO)
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue has requests
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}
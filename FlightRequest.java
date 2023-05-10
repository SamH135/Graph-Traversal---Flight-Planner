public class FlightRequest {
    String origin;
    String destination;
    char orderBy;

    public FlightRequest(String origin, String destination, char orderBy) {
        this.origin = origin;
        this.destination = destination;
        this.orderBy = orderBy;
    }
}

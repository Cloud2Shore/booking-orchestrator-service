package bookingorchestrator.model;

public class BookingResponse {
    private String message;
    private BookingRequest bookingRequest;

    public BookingResponse(String message, BookingRequest bookingRequest) {
        this.message = message;
        this.bookingRequest = bookingRequest;
    }

    // Getters and Setters
}

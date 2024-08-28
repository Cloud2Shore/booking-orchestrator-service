package bookingorchestrator.model;

public class BookingResponse {
    private String message;
    private BookingRequest bookingRequest;

    public BookingResponse(String message, BookingRequest bookingRequest) {
        this.message = message;
        this.bookingRequest = bookingRequest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public void setBookingRequest(BookingRequest bookingRequest) {
        this.bookingRequest = bookingRequest;
    }
}

package bookingorchestrator.controllers;

import bookingorchestrator.client.HotelServiceClient;
import bookingorchestrator.client.NotificationServiceClient;
import bookingorchestrator.client.PaymentServiceClient;
import bookingorchestrator.client.UserServiceClient;
import bookingorchestrator.model.BookingRequest;
import bookingorchestrator.model.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingOrchestratorController {

    private final UserServiceClient userServiceClient;

    private final HotelServiceClient hotelServiceClient;

    private final PaymentServiceClient paymentServiceClient;

    private final NotificationServiceClient notificationServiceClient;

    public BookingOrchestratorController(UserServiceClient userServiceClient, HotelServiceClient hotelServiceClient,
                                         PaymentServiceClient paymentServiceClient, NotificationServiceClient notificationServiceClient) {
        this.userServiceClient = userServiceClient;
        this.hotelServiceClient = hotelServiceClient;
        this.paymentServiceClient = paymentServiceClient;
        this.notificationServiceClient = notificationServiceClient;
    }

    @PostMapping("/create")
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest) {
        // Step 1: Authenticate User
        boolean isAuthenticated = userServiceClient.authenticateUser(bookingRequest.getUserId());
        if (!isAuthenticated) {
            return ResponseEntity.status(401).body(new BookingResponse("User authentication failed", null));
        }

        // Step 2: Check Room Availability
        boolean isRoomAvailable = hotelServiceClient.checkRoomAvailability(bookingRequest.getHotelId(), bookingRequest.getRoomType());
        if (!isRoomAvailable) {
            return ResponseEntity.status(404).body(new BookingResponse("Room not available", null));
        }

        // Step 3: Process Payment
        boolean isPaymentProcessed = paymentServiceClient.processPayment(bookingRequest.getPaymentDetails());
        if (!isPaymentProcessed) {
            return ResponseEntity.status(402).body(new BookingResponse("Payment processing failed", null));
        }

        // Step 4: Send Notification
        notificationServiceClient.sendBookingConfirmation(bookingRequest.getUserId());

        return ResponseEntity.ok(new BookingResponse("Booking successful", bookingRequest));
    }
}

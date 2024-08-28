package bookingorchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "notification-service",url = "http://localhost:8085")
public interface NotificationServiceClient {
    @PostMapping("/notification/sendConfirmation")
    void sendBookingConfirmation(@RequestParam("userId") String userId);
}

package bookingorchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hotel-service",url = "http://localhost:8083")
public interface HotelServiceClient {

    @GetMapping("/hotel/checkAvailability")
    boolean checkRoomAvailability(@RequestParam("hotelId") String hotelId, @RequestParam("roomType") String roomType);
}

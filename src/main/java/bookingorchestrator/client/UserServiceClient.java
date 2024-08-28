package bookingorchestrator.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8082")
public interface UserServiceClient {
    @GetMapping("/user/authenticate")
    boolean authenticateUser(@RequestParam("userId") String userId);
}


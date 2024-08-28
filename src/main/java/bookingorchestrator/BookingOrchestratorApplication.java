package bookingorchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BookingOrchestratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingOrchestratorApplication.class, args);
    }
}

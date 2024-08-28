package bookingorchestrator.client;

import bookingorchestrator.model.PaymentDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service",url = "http://localhost:8084")
public interface PaymentServiceClient {

    @PostMapping("/payment/process")
    boolean processPayment(@RequestBody PaymentDetails paymentDetails);
}

package jm.stockx.feign;

import jm.stockx.dto.PayPalOrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "paypalrest", url = "http://localhost:8080")
public interface PayPalRestClient {

    @PostMapping(value = "/api/payment/paypal/creation", consumes = "application/json")
    String createPayment(@RequestBody PayPalOrderDto orderForProcessing);

    @PostMapping(value = "/api/payment/paypal/execution", consumes = "application/json")
    String makePayment(@RequestParam("paymentId") String paymentId,
                       @RequestParam("PayerID") String payerId);
}
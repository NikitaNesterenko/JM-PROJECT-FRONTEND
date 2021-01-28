package jm.stockx.controller.paypal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "paypalrest", url = "http://localhost:8080")
public interface PayPalRestClient {

    @PostMapping(value = "/api/payment/paypal/get", consumes = "application/json")
    String createPayment(@RequestBody PayPalOrder orderForProcessing);

    @PostMapping(value = "/api/payment/paypal/put", consumes = "application/json")
    String makePayment(@RequestParam("paymentId") String paymentId,
                       @RequestParam("PayerID") String payerId);
}

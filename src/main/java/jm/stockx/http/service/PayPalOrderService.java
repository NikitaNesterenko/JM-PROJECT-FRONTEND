package jm.stockx.http.service;

import jm.stockx.dto.PayPalOrderDto;
import jm.stockx.feign.PayPalRestClient;
import org.springframework.stereotype.Service;

@Service
public class PayPalOrderService {
    private final PayPalRestClient payPalRestClient;

    public PayPalOrderService(PayPalRestClient payPalRestClient) {
        this.payPalRestClient = payPalRestClient;
    }

    public PayPalOrderDto createPayPalOrderSample() {
        PayPalOrderDto orderForCreation = new PayPalOrderDto();
        orderForCreation.setPrice(1.1D);
        orderForCreation.setCurrency("USD");
        orderForCreation.setDescription("1.1 sneaker");
        return orderForCreation;
    }

    public String getApprovalURL(PayPalOrderDto generateOrder) {
        return payPalRestClient.createPayment(generateOrder);
    }

    public String makePayment(String paymentId, String payerID) {
        return payPalRestClient.makePayment(paymentId, payerID);
    }
}
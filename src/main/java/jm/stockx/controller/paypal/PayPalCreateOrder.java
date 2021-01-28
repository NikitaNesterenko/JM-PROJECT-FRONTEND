package jm.stockx.controller.paypal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("order/create")
public class PayPalCreateOrder extends Div {

    private final PayPalRestClient payPalRestClient;

    public PayPalCreateOrder(PayPalRestClient payPalRestClient) {
        this.payPalRestClient = payPalRestClient;
        add(createButton());
    }

    private Button createButton() {
        PayPalOrder generateOrder = createPayPalOrder();

        Button button = new Button();
        button.addClickListener(buttonClickEvent -> {
            String approval_URL = payPalRestClient.createPayment(generateOrder);
            System.out.println(approval_URL);
            getUI().get().getPage().setLocation(approval_URL);
        });
        button.setText("Create Order");


        return button;
    }

    private PayPalOrder createPayPalOrder() {
        PayPalOrder orderForCreation = new PayPalOrder();
        orderForCreation.setPrice(3.33D);
        orderForCreation.setCurrency("USD");
        orderForCreation.setMethod("paypal");
        orderForCreation.setIntent("SALE");
        orderForCreation.setDescription("3.33 sneaker");
        orderForCreation.setCancelURL("http://localhost:4446");
        orderForCreation.setSuccessURL("http://localhost:4446/paypal/redirect");

        return orderForCreation;
    }
}

package jm.stockx.controller.paypal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;

@Route("order/create")
public class PayPalCreateOrder extends Div
//        implements BeforeLeaveObserver
{
    private final HeaderRowNewsPage navPanel = new HeaderRowNewsPage();
    private final PayPalRestClient payPalRestClient;

    public PayPalCreateOrder(PayPalRestClient payPalRestClient) {
        this.payPalRestClient = payPalRestClient;
        add(navPanel, createButton());
    }

    private Button createButton() {
        PayPalOrder generateOrder = createPayPalOrder();

        Button button = new Button();
        button.addClickListener(buttonClickEvent -> {
            getApprovalURL(generateOrder);
        });
        button.setText("Create Order");


        return button;
    }

    private void getApprovalURL(PayPalOrder generateOrder) {
        String approval_URL = payPalRestClient.createPayment(generateOrder);
        System.out.println(approval_URL);
        getUI().get().getPage().setLocation(approval_URL);
    }

    private PayPalOrder createPayPalOrder() {
        PayPalOrder orderForCreation = new PayPalOrder();
        orderForCreation.setPrice(2.2D);
        orderForCreation.setCurrency("USD");
        orderForCreation.setMethod("paypal");
        orderForCreation.setIntent("SALE");
        orderForCreation.setDescription("2.22 sneaker");
        orderForCreation.setCancelURL("http://localhost:4446");
        orderForCreation.setSuccessURL("http://localhost:4446/paypal/redirect");

        return orderForCreation;
    }

//    @Override
//    public void beforeLeave(BeforeLeaveEvent beforeLeaveEvent) {
//        LocationChangeEvent.rerouteTo((NavigationHandler) navigationEvent -> re)
//    }
}

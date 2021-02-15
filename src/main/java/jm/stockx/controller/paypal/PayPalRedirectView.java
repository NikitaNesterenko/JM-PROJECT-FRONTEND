package jm.stockx.controller.paypal;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.*;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.controller.user.MainView;
import jm.stockx.http.service.PayPalOrderService;

import java.util.List;
import java.util.Map;

@Route("paypal/redirect")
public class PayPalRedirectView extends Div implements HasUrlParameter<String> {
    private final HeaderRowNewsPage navPanel = new HeaderRowNewsPage();
    private final PayPalOrderService payPalOrderService;

    public PayPalRedirectView(PayPalOrderService payPalOrderService) {
        this.payPalOrderService = payPalOrderService;
        add(navPanel, createButton());
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {
        Location location = beforeEvent.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();
        Map<String, List<String>> parametersMap = queryParameters.getParameters();

        makePayment(parametersMap);
        createButton();
    }

    private Button createButton() {
        Button button = new Button();
        button.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(MainView.class));
        button.setText("Back to Main Page");
        return button;
    }

    private void makePayment(Map<String, List<String>> parametersMap) {
        String paymentId = parametersMap.get("paymentId").get(0);
        String payerID = parametersMap.get("PayerID").get(0);
        String status = payPalOrderService.makePayment(paymentId, payerID);
        Notification.show(status.equals("Payment approved") ? "Payment approved" : "Something went wrong");
    }
}
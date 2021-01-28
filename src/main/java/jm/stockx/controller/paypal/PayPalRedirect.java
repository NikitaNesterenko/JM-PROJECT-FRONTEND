package jm.stockx.controller.paypal;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.controller.user.MainView;

import java.util.List;
import java.util.Map;

@Route("paypal/redirect")
public class PayPalRedirect extends Div implements HasUrlParameter<String> {
    private final HeaderRowNewsPage navPanel = new HeaderRowNewsPage();
    private final PayPalRestClient payPalRestClient;

    public PayPalRedirect(PayPalRestClient payPalRestClient) {
        this.payPalRestClient = payPalRestClient;
        add(navPanel, createButton());
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {
        Location location = beforeEvent.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();
        Map<String, List<String>> parametersMap = queryParameters.getParameters();

        makePayment(parametersMap);
        createButton();
        System.out.println(parametersMap);
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
        String returned = payPalRestClient.makePayment(paymentId, payerID);
        System.out.println(returned);
    }
}
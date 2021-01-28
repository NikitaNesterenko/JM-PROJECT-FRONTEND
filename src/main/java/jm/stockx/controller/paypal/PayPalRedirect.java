package jm.stockx.controller.paypal;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;
import jm.stockx.controller.purchase.AllItemController;
import jm.stockx.controller.user.MainView;

import java.util.List;
import java.util.Map;

@Route("paypal/redirect")
public class PayPalRedirect extends Div implements HasUrlParameter<String> {

    private final PayPalRestClient payPalRestClient;

    public PayPalRedirect(PayPalRestClient payPalRestClient) {
        this.payPalRestClient = payPalRestClient;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String s) {
        Location location = beforeEvent.getLocation();
        QueryParameters queryParameters = location.getQueryParameters();
        Map<String, List<String>> parametersMap = queryParameters.getParameters();

        makePayment(parametersMap);
        createRouterLink();
        System.out.println(parametersMap);
    }

    private RouterLink createRouterLink() {
        return new RouterLink("Back to Main Page", MainView.class);
    }

    private void makePayment(Map<String, List<String>> parametersMap) {
        String paymentId = parametersMap.get("paymentId").get(0);
        String payerID = parametersMap.get("PayerID").get(0);
        String returned = payPalRestClient.makePayment(paymentId, payerID);
        System.out.println(returned);
    }
}
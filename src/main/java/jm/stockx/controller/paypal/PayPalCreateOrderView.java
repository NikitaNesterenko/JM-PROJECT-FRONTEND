package jm.stockx.controller.paypal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.dto.PayPalOrderDto;
import jm.stockx.http.service.PayPalOrderService;

@Route("order/create")
public class PayPalCreateOrderView extends Div {
    private final HeaderRowNewsPage navPanel = new HeaderRowNewsPage();
    private final PayPalOrderService payPalOrderService;

    public PayPalCreateOrderView(PayPalOrderService payPalOrderService) {
        this.payPalOrderService = payPalOrderService;
        add(navPanel, createButton());
    }

    private Button createButton() {
        PayPalOrderDto generateOrder = payPalOrderService.createPayPalOrderSample();

        Button button = new Button();
        button.addClickListener(buttonClickEvent -> getApprovalURL(generateOrder));
        button.setText("Create Order");
        return button;
    }

    private void getApprovalURL(PayPalOrderDto generateOrder) {
        String approvalURL = payPalOrderService.getApprovalURL(generateOrder);
        if (getUI().isPresent()) {
            getUI().get().getPage().setLocation(approvalURL);
        }
    }
}
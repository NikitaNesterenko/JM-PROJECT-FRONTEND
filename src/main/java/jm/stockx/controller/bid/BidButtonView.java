package jm.stockx.controller.bid;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import jm.stockx.components.templates.BidButton;
import jm.stockx.http.service.BidHttpService;

@Route("bid")
public class BidButtonView extends VerticalLayout {

    public BidButtonView(BidHttpService bidHttpService) {
        BidButton bidButton = new BidButton();
        Button button = bidButton.createButton();
        add(button);
        button.addClickListener(event -> bidHttpService.sendBid());

    }
}

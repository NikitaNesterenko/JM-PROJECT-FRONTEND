package jm.stockx.controller.user;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.controller.paypal.PayPalCreateOrderView;
import jm.stockx.controller.purchase.AllItemController;
import org.springframework.context.annotation.Scope;

@Route()
@Scope("prototype")
public class MainView extends VerticalLayout {
    private HeaderRowNewsPage navPanel = new HeaderRowNewsPage();

    public MainView() {
        Button toListButton = new Button("To List");
        toListButton.addClickListener(e -> UI.getCurrent().navigate(AllItemController.class));
        add(navPanel, toListButton, createButton());
    }

    private Button createButton() {
        Button button = new Button();
        button.addClickListener(buttonClickEvent -> UI.getCurrent().navigate(PayPalCreateOrderView.class));
        button.setText("Create PayPal Order");
        return button;
    }
}
package jm.stockx.controller.user;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jm.stockx.components.templates.MostPopularItemsGrid;

import java.util.ArrayList;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        add(new MostPopularItemsGrid(new ArrayList<>()));
        add(new Button("Click me", e -> Notification.show("Hello, Spring+Vaadin user!")));
    }


}

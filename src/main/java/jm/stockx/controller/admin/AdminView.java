package jm.stockx.controller.admin;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.controller.purchase.AllItemController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Route(value = "admin")
public class AdminView extends VerticalLayout {
    private HeaderRowNewsPage navPanel = new HeaderRowNewsPage();

    public AdminView() {
        Button toListButton = new Button("To List");
        toListButton.addClickListener(e -> UI.getCurrent().navigate(AllItemController.class));
        add(navPanel, toListButton);
    }
}
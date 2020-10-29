package jm.stockx.components.templates;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BidButton extends VerticalLayout {

    private final VerticalLayout layout = new VerticalLayout();

    public BidButton(){
        add(createButton());
    }

    public Button createButton() {
        Button button = new Button(
                new Image("img/vaadin-logo.svg", "Place Bid"));
        button.setAutofocus(true);
        layout.setHorizontalComponentAlignment(Alignment.CENTER, button);
        layout.add(button);
        return button;
    }
}
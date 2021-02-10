package jm.stockx.controller.paypal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class PayPalOrderForm extends FormLayout {
    private TextField price = new TextField("Price");
    private TextField currency = new TextField("Currency");
    private TextField description = new TextField("Description");
    private Button save = new Button("Place Order");
    private Button delete = new Button("Clean Order Form");

    public PayPalOrderForm() {
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(price, currency, description, buttons);
    }
}

package jm.stockx.controller.modalWindows;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.server.VaadinService;

import javax.servlet.http.Cookie;
import java.util.ArrayList;


public class SelectLocaleModalWindow extends Dialog {

    public SelectLocaleModalWindow() {

        VerticalLayout verticalLayoutForCheckBox = new VerticalLayout();
        VerticalLayout verticalLayoutForButton = new VerticalLayout();

        Button button = new Button();
        add("Select Locale");

        ComboBox<String> locales = new ComboBox<>();
        ArrayList<String> localeList = new ArrayList<>();
        localeList.add("RUS");
        localeList.add("ENG");
        localeList.add("CNA");
        localeList.add("ESP");
        localeList.add("FIN");
        locales.setItems(localeList);
        add(verticalLayoutForCheckBox);
        add(locales);

        button.setText("Confirm");
        StringBuilder locale = new StringBuilder();

        locales.addValueChangeListener(comboBoxStringComponentValueChangeEvent -> {

            locale.append(comboBoxStringComponentValueChangeEvent.getValue());

        });
        button.addClickListener(e -> {
            Cookie localeCookie = new Cookie("locale", locale.toString());

            //VaadinService.getCurrentResponse().addCookie(localeCookie);

            close();

        });

        add(verticalLayoutForButton);
        add(button);


    }

}

package jm.stockx.controller.modalWindows;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.server.VaadinService;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Route("locale")

public class TestLocaleModal extends VerticalLayout {

    public TestLocaleModal() {

        SelectLocaleModalWindow selectLocaleModalWindow = new SelectLocaleModalWindow();
        selectLocaleModalWindow.open();

        add(selectLocaleModalWindow);

    }

}



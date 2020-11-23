package jm.stockx.http.service.configuration;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.i18n.I18NProvider;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

@SpringComponent
public class ServiceInitListener implements VaadinServiceInitListener {

    @Autowired
    private I18NProvider i18nProvider;

    @Override
    public void serviceInit(ServiceInitEvent serviceInitEvent) {
        serviceInitEvent.getSource().addUIInitListener(uiInitEvent -> {
            initLanguage(uiInitEvent.getUI());
        });
    }

    private void initLanguage(UI ui) {

        Optional<Cookie> localeCookie = Optional.empty();

        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();
        if (cookies != null) {
            localeCookie = Arrays.stream(cookies).filter(cookie -> "locale".equals(cookie.getName())).findFirst();
        }

        Locale locale;

        if (localeCookie.isPresent() && !"".equals(localeCookie.get().getValue())) {
            locale = Locale.forLanguageTag(localeCookie.get().getValue());
        } else {
            locale = VaadinService.getCurrentRequest().getLocale();
        }
        if (locale.getLanguage().equals("")) {
            locale = i18nProvider.getProvidedLocales().get(0);
        }

        ui.setLocale(locale);
    }
}
package jm.stockx.controller.login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.i18n.I18NProvider;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import jm.stockx.components.news.news_header.HeaderRowNewsPage;
import jm.stockx.controller.admin.AdminView;
import jm.stockx.controller.purchase.AllItemController;
import jm.stockx.controller.user.MainView;
import jm.stockx.http.service.AuthRestGoogleService;
import jm.stockx.http.service.AuthRestHttpService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import javax.servlet.http.Cookie;
import java.util.Locale;

@Route("login")
@PageTitle("Login")
@Scope("prototype")
public class LoginView extends VerticalLayout implements BeforeEnterObserver, LocaleChangeObserver {
    @Value("${cookie.token.name}")
    private String cookieTokenName;

    private final AuthRestGoogleService googleService;
    private final LoginForm login;
    private final AuthRestHttpService auth;
    private final Button googleButton;

    private HeaderRowNewsPage navPanel = new HeaderRowNewsPage();

    private final H1 vaad = new H1("");
    private final Select<Locale> languageSelect;

    public LoginView(AuthRestHttpService auth,
                     AuthRestGoogleService googleService,
                     I18NProvider i18NProvider) {
        this.auth = auth;
        this.googleService = googleService;
        login = new LoginForm();
        googleButton = new Button();
        languageSelect = new Select<>();

        add(navPanel);
        setPageProperties();
        selectLanguage(i18NProvider);
        login.addLoginListener(e -> authenticateUser(auth, e));
        googleAuthButtonOnclick(googleService);
        add(vaad, login, googleButton);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }

    private void authenticateUser(AuthRestHttpService auth, AbstractLogin.LoginEvent e) {
        String token = auth.getToken(e.getUsername(), e.getPassword());
        if (token != null) {
            VaadinService.getCurrentResponse().addCookie(new Cookie(cookieTokenName, token));
            choosePathFromRoleName(auth);
        } else {
            getUI().get().getPage().setLocation("/login");
        }
    }

    private void setPageProperties() {
        addClassName("login-view");
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }

    private void googleAuthButtonOnclick(AuthRestGoogleService googleService) {
        googleButton.addClickListener(e -> getUI().get().getPage().setLocation(googleService.getUrl()));
    }

    private void selectLanguage(I18NProvider i18NProvider) {
        languageSelect.setItems(i18NProvider.getProvidedLocales());
        languageSelect.setItemLabelGenerator(l -> getTranslation(l.getLanguage()));
        languageSelect.setValue(UI.getCurrent().getLocale());
        languageSelect.addValueChangeListener(event -> saveLocalePreference(event.getValue()));
        add(languageSelect);
    }

    private void choosePathFromRoleName(AuthRestHttpService auth) {
        UI.getCurrent().navigate(auth.getRole().equals("ROLE_ADMIN") ? AdminView.class : MainView.class);
    }

    private void saveLocalePreference(Locale locale) {
        getUI().get().setLocale(locale);
        VaadinService.getCurrentResponse().addCookie(new Cookie("locale", locale.toLanguageTag()));
    }

    @SneakyThrows
    @Override
    public void localeChange(LocaleChangeEvent localeChangeEvent) {
        googleButton.setText(getTranslation("label.withGoogle"));
        vaad.setText(getTranslation("label.vaadin"));
    }
}
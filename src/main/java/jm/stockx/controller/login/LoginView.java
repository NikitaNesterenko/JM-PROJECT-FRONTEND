package jm.stockx.controller.login;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import jm.stockx.http.service.AuthRestGoogleService;
import jm.stockx.http.service.AuthRestHttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;

@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
    @Value("${cookie.token.name}")
    private String cookieTokenName;

    private final AuthRestGoogleService googleService;
    private final LoginForm login;
    private final AuthRestHttpService auth;
    private final Button googleButton;

    public LoginView(AuthRestHttpService auth, AuthRestGoogleService googleService) {

        this.auth = auth;
        this.googleService = googleService;
        login = new LoginForm();
        googleButton = new Button("With google");
        addClassName("login-view");
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);


        login.addLoginListener(e -> {
            String token = auth.getToken(e.getUsername(), e.getPassword());
            if (token != null) {
                VaadinService.getCurrentResponse().addCookie(new Cookie(cookieTokenName, token));
                getUI().get().getPage().setLocation("/");
            } else {
                getUI().get().getPage().setLocation("/login");
            }
        });

        googleButton.addClickListener(e -> {
            getUI().get().getPage().setLocation(googleService.getUrl());
        });

        add(
                new H1("Vaadin Login"),
                login,
                googleButton
        );
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }

}


